package com.acc.customexception;

public class PinCodeNotFoundException extends UserInfoNotFound {
	private static final long serialVersionUID = -3369179845585473219L;

	public PinCodeNotFoundException() {
		super();
	}

	public PinCodeNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PinCodeNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public PinCodeNotFoundException(String message) {
		super(message);
	}

	public PinCodeNotFoundException(Throwable cause) {
		super(cause);
	}

}
