package com.hau.bui.tutorial.saga.coreapis.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class RejectOrderCommand {

	@TargetAggregateIdentifier
	public final String orderId;

	public final String paymentId;

	public RejectOrderCommand(String orderId, String paymentId) {
		this.orderId = orderId;
		this.paymentId = paymentId;
	}
}
