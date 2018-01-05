package com.acc.customexception;

public class CancelMeetingException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CancelMeetingException() {
		super();

	}

	public CancelMeetingException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public CancelMeetingException(String message, Throwable cause) {
		super(message, cause);

	}

	public CancelMeetingException(String message) {
		super(message);

	}

	public CancelMeetingException(Throwable cause) {
		super(cause);

	}

}
