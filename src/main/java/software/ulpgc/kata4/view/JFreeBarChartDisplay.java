package software.ulpgc.kata4.view;

import org.jfree.chart.ChartPanel;
import software.ulpgc.kata4.control.JFrameBarChartAdapter;
import software.ulpgc.kata4.model.BarChart;

import javax.swing.*;

public class JFreeBarChartDisplay extends JPanel implements BarChartDisplay {
    @Override
    public void display(BarChart barChart) {
        removeAll();
        add(new ChartPanel(JFrameBarChartAdapter.adapt(barChart)));
        revalidate();
    }
}
