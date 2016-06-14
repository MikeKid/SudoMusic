package com.evolusound.sudomusic.command;

import java.util.HashMap;
import java.util.Map;

public class ContactFormCommand {
	
	private String fullName;
	private String email;
	private String message;
	private Boolean subscribe;
	private Boolean register;
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Boolean getSubscribe() {
		return subscribe;
	}
	public void setSubscribe(Boolean subscribe) {
		this.subscribe = subscribe;
	}
	public Boolean getRegister() {
		return register;
	}
	public void setRegister(Boolean register) {
		this.register = register;
	}
	
	public Map<String, Object> toMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("fullName", fullName);
		map.put("email", email);
		map.put("message", message);
		map.put("subscribe", subscribe);
		map.put("register", register);
		return map;
	}

}
