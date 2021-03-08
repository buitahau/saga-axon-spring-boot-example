package com.hau.bui.tutorial.saga.orderservice.saga;

import com.hau.bui.tutorial.saga.coreapis.commands.CreateInvoiceCommand;
import com.hau.bui.tutorial.saga.coreapis.commands.CreateShippingCommand;
import com.hau.bui.tutorial.saga.coreapis.commands.RejectOrderCommand;
import com.hau.bui.tutorial.saga.coreapis.commands.UpdateOrderStatusCommand;
import com.hau.bui.tutorial.saga.coreapis.events.*;
import com.hau.bui.tutorial.saga.orderservice.aggregate.OrderStatus;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.SagaLifecycle;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;

import javax.inject.Inject;
import java.util.UUID;

@Saga
public class OrderManagementSaga {

    @Inject
    private transient CommandGateway commandGateway;

    @StartSaga
    @SagaEventHandler(associationProperty = "orderId")
    public void handle(OrderCreatedEvent orderCreatedEvent) {
        String paymentId = UUID.randomUUID().toString();

        System.out.println("Saga invoked");

        SagaLifecycle.associateWith("paymentId", paymentId);

        System.out.println("order id " + orderCreatedEvent.orderId);

        commandGateway.send(new CreateInvoiceCommand(paymentId,
                        orderCreatedEvent.orderId, orderCreatedEvent.price));
    }

    @SagaEventHandler(associationProperty = "paymentId")
    public void handle(InvoiceCreatedEvent invoiceCreatedEvent) {
        String shippingId = UUID.randomUUID().toString();

        System.out.println("Saga continued");

        SagaLifecycle.associateWith("shippingId", shippingId);

        commandGateway.send(new CreateShippingCommand(shippingId, invoiceCreatedEvent.orderId, invoiceCreatedEvent.paymentId));
    }

    @SagaEventHandler(associationProperty = "paymentId")
    public void handle(RejectInvoiceEvent rejectInvoiceEvent) {

        System.out.println("Receive reject invoice event");

        commandGateway.send(new RejectOrderCommand(rejectInvoiceEvent.orderId,
                        rejectInvoiceEvent.paymentId));
    }

    @SagaEventHandler(associationProperty = "orderId")
    public void handle(RejectOrderEvent rejectOrderEvent) {
        System.out.println("Saga end with rejected order !!!");

        SagaLifecycle.end();
    }

    @SagaEventHandler(associationProperty = "orderId")
    public void handle(OrderShippedEvent orderShippedEvent) {
        commandGateway.send(new UpdateOrderStatusCommand(orderShippedEvent.orderId, String.valueOf(OrderStatus.SHIPPED)));
    }

    @SagaEventHandler(associationProperty = "orderId")
    public void handle(OrderUpdatedEvent orderUpdatedEvent) {

        System.out.println("Saga end!!!");

        SagaLifecycle.end();
    }
}
