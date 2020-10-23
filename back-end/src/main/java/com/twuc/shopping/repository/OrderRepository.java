package com.twuc.shopping.repository;

import com.twuc.shopping.Entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<OrderEntity, Integer> {
    List<OrderEntity> findAll();

    OrderEntity save(OrderEntity orderEntity);

    void deleteById(int id);
}
