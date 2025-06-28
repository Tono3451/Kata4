package software.ulpgc.kata4.control;

import software.ulpgc.kata4.model.BarChart;
import software.ulpgc.kata4.view.BarChartDisplay;

import java.util.List;

public class ToggleChartCommand implements Command {
    private  int index = 0;
    private final BarChartDisplay barChartDisplay;
    private final List<BarChart> barCharts;

    public ToggleChartCommand(BarChartDisplay barChartDisplay, List<BarChart> barCharts) {
        this.barChartDisplay = barChartDisplay;
        this.barCharts = barCharts;
    }

    @Override
    public void execute() {
        nextChart();
    }

    private void nextChart() {
        nextIndex();
        barChartDisplay.display(barCharts.get(index));
    }

    private void nextIndex() {
        index = (index+1) % barCharts.size();
    }


}
