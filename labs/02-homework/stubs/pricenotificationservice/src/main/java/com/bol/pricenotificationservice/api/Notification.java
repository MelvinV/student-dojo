package com.bol.pricenotificationservice.api;

/**
 * Created by melvin on 6-4-2017.
 */
public class Notification {

    private String ean;
    private Double price;

    public Notification(String ean, Double price) {
        this.ean = ean;
        this.price = price;
    }

    public Notification() {
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
