package com.mypack.springbootrestreactapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mypack.spring.rest.error.EntityNotFoundException;
import com.mypack.spring.rest.error.RestError;

@RestControllerAdvice
public class GlobalRestExceptionHandler extends ResponseEntityExceptionHandler{
	
	private static final Logger log = LoggerFactory.getLogger(GlobalRestExceptionHandler.class);
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException exception, WebRequest webRequest) {
		log.info("handleEntityNotFoundException method called.");
		RestError restError = new RestError();
		restError.setStatusCode(HttpStatus.NOT_FOUND.value());
		restError.setMessage("Entity not found with entity id: " + exception.getId());
		ResponseEntity<Object> entity = new ResponseEntity<>(restError, HttpStatus.NOT_FOUND);
        return entity;
	  }
	
	@ExceptionHandler(Exception.class)
	  public ResponseEntity<RestError> handleInternalServerError(Exception exception) {
		log.info("handleInternalServerError method called.");
		RestError restError = new RestError();
		restError.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		restError.setMessage("Something went wrong");
	    return ResponseEntity.unprocessableEntity().body(restError);
	  }
}
