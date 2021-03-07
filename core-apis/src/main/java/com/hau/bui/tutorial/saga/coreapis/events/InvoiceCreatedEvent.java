package com.hau.bui.tutorial.saga.coreapis.events;

public class InvoiceCreatedEvent {

    public final String orderId;

    public final String paymentId;

    public final double invoice;

    public InvoiceCreatedEvent(String paymentId, String orderId, double
                    invoice) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.invoice = invoice;
    }
}
