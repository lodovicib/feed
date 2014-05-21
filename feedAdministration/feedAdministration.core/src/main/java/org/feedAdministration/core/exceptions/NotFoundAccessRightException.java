package org.feedAdministration.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@SuppressWarnings("serial")
public class NotFoundAccessRightException extends Exception {
	/**
	 * Parameterized constructor.
	 * 
	 * @param message
	 *            the exception message
	 */
	public NotFoundAccessRightException(String message) {

		super(message);
	}

	/**
	 * Parameterized constructor.
	 * 
	 * @param message
	 *            the exception message
	 * @param exception
	 *            the parent exception
	 */
	public NotFoundAccessRightException(String message, Exception exception) {

		super(message, exception);
	}

	/**
	 * Parameterized constructor.
	 * 
	 * @param exception
	 *            the parent exception
	 */
	public NotFoundAccessRightException(Exception exception) {

		super(exception);
	}
}
