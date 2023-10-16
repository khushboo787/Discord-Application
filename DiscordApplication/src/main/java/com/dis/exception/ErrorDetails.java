package com.dis.exception;

import java.time.LocalDateTime;

public class ErrorDetails {
      
	 private LocalDateTime timestamp;
	 private String message;
	 private String url;
	 
	public ErrorDetails() {
	
	}
	
	

	
	public ErrorDetails(LocalDateTime timestamp, String message, String url) {
		this.timestamp = timestamp;
		this.message = message;
		this.url = url;
	}




	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	 
	
	 
	
}
