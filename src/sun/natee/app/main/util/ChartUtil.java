package sun.natee.app.main.util;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class ChartUtil {

    public static void showPieReport(DefaultPieDataset dataset, JPanel panel, String title) {
        JFreeChart chart = ChartFactory.createPieChart(title, dataset, true, true, false);
        ChartPanel myChart = new ChartPanel(chart);
        myChart.setMouseWheelEnabled(true);
        panel.setLayout(new java.awt.BorderLayout());
        panel.add(myChart, BorderLayout.CENTER);
        panel.validate();
    }
}
