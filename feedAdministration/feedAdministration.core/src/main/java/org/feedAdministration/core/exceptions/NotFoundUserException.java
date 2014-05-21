package org.feedAdministration.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * Exception thrown when a user is not found.
 * 
 * @author emokaddem
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
@SuppressWarnings("serial")
public class NotFoundUserException extends Exception {
	/**
     * Parameterized constructor.
     * 
     * @param message
     *            the exception message
     */
    public NotFoundUserException(String message) {

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
    public NotFoundUserException(String message, Exception exception) {

    	super(message, exception);
    }

    /**
     * Parameterized constructor.
     * 
     * @param exception
     *            the parent exception
     */
    public NotFoundUserException(Exception exception) {

    	super(exception);
    }
}

