package com.hau.bui.tutorial.saga.coreapis.events;

public class RejectInvoiceEvent {

	public final String orderId;

	public final String paymentId;

	public final double invoice;

	public RejectInvoiceEvent(String paymentId, String orderId, double
					invoice) {
		this.paymentId = paymentId;
		this.orderId = orderId;
		this.invoice = invoice;
	}
}
