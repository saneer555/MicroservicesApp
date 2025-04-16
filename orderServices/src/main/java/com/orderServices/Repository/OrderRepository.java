package com.orderServices.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orderServices.Entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	
	

}
