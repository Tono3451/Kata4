package software.ulpgc.kata4.control;

import software.ulpgc.kata4.io.FilePlayerLoader;
import software.ulpgc.kata4.io.PlayerWriter;
import software.ulpgc.kata4.io.csv.CsvPlayerDeserializer;
import software.ulpgc.kata4.io.sqlDatabase.DatabasePlayerWriter;
import software.ulpgc.kata4.io.sqlDatabase.PlayerDatabaseConnection;
import software.ulpgc.kata4.io.sqlDatabase.PlayerDatabaseCreator;
import software.ulpgc.kata4.model.Player;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class InsertPlayersInDatabaseCommand implements Command{
    @Override
    public void execute() {
        try {
            File file = new File("D:/clase/Asignaturas_tercero/is2/kata3/dataset/players_data-2024_2025.csv");
            List<Player> players = new FilePlayerLoader(file, new CsvPlayerDeserializer()).load();
            try (Connection connection = PlayerDatabaseConnection.connect()) {
                PlayerDatabaseCreator.createTable(connection);
                PlayerWriter playerWriter = new DatabasePlayerWriter(connection);
                for (Player player: players){
                    playerWriter.write(player);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
