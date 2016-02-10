package com.au.example.exception.util;

public class ServerException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2048920037095604505L;

	/**
	 * Instantiates a new server exception.
	 *
	 * @param errorCode
	 *            the error code
	 * @param message
	 *            the message
	 */
	public ServerException(String message) {

		super(message);

	}

}
