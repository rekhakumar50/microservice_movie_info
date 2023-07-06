package com.example.demo.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CodeValue implements Serializable {

	private static final long serialVersionUID = 4777551959937275736L;
	
	private String code;
	private String value;

}
