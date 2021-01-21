package com.example.demo.boundaries;

public class UserBoundary {

	private String email;

	public UserBoundary() {
		super();
	}

	public UserBoundary(String email) {
		super();
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
