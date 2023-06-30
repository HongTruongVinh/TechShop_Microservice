package com.nhom1.invoiceservice.command.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceDeleteEvent {
    private int invoiceID;
}
