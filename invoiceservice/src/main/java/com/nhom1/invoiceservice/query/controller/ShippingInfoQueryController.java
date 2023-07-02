package com.nhom1.invoiceservice.query.controller;

import java.util.List;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nhom1.invoiceservice.query.model.ShippingInfoResponseModel;
import com.nhom1.invoiceservice.query.queries.GetAllShippingInfoQuery;

@RestController
@RequestMapping("/api/v1/shipping-infos")
public class ShippingInfoQueryController {
    @Autowired private QueryGateway queryGateway;

    @GetMapping()
    public List<ShippingInfoResponseModel> getAllShippingInfo() {
        GetAllShippingInfoQuery getAllShippingInfoQuery = new GetAllShippingInfoQuery();
        List<ShippingInfoResponseModel> list = queryGateway.query(getAllShippingInfoQuery,
                ResponseTypes.multipleInstancesOf(ShippingInfoResponseModel.class)).join();
        return list;
    }
}
