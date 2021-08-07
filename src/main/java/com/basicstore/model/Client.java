package com.basicstore.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Client implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String email;
	private String CPF;
	
	@OneToMany(mappedBy="client")
	@JsonIgnoreProperties("requests")
	@JsonIgnore
	private List<Request> requests;

	
	public Client() {
		super();
	}
	
	
	public Client(Long id, String name, String email, String CPF) {
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


	public void setCPF(String CPF) {
		this.CPF = CPF;
	}


	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", email=" + email + ", CPF=" + CPF + "]";
	}

	
}
