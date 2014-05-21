/********************************************************
 * 
 * This file is part of the TELESPAZIO java commons lib.
 *
 * Library - eocat.core
 *
 * Copyright (C) 2013 TELESPAZIO France
 * BU SSA. All rights reserved
 *
 ********************************************************/
package org.feedAdministration.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author flavignotte
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

}
