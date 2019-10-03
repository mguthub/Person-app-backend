package com.example.person.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.person.dto.MessageDTO;
import com.example.person.exception.DataNotFoundException;

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
	
	@ExceptionHandler(DataNotFoundException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public MessageDTO processDataNotFoundException(DataNotFoundException exception){
		MessageDTO message = new MessageDTO();
		message.setMessage(exception.getMessage());
		message.setType("ERROR");
		return message;
	}
	
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public MessageDTO processInternalServerErrorException(Exception exception){
		MessageDTO message = new MessageDTO();
		message.setMessage("An error occurred processing request");
		message.setType("ERROR");
		return message;
	}
}
