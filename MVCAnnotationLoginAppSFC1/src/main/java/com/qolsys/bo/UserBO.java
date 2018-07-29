package com.qolsys.bo;

import javax.validation.constraints.NotNull;

public class UserBO {
	
	@NotNull
	private String user="user";
	
	@NotNull
	private String pwd;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
