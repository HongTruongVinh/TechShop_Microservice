package com.nhom1.invoiceservice.command.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateShippingInfoCommand {
    @TargetAggregateIdentifier
    private int shippingInfoID;
    private int invoiceID;
    private String fullName;
    private String phoneNumber;
    private String address;
}
