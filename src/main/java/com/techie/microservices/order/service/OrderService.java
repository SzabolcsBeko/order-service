package com.techie.microservices.order.service;

import com.techie.microservices.order.dto.OrderRequest;
import com.techie.microservices.order.model.Order;
import com.techie.microservices.order.repository.OrderRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

  private final OrderRepository orderRepository;

  public void placeOrder(OrderRequest orderRequest){
    Order order = new Order();
    order.setOrderNumber(UUID.randomUUID().toString());
    order.setPrice(orderRequest.price());
    order.setSkuCode(orderRequest.skuCode());
    order.setQuantity(orderRequest.quantity());

    orderRepository.save(order);

  }

}
