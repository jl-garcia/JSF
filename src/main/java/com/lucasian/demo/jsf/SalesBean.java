/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucasian.demo.jsf;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Evaluacion
 */
@ManagedBean
public class SalesBean {

    private ArrayList<Sales> sales2001;
    private ArrayList<Sales> sales2002;
    private ArrayList<Sales> sales2003;
    private ArrayList<Sales> sales2004;

    public SalesBean() {
        sales2001 = new ArrayList<Sales>();
        sales2001.add(new Sales(234, "Coca Cola"));
        sales2001.add(new Sales(123, "Agua Mineral"));
        sales2001.add(new Sales(199, "Pepsi Cola"));
        sales2001.add(new Sales(100, "Vino Tinto"));
        sales2001.add(new Sales(50, "Agua Natural"));
        
        sales2002 = new ArrayList<Sales>();
        sales2002.add(new Sales(245, "Coca Cola"));
        sales2002.add(new Sales(144, "Agua Mineral"));
        sales2002.add(new Sales(230, "Pepsi Cola"));
        sales2002.add(new Sales(220, "Vino Tinto"));
        sales2002.add(new Sales(55, "Agua Natural"));
        
//        sales2003 = new ArrayList<Sales>();
//        sales2003.add(new Sales(245, "Coca Cola"));
//        sales2003.add(new Sales(144, "Agua Mineral"));
//        sales2003.add(new Sales(230, "Pepsi Cola"));
    }

    public ArrayList<Sales> getSales2001() {
        return sales2001;
    }

    public void setSales2001(ArrayList<Sales> sales2001) {
        this.sales2001 = sales2001;
    }

    public ArrayList<Sales> getSales2002() {
        return sales2002;
    }

    public void setSales2002(ArrayList<Sales> sales2002) {
        this.sales2002 = sales2002;
    }

    public ArrayList<Sales> getSales2003() {
        return sales2003;
    }

    public void setSales2003(ArrayList<Sales> sales2003) {
        this.sales2003 = sales2003;
    }

    public ArrayList<Sales> getSales2004() {
        return sales2004;
    }

    public void setSales2004(ArrayList<Sales> sales2004) {
        this.sales2004 = sales2004;
    }
    
}
