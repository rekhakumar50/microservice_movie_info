package com.example.demo.transformer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.dto.CodeValue;
import com.example.demo.dto.ErrorInfo;
import com.example.demo.dto.ResponseInformation;

@Component
public class ErrorResponseInformationTransformer {
	
	public ResponseInformation getResponseInformation(final String code, final String value) {
		ResponseInformation responseInformation = new ResponseInformation();
		responseInformation.setCompletion(this.getCodeValue(code, value));
		responseInformation.setErrorInfo(this.getErrorInfo(code, value));
		
		return responseInformation;
	}
	
	public CodeValue getCodeValue(final String code, final String value) {
		CodeValue codeValue = new CodeValue();
		codeValue.setCode(code);
		codeValue.setValue(value);
		
		return codeValue;
	}
	
	private List<ErrorInfo> getErrorInfo(final String code, final String value) {
		List<ErrorInfo> errorInfoList = new ArrayList<>();
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setCategory(this.getCodeValue(code, value));
		errorInfo.setDescription(value);
		errorInfoList.add(errorInfo);
		
		return errorInfoList;
	}
	
}
