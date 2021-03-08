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

	private static BigDecimal currentBalance = BigDecimal.valueOf(10000);

	private static Map<String, InvoiceEntity> mapInvoiceRepositories = new
					HashMap<>();

	@Override
	public boolean createInvoice(
					String invoiceId, String orderId, BigDecimal invoice,
					InvoiceStatus status) {


		if(currentBalance.compareTo(invoice) < 0) {

			return false;
		}

		currentBalance = currentBalance.subtract(invoice);

		InvoiceEntity invoiceEntity = new InvoiceEntity(invoiceId, orderId,
						invoice, status);

		mapInvoiceRepositories.put(invoiceId, invoiceEntity);

		System.out.println("Remaining balance : " + currentBalance.intValue());

		return true;
	}
}
