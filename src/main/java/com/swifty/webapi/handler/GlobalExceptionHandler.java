package com.swifty.webapi.handler;


import com.swifty.webapi.dto.ApiResponse;
import com.swifty.webapi.exception.UserException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(UserException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ApiResponse<String> userNotFound(UserException ex) {
		return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), ex.getMessage());
	}


}