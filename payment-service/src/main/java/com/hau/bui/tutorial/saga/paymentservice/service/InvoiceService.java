package com.hau.bui.tutorial.saga.paymentservice.service;

import com.hau.bui.tutorial.saga.paymentservice.aggregate.InvoiceStatus;

public interface InvoiceService {

	boolean createInvoice(String paymentId, String orderId, double invoice,
					InvoiceStatus status);

}
