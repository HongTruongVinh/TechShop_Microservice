package com.nhom1.invoiceservice.command.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShippingInfoRequestModel {
    private int shippingInfoID;
    private int invoiceID;
    private String fullName;
    private String phoneNumber;
    private String address;
}
