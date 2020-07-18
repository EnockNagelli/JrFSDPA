package com.iiht.forum.exceptionTestCases;

import static com.iiht.forum.UtilTestClass.TestUtils.*;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.iiht.forum.UtilTestClass.MasterData;
import com.iiht.forum.controller.VisitorPostController;
import com.iiht.forum.dto.VisitorCommentsDto;
import com.iiht.forum.dto.VisitorPostsDto;
import com.iiht.forum.service.CommentService;
import com.iiht.forum.service.PostService;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@WebMvcTest(VisitorPostController.class)
public class ExceptionTest 
{
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PostService postService;

	@MockBean
	private CommentService commentService;
	
	@Test
	public void testSavePostException() throws Exception
	{
		VisitorPostsDto badData = MasterData.getPostDetails();
		
		badData.setId("123");
		badData.setTitle("Cricket");
		badData.setTags("Sport");
		badData.setPostDescription("World Sport");
		
		when(postService.saveUpdate(MasterData.getPostDetails())).thenReturn(true);
				
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/savePost")
				.content(MasterData.asJsonString(MasterData.getPostDetails()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(), 
		(result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? "true" : "false"), exceptionTestFile);
	}
	
	@Test
	public void testCommentPostException() throws Exception
	{
		VisitorCommentsDto badData = MasterData.getCommentDetails();
		
		badData.setId("123");
		badData.setPostId("111");
		badData.setTags("International Sport");
		badData.setComment("Good Sport. India won twice.");
		
		when(commentService.saveUpdate(MasterData.getCommentDetails())).thenReturn(true);
				
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/postComment")
				.content(MasterData.asJsonString(MasterData.getCommentDetails()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(), 
		(result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? "true" : "false"), exceptionTestFile);
	}	
}