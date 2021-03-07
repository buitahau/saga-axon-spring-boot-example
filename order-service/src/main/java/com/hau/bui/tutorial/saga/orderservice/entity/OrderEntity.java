package com.hau.bui.tutorial.saga.orderservice.entity;

import com.hau.bui.tutorial.saga.orderservice.aggregate.OrderStatus;

public class OrderEntity {

	private String orderId;

	private String itemType;

	private double price;

	private String currency;

	private OrderStatus orderStatus;

	public OrderEntity(
					String orderId, String itemType, double price,
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
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
