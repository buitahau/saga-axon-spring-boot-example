package com.hau.bui.tutorial.saga.orderservice.dto;

import java.math.BigDecimal;

public class OrderCreateDTO {

    private String itemType;

    private double price;

    private String currency;

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
