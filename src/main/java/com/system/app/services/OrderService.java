package com.system.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.app.entities.Order;

@Service
public class OrderService {

    @Autowired
    private ShippingService shippingService;

    public Double total(Order order) {
        var value = order.getBasic() - ((order.getDiscount() / 100) * order.getBasic());
        value += shippingService.shipment(order);
        return value;
    }
}
