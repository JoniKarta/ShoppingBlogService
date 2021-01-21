package com.example.demo.dal;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.data.PostEntity;

public interface PostDao extends PagingAndSortingRepository<PostEntity, String> {

	public List<PostEntity> findAllByUser_Email(@Param("email") String email, Pageable pageable);

	public List<PostEntity> findAllByUser_EmailAndLanguage(@Param("email") String email,
			@Param("language") String language, Pageable pageable);

	public List<PostEntity> findAllByUser_EmailAndPostingTimestampGreaterThanEqual(@Param("email") String email,
			@Param("postingTimestamp") Date date, Pageable pageable);

	public List<PostEntity> findAllByUser_EmailAndProduct_Id(@Param("email") String email, @Param("id") String id,
			Pageable pageable);

	public List<PostEntity> findAllByProduct_IdAndLanguage(@Param("productId") String productId,
			@Param("value") String value, Pageable pageable);

	public List<PostEntity> findAllByProduct_IdAndPostingTimestampGreaterThanEqual(@Param("productId") String productId,
			@Param("postingTimestamp") Date date, Pageable pageable);

	public List<PostEntity> findAllByProduct_Id(@Param("ProductId") String productId, Pageable pageable);

	public List<PostEntity> findAllByPostingTimestampGreaterThanEqual(@Param("postingTimestamp") Date date,
			Pageable pageable);

}
