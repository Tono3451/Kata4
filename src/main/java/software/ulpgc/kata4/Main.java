package software.ulpgc.kata4;

import software.ulpgc.kata4.control.ToggleChartCommand;
import software.ulpgc.kata4.control.BarChartCreator;
import software.ulpgc.kata4.view.MainFrame;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        MainFrame mainFrame = new MainFrame();
        mainFrame.put("toggle", new ToggleChartCommand(mainFrame.getBarChartDisplay(), new BarChartCreator().getBarCharts()));
        mainFrame.setVisible(true);
    }
}
