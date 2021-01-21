package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.boundaries.PostBoundary;
import com.example.demo.data.OrderEnum;
import com.example.demo.exceptions.BadFilterTypeException;
import com.example.demo.logic.ShoppingBlogService;
import com.example.demo.utility.ControllerTypes;

@RestController
public class ShoppingBlogController {

	private ShoppingBlogService shoppingBlogService;

	@Autowired
	public void setShoppingBlogService(ShoppingBlogService shoppingBlogService) {
		this.shoppingBlogService = shoppingBlogService;
	}

	@RequestMapping(path = "/blog", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public PostBoundary createMessage(@RequestBody PostBoundary post) {
		return this.shoppingBlogService.createPost(post);
	}

	@RequestMapping(path = "/blog/byUser/{email}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public PostBoundary[] getPostsByUser(@PathVariable("email") String email,
			@RequestParam(name = "filterType", required = false, defaultValue = "") String filterType,
			@RequestParam(name = "filterValue", required = false) String filterValue,
			@RequestParam(name = "sortBy", required = false, defaultValue = "postingTimestamp") String sortAttr,
			@RequestParam(name = "sortOrder", required = false, defaultValue = "ASC") OrderEnum order,
			@RequestParam(name = "page", required = false, defaultValue = "0") int page,
			@RequestParam(name = "size", required = false, defaultValue = "10") int size) {

		switch (filterType) {
		case ControllerTypes.BY_LANGUAGE:
			return this.shoppingBlogService
					.getByLanguage(email, filterValue, sortAttr, order.equals(OrderEnum.ASC), page, size)
					.toArray(new PostBoundary[0]);

		case ControllerTypes.BY_CREATION:
			return this.shoppingBlogService
					.getByCreation(email, filterValue, sortAttr, order.equals(OrderEnum.ASC), page, size)
					.toArray(new PostBoundary[0]);

		case ControllerTypes.BY_PRODUCT:
			return this.shoppingBlogService
					.getByProduct(email, filterValue, sortAttr, order.equals(OrderEnum.ASC), page, size)
					.toArray(new PostBoundary[0]);

		default:
			return this.shoppingBlogService.getAll(email, sortAttr, order.equals(OrderEnum.ASC), page, size)
					.toArray(new PostBoundary[0]);
		}
	}

	@RequestMapping(path = "/blog/byProduct/{productId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public PostBoundary[] getPostsByProduct(@PathVariable("productId") String productId,
			@RequestParam(name = "filterType", required = false, defaultValue = "") String filterType,
			@RequestParam(name = "filterValue", required = false) String filterValue,
			@RequestParam(name = "sortBy", required = false, defaultValue = "postingTimestamp") String sortAttr,
			@RequestParam(name = "sortOrder", required = false, defaultValue = "ASC") OrderEnum order,
			@RequestParam(name = "page", required = false, defaultValue = "0") int page,
			@RequestParam(name = "size", required = false, defaultValue = "10") int size) {

		switch (filterType) {
		case ControllerTypes.BY_LANGUAGE:
			return this.shoppingBlogService
					.getPostsByLanguage(productId, filterValue, sortAttr, order.equals(OrderEnum.ASC), page, size)
					.toArray(new PostBoundary[0]);

		case ControllerTypes.BY_CREATION:
			return this.shoppingBlogService
					.getPostsByCreation(productId, filterValue, sortAttr, order.equals(OrderEnum.ASC), page, size)
					.toArray(new PostBoundary[0]);

		default:
			return this.shoppingBlogService.getAllPosts(productId, sortAttr, order.equals(OrderEnum.ASC), page, size)
					.toArray(new PostBoundary[0]);
		}
	}

	@RequestMapping(path = "/blog", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public PostBoundary[] getAllPosts(@RequestParam(name = "filterType", required = true) String filterType,
			@RequestParam(name = "filterValue", required = false) String filterValue,
			@RequestParam(name = "sortBy", required = false, defaultValue = "postingTimestamp") String sortAttr,
			@RequestParam(name = "sortOrder", required = false, defaultValue = "ASC") OrderEnum order,
			@RequestParam(name = "page", required = false, defaultValue = "0") int page,
			@RequestParam(name = "size", required = false, defaultValue = "10") int size) {
		switch (filterType) {
		case ControllerTypes.BY_CREATION:
			return this.shoppingBlogService
					.getAllPostsByCreation(filterValue, sortAttr, order.equals(OrderEnum.ASC), page, size)
					.toArray(new PostBoundary[0]);

		case ControllerTypes.BY_COUNT:
			return this.shoppingBlogService
					.getAllPostsByCount(filterValue, "postingTimestamp", order.equals(OrderEnum.DESC), page, size)
					.toArray(new PostBoundary[0]);

		default:
			throw new BadFilterTypeException("This filter type was not found");
		}

	}

	@RequestMapping(path = "/blog", method = RequestMethod.DELETE)
	public void deleteAll() {
		this.shoppingBlogService.deleteAll();
	}
}
