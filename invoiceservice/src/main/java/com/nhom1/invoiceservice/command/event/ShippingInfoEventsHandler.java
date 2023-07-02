package com.nhom1.invoiceservice.command.event;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nhom1.invoiceservice.command.data.ShippingInfo;
import com.nhom1.invoiceservice.command.data.ShippingInfoRepository;

@Component
public class ShippingInfoEventsHandler {
    @Autowired
    private ShippingInfoRepository shippingInfoRepository;

    @EventHandler
    public void on(ShippingInfoCreateEvent shippingInfoCreateEvent) {
        ShippingInfo shippingInfo = new ShippingInfo();
        BeanUtils.copyProperties(shippingInfoCreateEvent, shippingInfo);
        shippingInfoRepository.save(shippingInfo);
    }

    @EventHandler
    public void on(ShippingInfoUpdateEvent shippingInfoUpdateEvent) {
        ShippingInfo shippingInfo = shippingInfoRepository.getById(shippingInfoUpdateEvent.getShippingInfoID());
        BeanUtils.copyProperties(shippingInfoUpdateEvent, shippingInfo);
        shippingInfoRepository.save(shippingInfo);
    }

    @EventHandler
    public void on(ShippingInfoDeleteEvent shippingInfoDelelteEvent) {
        shippingInfoRepository.deleteById(shippingInfoDelelteEvent.getShippingInfoID());
    }
}
