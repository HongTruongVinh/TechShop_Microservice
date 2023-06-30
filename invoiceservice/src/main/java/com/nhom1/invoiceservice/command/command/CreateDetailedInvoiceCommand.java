package com.nhom1.invoiceservice.command.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateDetailedInvoiceCommand {
    @TargetAggregateIdentifier
    private int detailedInvoiceID;
    private int invoiceID;
    private int productID;
    private int quantity;
    private int price;
    private int totalPrice;
    private boolean isReviewed;

}
