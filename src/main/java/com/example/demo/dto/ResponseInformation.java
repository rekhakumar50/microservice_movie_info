package com.example.demo.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseInformation implements Serializable {

	private static final long serialVersionUID = 3624966359452597066L;
	
	private CodeValue completion;
	private List<ErrorInfo> errorInfo;

}
