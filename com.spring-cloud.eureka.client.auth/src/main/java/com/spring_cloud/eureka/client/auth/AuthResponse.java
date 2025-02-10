package com.spring_cloud.eureka.client.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * JWT 액세스 토큰을 포함하는 응답 객체입니다.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
	private String accessToken;

}