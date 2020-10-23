package com.twuc.shopping.dto;


import com.twuc.shopping.Entity.OrderEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    private int id;
    private String productName;
    private int price;
    private int number;
    private String unit;

    public static Order from(OrderEntity orderEntity) {
        return Order.builder()
                .id(orderEntity.getId())
                .productName(orderEntity.getProductName())
                .price(orderEntity.getPrice())
                .number(orderEntity.getNumber())
                .unit(orderEntity.getUnit())
                .build();
    }
}
