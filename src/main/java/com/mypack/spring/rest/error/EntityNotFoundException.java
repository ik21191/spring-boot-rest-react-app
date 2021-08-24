package com.mypack.spring.rest.error;

public class EntityNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	private int id;
	public EntityNotFoundException(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
