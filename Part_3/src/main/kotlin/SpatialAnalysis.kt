import java.sql.Connection

/**
 * Analyzes accessible shops by type in the H2GIS database.
 * Outputs the count of each shop type that is accessible.
 * @param h2Connection The H2GIS connection
 */
fun analyzeShopsAccessibility(h2Connection: Connection) {
    val query = """
        SELECT shop_type, COUNT(*) AS accessible_shops
        FROM shops
        GROUP BY shop_type
        ORDER BY accessible_shops DESC
    """
    val resultSet = h2Connection.createStatement().executeQuery(query)

    println("Accessible shops by type:")
    while (resultSet.next()) {
        val shopType = resultSet.getString("shop_type")
        val count = resultSet.getInt("accessible_shops")
        println("$shopType: $count")
    }
}
