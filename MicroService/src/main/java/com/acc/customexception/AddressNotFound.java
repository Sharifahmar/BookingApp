package com.acc.customexception;

public class AddressNotFound extends Exception {
	private static final long serialVersionUID = 6549568671272617766L;

	public AddressNotFound() {
		super();
	}

	public AddressNotFound(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AddressNotFound(String message, Throwable cause) {
		super(message, cause);
	}

	public AddressNotFound(String message) {
		super(message);
	}

	public AddressNotFound(Throwable cause) {
		super(cause);
	}

}
