package org.feedAdministration.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when an error occurs on the persistence layer. 
 * 
 * @author emokaddem
 *
 */
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
@SuppressWarnings("serial")
public class RepositoryException extends Exception {

    /**
     * Parameterized constructor.
     * 
     * @param message
     *            the exception message
     */
    public RepositoryException(String message) {

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
    public RepositoryException(String message, Exception exception) {

    	super(message, exception);
    }

    /**
     * Parameterized constructor.
     * 
     * @param exception
     *            the parent exception
     */
    public RepositoryException(Exception exception) {

    	super(exception);
    }
}