package com.nhom1.invoiceservice.command.controller;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.checkerframework.checker.units.qual.m;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nhom1.invoiceservice.command.command.*;
import com.nhom1.invoiceservice.command.model.DetailedInvoiceRequestModel;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/v1/detailed-invoices")
public class DetailedInvoiceCommandController {
    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String addInvoiceString(DetailedInvoiceRequestModel model) {
        CreateDetailedInvoiceCommand command = new CreateDetailedInvoiceCommand(model.getDetailedInvoiceID(), model.getInvoiceID(), model.getProductID(), model.getQuantity(),model.getPrice(), model.getTotalPrice(), model.isReviewed());
        commandGateway.sendAndWait(command);
        return "added Detailed Invoice";
    }
    
    @PutMapping()
    public String updateInvoiceString(DetailedInvoiceRequestModel model) {
        UpdateDetailedInvoiceCommand command = new UpdateDetailedInvoiceCommand(model.getDetailedInvoiceID(), model.getInvoiceID(), model.getProductID(), model.getQuantity(), model.getPrice(), model.getTotalPrice(), model.isReviewed());
        commandGateway.sendAndWait(command);
        return "updated Detailed Invoice";
    }

    @DeleteMapping("/{invoiceId}")
    public String deleteInvoice(@PathVariable int invoiceId) {
        DeleteDetailedInvoiceCommand command = new DeleteDetailedInvoiceCommand(invoiceId);
        commandGateway.sendAndWait(command);
        return "deleted Detailed Invoice";
    }
}
