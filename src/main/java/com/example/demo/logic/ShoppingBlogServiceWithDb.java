package com.example.demo.logic;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.demo.boundaries.PostBoundary;
import com.example.demo.dal.PostDao;
import com.example.demo.data.converter.PostConverter;
import com.example.demo.exceptions.BadTypeDateFormatException;
import com.example.demo.exceptions.BadTypeFilterValueException;
import com.example.demo.exceptions.InvalidEmailException;
import com.example.demo.validator.Validator;

@Service
public class ShoppingBlogServiceWithDb implements ShoppingBlogService {

	private PostDao posts;
	private PostConverter converter;
	private Validator validator;

	@Autowired
	public ShoppingBlogServiceWithDb(PostDao posts) {
		super();
		this.posts = posts;
	}

	@Autowired
	public void setConverter(PostConverter converter) {
		this.converter = converter;
	}

	@Autowired
	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	@Override
	public PostBoundary createPost(PostBoundary post) {
		if (!this.validator.validateEmail(post.getUser().getEmail())) {
			throw new InvalidEmailException("Email must be in the format of example@example.com");
		}
		return this.converter.fromEntity(this.posts.save(this.converter.toEntity(post)));
	}

	@Override
	public List<PostBoundary> getAll(String email, String sortAttr, boolean sortOrder, int page, int size) {
		if (!this.validator.validateEmail(email)) {
			throw new InvalidEmailException("Email must be in the format of example@example.com");
		}
		return this.posts
				.findAllByUser_Email(email,
						PageRequest.of(page, size, sortOrder ? Direction.ASC : Direction.DESC, sortAttr))
				.stream().map(this.converter::fromEntity).collect(Collectors.toList());
	}

	@Override
	public List<PostBoundary> getByLanguage(String email, String filterValue, String sortAttr, boolean sortOrder,
			int page, int size) {
		if (!this.validator.validateEmail(email)) {
			throw new InvalidEmailException("Email must be in the format of example@example.com");
		}
		return this.posts
				.findAllByUser_EmailAndLanguage(email, filterValue,
						PageRequest.of(page, size, sortOrder ? Direction.ASC : Direction.DESC, sortAttr))
				.stream().map(this.converter::fromEntity).collect(Collectors.toList());
	}

	@Override
	public List<PostBoundary> getByCreation(String email, String filterValue, String sortAttr, boolean sortOrder,
			int page, int size) {
		Date date = this.validator.validDate(filterValue);
		if (date == null) {
			throw new BadTypeDateFormatException("Date type should be 'lastDay'/'lastWeek'/'lastMonth'");
		}
		if (!this.validator.validateEmail(email)) {
			throw new InvalidEmailException("Email must be in the format of example@example.com");
		}
		return this.posts
				.findAllByUser_EmailAndPostingTimestampGreaterThanEqual(email, date,
						PageRequest.of(page, size, sortOrder ? Direction.ASC : Direction.DESC, sortAttr))
				.stream().map(this.converter::fromEntity).collect(Collectors.toList());
	}

	@Override
	public List<PostBoundary> getByProduct(String email, String filterValue, String sortAttr, boolean sortOrder,
			int page, int size) {
		if (!this.validator.validateEmail(email)) {
			throw new InvalidEmailException("Email must be in the format of example@example.com");
		}
		return this.posts
				.findAllByUser_EmailAndProduct_Id(email, filterValue,
						PageRequest.of(page, size, sortOrder ? Direction.ASC : Direction.DESC, sortAttr))
				.stream().map(this.converter::fromEntity).collect(Collectors.toList());
	}

	@Override
	public List<PostBoundary> getPostsByLanguage(String productId, String filterValue, String sortAttr,
			boolean sortOrder, int page, int size) {
		return this.posts
				.findAllByProduct_IdAndLanguage(productId, filterValue,
						PageRequest.of(page, size, sortOrder ? Direction.ASC : Direction.DESC, sortAttr))
				.stream().map(this.converter::fromEntity).collect(Collectors.toList());
	}

	@Override
	public List<PostBoundary> getPostsByCreation(String productId, String filterValue, String sortAttr,
			boolean sortOrder, int page, int size) {
		Date date = this.validator.validDate(filterValue);
		if (date == null) {
			throw new BadTypeDateFormatException("Date type should be 'lastDay'/'lastWeek'/'lastMonth'");
		}

		return this.posts
				.findAllByProduct_IdAndPostingTimestampGreaterThanEqual(productId, date,
						PageRequest.of(page, size, sortOrder ? Direction.ASC : Direction.DESC, sortAttr))
				.stream().map(this.converter::fromEntity).collect(Collectors.toList());
	}

	@Override
	public List<PostBoundary> getAllPosts(String productId, String sortAttr, boolean sortOrder, int page, int size) {
		return this.posts
				.findAllByProduct_Id(productId,
						PageRequest.of(page, size, sortOrder ? Direction.ASC : Direction.DESC, sortAttr))
				.stream().map(this.converter::fromEntity).collect(Collectors.toList());
	}

	@Override
	public List<PostBoundary> getAllPostsByCreation(String filterValue, String sortAttr, boolean sortOrder, int page,
			int size) {
		Date date = this.validator.validDate(filterValue);
		if (date == null) {
			throw new BadTypeDateFormatException("Date type should be 'lastDay'/'lastWeek'/'lastMonth'");
		}
		return this.posts
				.findAllByPostingTimestampGreaterThanEqual(date,
						PageRequest.of(page, size, sortOrder ? Direction.ASC : Direction.DESC, sortAttr))
				.stream().map(this.converter::fromEntity).collect(Collectors.toList());
	}

	@Override
	public List<PostBoundary> getAllPostsByCount(String filterValue, String sortAttr, boolean sortOrder, int page,
			int size) {
		if (!((filterValue != null) && (filterValue.matches("\\d*")))) {
			throw new BadTypeFilterValueException("Filter value should be only digits");
		}
		return this.posts.findAll(
				PageRequest.of(0, Integer.parseInt(filterValue), sortOrder ? Direction.ASC : Direction.DESC, sortAttr))
				.stream().map(this.converter::fromEntity).collect(Collectors.toList());
	}

	@Override
	public void deleteAll() {
		this.posts.deleteAll();

	}

}
