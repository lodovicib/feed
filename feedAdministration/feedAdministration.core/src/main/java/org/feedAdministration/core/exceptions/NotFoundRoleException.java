package org.feedAdministration.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@SuppressWarnings("serial")
public class NotFoundRoleException extends Exception {
	/**
     * Parameterized constructor.
     * 
     * @param message
     *            the exception message
     */
    public NotFoundRoleException(String message) {

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
    public NotFoundRoleException(String message, Exception exception) {

    	super(message, exception);
    }

    /**
     * Parameterized constructor.
     * 
     * @param exception
     *            the parent exception
     */
    public NotFoundRoleException(Exception exception) {

    	super(exception);
    }
}

