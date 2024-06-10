package com.example.cloudnote.exception;

public class NoteBookNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -5991491771124061955L;

	public NoteBookNotFoundException() {
		super();
	}

	public NoteBookNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NoteBookNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoteBookNotFoundException(String message) {
		super(message);
	}

	public NoteBookNotFoundException(Throwable cause) {
		super(cause);
	}


}
