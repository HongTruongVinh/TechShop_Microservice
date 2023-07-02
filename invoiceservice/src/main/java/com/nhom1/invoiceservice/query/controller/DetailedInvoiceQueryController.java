package com.nhom1.invoiceservice.query.controller;

import java.util.List;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nhom1.invoiceservice.query.model.DetailedInvoiceResponseModel;
import com.nhom1.invoiceservice.query.queries.GetAllDetailedInvoiceQuery;

@RestController
@RequestMapping("/api/v1/detailed-invoices")
public class DetailedInvoiceQueryController {
    @Autowired private QueryGateway queryGateway;

    @GetMapping()
    public List<DetailedInvoiceResponseModel> getAllDetailedInvoice() {
        GetAllDetailedInvoiceQuery getAllDetailedInvoiceQuery = new GetAllDetailedInvoiceQuery();
        List<DetailedInvoiceResponseModel> list = queryGateway.query(getAllDetailedInvoiceQuery,
                ResponseTypes.multipleInstancesOf(DetailedInvoiceResponseModel.class)).join();
        return list;
    }

}
