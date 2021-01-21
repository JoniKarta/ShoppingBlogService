package com.example.demo.logic;

import java.util.List;

import com.example.demo.boundaries.PostBoundary;

public interface ShoppingBlogService {

	public PostBoundary createPost(PostBoundary post);

	public List<PostBoundary> getAll(String email, String sortAttr, boolean sortOrder, int page, int size);

	public List<PostBoundary> getByLanguage(String email, String filterValue, String sortAttr, boolean sortOrder, int page, int size);

	public List<PostBoundary> getByCreation(String email, String filterValue, String sortAttr, boolean sortOrder, int page, int size);

	public List<PostBoundary> getByProduct(String email, String filterValue, String sortAttr, boolean sortOrder, int page, int size);

	public List<PostBoundary> getPostsByLanguage(String productId, String filterValue, String sortAttr, boolean sortOrder,int page, int size);

	public List<PostBoundary> getPostsByCreation(String productId, String filterValue, String sortAttr, boolean sortOrder, int page, int size);

	public List<PostBoundary> getAllPosts(String productId, String sortAttr, boolean sortOrder, int page, int size);

	public List<PostBoundary> getAllPostsByCreation(String filterValue, String sortAttr, boolean sortOrder, int page, int size);

	public List<PostBoundary> getAllPostsByCount(String filterValue, String sortAttr, boolean sortOrder, int page, int size);

	public void deleteAll();

}
