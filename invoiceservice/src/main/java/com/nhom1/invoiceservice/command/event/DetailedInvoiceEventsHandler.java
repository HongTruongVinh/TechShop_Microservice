package com.nhom1.invoiceservice.command.event;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nhom1.invoiceservice.command.data.DetailedInvoice;
import com.nhom1.invoiceservice.command.data.DetailedInvoiceRepository;

@Component
public class DetailedInvoiceEventsHandler {
    @Autowired
    private DetailedInvoiceRepository detailedInvoiceRepository;

    @EventHandler
    public void on(DetailedInvoiceDeleteEvent event) {
        detailedInvoiceRepository.deleteById(event.getDetailedInvoiceID());
    }
    @EventHandler
    public void on(DetailedInvoiceUpdateEvent event) {
        DetailedInvoice detailedInvoice = detailedInvoiceRepository.getById(event.getDetailedInvoiceID());
        detailedInvoice.setInvoiceID(event.getInvoiceID());
        detailedInvoice.setProductID(event.getProductID());
        detailedInvoice.setQuantity(event.getQuantity());
        detailedInvoice.setPrice(event.getPrice());
        detailedInvoice.setTotalPrice(event.getTotalPrice());
        detailedInvoice.setReviewed(event.isReviewed());
        detailedInvoiceRepository.save(detailedInvoice);
    }
    @EventHandler
    public void on(DetailedInvoiceCreateEvent event) {
        DetailedInvoice detailedInvoice = new DetailedInvoice();
        BeanUtils.copyProperties(event, detailedInvoice);
        detailedInvoiceRepository.save(detailedInvoice);
    }
}
