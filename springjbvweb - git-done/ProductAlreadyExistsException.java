package com.sjv.exception;

public class ProductAlreadyExistsException extends RuntimeException {

	public ProductAlreadyExistsException() {
		super();
	}

	public ProductAlreadyExistsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ProductAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProductAlreadyExistsException(String message) {
		super(message);
	}

	public ProductAlreadyExistsException(Throwable cause) {
		super(cause);
	}

}
