package com.iiht.forum.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.iiht.forum.dto.VisitorCommentsDto;
import com.iiht.forum.model.VisitorComments;
import com.iiht.forum.repository.CommentRepository;

@Service
public class CommentService 
{
	@Autowired
	private CommentRepository repository; 

	@Autowired
	private ModelMapper modelMapper;

	@Transactional
	public Boolean saveUpdate(VisitorCommentsDto commentInput)
	{
		return null;
	}
	
	public List<VisitorCommentsDto> getCommentById(String postId)
	{
		return null;
	}

	public VisitorCommentsDto getVisitorCommentsDto(VisitorComments comments)
	{
		return null;
	}	
}