package com.example.demo.adapter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.RatingRequest;
import com.example.demo.dto.RatingResponse;
import com.example.demo.transformer.HeaderTransformer;

@Component
public class MovieInfoAdapter {
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HeaderTransformer headerTransformer;
	
	
	@Value("${rating.api.url}")
	private String ratingEndpointUrl;
	
	
	public RatingResponse invokeAdapter(final RatingRequest ratingRequest) {
		final HttpHeaders headers = headerTransformer.transform(request);
		final HttpEntity<RatingRequest> requestEntity = new HttpEntity<>(ratingRequest, headers);
		
		ResponseEntity<RatingResponse> responseEntity = null;
		try {
			responseEntity = restTemplate.exchange(ratingEndpointUrl, HttpMethod.POST, requestEntity, RatingResponse.class);
		} catch(Exception e) {
			System.out.println("Rating Service is not available");
		}
		
		return this.process(responseEntity);
	}
	
	
	private RatingResponse process(ResponseEntity<RatingResponse> responseEntity) {
		RatingResponse ratingResponse = null;
		
		if(responseEntity != null && responseEntity.getStatusCode() == HttpStatus.OK) {
			ratingResponse = responseEntity.getBody();
			
		} 
		
		return ratingResponse;
	}

}
