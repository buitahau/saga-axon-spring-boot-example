package com.hau.bui.tutorial.saga.orderservice.service.impl;

import com.hau.bui.tutorial.saga.coreapis.commands.CreateOrderCommand;
import com.hau.bui.tutorial.saga.orderservice.aggregate.OrderStatus;
import com.hau.bui.tutorial.saga.orderservice.dto.OrderCreateDTO;
import com.hau.bui.tutorial.saga.orderservice.entity.OrderEntity;
import com.hau.bui.tutorial.saga.orderservice.service.OrderCommandService;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
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

        final String orderId = UUID.randomUUID().toString();

        final OrderStatus status = OrderStatus.CREATED;

        OrderEntity orderEntity = new OrderEntity(orderId, orderCreateDTO.getItemType(),
                        orderCreateDTO.getPrice(), orderCreateDTO.getCurrency(), status);

        orderEntities.put(orderId, orderEntity);

        return commandGateway.send(new CreateOrderCommand(orderId, orderCreateDTO.getItemType(),
                orderCreateDTO.getPrice(), orderCreateDTO.getCurrency(), String.valueOf(status)));
    }

    @Override
    public void rejectOrder(String orderId) {
        OrderEntity orderEntity = orderEntities.get(orderId);

        orderEntity.setOrderStatus(OrderStatus.REJECTED);
    }

    private static Map<String, OrderEntity> orderEntities = new HashMap<>();
}
