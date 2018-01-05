package com.acc.customexception;

public class LoginException extends UserInfoNotFound {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginException() {
		super();

	}

	public LoginException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public LoginException(String message, Throwable cause) {
		super(message, cause);

	}

	public LoginException(String message) {
		super(message);

	}

	public LoginException(Throwable cause) {
		super(cause);

	}

}
