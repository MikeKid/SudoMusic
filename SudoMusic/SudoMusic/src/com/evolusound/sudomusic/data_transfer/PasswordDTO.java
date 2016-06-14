package com.evolusound.sudomusic.data_transfer;

public class PasswordDTO implements BaseDTO {
	
	private Long id;
	private Long customerId;
	private String password;
	private Integer iterations;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getIterations() {
		return iterations;
	}
	public void setIterations(Integer iterations) {
		this.iterations = iterations;
	}
}
