package com.hau.bui.tutorial.saga.coreapis.events;

public class OrderCreatedEvent {

    public final String orderId;

    public final String itemType;

    public final double price;

    public final String currency;

    public final String orderStatus;

    public OrderCreatedEvent(String orderId, String itemType, double price, String currency, String orderStatus) {
        this.orderId = orderId;
        this.itemType = itemType;
        this.price = price;
        this.currency = currency;
        this.orderStatus = orderStatus;
    }
}
