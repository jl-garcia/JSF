/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucasian.demo.primefaces;

/**
 *
 * @author Evaluacion
 */
public class Sales {

    private String year;
    private String product;
    private int price;

    public Sales(int price, String product, String year) {
        this.price = price;
        this.product = product;
        this.year = year;
    }

    public Sales() {
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
