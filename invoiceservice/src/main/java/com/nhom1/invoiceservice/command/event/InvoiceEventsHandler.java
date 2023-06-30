package com.nhom1.invoiceservice.command.event;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nhom1.invoiceservice.command.data.Invoice;
import com.nhom1.invoiceservice.command.data.InvoiceRepository;

@Component
public class InvoiceEventsHandler {
    @Autowired
    private InvoiceRepository invoiceRepository;

    @EventHandler
    public void on(InvoiceDeleteEvent event) {
        invoiceRepository.deleteById(event.getInvoiceID());
    }
    @EventHandler
    public void on(InvoiceUpdateEvent event) {
        Invoice invoice = invoiceRepository.getById(event.getInvoiceID());
        invoice.setUserID(event.getUserID());
        invoice.setTotalCost(event.getTotalCost());
        invoice.setInvoiceDate(event.getInvoiceDate());
        invoice.setShippingDate(event.getShippingDate());
        invoice.setNote(event.getNote());
        invoice.setOtherShippingAddress(event.isOtherShippingAddress());
        invoice.setStatusInvoice(event.getStatusInvoice());
        invoice.setUserInvoiceIndex(event.getUserInvoiceIndex());
        invoiceRepository.save(invoice);
    }
    @EventHandler
    public void on(InvoiceCreateEvent event) {
        Invoice invoice = new Invoice();
        invoice.setInvoiceID(event.getInvoiceID());
        invoice.setUserID(event.getUserID());
        invoice.setTotalCost(event.getTotalCost());
        invoice.setInvoiceDate(event.getInvoiceDate());
        invoice.setShippingDate(event.getShippingDate());
        invoice.setNote(event.getNote());
        invoice.setOtherShippingAddress(event.isOtherShippingAddress());
        invoice.setStatusInvoice(event.getStatusInvoice());
        invoice.setUserInvoiceIndex(event.getUserInvoiceIndex());
        invoiceRepository.save(invoice);
    }
}
