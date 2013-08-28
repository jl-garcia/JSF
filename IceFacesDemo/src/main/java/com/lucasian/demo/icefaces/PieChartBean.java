/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucasian.demo.icefaces;

import com.icesoft.faces.component.outputchart.OutputChart;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

/**
 * The PieChartBean is responsible for holding all the UI information and
 * generating detailed sales data for the pie chart
 *
 * @since 1.5
 */
//@ManagedBean
public class PieChartBean extends PieChart {

    //String displayed in the UI
    private static String clickedAreaValue = "Click on the image map below to display a chart value: ";
    //flag to determine if the graph needs rendering
    private boolean pieNeedsRendering = false;
    //list of the sales data from the sales class
    private List sales = SalesBean.buildSales(this);

    public PieChartBean() {
        super();
    }

    /**
     * Method to call the rendering of the chart based on the pieNeedsRendering
     * flag
     *
     * @param component chart component which will be rendered.
     * @return boolean true if OutputChart should be re-rendered; otherwise,
     * false.
     */
    public boolean newChart(OutputChart component) {
        if (pieNeedsRendering) {
            pieNeedsRendering = false;
            return true;
        } else {
            return false;
        }
    }

    public String getClickedAreaValue() {
        return clickedAreaValue;
    }

    public void setClickedAreaValue(String clickedAreaValue) {
        PieChartBean.clickedAreaValue = clickedAreaValue;
    }

    // When a piece of the pie is clicked, retrieve the sales data for that year.
    public void imageClicked(ActionEvent event) {

        if (event.getSource() instanceof OutputChart) {
            OutputChart chart = (OutputChart) event.getSource();
            if (chart.getClickedImageMapArea().getLengendLabel() != null) {
                setClickedAreaValue(clickedAreaValue + chart
                        .getClickedImageMapArea().getLengendLabel()
                        + " : "
                        + chart.getClickedImageMapArea().getValue());
                SalesBean.setSalesForYear(this,
                        chart.getClickedImageMapArea().getLengendLabel());


            }
        }
    }

    public List getSales() {
        return sales;
    }
}
