package com.example.wholesalerorder.wholesalerorders.domain.model.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "wholesaler_order")
public class WholesalerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long quantity;

    private Long retailSellerId;

    private Long productId;

    private String operationCode;

    private boolean isPaid;
}
