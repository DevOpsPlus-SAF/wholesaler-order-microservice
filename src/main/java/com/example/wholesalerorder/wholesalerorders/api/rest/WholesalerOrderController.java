package com.example.wholesalerorder.wholesalerorders.api.rest;

import com.example.wholesalerorder.wholesalerorders.domain.model.entity.WholesalerOrder;
import com.example.wholesalerorder.wholesalerorders.domain.service.WholesalerOrderService;
import com.example.wholesalerorder.wholesalerorders.mapping.WholesalerOrderMapper;
import com.example.wholesalerorder.wholesalerorders.resource.WholesalerOrderResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*", allowedHeaders = "Requestor-Type")
@RestController
@RequestMapping("api/v1/wholesaler-orders")
public class WholesalerOrderController {
    private final WholesalerOrderService wholesalerOrderService;
    private final WholesalerOrderMapper mapper;

    public WholesalerOrderController(WholesalerOrderService wholesalerOrderService, WholesalerOrderMapper mapper){
        this.wholesalerOrderService = wholesalerOrderService;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<WholesalerOrderResource>> getAll(){
        List<WholesalerOrderResource> resources = mapper.toResource(wholesalerOrderService.getAll());
        return ResponseEntity.ok().body(resources);
    }

    @GetMapping("{wholesalerOrderId}")
    public WholesalerOrderResource getWholesalerOrderById(@PathVariable Long wholesalerOrderId){
        return mapper.toResource(wholesalerOrderService.getById(wholesalerOrderId));
    }

    /*@GetMapping("retailSellerId/{retailSellerId}")
    public ResponseEntity<List<WholesalerOrder>> getByRetailSellerId(@PathVariable Long retailSellerId) {
        List<WholesalerOrder> orders = wholesalerOrderService.getByRetailSellerId(retailSellerId);
        return ResponseEntity.ok().body(orders);
    }*/

    @PostMapping
    public ResponseEntity<WholesalerOrder> createWholesalerOrder(@RequestBody WholesalerOrder order) {
        WholesalerOrder createdOrder = wholesalerOrderService.create(order);
        return ResponseEntity.ok().body(createdOrder);
    }

    @PutMapping("{wholesalerOrderId}")
    public ResponseEntity<WholesalerOrder> updateWholesalerOrder(
            @PathVariable Long wholesalerOrderId, @RequestBody WholesalerOrder order) {
        WholesalerOrder updatedOrder = wholesalerOrderService.update(wholesalerOrderId, order);
        return ResponseEntity.ok().body(updatedOrder);
    }

    @DeleteMapping("{wholesalerOrderId}")
    public ResponseEntity<?> deleteWholesalerOrder(@PathVariable Long wholesalerOrderId) {
        wholesalerOrderService.delete(wholesalerOrderId);
        return ResponseEntity.noContent().build();
    }

}
