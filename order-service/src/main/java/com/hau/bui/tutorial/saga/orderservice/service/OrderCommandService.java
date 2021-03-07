package com.hau.bui.tutorial.saga.orderservice.service;

import com.hau.bui.tutorial.saga.orderservice.dto.OrderCreateDTO;

import java.util.concurrent.CompletableFuture;

public interface OrderCommandService {

    CompletableFuture<String> createOrder(OrderCreateDTO orderCreatedDTO);

    void rejectOrder(String orderId);
}
