package com.example.person.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.person.dto.MessageDTO;

@RestControllerAdvice
public class PersonAdvice {
	
	@ExceptionHandler(NullPointerException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public MessageDTO processNullPointerException(NullPointerException exception){
		MessageDTO message = new MessageDTO();
		message.setMessage("Errors found in request, try again later");
		message.setType("ERROR");
		return message;
	}
}
