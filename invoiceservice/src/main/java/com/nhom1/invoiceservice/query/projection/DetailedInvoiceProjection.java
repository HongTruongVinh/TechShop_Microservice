package com.nhom1.invoiceservice.query.projection;

import java.util.ArrayList;
import java.util.List;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nhom1.invoiceservice.command.data.DetailedInvoice;
import com.nhom1.invoiceservice.command.data.DetailedInvoiceRepository;
import com.nhom1.invoiceservice.query.model.DetailedInvoiceResponseModel;
import com.nhom1.invoiceservice.query.queries.GetAllDetailedInvoiceQuery;

@Component
public class DetailedInvoiceProjection {
    @Autowired
    private DetailedInvoiceRepository detailedInvoiceRepository;

    @QueryHandler
    public List<DetailedInvoiceResponseModel> handle(GetAllDetailedInvoiceQuery getAllDetailedInvoiceQuery) {
        List<DetailedInvoice> listDetailedInvoices = detailedInvoiceRepository.findAll();
        List<DetailedInvoiceResponseModel> responseModels = new ArrayList<>();

        listDetailedInvoices.forEach(detailedInvoice -> {
            DetailedInvoiceResponseModel model = new DetailedInvoiceResponseModel();
            BeanUtils.copyProperties(detailedInvoice, model);
            responseModels.add(model);
        });
        return responseModels;
    }
}
