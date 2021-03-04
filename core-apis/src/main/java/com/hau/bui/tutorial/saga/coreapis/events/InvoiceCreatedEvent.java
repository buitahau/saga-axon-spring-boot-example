package com.hau.bui.tutorial.saga.coreapis.events;

public class InvoiceCreatedEvent {

    public final String orderId;

    public final String paymentId;

    public InvoiceCreatedEvent(String paymentId, String orderId) {
        this.paymentId = paymentId;
        this.orderId = orderId;
    }
}
