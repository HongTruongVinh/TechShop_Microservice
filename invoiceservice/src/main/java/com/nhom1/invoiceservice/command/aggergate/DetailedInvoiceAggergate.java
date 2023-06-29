package com.nhom1.invoiceservice.command.aggergate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import com.nhom1.invoiceservice.command.command.CreateDetailedInvoiceCommand;

@Aggregate
public class DetailedInvoiceAggergate {
    @AggregateIdentifier
    private int detailedInvoiceID;
    private int invoiceID;
    private int productID;
    private int quantity;
    private int price;
    private int totalPrice;
    private boolean isReviewed;
    
}
