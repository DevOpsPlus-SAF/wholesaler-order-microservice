package com.example.wholesalerorder.wholesalerorders.domain.service;

import com.example.wholesalerorder.wholesalerorders.domain.model.entity.WholesalerOrder;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface WholesalerOrderService {
    List<WholesalerOrder> getAll();
    WholesalerOrder getById(Long wholesalerOrderId);
    //List<WholesalerOrder> getByRetailSellerId(Long retailSellerId);
    WholesalerOrder create(WholesalerOrder wholesalerOrder);
    WholesalerOrder update(Long id, WholesalerOrder wholesalerOrder);
    ResponseEntity<?> delete(Long wholesalerOrderId);
}
