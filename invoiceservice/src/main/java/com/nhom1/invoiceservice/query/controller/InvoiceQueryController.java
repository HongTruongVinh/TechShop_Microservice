package com.nhom1.invoiceservice.query.controller;

import java.util.List;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nhom1.invoiceservice.command.data.Invoice;
import com.nhom1.invoiceservice.query.model.InvoiceResponseModel;
import com.nhom1.invoiceservice.query.queries.GetAllInvoiceQuery;
import com.nhom1.invoiceservice.query.queries.GetInvoiceByIdQuery;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

@RestController
@RequestMapping("/api/v1/invoice")
public class InvoiceQueryController {
    @Autowired
    private QueryGateway queryGateway;

    
    @GetMapping("/{invoiceID}")
    public InvoiceResponseModel getInvoiceDetail(@PathVariable String invoiceID) {
        GetInvoiceByIdQuery getInvoiceByIdQuery = new GetInvoiceByIdQuery();
        getInvoiceByIdQuery.setInvoiceId(invoiceID);

        InvoiceResponseModel invoiceResponseModel = queryGateway.query(getInvoiceByIdQuery,
                ResponseTypes.instanceOf(InvoiceResponseModel.class)).join();

        return invoiceResponseModel;
    }
    
	/*
	 * @GetMapping("/user") public List<InvoiceResponseModel> getAllUserInvoices() {
	 * 
	 * GetAllInvoiceQuery getAllInvoiceQuery = new GetAllInvoiceQuery();
	 * 
	 * List<InvoiceResponseModel> list = queryGateway.query(getAllInvoiceQuery,
	 * ResponseTypes.multipleInstancesOf(InvoiceResponseModel.class)).join(); return
	 * list; }
	 */
    
    @GetMapping("/user")
    public List<Invoice> getAllUserInvoices() {
    	
        GetAllInvoiceQuery getAllInvoiceQuery = new GetAllInvoiceQuery();
        
        List<Invoice> list = queryGateway.query(getAllInvoiceQuery,
                ResponseTypes.multipleInstancesOf(Invoice.class)).join();
        return list;
    }
    
    
    
    
    /////////////////////////////////////////////////////////////////////////////////
    
    @GetMapping()
    public List<InvoiceResponseModel> getAllInvoiceDetail() {
        GetAllInvoiceQuery getAllInvoiceQuery = new GetAllInvoiceQuery();
        List<InvoiceResponseModel> list = queryGateway.query(getAllInvoiceQuery,
                ResponseTypes.multipleInstancesOf(InvoiceResponseModel.class)).join();
        return list;
    }

   

    @GetMapping("/user/{id}")
    public List<InvoiceResponseModel> getAllInvoiceByUserId(@PathVariable int id) {
        GetAllInvoiceQuery getAllInvoiceQuery = new GetAllInvoiceQuery();
        
        List<InvoiceResponseModel> list = queryGateway.query(getAllInvoiceQuery,
                ResponseTypes.multipleInstancesOf(InvoiceResponseModel.class)).join();
        return list;
    }

}
