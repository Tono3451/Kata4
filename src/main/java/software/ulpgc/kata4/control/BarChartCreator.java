package software.ulpgc.kata4.control;

import software.ulpgc.kata4.io.csv.CsvPlayerDeserializer;
import software.ulpgc.kata4.io.FilePlayerLoader;
import software.ulpgc.kata4.model.BarChart;
import software.ulpgc.kata4.model.Player;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BarChartCreator {
    private final List<Player> players;

    public BarChartCreator() throws IOException {
        File file = new File("D:/clase/Asignaturas_tercero/is2/kata3/dataset/players_data-2024_2025.csv");
        this.players = new FilePlayerLoader(file, new CsvPlayerDeserializer()).load();
    }

    public List<BarChart> getBarCharts() {
        List<BarChart> barCharts = new ArrayList<>();
        barCharts.add(barChartPlayerNacionality());
        barCharts.add(barChartPlayerPosition());
        return barCharts;
    }

    private BarChart barChartPlayerPosition() {
        Map<String, Integer> counts = new HashMap<>();
        for (Player player: this.players){
            counts.put(player.getPosition(), counts.getOrDefault(player.getPosition(), 0) + 1);
        }
        return new BarChart("Número de jugadores por posición", counts);
    }

    private BarChart barChartPlayerNacionality() {
        Map<String, Integer> counts = new HashMap<>();
        for (Player player: this.players){
            counts.put(player.getNacionality(), counts.getOrDefault(player.getNacionality(), 0) + 1);
        }
        return new BarChart("Número de jugadores por nacionalidad", counts);
    }
}
