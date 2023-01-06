package com.pytosoft.exception;

@SuppressWarnings("serial")
public class ResourceNotFoundException extends RuntimeException {

	@SuppressWarnings("unused")
	private String massage;

	public ResourceNotFoundException() {

	}

	public ResourceNotFoundException(String massage) {
		super(massage);
		this.massage = massage;
	}

}
