package software.ulpgc.kata4.io.sqlDatabase;

import software.ulpgc.kata4.io.PlayerLoader;
import software.ulpgc.kata4.model.League;
import software.ulpgc.kata4.model.Player;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabasePlayerLoader implements PlayerLoader {
    private final Connection connection;
    private final static String selectText = "SELECT name, nationality, position, squad, league FROM players";

    public DatabasePlayerLoader(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Player> load() throws IOException {
        List<Player> players = new ArrayList<>();
        try (Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(selectText);
            while (resultSet.next()){
                players.add(new Player(resultSet.getString("name"),
                        resultSet.getString("nationality"),
                        resultSet.getString("position"),
                        resultSet.getString("squad"),
                        toLeague(resultSet.getString("league"))));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return players;
    }

    private League toLeague(String value) {
        return switch (value) {
            case "eng Premier League" -> League.PREMIERLEAGUE;
            case "es La Liga" -> League.LALIGA;
            case "it Serie A" -> League.SERIAA;
            case "fr Ligue 1" -> League.LIGUE1;
            case "de Bundesliga" -> League.BUNDESLIGA;
            default -> League.UNKNOWN;
        };
    }
}
