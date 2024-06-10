package com.example.cloudnote.exception;

public class NameException extends RuntimeException{


	private static final long serialVersionUID = 3606266484840927921L;

	public NameException() {
		super();
	}

	public NameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NameException(String message, Throwable cause) {
		super(message, cause);
	}

	public NameException(String message) {
		super(message);
	}

	public NameException(Throwable cause) {
		super(cause);
	}

}
