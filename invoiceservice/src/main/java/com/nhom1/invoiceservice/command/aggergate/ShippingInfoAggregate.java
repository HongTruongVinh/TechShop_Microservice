package com.nhom1.invoiceservice.command.aggergate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import com.nhom1.invoiceservice.command.command.CreateShippingInfoCommand;
import com.nhom1.invoiceservice.command.command.DeleteShippingInfoCommand;
import com.nhom1.invoiceservice.command.command.UpdateShippingInfoCommand;
import com.nhom1.invoiceservice.command.event.ShippingInfoCreateEvent;
import com.nhom1.invoiceservice.command.event.ShippingInfoDeleteEvent;
import com.nhom1.invoiceservice.command.event.ShippingInfoUpdateEvent;

@Aggregate
public class ShippingInfoAggregate {
    @AggregateIdentifier
    private int shippingInfoID;
    private int invoiceID;
    private String fullName;
    private String phoneNumber;
    private String address;

    public ShippingInfoAggregate() {
    }
    @CommandHandler
    public ShippingInfoAggregate(CreateShippingInfoCommand createShippingInfoCommand) {
        ShippingInfoCreateEvent shippingInfoCreateEvent = new ShippingInfoCreateEvent();
        BeanUtils.copyProperties(createShippingInfoCommand, shippingInfoCreateEvent);
        AggregateLifecycle.apply(shippingInfoCreateEvent);
    }

    @CommandHandler
    public void hendle(UpdateShippingInfoCommand updateShippingInfoCommand) {
        ShippingInfoUpdateEvent shippingInfoUpdateEvent = new ShippingInfoUpdateEvent();
        BeanUtils.copyProperties(updateShippingInfoCommand, shippingInfoUpdateEvent);
        AggregateLifecycle.apply(shippingInfoUpdateEvent);
    }

    @CommandHandler
    public void hendle(DeleteShippingInfoCommand deleteShippingInfoCommand) {
        ShippingInfoDeleteEvent shippingInfoDeleteEvent = new ShippingInfoDeleteEvent();
        BeanUtils.copyProperties(deleteShippingInfoCommand, shippingInfoDeleteEvent);
        AggregateLifecycle.apply(shippingInfoDeleteEvent);
    }

    @EventSourcingHandler
    public void on(ShippingInfoUpdateEvent event) {
        this.shippingInfoID = event.getShippingInfoID();
        this.invoiceID = event.getInvoiceID();
        this.fullName = event.getFullName();
        this.phoneNumber = event.getPhoneNumber();
        this.address = event.getAddress();
    }

    @EventSourcingHandler
    public void on(ShippingInfoDeleteEvent event) {
        this.shippingInfoID = event.getShippingInfoID();
    }

    @EventSourcingHandler
    public void on(ShippingInfoCreateEvent event) {
        this.shippingInfoID = event.getShippingInfoID();
        this.invoiceID = event.getInvoiceID();
        this.fullName = event.getFullName();
        this.phoneNumber = event.getPhoneNumber();
        this.address = event.getAddress();
    }

    

}
