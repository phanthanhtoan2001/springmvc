package com.laptrinhjavaweb.model;
 
import java.io.Serializable;

public class User implements Serializable {
 
    private static final long serialVersionUID = 1L;
 
    private String id, name,password,email;
 
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

	public User() {
        super();
    }
 
    public User(String id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
 
    public String getId() {
        return id;
    }
 
    public void setId(String id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
}