package com.twuc.shopping.dto;

import com.twuc.shopping.Entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    private Integer id;
    private String name;
    private int price;
    private String unit;
    private String prictureUrl;


    public static Product from(ProductEntity productEntity) {
        return Product.builder()
                .id(productEntity.getId())
                .name(productEntity.getName())
                .price(productEntity.getPrice())
                .unit(productEntity.getUnit())
                .prictureUrl(productEntity.getPrictureUrl())
                .build();
    }


}

