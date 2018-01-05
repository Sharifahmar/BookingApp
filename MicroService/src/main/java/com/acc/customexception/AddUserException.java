package com.acc.customexception;

public class AddUserException extends UserInfoNotFound {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddUserException() {
		super();

	}

	public AddUserException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public AddUserException(String message, Throwable cause) {
		super(message, cause);

	}

	public AddUserException(String message) {
		super(message);

	}

	public AddUserException(Throwable cause) {
		super(cause);

	}

}
