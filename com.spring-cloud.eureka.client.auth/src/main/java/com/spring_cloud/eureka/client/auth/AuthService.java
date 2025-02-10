package com.spring_cloud.eureka.client.auth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Jwts.SIG;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.util.Date;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

	@Value("${spring.application.name}")
	private String issuer;

	@Value("${service.jwt.access-expiration}")
	private long accessExpiration;

	private final SecretKey secretKey;

	public AuthService(@Value("${service.jwt.secret-key}")String secretKey) {
		this.secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
	}

	public String createAccessToken(String userId) {
		Date date = new Date();

		return Jwts.builder()
			.claim("userId", userId)
			.claim("role", "ADMIN")
			.issuer(issuer)
			.expiration(new Date(date.getTime() + accessExpiration)) // 만료 시간
			.issuedAt(date) // 발급일
			//.signWith(secretKey, SignatureAlgorithm.HS512)
			//-> .signWith(secretKey, Jwts.SIG.HS512) 변경
			.signWith(secretKey, SIG.HS512)
			.compact();
	}
}
