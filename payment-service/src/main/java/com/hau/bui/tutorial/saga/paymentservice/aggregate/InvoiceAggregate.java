package com.hau.bui.tutorial.saga.paymentservice.aggregate;

import com.hau.bui.tutorial.saga.coreapis.commands.CreateInvoiceCommand;
import com.hau.bui.tutorial.saga.coreapis.events.InvoiceCreatedEvent;
import com.hau.bui.tutorial.saga.coreapis.events.RejectInvoiceEvent;
import com.hau.bui.tutorial.saga.paymentservice.service.InvoiceService;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class InvoiceAggregate {

    @AggregateIdentifier
    private String paymentId;

    private String orderId;

    private InvoiceStatus invoiceStatus;

    public InvoiceAggregate() {

    }

    @CommandHandler
    public InvoiceAggregate(CreateInvoiceCommand createInvoiceCommand,
                    InvoiceService invoiceService) {

        boolean payed = invoiceService.createInvoice(
                        createInvoiceCommand.paymentId,
                        createInvoiceCommand.orderId,
                        createInvoiceCommand.invoice,
                        InvoiceStatus.PAID);

        if(payed) {
            AggregateLifecycle.apply(new InvoiceCreatedEvent(
                            createInvoiceCommand.paymentId,
                            createInvoiceCommand.orderId));
        }

        if(!payed) {
            AggregateLifecycle.apply(new RejectInvoiceEvent(
                            createInvoiceCommand.paymentId,
                            createInvoiceCommand.orderId,
                            createInvoiceCommand.invoice));
        }
    }

    @EventSourcingHandler
    protected void on(InvoiceCreatedEvent invoiceCreatedEvent) {
        this.paymentId = invoiceCreatedEvent.paymentId;
        this.orderId = invoiceCreatedEvent.orderId;
        this.invoiceStatus = InvoiceStatus.PAID;
    }

    @EventSourcingHandler
    protected void on(RejectInvoiceEvent rejectInvoiceEvent) {
        this.paymentId = rejectInvoiceEvent.paymentId;
        this.orderId = rejectInvoiceEvent.orderId;
        this.invoiceStatus = InvoiceStatus.PAYMENT_REVERSED;
    }
}
