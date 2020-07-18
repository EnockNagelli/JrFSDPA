package com.iiht.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iiht.forum.model.VisitorPosts;

@Repository
public interface PostRepository extends MongoRepository<VisitorPosts, String>{

//	@Query("select vp FROM VisitorPosts vp")
//	List<VisitorPosts> findAllPosts();
	
	//@Query("select vp FROM VisitorPosts vp WHERE vp.postId=?1")
	VisitorPosts findPostById(String postId);
}