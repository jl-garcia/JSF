/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucasian.demo.primefaces;

/**
 *
 * @author Evaluacion
 */
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.PieChartModel;

@ManagedBean
public class ChartBean implements Serializable {

    private PieChartModel sales2001;
    private PieChartModel sales2002;
    private PieChartModel sales2003;

    public ChartBean() {
        createPieModel();
    }

    private void createPieModel() {
        sales2001 = new PieChartModel();
        sales2001.set("Coca Cola", 234);
        sales2001.set("Agua Mineral", 123);
        sales2001.set("Pepsi Cola", 199);
        sales2001.set("Vino Tinto", 100);
        sales2001.set("Agua Natural", 50);

        sales2002 = new PieChartModel();
        sales2002.set("Coca Cola", 245);
        sales2002.set("Agua Mineral", 144);
        sales2002.set("Pepsi Cola", 203);
        sales2002.set("Vino Tinto", 220);
        sales2002.set("Agua Natural", 55);

    }

    public PieChartModel getSales2001() {
        return sales2001;
    }

    public void setSales2001(PieChartModel sales2001) {
        this.sales2001 = sales2001;
    }

    public PieChartModel getSales2002() {
        return sales2002;
    }

    public void setSales2002(PieChartModel sales2002) {
        this.sales2002 = sales2002;
    }

    public PieChartModel getSales2003() {
        return sales2003;
    }

    public void setSales2003(PieChartModel sales2003) {
        this.sales2003 = sales2003;
    }
}
