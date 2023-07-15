package com.nhom1.invoiceservice.command.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailedInvoiceDeleteEvent {
    private int detailedInvoiceID;

	public int getDetailedInvoiceID() {
		return detailedInvoiceID;
	}

	public void setDetailedInvoiceID(int detailedInvoiceID) {
		this.detailedInvoiceID = detailedInvoiceID;
	}
    
}
