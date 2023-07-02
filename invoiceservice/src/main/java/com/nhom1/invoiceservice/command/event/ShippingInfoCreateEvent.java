package com.nhom1.invoiceservice.command.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShippingInfoCreateEvent {
    private int shippingInfoID;
    private int invoiceID;
    private String fullName;
    private String phoneNumber;
    private String address;
}