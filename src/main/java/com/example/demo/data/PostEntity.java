package com.example.demo.data;

import java.util.Date;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "posts")
public class PostEntity {

	@Id
	private String id;
	private UserEntity user;
	private ProductEntity product;
	private Date postingTimestamp;
	private String language;
	private Map<String, Object> postContent;

	public PostEntity() {
		super();
	}

	public PostEntity(UserEntity user, ProductEntity product, Date postingTimestamp, String language,
			Map<String, Object> postContent) {
		super();
		this.user = user;
		this.product = product;
		this.postingTimestamp = postingTimestamp;
		this.language = language;
		this.postContent = postContent;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public Date getPostingTimestamp() {
		return postingTimestamp;
	}

	public void setPostingTimestamp(Date postingTimestamp) {
		this.postingTimestamp = postingTimestamp;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Map<String, Object> getPostContent() {
		return postContent;
	}

	public void setPostContent(Map<String, Object> postContent) {
		this.postContent = postContent;
	}
}
