package com.nhom1.invoiceservice.command.controller;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nhom1.invoiceservice.command.command.CreateInvoiceCommand;
import com.nhom1.invoiceservice.command.command.DeleteInvoiceCommand;
import com.nhom1.invoiceservice.command.command.UpdateInvoiceCommand;
import com.nhom1.invoiceservice.command.model.InvoiceRequestModel;

@RestController
@RequestMapping("/api/v1/invoices")
public class InvoiceCommandController {
    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String addInvoiceString(InvoiceRequestModel model) {
        CreateInvoiceCommand command = new CreateInvoiceCommand(model.getInvoiceID(), model.getUserID(),
                model.getTotalCost(), model.getInvoiceDate(), model.getShippingDate(), model.getNote(),
                model.isOtherShippingAddress(), model.getStatusInvoice(), model.getUserInvoiceIndex());
        commandGateway.sendAndWait(command);
        return "added Invoice";
    }

    @PutMapping()
    public String updateInvoiceString(InvoiceRequestModel model) {
        UpdateInvoiceCommand command = new UpdateInvoiceCommand(model.getInvoiceID(), model.getUserID(),
                model.getTotalCost(), model.getInvoiceDate(), model.getShippingDate(), model.getNote(),
                model.isOtherShippingAddress(), model.getStatusInvoice(), model.getUserInvoiceIndex());
        commandGateway.sendAndWait(command);
        return "updated Invoice";
    }

    @DeleteMapping("/{invoiceId}")
    public String deleteInvoice(@PathVariable int invoiceId) {
        DeleteInvoiceCommand command = new DeleteInvoiceCommand(invoiceId);
        commandGateway.sendAndWait(command);
        return "deleted Invoice";
    }

}
