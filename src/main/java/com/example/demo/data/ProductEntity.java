package com.example.demo.data;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection = "products")
public class ProductEntity {

	@Id
	private String id;

	public ProductEntity() {
		super();
	}

	public ProductEntity(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
