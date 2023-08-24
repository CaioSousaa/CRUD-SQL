import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conection {
    private static final String URL = "jdbc:postgresql://rosie.db.elephantsql.com:5432/yiviqonk";
    private static final String USERNAME = "yiviqonk";
    private static final String PASSWORD = "xZrOR0N4NS-BS-2nnEfmM9vmtq5HClTj";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connected to the database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}