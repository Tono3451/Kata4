package software.ulpgc.kata4.io.csv;

import software.ulpgc.kata4.io.PlayerDeserializer;
import software.ulpgc.kata4.model.League;
import software.ulpgc.kata4.model.Player;

public class CsvPlayerDeserializer implements PlayerDeserializer {
    @Override
    public Player deserialize(String line) {
        return deserialize(line.split(","));
    }

    private Player deserialize(String[] values) {
        return new Player(values[1], values[2], removeQuotes(values[3]), values[4], toLeague(values[5]));
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

    private String removeQuotes(String value) {
        value = value.replace("\"", "");
        return value;
    }
}
