package com.orderServices.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderServices.Binding.OrderDTO;
import com.orderServices.OrderRequest.OrderRequestDTO;
import com.orderServices.Service.OrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@Valid @RequestBody OrderRequestDTO orderRequest) {
        OrderDTO orderDTO = orderService.createOrder(orderRequest);
        return new ResponseEntity<>(orderDTO, HttpStatus.CREATED);
    }
}