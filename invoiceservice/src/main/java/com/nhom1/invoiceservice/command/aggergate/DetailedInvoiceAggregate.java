package com.nhom1.invoiceservice.command.aggergate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import com.nhom1.invoiceservice.command.command.CreateDetailedInvoiceCommand;
import com.nhom1.invoiceservice.command.command.DeleteDetailedInvoiceCommand;
import com.nhom1.invoiceservice.command.command.UpdateDetailedInvoiceCommand;
import com.nhom1.invoiceservice.command.event.DetailedInvoiceCreateEvent;
import com.nhom1.invoiceservice.command.event.DetailedInvoiceDeleteEvent;
import com.nhom1.invoiceservice.command.event.DetailedInvoiceUpdateEvent;

@Aggregate
public class DetailedInvoiceAggregate {
    @AggregateIdentifier
    private int detailedInvoiceID;
    private int invoiceID;
    private int productID;
    private int quantity;
    private int price;
    private int totalPrice;
    private boolean isReviewed;
    
    public DetailedInvoiceAggregate() {
    }

    @CommandHandler
    public DetailedInvoiceAggregate(CreateDetailedInvoiceCommand command) {
        DetailedInvoiceCreateEvent detailedInvoiceCreateEvent = new DetailedInvoiceCreateEvent();
        BeanUtils.copyProperties(command, detailedInvoiceCreateEvent);
        AggregateLifecycle.apply(detailedInvoiceCreateEvent);
    }

    @CommandHandler
    public void hendle(UpdateDetailedInvoiceCommand command) {
        DetailedInvoiceUpdateEvent detailedInvoiceUpdateEvent = new DetailedInvoiceUpdateEvent();
        BeanUtils.copyProperties(command, detailedInvoiceUpdateEvent);
        AggregateLifecycle.apply(detailedInvoiceUpdateEvent);
    }

    @CommandHandler
    public void hendle(DeleteDetailedInvoiceCommand command) {
        DetailedInvoiceDeleteEvent detailedInvoiceDeleteEvent = new DetailedInvoiceDeleteEvent();
        BeanUtils.copyProperties(command, detailedInvoiceDeleteEvent);
        AggregateLifecycle.apply(detailedInvoiceDeleteEvent);
    }

    @EventSourcingHandler
    public void on(DetailedInvoiceCreateEvent event) {
        this.detailedInvoiceID = event.getDetailedInvoiceID();
        this.invoiceID = event.getInvoiceID();
        this.productID = event.getProductID();
        this.quantity = event.getQuantity();
        this.price = event.getPrice();
        this.totalPrice = event.getTotalPrice();
        this.isReviewed = event.isReviewed();
    }

    @EventSourcingHandler
    public void on(DetailedInvoiceUpdateEvent event) {
        this.detailedInvoiceID = event.getDetailedInvoiceID();
        this.invoiceID = event.getInvoiceID();
        this.productID = event.getProductID();
        this.quantity = event.getQuantity();
        this.price = event.getPrice();
        this.totalPrice = event.getTotalPrice();
        this.isReviewed = event.isReviewed();
    }

    @EventSourcingHandler
    public void on(DetailedInvoiceDeleteEvent event) {
        this.detailedInvoiceID = event.getDetailedInvoiceID();
    }

}
