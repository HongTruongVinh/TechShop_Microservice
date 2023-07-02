package com.nhom1.invoiceservice.command.controller;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nhom1.invoiceservice.command.command.CreateShippingInfoCommand;
import com.nhom1.invoiceservice.command.command.DeleteShippingInfoCommand;
import com.nhom1.invoiceservice.command.command.UpdateShippingInfoCommand;
import com.nhom1.invoiceservice.command.model.ShippingInfoRequestModel;

@RestController
@RequestMapping("/api/v1/shipping-infos")
public class ShippingInfoController {

    @Autowired
    private CommandGateway commandGateway;

   

    @PostMapping
    public String addShippingInfo(@RequestBody ShippingInfoRequestModel model) {
        CreateShippingInfoCommand command = new CreateShippingInfoCommand(model.getShippingInfoID(),
                model.getInvoiceID(), model.getFullName(), model.getPhoneNumber(), model.getAddress());
        commandGateway.sendAndWait(command);
        return "added Shipping Info";
    }

    @PutMapping
    public String updateShippingInfo(@RequestBody ShippingInfoRequestModel model) {
        UpdateShippingInfoCommand command = new UpdateShippingInfoCommand(model.getShippingInfoID(),
                model.getInvoiceID(), model.getFullName(), model.getPhoneNumber(), model.getAddress());
        commandGateway.sendAndWait(command);
        return "updated Shipping Info";
    }

    @DeleteMapping("/{shippingInfoId}")
    public String deleteShippingInfo(@PathVariable int shippingInfoId) {
        DeleteShippingInfoCommand command = new DeleteShippingInfoCommand(shippingInfoId);
        commandGateway.sendAndWait(command);
        return "deleted Shipping Info";
    }

}
