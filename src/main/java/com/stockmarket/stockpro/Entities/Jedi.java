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
// import javax.persistence.Table;

@Entity
public class Jedi {

	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String password;
	private String email;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Jedi(String name, String password, String email) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
	}
	public Jedi() {
		super();
	}	
}
