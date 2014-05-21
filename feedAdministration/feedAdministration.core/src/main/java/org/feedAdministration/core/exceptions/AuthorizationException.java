package org.feedAdministration.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
@SuppressWarnings("serial")
/**
 * Exception thrown when an error occurs during authorization checks.
 * 
 * @author emokaddem
 *
 */
public class AuthorizationException extends Exception {

	/**
	 * Parameterized constructor.
	 * 
	 * @param message
	 *            the exception message
	 */
	public AuthorizationException(String message) {

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
	public AuthorizationException(String message, Exception exception) {

		super(message, exception);
	}

	/**
	 * Parameterized constructor.
	 * 
	 * @param exception
	 *            the parent exception
	 */
	public AuthorizationException(Exception exception) {

		super(exception);
	}
}
