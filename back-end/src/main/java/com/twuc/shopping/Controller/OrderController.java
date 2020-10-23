package com.twuc.shopping.Controller;

import com.twuc.shopping.Entity.OrderEntity;
import com.twuc.shopping.dto.Order;
import com.twuc.shopping.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@ResponseBody
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> queryOrderList() {
        List<OrderEntity> orderEntityList = orderService.queryOrderlist();
        List<Order> orderList = orderEntityList.stream().map(Order::from).collect(Collectors.toList());
        return ResponseEntity.ok().body(orderList);

    }

    @PostMapping("/order")
    public ResponseEntity<Order> addOrder(@RequestBody Order order) {
        OrderEntity orderEntity = OrderEntity.builder()
                .productName(order.getProductName())
                .number(order.getNumber())
                .price(order.getPrice())
                .unit(order.getUnit())
                .build();
        OrderEntity addtion = orderService.addOrder(orderEntity);

        Order result = Order.builder()
                .productName(addtion.getProductName())
                .id(addtion.getId())
                .number(addtion.getNumber())
                .price(addtion.getPrice())
                .unit(addtion.getUnit())
                .build();
        if (result == null)
            return ResponseEntity.status(400).build();
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/order/{id}")
    public ResponseEntity<Order> deleteOrder(@PathVariable int id){
         orderService.deleteOrderById(id);
        return ResponseEntity.ok().build();
    }
}
