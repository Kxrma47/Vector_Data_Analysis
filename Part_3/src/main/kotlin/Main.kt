fun main() {
    println("Connecting to PostgreSQL...")
    val pgConnection = getPostgresConnection()
    val pgResultSet = fetchShopsData(pgConnection)
    println("Fetched data from PostgreSQL.")

    println("Connecting to H2GIS...")
    val h2Connection = getH2GISConnection()
    importDataToH2GIS(h2Connection, pgResultSet)
    println("Data imported to H2GIS.")

    // Run the spatial analysis query in H2GIS
    analyzeShopsAccessibility(h2Connection)

    // Close connections
    pgConnection.close()
    h2Connection.close()
}
