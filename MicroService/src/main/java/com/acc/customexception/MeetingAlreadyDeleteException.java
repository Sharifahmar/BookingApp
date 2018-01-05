package com.acc.customexception;

public class MeetingAlreadyDeleteException extends RuntimeException {
	private static final long serialVersionUID = 944875364177382614L;

	public MeetingAlreadyDeleteException() {
		super();
	}

	public MeetingAlreadyDeleteException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public MeetingAlreadyDeleteException(String message, Throwable cause) {
		super(message, cause);
	}

	public MeetingAlreadyDeleteException(String message) {
		super(message);
	}

	public MeetingAlreadyDeleteException(Throwable cause) {
		super(cause);
	}

}
