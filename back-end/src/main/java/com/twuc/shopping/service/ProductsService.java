package com.twuc.shopping.service;

import com.twuc.shopping.Entity.ProductEntity;
import com.twuc.shopping.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    @Autowired
    ProductsRepository productsRepository;

    public List<ProductEntity> findAll() {
        List<ProductEntity> list = productsRepository.findAll();
        return list;
    }

    public ProductEntity addProduct(ProductEntity productEntity) {
        String name = productEntity.getName();
        ProductEntity find = productsRepository.findByName(name);

        if (find != null ){
            find.setName("重名");
            return find;
        }

        ProductEntity result = productsRepository.save(productEntity);
        return result;

    }
}
