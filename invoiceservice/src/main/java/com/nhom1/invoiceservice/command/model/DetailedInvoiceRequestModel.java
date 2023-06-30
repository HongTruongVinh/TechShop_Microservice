package com.nhom1.invoiceservice.command.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailedInvoiceRequestModel {
    private int detailedInvoiceID;
	private int invoiceID;
	private int productID;
	private int quantity;
	private int price;
	private int totalPrice;
	private boolean isReviewed;

}
