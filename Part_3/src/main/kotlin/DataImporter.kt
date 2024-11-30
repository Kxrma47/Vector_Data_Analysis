import java.sql.Connection
import java.sql.ResultSet

/**
 * Fetches shop data from PostgreSQL within 200 meters of tram stops, in WKT format.
 * @param pgConnection The PostgreSQL connection
 * @return A ResultSet containing the query results
 */
fun fetchShopsData(pgConnection: Connection): ResultSet {
    val statement = pgConnection.createStatement()
    val query = """
        SELECT DISTINCT p."osm_id" AS poi_id, p."shop" AS shop_type, ST_AsText(p.geom) AS geom
        FROM poi_point_4326 AS p
        JOIN railway_station_point_4326 AS t ON ST_DWithin(p.geom, t.geom, 200)
        WHERE p."shop" IS NOT NULL
    """
    return statement.executeQuery(query)
}

/**
 * Imports the ResultSet data from PostgreSQL into H2GIS, creating a new table with spatial data.
 * @param h2Connection The H2GIS connection
 * @param pgResultSet The ResultSet containing PostgreSQL data to import
 */
fun importDataToH2GIS(h2Connection: Connection, pgResultSet: ResultSet) {
    // Create a table for shops in H2GIS with a spatial geometry column
    val createTableQuery = """
        CREATE TABLE shops (
            poi_id VARCHAR,
            shop_type VARCHAR,
            geom GEOMETRY
        )
    """
    h2Connection.createStatement().execute(createTableQuery)

    // Insert data into the H2GIS table, directly using the WKT format
    while (pgResultSet.next()) {
        val poiId = pgResultSet.getString("poi_id")
        val shopType = pgResultSet.getString("shop_type")
        val geom = pgResultSet.getString("geom")  // Geometry in WKT format

        val insertQuery = """
            INSERT INTO shops (poi_id, shop_type, geom)
            VALUES ('$poiId', '$shopType', '$geom'::GEOMETRY)
        """
        h2Connection.createStatement().execute(insertQuery)
    }
}
