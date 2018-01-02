package com.acc.customexception;

public class UpdateMeetingException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2453195210482822973L;

	public UpdateMeetingException() {
		super();

	}

	public UpdateMeetingException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public UpdateMeetingException(String message, Throwable cause) {
		super(message, cause);

	}

	public UpdateMeetingException(String message) {
		super(message);

	}

	public UpdateMeetingException(Throwable cause) {
		super(cause);

	}

}
