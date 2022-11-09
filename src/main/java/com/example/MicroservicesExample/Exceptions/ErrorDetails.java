package com.example.MicroservicesExample.Exceptions;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ErrorDetails {
	private LocalDateTime timestamps;
	private String message;
	private String details;
	public LocalDateTime getTimestamps() {
		return timestamps;
	}
	public void setTimestamps(LocalDateTime timestamps) {
		this.timestamps = timestamps;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public ErrorDetails(LocalDateTime localDateTime, String message, String details) {
		super();
		this.timestamps = localDateTime;
		this.message = message;
		this.details = details;
	}
	
	
	
}
