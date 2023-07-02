package com.nhom1.invoiceservice.command.data;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SHIPPINGINFO")
public class ShippingInfo {
    @Id
    private int shippingInfoID;
    private int invoiceID;
    private String fullName;
    private String phoneNumber;
    private String address;
}
