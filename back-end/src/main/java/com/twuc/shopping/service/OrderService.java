package com.twuc.shopping.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twuc.shopping.Entity.OrderEntity;
import com.twuc.shopping.dto.Order;
import com.twuc.shopping.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public List<OrderEntity> queryOrderlist(){
       List<OrderEntity> orderEntityList = orderRepository.findAll();
       return orderEntityList;
    }

    public OrderEntity addOrder(OrderEntity orderEntity){
        OrderEntity result = orderRepository.save(orderEntity);
        return result;
    }

    public void deleteOrderById(int id){
         orderRepository.deleteById(id);

    }
}
