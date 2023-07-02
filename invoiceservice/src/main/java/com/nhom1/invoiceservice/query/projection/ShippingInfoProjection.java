package com.nhom1.invoiceservice.query.projection;

import java.util.ArrayList;
import java.util.List;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nhom1.invoiceservice.command.data.ShippingInfo;
import com.nhom1.invoiceservice.command.data.ShippingInfoRepository;
import com.nhom1.invoiceservice.query.model.ShippingInfoResponseModel;
import com.nhom1.invoiceservice.query.queries.GetAllShippingInfoQuery;

@Component
public class ShippingInfoProjection {
    
    @Autowired
    private ShippingInfoRepository shippingInfoRepository;

    @QueryHandler
    public List<ShippingInfoResponseModel> handle(GetAllShippingInfoQuery getAllShippingInfoQuery) {
        List<ShippingInfo> listShippingInfos = shippingInfoRepository.findAll();
        List<ShippingInfoResponseModel> responseModels = new ArrayList<>();

        listShippingInfos.forEach(shippingInfo -> {
            ShippingInfoResponseModel model = new ShippingInfoResponseModel();
            BeanUtils.copyProperties(shippingInfo, model);
            responseModels.add(model);
        });
        return responseModels;
    }
}