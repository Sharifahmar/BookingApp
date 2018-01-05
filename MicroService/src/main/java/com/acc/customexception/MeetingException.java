package com.acc.customexception;

public class MeetingException extends Exception {
	private static final long serialVersionUID = -8699213810031274722L;

	public MeetingException() {
		super();
	}

	public MeetingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public MeetingException(String message, Throwable cause) {
		super(message, cause);
	}

	public MeetingException(String message) {
		super(message);
	}

	public MeetingException(Throwable cause) {
		super(cause);
	}

}
