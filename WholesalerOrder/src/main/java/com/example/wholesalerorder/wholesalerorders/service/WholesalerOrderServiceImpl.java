package com.example.wholesalerorder.wholesalerorders.service;

import com.example.wholesalerorder.tools.exception.ResourceNotFoundException;
import com.example.wholesalerorder.tools.exception.ResourceValidationException;
import com.example.wholesalerorder.wholesalerorders.domain.model.entity.WholesalerOrder;
import com.example.wholesalerorder.wholesalerorders.domain.repository.WholesalerOrderRepository;
import com.example.wholesalerorder.wholesalerorders.domain.service.WholesalerOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import java.util.List;
import java.util.Set;


@Service
public class WholesalerOrderServiceImpl implements WholesalerOrderService {
    private static final String ENTITY = "WholesalerOrder";
    private final WholesalerOrderRepository wholesalerOrderRepository;
    private final Validator validator;

    public WholesalerOrderServiceImpl(WholesalerOrderRepository wholesalerOrderRepository, Validator validator) {
        this.wholesalerOrderRepository = wholesalerOrderRepository;
        this.validator = validator;
    }

    @Override
    public List<WholesalerOrder> getAll() {
        return wholesalerOrderRepository.findAll();
    }

    @Override
    public WholesalerOrder getById(Long wholesalerOrderId) {
        return wholesalerOrderRepository.findById(wholesalerOrderId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, wholesalerOrderId));
    }

    /*@Override
    public List<WholesalerOrder> getByRetailSellerId(Long retailSellerId){
        Optional<RetailSeller> retailSeller = retailSellerRepository.findById(retailSellerId);
        if(!retailSeller.isPresent())
            throw new ResourceNotFoundException(ENTITY2, retailSellerId);

        return wholesalerOrderRepository.findByRetailSellerId(retailSellerId);
    }*/

    @Override
    public WholesalerOrder create(WholesalerOrder wholesalerOrder) {
        Set<ConstraintViolation<WholesalerOrder>> violations = validator.validate(wholesalerOrder);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);


        return wholesalerOrderRepository.save(wholesalerOrder);
    }

    @Override
    public WholesalerOrder update(Long wholesalerOrderId, WholesalerOrder request) {
        Set<ConstraintViolation<WholesalerOrder>> violations = validator.validate(request);

        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        WholesalerOrder existingOrder = wholesalerOrderRepository.findById(wholesalerOrderId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, wholesalerOrderId));

        // Actualiza los campos individuales
        existingOrder.setQuantity(request.getQuantity());
        existingOrder.setRetailSellerId(request.getRetailSellerId());
        existingOrder.setProductId(request.getProductId());

        return wholesalerOrderRepository.save(existingOrder);
    }

    @Override
    public ResponseEntity<?> delete(Long wholesalerOrderId) {
        return wholesalerOrderRepository.findById(wholesalerOrderId).map(wholesalerOrder -> {
            wholesalerOrderRepository.delete(wholesalerOrder);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, wholesalerOrderId));
    }

}
