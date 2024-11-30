import java.sql.ResultSet

fun fetchShopsData(): ResultSet {
    val connection = getPostgresConnection()
    val statement = connection.createStatement()
    val query = """
        SELECT DISTINCT p."osm_id" AS poi_id, p."shop" AS shop_type, ST_AsText(p.geom) AS geom
        FROM poi_point_4326 AS p
        JOIN railway_station_point_4326 AS t ON ST_DWithin(p.geom, t.geom, 200)
        WHERE p."shop" IS NOT NULL
    """
    return statement.executeQuery(query)
}
