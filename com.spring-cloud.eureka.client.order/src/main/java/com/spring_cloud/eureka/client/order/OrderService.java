package com.spring_cloud.eureka.client.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

	private final ProductClient productClient;

	public String getProductInfo(Long productId) {
		return productClient.getProduct(productId);
	}

	public String getOrder(Long orderId) {
		if(orderId.equals(1L)) {
			Long productId = 111L;
			String productInfo = getProductInfo(productId);
			return "Your order is " + orderId + " and " + productInfo;
		}
		return getProductInfo(orderId);
	}
}
