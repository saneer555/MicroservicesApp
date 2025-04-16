package com.orderServices.Service;

import com.orderServices.Binding.OrderDTO;
import com.orderServices.OrderRequest.OrderRequestDTO;

public interface OrderService {
	
	public OrderDTO createOrder(OrderRequestDTO request);
	

}
