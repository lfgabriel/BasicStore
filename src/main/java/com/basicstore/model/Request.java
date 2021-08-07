package com.basicstore.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class Request implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne()
	@JsonIgnoreProperties("requests")
	private Client client;
	
	@ManyToMany()
	@JoinTable(
			  name = "request_item", 
			  joinColumns = @JoinColumn(name = "request_id"), 
			  inverseJoinColumns = @JoinColumn(name = "item_id"))
	private List<Item> items;
	
	
	public Request() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Request [id=" + id + ", client=" + client + ", items=" + items + "]";
	}
	
}
