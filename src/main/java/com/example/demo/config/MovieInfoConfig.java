package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MovieInfoConfig {
	
	@Value("${rating.timeout}")
	private int timout;
	
	/**
	 * setting timeout in RestTemplate
	 * to use this feature we need to add dependency org.apache.httpcomponents.httpclient
	 * @return
	 */
	@Bean
	public RestTemplate restTemplate() {
		HttpComponentsClientHttpRequestFactory requestFatory = new HttpComponentsClientHttpRequestFactory();
		requestFatory.setConnectTimeout(timout);
		requestFatory.setReadTimeout(timout);
		return new RestTemplate(requestFatory);
	}
	
	
	/**
	 * returning RestTemplate without timeout option
	 * @return
	 */
	/*
	 * @Bean public RestTemplate restTemplate() { 
	 * return new RestTemplate(); 
	 * }
	 */

}
