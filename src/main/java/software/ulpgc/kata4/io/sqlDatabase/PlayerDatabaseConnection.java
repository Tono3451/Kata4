package software.ulpgc.kata4.io.sqlDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PlayerDatabaseConnection {
    private static final String Url = "jdbc:sqlite:players.db";

    public static Connection connect(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(Url);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
