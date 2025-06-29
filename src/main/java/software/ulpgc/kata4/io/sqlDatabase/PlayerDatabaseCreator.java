package software.ulpgc.kata4.io.sqlDatabase;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class PlayerDatabaseCreator {
    private static final String tableTextCreate = "CREATE TABLE IF NOT EXISTS players (" +
                                            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                            "name TEXT," +
                                            "nationality TEXT NOT NULL," +
                                            "position TEXT NOT NULL," +
                                            "squad TEXT NOT NULL," +
                                            "league TEXT NOT NULL" +
                                            ");";

    public static void createTable(Connection connection){
        try (Statement statement = connection.createStatement()){
            statement.execute(tableTextCreate);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
