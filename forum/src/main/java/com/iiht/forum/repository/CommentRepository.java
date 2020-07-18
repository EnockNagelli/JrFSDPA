package com.iiht.forum.repository;

import java.util.List;

//import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.iiht.forum.model.VisitorComments;

@Repository
public interface CommentRepository extends MongoRepository<VisitorComments, String>
{
	//@Query("select vp FROM VisitorComments vp WHERE vp.postId=?1")
	List<VisitorComments> findVisitorByPostId(String postId);
}