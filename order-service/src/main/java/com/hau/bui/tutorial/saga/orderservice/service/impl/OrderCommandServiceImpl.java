package com.hau.bui.tutorial.saga.orderservice.service.impl;

import com.hau.bui.tutorial.saga.coreapis.commands.CreateOrderCommand;
import com.hau.bui.tutorial.saga.orderservice.aggregate.OrderStatus;
import com.hau.bui.tutorial.saga.orderservice.dto.OrderCreateDTO;
import com.hau.bui.tutorial.saga.orderservice.service.OrderCommandService;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class OrderCommandServiceImpl implements OrderCommandService {

    private final CommandGateway commandGateway;

    public OrderCommandServiceImpl(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @Override
    public CompletableFuture<String> createOrder(OrderCreateDTO orderCreateDTO) {
        return commandGateway.send(new CreateOrderCommand(UUID.randomUUID().toString(), orderCreateDTO.getItemType(),
                orderCreateDTO.getPrice(), orderCreateDTO.getCurrency(), String.valueOf(OrderStatus.CREATED)));
    }
}
