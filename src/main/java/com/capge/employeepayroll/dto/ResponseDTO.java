package com.capge.employeepayroll.dto;

public class ResponseDTO {
	private String message;
	private Object Data;
	
	public ResponseDTO(String message, Object data) {
		super();
		this.message = message;
		Data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return Data;
	}
	public void setData(Object data) {
		Data = data;
	}
	
	
}
