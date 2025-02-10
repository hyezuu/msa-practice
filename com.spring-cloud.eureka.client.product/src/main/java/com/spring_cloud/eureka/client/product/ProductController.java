package com.spring_cloud.eureka.client.product;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {

	@Value("${server.port}")
	private String serverPort;

	private final ProductService productService;

	@GetMapping("/product/{id}")
	public String getProduct(@PathVariable("id") Long id) {
		Product product = productService.getProductDetails(id);
		return "Product " + product.getTitle() + " Info ! \n From port : " + serverPort;
	}

	@GetMapping("/product")
	public String getProduct() {
		return "ProductInfo ! \n From port : " + serverPort;
	}
}
