package com.hau.bui.tutorial.saga.orderservice.aggregate;

import com.hau.bui.tutorial.saga.coreapis.commands.CreateOrderCommand;
import com.hau.bui.tutorial.saga.coreapis.commands.RejectOrderCommand;
import com.hau.bui.tutorial.saga.coreapis.commands.UpdateOrderStatusCommand;
import com.hau.bui.tutorial.saga.coreapis.events.OrderCreatedEvent;
import com.hau.bui.tutorial.saga.coreapis.events.OrderUpdatedEvent;
import com.hau.bui.tutorial.saga.coreapis.events.RejectOrderEvent;
import com.hau.bui.tutorial.saga.orderservice.service.OrderCommandService;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.factory.annotation.Autowired;

@Aggregate
public class OrderAggregate {

    @AggregateIdentifier
    private String orderId;

    private ItemType itemType;

    private double price;

    private String currency;

    private OrderStatus orderStatus;

    private OrderCommandService orderCommandService;

    @Autowired
    public OrderAggregate(OrderCommandService orderCommandService) {
        this.orderCommandService = orderCommandService;
    }

    @CommandHandler
    public OrderAggregate(CreateOrderCommand createOrderCommand) {
        AggregateLifecycle.apply(new OrderCreatedEvent(createOrderCommand.orderId, createOrderCommand.itemType, createOrderCommand.price, createOrderCommand.currency, createOrderCommand.orderStatus));
    }

    @EventSourcingHandler
    protected void on(OrderCreatedEvent orderCreatedEvent) {
        this.orderId = orderCreatedEvent.orderId;
        this.itemType = ItemType.valueOf(orderCreatedEvent.itemType);
        this.price = orderCreatedEvent.price;
        this.currency = orderCreatedEvent.currency;
        this.orderStatus = OrderStatus.valueOf(orderCreatedEvent.orderStatus);
    }

    @CommandHandler
    protected void on(UpdateOrderStatusCommand updateOrderStatusCommand) {
        AggregateLifecycle.apply(new OrderUpdatedEvent(updateOrderStatusCommand.orderId, updateOrderStatusCommand.orderStatus));
    }

    @CommandHandler
    protected void on(RejectOrderCommand rejectOrderCommand) {

        orderCommandService.rejectOrder(rejectOrderCommand.orderId);
        AggregateLifecycle.apply(new RejectOrderEvent(rejectOrderCommand.orderId,
                        rejectOrderCommand.paymentId));
    }

    @EventSourcingHandler
    protected void on(OrderUpdatedEvent orderUpdatedEvent) {
        this.orderStatus = OrderStatus.valueOf(orderUpdatedEvent.orderStatus);
    }

}
