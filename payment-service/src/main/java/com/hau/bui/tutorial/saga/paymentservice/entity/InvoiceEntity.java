package com.hau.bui.tutorial.saga.paymentservice.entity;

import com.hau.bui.tutorial.saga.paymentservice.aggregate.InvoiceStatus;

import java.math.BigDecimal;

public class InvoiceEntity {

	private String paymentId;

	private String orderId;

	private double invoice;

	private InvoiceStatus status;

	public InvoiceEntity(String paymentId, String orderId, double invoice,
					InvoiceStatus status) {

		this.paymentId = paymentId;
		this.orderId = orderId;
		this.invoice = invoice;
		this.status = status;
	}

	public String getPaymentId() {

		return paymentId;
	}

	public void setPaymentId(String paymentId) {

		this.paymentId = paymentId;
	}

	public String getOrderId() {

		return orderId;
	}

	public void setOrderId(String orderId) {

		this.orderId = orderId;
	}

	public double getInvoice() {

		return invoice;
	}

	public void setInvoice(double invoice) {

		this.invoice = invoice;
	}

	public InvoiceStatus getStatus() {

		return status;
	}

	public void setStatus(InvoiceStatus status) {

		this.status = status;
	}
}
