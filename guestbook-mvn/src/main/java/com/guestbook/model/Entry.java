package com.guestbook.model;

public class Entry {
	
	private String name;
	private String message;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Entry(String name, String message) {
		super();
		this.name = name;
		this.message = message;
	}

}
