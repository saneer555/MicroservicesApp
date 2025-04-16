package com.productServices.productservices.Service;

import com.productServices.productservices.Binding.ProductDTO;

public interface ProductService {
	public ProductDTO createProduct(ProductDTO productDTO);
	
	public ProductDTO getProductById(Long id);
	
	public Double getProductPriceById(Long id);
}
