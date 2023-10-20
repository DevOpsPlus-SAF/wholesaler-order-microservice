package com.example.wholesalerorder.wholesalerorders.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class WholesalerOrderResource {

    private Long id;
    private Long quantity;
    private Long retailSellerId;
    private Long productId;
    private String operationCode;

    private boolean isPaid;
    public WholesalerOrderResource(
            Long id,
            Long quantity,
            Long retailSellerId,
            Long productId
    ) {
        this.id = id;
        this.quantity = quantity;
        this.retailSellerId = retailSellerId;
        this.productId = productId;
        this.operationCode = null;
        this.isPaid = false;
    }
}
