package org.spring.my.exception;

public class BadRequestmessageException extends RuntimeException{

	String code;
	String msg;

	public BadRequestmessageException(String code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
}
