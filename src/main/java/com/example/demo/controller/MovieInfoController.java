package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.MovieInfo;
import com.example.demo.service.MovieInfoService;

@RestController
@RequestMapping("/movie")
public class MovieInfoController {
	
	@Autowired
	private MovieInfoService movieInfoService;
	
	
	@GetMapping("/{movieId}")
	public MovieInfo getMovieInfo(@PathVariable("movieId") long movieId) {
		return movieInfoService.getMovieInfo(movieId);
	}

}
