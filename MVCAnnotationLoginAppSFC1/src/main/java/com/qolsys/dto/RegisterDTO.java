package com.qolsys.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;


public class RegisterDTO implements Serializable{
	
	
	@NotNull
	private String name;
	
	@NotNull
	private String userid;
	
	@NotNull
	private String pwd;

	
	private String phone;
	
	private String gender;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
