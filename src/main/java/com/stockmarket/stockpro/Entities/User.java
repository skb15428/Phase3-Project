package com.stockmarket.stockpro.Entities;

// import java.time.LocalDateTime;
// import java.util.List;

import javax.persistence.Entity;
// import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.ManyToOne;
// import javax.persistence.OneToMany;
// import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {

	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String password;
	private String email;
	private Boolean Confirmed;
	private Boolean Admin;
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String getpassword() {
		return password;
	}
	public void setpassword(String password) {
		this.password = password;
	}
	public String getemail() {
		return email;
	}
	public void setemail(String email) {
		this.email = email;
	}
	public Boolean getConfirmed() {
		return Confirmed;
	}
	public void setConfirmed(Boolean confirmed) {
		Confirmed = confirmed;
	}
	public Boolean getAdmin() {
		return Admin;
	}
	public void setAdmin(Boolean admin) {
		Admin = admin;
	}
	public User() {
		
		super();
	}
	public User(String name, String password, String email, Boolean admin) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		Admin = admin;
	}
	
	public User(String name, String password, String email) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		
	}
}
