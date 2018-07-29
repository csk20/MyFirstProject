package com.qolsys.command;

import javax.validation.constraints.NotNull;


public class EditCommand {
	
	@NotNull
	private String user=null;
	
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
