package com.example.demo.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorInfo implements Serializable {

	private static final long serialVersionUID = -861602936530307725L;
	
	private CodeValue category;
	private String description;

}
