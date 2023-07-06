package com.example.demo.transformer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class HeaderTransformer {
	
	public HttpHeaders transform(HttpServletRequest request) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		headers.add("Accept-Charset", "utf-8");
		headers.add("Accept", "application/json");
		
		return headers;
	}

}
