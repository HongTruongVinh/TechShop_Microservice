package com.nhom1.invoiceservice.command.aggergate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import com.nhom1.invoiceservice.command.command.CreateInvoiceCommand;
import com.nhom1.invoiceservice.command.command.DeleteInvoiceCommand;
import com.nhom1.invoiceservice.command.command.UpdateInvoiceCommand;
import com.nhom1.invoiceservice.command.event.InvoiceCreateEvent;
import com.nhom1.invoiceservice.command.event.InvoiceDeleteEvent;
import com.nhom1.invoiceservice.command.event.InvoiceUpdateEvent;

@Aggregate
public class InvoiceAggregate {
    @AggregateIdentifier
    private int invoiceID;
    private int userID;
    private int totalCost;
    private String invoiceDate;
    private String shippingDate;
    private String note;
    private boolean otherShippingAddress;
    private String statusInvoice = "PENDING";
    private String userInvoiceIndex;

    public InvoiceAggregate() {
 }

    @CommandHandler
    public InvoiceAggregate(CreateInvoiceCommand command) {
        InvoiceCreateEvent invoiceCreateEvent = new InvoiceCreateEvent();
        BeanUtils.copyProperties(command, invoiceCreateEvent);
        AggregateLifecycle.apply(invoiceCreateEvent);
    }

    @CommandHandler
    public void hendle(UpdateInvoiceCommand command) {
        InvoiceUpdateEvent invoiceUpdateEvent = new InvoiceUpdateEvent();
        BeanUtils.copyProperties(command, invoiceUpdateEvent);
        AggregateLifecycle.apply(invoiceUpdateEvent);
    }

    @CommandHandler
    public void hendle(DeleteInvoiceCommand command) {
        InvoiceDeleteEvent invoiceDeleteEvent = new InvoiceDeleteEvent();
        BeanUtils.copyProperties(command, invoiceDeleteEvent);
        AggregateLifecycle.apply(invoiceDeleteEvent);
    }

    @EventSourcingHandler
    public void on(InvoiceCreateEvent event) {
        this.invoiceID = event.getInvoiceID();
        this.userID = event.getUserID();
        this.totalCost = event.getTotalCost();
        this.invoiceDate = event.getInvoiceDate();
        this.shippingDate = event.getShippingDate();
        this.note = event.getNote();
        this.otherShippingAddress = event.isOtherShippingAddress();
        this.statusInvoice = event.getStatusInvoice();
        this.userInvoiceIndex = event.getUserInvoiceIndex();
    }

    @EventSourcingHandler
    public void on(InvoiceUpdateEvent event) {
        this.invoiceID = event.getInvoiceID();
        this.userID = event.getUserID();
        this.totalCost = event.getTotalCost();
        this.invoiceDate = event.getInvoiceDate();
        this.shippingDate = event.getShippingDate();
        this.note = event.getNote();
        this.otherShippingAddress = event.isOtherShippingAddress();
        this.statusInvoice = event.getStatusInvoice();
        this.userInvoiceIndex = event.getUserInvoiceIndex();
    }

    @EventSourcingHandler
    public void on(InvoiceDeleteEvent event) {
        this.invoiceID = event.getInvoiceID();
    }

}
