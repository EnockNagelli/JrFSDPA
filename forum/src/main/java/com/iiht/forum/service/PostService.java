package com.iiht.forum.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.iiht.forum.dto.VisitorPostsDto;
import com.iiht.forum.model.VisitorPosts;
import com.iiht.forum.repository.PostRepository;

@Service
public class PostService 
{
	@Autowired(required=true)
	private PostRepository repository;

	@Autowired
	private ModelMapper modelMapper;
	
	@Transactional
	public Boolean saveUpdate(VisitorPostsDto postInput) 
	{
		return null;
	}
	
	public VisitorPostsDto getPostById(String id)
	{
		return null;
	}
	
	public List<VisitorPostsDto> getAllPosts()
	{
		return null;
	}

	public VisitorPostsDto getVisitorPost(VisitorPosts posts) {
		return null;
	}
	
	public VisitorPostsDto getVisitorPostsDto(VisitorPosts posts) {
		return null;
	}
}