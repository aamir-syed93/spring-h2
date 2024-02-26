package com.dev.springawsapp.service;

import com.dev.springawsapp.model.Order;
import com.dev.springawsapp.repo.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class OrderService {

    private OrderRepository orderRepository;

    public String addOrder(Order order){
        var productPrice = new Random().nextInt(20, 250);
        order.setProduct_price(productPrice);
        order.setOrder_bill_price(productPrice * order.getQuantity());
        var savedOrder = orderRepository.save(order);
        return "Your Order "+savedOrder.getOrder_id()+" is placed with bill amount : "+savedOrder.getOrder_bill_price();

    }

    public List<Order> getALlOrders(){
        return orderRepository.findAll();
    }

    public Order getOrder(Long orderId){
        return orderRepository.findById(orderId).orElse(new Order());
    }

}
