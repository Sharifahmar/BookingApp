package com.acc.customexception;

public class UserInfoNotFound extends Exception {
	private static final long serialVersionUID = 7540119062728705796L;

	public UserInfoNotFound() {
		super();
	}

	public UserInfoNotFound(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserInfoNotFound(String message, Throwable cause) {
		super(message, cause);
	}

	public UserInfoNotFound(String message) {
		super(message);
	}

	public UserInfoNotFound(Throwable cause) {
		super(cause);
	}

}
