package com.nhom1.invoiceservice.command.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteDetailedInvoiceCommand {
    @TargetAggregateIdentifier
    private String detailedInvoiceID;
    
	public DeleteDetailedInvoiceCommand(String detailedInvoiceID) {
		super();
		this.detailedInvoiceID = detailedInvoiceID;
	}

	public String getDetailedInvoiceID() {
		return detailedInvoiceID;
	}

	public void setDetailedInvoiceID(String detailedInvoiceID) {
		this.detailedInvoiceID = detailedInvoiceID;
	}
    
    
}
