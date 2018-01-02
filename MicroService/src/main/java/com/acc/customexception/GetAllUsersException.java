package com.acc.customexception;

public class GetAllUsersException
    extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GetAllUsersException() {
        super();

    }

    public GetAllUsersException(String message, Throwable cause,
                                boolean enableSuppression,
                                boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);

    }

    public GetAllUsersException(String message, Throwable cause) {
        super(message, cause);

    }

    public GetAllUsersException(String message) {
        super(message);

    }

    public GetAllUsersException(Throwable cause) {
        super(cause);

    }

}
