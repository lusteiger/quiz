package com.twuc.shopping.repository;

import com.twuc.shopping.Entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductsRepository extends CrudRepository<ProductEntity,Integer> {
    List<ProductEntity> findAll();
    ProductEntity findByName(String name);
    ProductEntity save(ProductEntity productEntity);
}
