package com.example.demo.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonResponseBase implements Serializable {

	private static final long serialVersionUID = -4000882916954585415L;
	
	private ResponseInformation information;

}
