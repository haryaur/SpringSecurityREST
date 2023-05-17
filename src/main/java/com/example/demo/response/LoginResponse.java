package com.example.demo.response;

public class LoginResponse {
	private String successful;
	private Object login;

	public LoginResponse() {

	}

	public String getSuccessful() {
		return successful;
	}

	public void setSuccessful(String successful) {
		this.successful = successful;
	}

	public Object getLogin() {
		return login;
	}

	public void setLogin(Object login) {
		this.login = login;
	}

	public LoginResponse(String successful, Object login) {
		this.successful = successful;
		this.login = login;
	}


}
