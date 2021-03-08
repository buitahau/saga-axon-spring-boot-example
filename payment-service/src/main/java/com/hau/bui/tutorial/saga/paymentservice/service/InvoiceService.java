package com.hau.bui.tutorial.saga.paymentservice.service;

import com.hau.bui.tutorial.saga.paymentservice.aggregate.InvoiceStatus;

import java.math.BigDecimal;

public interface InvoiceService {

	boolean createInvoice(String invoiceId, String orderId, BigDecimal invoice,
					InvoiceStatus status);

}
