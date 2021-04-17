package com.mypack.spring.rest.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such resource available") 
public class ResourceNotFoundException extends RuntimeException{

	private static final Logger log = LoggerFactory.getLogger(ResourceNotFoundException.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(String error) {
		super(error);
		log.error(error);
	}
	
}
