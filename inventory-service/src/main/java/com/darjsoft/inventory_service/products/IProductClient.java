package com.darjsoft.inventory_service.products;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service")
public interface IProductClient {

	@GetMapping("product/{id}")
	ProductDTO getProductId(@PathVariable Long id);
	
}
