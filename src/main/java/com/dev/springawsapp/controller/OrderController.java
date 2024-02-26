package com.dev.springawsapp.controller;

import com.dev.springawsapp.model.Order;
import com.dev.springawsapp.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@AllArgsConstructor
public class OrderController {

    public OrderService orderService;

    @PostMapping("/order")
    public String saveOrder(@RequestBody Order order){

        return orderService.addOrder(order);
    }

    @GetMapping("/orders")
    public List<Order> getAllOrders(@RequestHeader String auth){
        if(auth.equalsIgnoreCase("admin")){
            return orderService.getALlOrders();
        }

        return Collections.emptyList();
    }

    @GetMapping("/order/{orderId}")
    public Order getOrder(@PathVariable Long orderId){
        return orderService.getOrder(orderId);
    }


}
