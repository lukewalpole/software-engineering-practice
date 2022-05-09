package task10;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import task5and9.Task;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.HashMap;



public class taskCharts extends JFrame {

    public taskCharts() {

        initUI();
    }

    private void initUI() {

        CategoryDataset dataset = createDataset();

        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        add(chartPanel);

        pack();
        setTitle("Bar chart");
        setLocationRelativeTo(null);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private CategoryDataset createDataset() {
    	
     HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
     
     //Task t1 = new Task();
     //int task=t1.getTaskId();
     
    	/*for(Task task: ) {
    		int task1=t1.getTaskId();
    	
    	}*/

        var dataset = new DefaultCategoryDataset();
        dataset.setValue(46, "Duration", "Task 1");
        dataset.setValue(48, "Estimated Duration", "Task 1");
        dataset.setValue(38, "Duration", "Task 2");
        dataset.setValue(29, "Estimated Duration", "Task 2");
        dataset.setValue(22, "Duration", "Task 3");
        dataset.setValue(12, "Estimated Duration", "Task 3");
        dataset.setValue(13, "Duration", "4");
        dataset.setValue(43, "Estimated Duration", "Task 4");
        dataset.setValue(11, "Duration", "Task 5");
        dataset.setValue(23, "Estimated Duration", "Task 5");

        return dataset;
    }

    private JFreeChart createChart(CategoryDataset dataset) {

        JFreeChart barChart = ChartFactory.createBarChart(
                "Duration of tasks with estimated task duration for different task types",
                "Tasks",
                "Duration",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        return barChart;
    }

}