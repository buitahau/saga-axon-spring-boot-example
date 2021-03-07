package com.hau.bui.tutorial.saga.paymentservice.service.impl;

import com.hau.bui.tutorial.saga.paymentservice.aggregate.InvoiceStatus;
import com.hau.bui.tutorial.saga.paymentservice.entity.InvoiceEntity;
import com.hau.bui.tutorial.saga.paymentservice.service.InvoiceService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	private static double currentBalance = 10000;

	private static Map<String, InvoiceEntity> invoiceEntities = new HashMap<>();

	@Override
	public boolean createInvoice(
					String paymentId, String orderId, double invoice,
					InvoiceStatus status) {


		if(currentBalance < invoice) {

			return false;
		}

		currentBalance -= invoice;

		InvoiceEntity invoiceEntity = new InvoiceEntity(paymentId, orderId,
						invoice, status);

		invoiceEntities.put(paymentId, invoiceEntity);

		return true;
	}
}
