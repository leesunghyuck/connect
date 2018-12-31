package org.spring.my.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserPost {

	private int idx;
	private String email;
	private String name;
	private List<Post> posts = new ArrayList<>();
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
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	public List<Post> getPosts() {
		return posts;
	}
}
