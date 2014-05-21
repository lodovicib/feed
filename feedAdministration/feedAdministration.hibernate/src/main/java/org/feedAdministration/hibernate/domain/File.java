package org.feedAdministration.hibernate.domain;

import java.util.Date;

public class File {

	private Long id;

    private String name;
    private String status;
    private String message;
	private Date date;
	
    public File() {
    	date = new Date();
    }
    
    public File(String _nom, String _status, String _message) {
    	name = _nom;
    	status = _status;
    	message = _message;
    	date = new Date();
    }

    
    /* si on met un bool au lieu d'un string pour le status*/
    public File(String _nom, boolean _status, String _message) {
    	name = _nom;
    	status = "NOK";
    	if (_status)
    	status = "OK";
    	message = _message;
    	date = new Date();
    }

    /* si on ne met pas de message et un bool en status */
    public File(String _nom, boolean _status) {
    	name = _nom;
    	status = "NOK";
    	if (_status)
    	status = "OK";
    	message = null;
    	date = new Date();
    }
    
    /* si on ne met pas de message */
    public File(String _nom, String _status) {
    	name = _nom;
    	status = _status;
    	message = null;
    	date = new Date();
    }
    
    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public void replaceData(File fileToReplace) {
		if (fileToReplace.getName() != null)
			if (getName() == null || !getName().equals(fileToReplace.getName()))
				setName(fileToReplace.getName());
		if (fileToReplace.getStatus() != null)
			if (getStatus() == null || !getStatus().equals(fileToReplace.getStatus()))
				setStatus(fileToReplace.getStatus());
		if (fileToReplace.getMessage() != null)
			if (getMessage() == null || !getMessage().equals(fileToReplace.getMessage()))
				setMessage(fileToReplace.getMessage());
	}
	
}
