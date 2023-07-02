package com.nhom1.invoiceservice.query.projection;

import java.util.ArrayList;
import java.util.List;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nhom1.invoiceservice.command.data.Invoice;
import com.nhom1.invoiceservice.command.data.InvoiceRepository;
import com.nhom1.invoiceservice.query.model.InvoiceResponseModel;
import com.nhom1.invoiceservice.query.queries.GetAllInvoiceByUserIdQuery;
import com.nhom1.invoiceservice.query.queries.GetAllInvoiceQuery;
import com.nhom1.invoiceservice.query.queries.GetInvoiceByIdQuery;

@Component
public class InvoiceProjection {
    @Autowired
    private InvoiceRepository invoiceRepository;

    @QueryHandler
    public List<InvoiceResponseModel> handle(GetAllInvoiceQuery getAllInvoiceQuery) {
        List<Invoice> listInvoices = invoiceRepository.findAll();
        List<InvoiceResponseModel> responseModels = new ArrayList<>();
        listInvoices.forEach(invoice -> {
            InvoiceResponseModel model = new InvoiceResponseModel();
            BeanUtils.copyProperties(invoice, model);
            responseModels.add(model);
        });
        return responseModels;
    }

    @QueryHandler
    public InvoiceResponseModel handle(GetInvoiceByIdQuery getInvoiceByIdQuery) {
        InvoiceResponseModel model = new InvoiceResponseModel();
        Invoice entity = invoiceRepository.getById(getInvoiceByIdQuery.getInvoiceId());
        BeanUtils.copyProperties(entity, model);
        return model;
    }

    @QueryHandler
    public List<InvoiceResponseModel> handle(GetAllInvoiceByUserIdQuery getAllInvoiceByUserIdQuery) {
        List<Invoice> listInvoices = invoiceRepository.findAll();
        List<InvoiceResponseModel> responseModels = new ArrayList<>();

        listInvoices.forEach(invoice -> {
            if (invoice.getUserID() == getAllInvoiceByUserIdQuery.getUserID()) {
                InvoiceResponseModel model = new InvoiceResponseModel();
                BeanUtils.copyProperties(invoice, model);
                responseModels.add(model);
            }
        });
        return responseModels;
    }
}
