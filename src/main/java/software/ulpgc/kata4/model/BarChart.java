package software.ulpgc.kata4.model;

import java.util.Map;

public class BarChart {
    private final String title;
    private final Map<String, Integer> counts;

    public BarChart(String title, Map<String, Integer> counts) {
        this.title = title;
        this.counts = counts;
    }

    public String getTitle() {
        return title;
    }

    public Map<String, Integer> getCounts() {
        return counts;
    }
}
