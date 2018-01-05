package com.acc.customexception;

public class UpdateUserException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -937684622755793258L;

	public UpdateUserException() {
		super();

	}

	public UpdateUserException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public UpdateUserException(String message, Throwable cause) {
		super(message, cause);

	}

	public UpdateUserException(String message) {
		super(message);

	}

	public UpdateUserException(Throwable cause) {
		super(cause);

	}

}
