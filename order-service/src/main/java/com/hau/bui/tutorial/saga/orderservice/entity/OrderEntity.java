package com.hau.bui.tutorial.saga.orderservice.entity;

import com.hau.bui.tutorial.saga.orderservice.aggregate.OrderStatus;

import java.math.BigDecimal;

public class OrderEntity {

	private String orderId;

	private String itemType;

	private BigDecimal price;

	private String currency;

	private OrderStatus orderStatus;

	public OrderEntity(
					String orderId, String itemType, BigDecimal price,
					String currency, OrderStatus orderStatus) {

		this.orderId = orderId;
		this.itemType = itemType;
		this.price = price;
		this.currency = currency;
		this.orderStatus = orderStatus;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public OrderStatus getOrderStatus() {

		return orderStatus;
	}

	public String getOrderId() {

		return orderId;
	}

	public void setOrderId(String orderId) {

		this.orderId = orderId;
	}

	public void setOrderStatus(
					OrderStatus orderStatus) {

		this.orderStatus = orderStatus;
	}
}
