package com.hau.bui.tutorial.saga.coreapis.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;

public class CreateInvoiceCommand {

    @TargetAggregateIdentifier
    public final String paymentId;

    public final String orderId;

    public final BigDecimal invoice;

    public CreateInvoiceCommand(String paymentId, String orderId,
                    BigDecimal invoice) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.invoice = invoice;
    }
}
