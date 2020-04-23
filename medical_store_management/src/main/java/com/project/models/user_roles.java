package com.project.models;
public class user_roles  {
	private int user_role_id;
	
	private String username;

	private String role;

	public user_roles() {
	}

	public int getUser_role_id() {
		return this.user_role_id;
	}

	public void setUser_role_id(int user_role_id) {
		this.user_role_id = user_role_id;
	}
	
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
