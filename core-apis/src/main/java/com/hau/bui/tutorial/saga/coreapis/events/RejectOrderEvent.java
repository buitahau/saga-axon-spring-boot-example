package com.hau.bui.tutorial.saga.coreapis.events;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class RejectOrderEvent {

	@TargetAggregateIdentifier
	public final String orderId;

	public final String paymentId;

	public RejectOrderEvent(String orderId, String paymentId) {
		this.orderId = orderId;
		this.paymentId = paymentId;
	}
}
