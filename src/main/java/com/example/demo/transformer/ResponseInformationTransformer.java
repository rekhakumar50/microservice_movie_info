package com.example.demo.transformer;

import org.springframework.stereotype.Component;

import com.example.demo.dto.CodeValue;
import com.example.demo.dto.ResponseInformation;

@Component
public class ResponseInformationTransformer {
	
	public ResponseInformation getResponseInformation(final String code, final String value) {
		ResponseInformation responseInformation = new ResponseInformation();
		responseInformation.setCompletion(this.getCodeValue(code, value));
		
		return responseInformation;
	}
	
	
	private CodeValue getCodeValue(final String code, final String value) {
		CodeValue codeValue = new CodeValue();
		codeValue.setCode(code);
		codeValue.setValue(value);
		
		return codeValue;
	}
	
}
