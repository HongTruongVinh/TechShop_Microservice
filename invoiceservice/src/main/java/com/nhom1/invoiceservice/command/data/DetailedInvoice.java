package com.nhom1.invoiceservice.command.data;

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
@Table(name = "DETAILEDINVOICE")
public class DetailedInvoice {
	
	@Id
	private int detailedInvoiceID;
	private int invoiceID;
	private int productID;
	private int quantity;
	private int price;
	private int totalPrice;
	private boolean isReviewed;
	
}