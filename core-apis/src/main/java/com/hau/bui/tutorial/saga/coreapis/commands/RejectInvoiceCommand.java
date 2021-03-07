package com.hau.bui.tutorial.saga.coreapis.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class RejectInvoiceCommand {

	@TargetAggregateIdentifier
	public final String paymentId;

	public final String orderId;

	public final double invoice;

	public RejectInvoiceCommand(String paymentId, String orderId, double invoice) {
		this.paymentId = paymentId;
		this.orderId = orderId;
		this.invoice = invoice;
	}
}
