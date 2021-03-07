package com.hau.bui.tutorial.saga.coreapis.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CreateInvoiceCommand {

    @TargetAggregateIdentifier
    public final String paymentId;

    public final String orderId;

    public final double invoice;

    public CreateInvoiceCommand(String paymentId, String orderId, double invoice) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.invoice = invoice;
    }
}
