package com.productServices.productservices.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productServices.productservices.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
