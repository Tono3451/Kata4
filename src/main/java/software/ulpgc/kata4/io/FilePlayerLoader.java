package software.ulpgc.kata4.io;

import software.ulpgc.kata4.model.Player;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FilePlayerLoader implements PlayerLoader{
    private final File file;
    private final PlayerDeserializer playerDeserializer;

    public FilePlayerLoader(File file, PlayerDeserializer playerDeserializer) {
        this.file = file;
        this.playerDeserializer = playerDeserializer;
    }

    @Override
    public List<Player> load() throws IOException {
        List<Player> players = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            reader.readLine();
            while(true){
                String line = reader.readLine();
                if (line == null) break;
                players.add(playerDeserializer.deserialize(line));
            }
        }
        return players;
    }
}
