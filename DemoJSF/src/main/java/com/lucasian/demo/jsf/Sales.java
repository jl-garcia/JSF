/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucasian.demo.jsf;

/**
 *
 * @author Evaluacion
 */
public class Sales {

    private String product;
    
    private int price;

    public Sales(int price, String product) {
        this.price = price;
        this.product = product;
    
    }

    public Sales() {
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
