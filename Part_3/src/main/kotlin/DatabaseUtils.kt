import java.sql.Connection
import java.sql.DriverManager

/**
 * Connects to the PostgreSQL database.
 * @return a Connection object for PostgreSQL
 */
fun getPostgresConnection(): Connection {
    val url = "jdbc:postgresql://localhost:5432/moscow_data"
    val user = "postgres"
    val password = "password"
    return DriverManager.getConnection(url, user, password)
}

/**
 * Connects to an in-memory H2GIS database with H2GIS spatial functions loaded.
 * @return a Connection object for H2GIS
 */
fun getH2GISConnection(): Connection {
    val url = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1"  // In-memory H2 database
    return DriverManager.getConnection(url, "sa", "")
}
