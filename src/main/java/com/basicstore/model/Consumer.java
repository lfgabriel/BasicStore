package com.basicstore.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Consumer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String email;
	private String CPF;
	

	
	public Consumer() {
		super();
	}
	
	
	public Consumer(Long id, String name, String email, String CPF) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.CPF = CPF;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCPF() {
		return CPF;
	}


	public void setCPF(String cPF) {
		CPF = cPF;
	}


	@Override
	public String toString() {
		return "Consumer [id=" + id + ", name=" + name + ", email=" + email + ", CPF=" + CPF + "]";
	}

	
}
