package org.feedAdministration.hibernate.domain;

import java.util.Date;

public class File {

	private Long id;

    private String name;
    private String status;
    private String message;
    private Date date;

    public File() {}
    
    public File(String _nom, String _status, String _message, Date _date) {
    	name = _nom;
    	status = _status;
    	message = _message;
    	date = _date;
    }

    
    /* si on met un bool au lieu d'un string pour le status*/
    public File(String _nom, boolean _status, String _message, Date _date) {
    	name = _nom;
    	status = "NOK";
    	if (_status)
    	status = "OK";
    	message = _message;
    	date = _date;
    }

    /* si on ne met pas de message et un bool en status */
    public File(String _nom, boolean _status, Date _date) {
    	name = _nom;
    	status = "NOK";
    	if (_status)
    	status = "OK";
    	message = null;
    	date = _date;
    }
    
    /* si on ne met pas de message */
    public File(String _nom, String _status, Date _date) {
    	name = _nom;
    	status = _status;
    	message = null;
    	date = _date;
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
}
