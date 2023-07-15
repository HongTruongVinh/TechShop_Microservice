package com.nhom1.invoiceservice.command.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data   
@AllArgsConstructor
@NoArgsConstructor
public class DeleteInvoiceCommand {
    @TargetAggregateIdentifier
    private String invoiceID;

	public DeleteInvoiceCommand(String invoiceID) {
		super();
		this.invoiceID = invoiceID;
	}

	public String getInvoiceID() {
		return invoiceID;
	}

	public void setInvoiceID(String invoiceID) {
		this.invoiceID = invoiceID;
	}
    
    
}
