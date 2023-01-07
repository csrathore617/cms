package com.pytosoft.response;

public class ErrorResponse {

	private String massage;
	
	private Integer statusCode;

	public ErrorResponse() {
		super();
	}

	public ErrorResponse(String massage, Integer statusCode) {
		super();
		this.massage = massage;
		this.statusCode = statusCode;
	}

	public ErrorResponse(String massage) {
		super();
		this.massage = massage;
	}

	public ErrorResponse(Integer statusCode) {
		super();
		this.statusCode = statusCode;
	}

	/**
	 * @return the massage
	 */
	public String getMassage() {
		return massage;
	}

	/**
	 * @param massage the massage to set
	 */
	public void setMassage(String massage) {
		this.massage = massage;
	}

	/**
	 * @return the statusCode
	 */
	public Integer getStatusCode() {
		return statusCode;
	}

	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	
	
}
