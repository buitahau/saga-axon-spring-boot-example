package com.hau.bui.tutorial.saga.coreapis.events;

public class RejectOrderEvent {

	public final String orderId;

	public final String paymentId;

	public RejectOrderEvent(String orderId, String paymentId) {
		this.orderId = orderId;
		this.paymentId = paymentId;
	}
}
