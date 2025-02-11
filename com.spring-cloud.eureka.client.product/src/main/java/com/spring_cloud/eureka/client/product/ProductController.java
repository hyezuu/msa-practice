package com.spring_cloud.eureka.client.product;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//IOC 컨테이너가 빈 객체 생성시에, @Value 값들을 주입하는데 -> 변경 사항이 생기면 빈을 재생성해야함.
@RefreshScope
@RestController
@RequiredArgsConstructor
public class ProductController {

	@Value("${server.port}")
	private String serverPort;

	@Value("${message}")
	private String message;

	private final ProductService productService;

	@GetMapping("/product/{id}")
	public String getProduct(@PathVariable("id") Long id) {
		Product product = productService.getProductDetails(id);
		return "Product " + product.getTitle() + " Info ! \n From port : " + serverPort;
	}

	@GetMapping("/product")
	public String getProduct() {
		return "ProductInfo ! \n From port : " + serverPort + "and message : " + message;
	}
}
