package com.iiht.forum.FunctionalTestCases;

import static com.iiht.forum.UtilTestClass.TestUtils.businessTestFile;
import static com.iiht.forum.UtilTestClass.TestUtils.currentTest;
import static com.iiht.forum.UtilTestClass.TestUtils.yakshaAssert;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.iiht.forum.UtilTestClass.MasterData;
import com.iiht.forum.dto.VisitorCommentsDto;
import com.iiht.forum.dto.VisitorPostsDto;
import com.iiht.forum.service.CommentService;
import com.iiht.forum.service.PostService;

public class TestFunctional 
{	
	@Mock
	private PostService postService;
	
	@Mock
	private CommentService commentService;
	
	//--------------------------------------------------------------------------------------------------------------------------------
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	//--------------------------------------------------------------------------------------------------------------------------------
	@Test
	public void testSavePosts() throws Exception 
	{
		boolean value = postService.saveUpdate(MasterData.getPostDetails());
		
	    yakshaAssert(currentTest(), value ? true : false, businessTestFile);
	}

	//--------------------------------------------------------------------------------------------------------------------------------
	@Test
	public void testSaveComments() throws Exception 
	{
		boolean value = commentService.saveUpdate(MasterData.getCommentDetails());

	    yakshaAssert(currentTest(), value ? true : false, businessTestFile);
	}
	
	//--------------------------------------------------------------------------------------------------------------------------------
	@Test
	public void testViewAllPosts() throws Exception 
	{
		List<VisitorPostsDto> list = new ArrayList<VisitorPostsDto>();
		list.add(new VisitorPostsDto());
		list.add(new VisitorPostsDto());
	    
	    when(postService.getAllPosts()).thenReturn((List<VisitorPostsDto>) list);

	    List<VisitorPostsDto> postFromdb = postService.getAllPosts();

	    yakshaAssert(currentTest(), postFromdb == list ? true : false, businessTestFile);
	}

	//--------------------------------------------------------------------------------------------------------------------------------
//	@Test
//	public void testViewAllComments() throws Exception
//	{
//		List<VisitorCommentsDto> list = new ArrayList<VisitorCommentsDto>();
//		list.add(new VisitorCommentsDto());
//		list.add(new VisitorCommentsDto());
	    
//	    when(commentService.getCommentById((long)5).thenReturn(List<VisitorCommentsDto> list));
	
//	    List<VisitorCommentsDto> commentFromdb = commentService.getCommentById((long)10);

//	    yakshaAssert(currentTest(), commentFromdb == list ? true : false, businessTestFile);
//	}
	
	//--------------------------------------------------------------------------------------------------------------------------------
	@Test
	public void testViewAllDiscussions() throws Exception 
	{
		List<VisitorPostsDto> list = new ArrayList<VisitorPostsDto>();
		list.add(new VisitorPostsDto());
		list.add(new VisitorPostsDto());
	    
	    when(postService.getAllPosts()).thenReturn((List<VisitorPostsDto>) list);
	    
		List<VisitorPostsDto> discussionFromdb = postService.getAllPosts();

	    yakshaAssert(currentTest(), discussionFromdb == list ? true : false, businessTestFile);
	}	
}