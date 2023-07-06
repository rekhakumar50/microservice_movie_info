package com.example.demo.model;

import java.io.Serializable;

import com.example.demo.dto.CommonResponseBase;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieInfo extends CommonResponseBase implements Serializable {

	private static final long serialVersionUID = 8423555254016558191L;
	
	private String movieName;
	private double rating;
	
	public MovieInfo(String movieName) {
		super();
		this.movieName = movieName;
	}

}
