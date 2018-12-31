package org.spring.my.controller;

import java.util.HashMap;
import java.util.Map;

import org.spring.my.exception.BadRequestmessageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice(annotations = Controller.class)
public class SignInExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(value= {BadRequestmessageException.class})
	public ResponseEntity<Object> signInHandle(RuntimeException ex, WebRequest request){

		Map<String, Object> result = new HashMap<>();
		result.put("succ", false);

		if(ex instanceof BadRequestmessageException) {
			BadRequestmessageException ex2 = (BadRequestmessageException) ex;
			result.put("code", ex2.getCode());
			result.put("msg", ex2.getMsg());
		}
		return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
	}
}
