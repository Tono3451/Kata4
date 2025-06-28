package software.ulpgc.kata4.control;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import software.ulpgc.kata4.model.BarChart;

import java.util.Map;

public class JFrameBarChartAdapter {

    public static JFreeChart adapt(BarChart barChart) {
        return ChartFactory.createBarChart(
                barChart.getTitle(),
                "",
                "",
                datasetOf(barChart.getCounts()),
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
    }

    private static DefaultCategoryDataset datasetOf(Map<String, Integer> counts) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(String key: counts.keySet()){
            dataset.addValue(counts.get(key), "Conteo", key);
        }
        return dataset;
    }
}
