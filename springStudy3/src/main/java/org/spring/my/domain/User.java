package org.spring.my.domain;

import java.util.Date;

public class User {

	private int idx;
	private String email;
	private String name;
	private String password;
	private Date createAt;

	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public Date getCreateAt() {
		return createAt;
	}
}
