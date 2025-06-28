package software.ulpgc.kata4.io;

import software.ulpgc.kata4.model.Player;

import java.io.IOException;
import java.util.List;

public interface PlayerLoader {
    List<Player> load() throws IOException;
}
