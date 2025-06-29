package software.ulpgc.kata4.io.sqlDatabase;

import software.ulpgc.kata4.io.PlayerWriter;
import software.ulpgc.kata4.model.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabasePlayerWriter implements PlayerWriter {
    private final Connection connection;
    private static final String insertText = "INSERT INTO players(name, nationality, position, squad, league) VALUES(?, ?, ?, ?, ?)";

    public DatabasePlayerWriter(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void write(Player player) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertText)) {
            preparedStatement.setString(1, player.getName());
            preparedStatement.setString(2, player.getNacionality());
            preparedStatement.setString(3, player.getPosition());
            preparedStatement.setString(4, player.getSquad());
            preparedStatement.setString(5, player.getLeague().toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
