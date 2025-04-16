package com.orderServices.Service;

import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.orderServices.Binding.OrderDTO;
import com.orderServices.Entity.Order;
import com.orderServices.Exceptions.ResourceNotFoundException;
import com.orderServices.OrderRequest.OrderRequestDTO;
import com.orderServices.Repository.OrderRepository;

import jakarta.transaction.Transactional;


@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final RestTemplate restTemplate;

    @Value("${user.service.url}")
    private String userServiceUrl;

    @Value("${product.service.url}")
    private String productServiceUrl;

    public OrderServiceImpl(OrderRepository orderRepository, RestTemplate restTemplate) {
        this.orderRepository = orderRepository;
        this.restTemplate = restTemplate;
    }

    @Transactional
    public OrderDTO createOrder(OrderRequestDTO orderRequest) {
        // Validate user exists
        ResponseEntity<Void> userValidation = restTemplate.getForEntity(
            userServiceUrl + orderRequest.getUserId(), Void.class);
        
        if (!userValidation.getStatusCode().is2xxSuccessful()) {
            throw new ResourceNotFoundException("User not found with id: " + orderRequest.getUserId());
        }

        // Get product price
        ResponseEntity<Double> productResponse = restTemplate.getForEntity(
            productServiceUrl + orderRequest.getProductId() + "/price", Double.class);
        
        if (!productResponse.getStatusCode().is2xxSuccessful()) {
            throw new ResourceNotFoundException("Product not found with id: " + orderRequest.getProductId());
        }

        double productPrice = productResponse.getBody();
        double totalPrice = productPrice * orderRequest.getQuantity();

        Order order = new Order();
        order.setUserId(orderRequest.getUserId());
        order.setProductId(orderRequest.getProductId());
        order.setQuantity(orderRequest.getQuantity());
        order.setTotalPrice(totalPrice);
        order.setOrderDate(LocalDateTime.now());

        Order savedOrder = orderRepository.save(order);
        return convertToDTO(savedOrder);
    }

    private OrderDTO convertToDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(order, orderDTO);
        return orderDTO;
    }
}