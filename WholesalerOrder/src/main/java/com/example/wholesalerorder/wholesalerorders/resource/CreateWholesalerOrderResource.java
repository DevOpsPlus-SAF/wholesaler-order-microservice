package com.example.wholesalerorder.wholesalerorders.resource;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateWholesalerOrderResource {
    @NotNull
    @Positive
    private Long quantity;
    private Long retailSellerId;
    private Long productId;
    private String operationCode;
    private boolean isPaid;

    public CreateWholesalerOrderResource(
            Long Id,
            Long quantity,
            Long retailSellerId,
            Long productId
    ) {
        this.quantity = quantity;
        this.retailSellerId = retailSellerId;
        this.productId = productId;
        this.operationCode = null;
        this.isPaid = false;
    }

}