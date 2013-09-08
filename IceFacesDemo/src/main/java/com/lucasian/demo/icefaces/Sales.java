/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucasian.demo.icefaces;

import java.util.HashMap;
import java.util.Map;


/**
 * Sales data used to assemble the 2D and 3D pie charts.
 */
public class Sales {

    //holds the year
    private String year;

    //holds the name of the item or product being sold
    private String product;

    //holds the price
    private int price;

    public Sales(int price, String product, String year) {
        this.price = price;
        this.product = product;
        this.year = year;
    }

    public Sales() {

    }

    //array of sales items for 2001
    private static final Sales[] sales2001 =
            {new Sales(15, "Ice Sailor", "2001"),
                    new Sales(15, "Ice Sailor", "2001"),
                    new Sales(15, "Ice Sailor", "2001"),
                    new Sales(22, "Ice Skate", "2001")};

    //array of sales items for 2002
    private static final Sales[] sales2002 = {new Sales(79, "Ice Car", "2002"),
            new Sales(63, "Icebreaker",
                    "2002"),
            new Sales(22, "Ice Skate",
                    "2002"),
            new Sales(22, "Ice Skate",
                    "2002"),
            new Sales(22, "Ice Skate",
                    "2002")};

    //array of sales items for 2003
    private static final Sales[] sales2003 =
            {new Sales(22, "Ice Skate", "2003"),
                    new Sales(15, "Ice Sailor", "2003")};

    //array of sales items for 2004
    private static final Sales[] sales2004 = {new Sales(79, "Ice Car", "2004"),
            new Sales(22, "Ice Skate",
                    "2004"),
            new Sales(22, "Ice Skate",
                    "2004"),
            new Sales(15, "Ice Sailor",
                    "2004")};
    //hashMap of the sales data
    protected static final HashMap masterSales = createMap();


    /**
     * Method to create the hash map from the sales from different years
     *
     * @return HasMap
     */
    public static HashMap createMap() {

        HashMap newSales = new HashMap();
        newSales.put("2001", sales2001);
        newSales.put("2002", sales2002);
        newSales.put("2003", sales2003);
        newSales.put("2004", sales2004);

        return newSales;
    }

    public static Map getMasterSales() {
        return masterSales;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
