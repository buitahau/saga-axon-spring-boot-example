package com.hau.bui.tutorial.saga.coreapis.events;

import java.math.BigDecimal;

public class RejectInvoiceEvent {

	public final String orderId;

	public final String paymentId;

	public final BigDecimal invoice;

	public RejectInvoiceEvent(String paymentId, String orderId,
					BigDecimal invoice) {
		this.paymentId = paymentId;
		this.orderId = orderId;
		this.invoice = invoice;
	}
}
