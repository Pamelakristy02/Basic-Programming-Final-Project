import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    //Complete database URL with database name, port, and host
    private static final String URL      = "jdbc:mysql://localhost:3306/game_project";

    //Complete MySQL username and password for local database
    private static final String USER     = "bn_processmaker";
    private static final String PASSWORD = "84e0d11b9d";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}