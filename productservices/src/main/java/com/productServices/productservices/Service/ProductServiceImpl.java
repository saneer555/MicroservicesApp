package com.productServices.productservices.Service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.productServices.productservices.Binding.ProductDTO;
import com.productServices.productservices.Entity.Product;
import com.productServices.productservices.Exceptions.ResourceNotFoundException;
import com.productServices.productservices.Repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	
	    private final ProductRepository productRepository;

	    public ProductServiceImpl(ProductRepository productRepository) {
	        this.productRepository = productRepository;
	    }

	    public ProductDTO createProduct(ProductDTO productDTO) {
	        Product product = new Product();
	        BeanUtils.copyProperties(productDTO, product);
	        Product savedProduct = productRepository.save(product);
	        return convertToDTO(savedProduct);
	    }

	    public ProductDTO getProductById(Long id) {
	        Product product = productRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
	        return convertToDTO(product);
	    }
	    
	    @Override
	    public Double getProductPriceById(Long id) {
	        Product product = productRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
	        return product.getPrice();
	    }

	    private ProductDTO convertToDTO(Product product) {
	        ProductDTO dto = new ProductDTO();
	        BeanUtils.copyProperties(product, dto);
	        return dto;
	    }
	}