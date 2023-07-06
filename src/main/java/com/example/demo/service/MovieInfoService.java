package com.example.demo.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.adapter.MovieInfoAdapter;
import com.example.demo.dto.RatingRequest;
import com.example.demo.dto.RatingResponse;
import com.example.demo.model.MovieInfo;
import com.example.demo.transformer.ErrorResponseInformationTransformer;
import com.example.demo.transformer.ResponseInformationTransformer;

@Service
public class MovieInfoService {
	
	@Autowired
	private MovieInfoAdapter movieInfoAdapter;
	
	@Autowired
	private ErrorResponseInformationTransformer errorResponseInformationTransformer;
	
	@Autowired
	private ResponseInformationTransformer responseInformationTransformer;
	
	
	public MovieInfo getMovieInfo(final long movieId) {
		MovieInfo movieInfo = null;
		
		RatingResponse ratingResponse = movieInfoAdapter.invokeAdapter(this.getRatingRequest(movieId));
		if(Objects.nonNull(ratingResponse)) {
			movieInfo = new MovieInfo("xxx", ratingResponse.getRating().getRatingPoint());
			movieInfo.setInformation(responseInformationTransformer.getResponseInformation("200", "Success"));
		} else {
			movieInfo = new MovieInfo("xxx");
			movieInfo.setInformation(
					errorResponseInformationTransformer.getResponseInformation("404", "Rating Service is not available"));
		}
			
		return movieInfo;
	}
	
	
	private RatingRequest getRatingRequest(final long movieId) {
		RatingRequest ratingRequest = new RatingRequest();
		ratingRequest.setMovieId(movieId);
		
		return ratingRequest;
	}

}
