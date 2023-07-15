package com.nhom1.invoiceservice.command.aggergate;

import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;


@Aggregate
public class DetailedInvoiceAggergate {
    @AggregateIdentifier
    private String detailedInvoiceID;
    private String invoiceID;
    private String productID;
    private int quantity;
    private int price;
    private int totalPrice;
    private boolean isReviewed;
    
    
    
}
