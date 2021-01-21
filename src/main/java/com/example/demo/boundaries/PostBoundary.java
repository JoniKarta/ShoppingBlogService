package com.example.demo.boundaries;

import java.util.Date;
import java.util.Map;

public class PostBoundary {

	private UserBoundary user;
	private ProductBoundary product;
	private Date postingTimestamp;
	private String language;
	private Map<String, Object> postContent;

	public PostBoundary() {
		super();
	}

	public PostBoundary(UserBoundary user, ProductBoundary product, Date postingTimestamp, String language,
			Map<String, Object> postContent) {
		super();
		this.user = user;
		this.product = product;
		this.postingTimestamp = postingTimestamp;
		this.language = language;
		this.postContent = postContent;
	}

	public UserBoundary getUser() {
		return user;
	}

	public void setUser(UserBoundary user) {
		this.user = user;
	}

	public ProductBoundary getProduct() {
		return product;
	}

	public void setProduct(ProductBoundary product) {
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
