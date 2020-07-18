package com.iiht.forum.serviceTest;

import static com.iiht.forum.UtilTestClass.TestUtils.businessTestFile;
import static com.iiht.forum.UtilTestClass.TestUtils.currentTest;
import static com.iiht.forum.UtilTestClass.TestUtils.yakshaAssert;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.iiht.forum.UtilTestClass.MasterData;
import com.iiht.forum.dto.VisitorCommentsDto;
import com.iiht.forum.model.VisitorComments;
import com.iiht.forum.service.CommentService;

public class TestCommentService
{
	@Mock
	private VisitorCommentsDto visitorCommentDto;
	
	@Mock
	private CommentService commentService;
	
	// -------------------------------------------------------------------------------------------------------------------
	@Before
	public void setup() 
	{
		MockitoAnnotations.initMocks(this);
	}

	//--------------------------------------------------------------------------------------------------------------------------------
	@Test 
	public void testSaveCommentsImplTest() throws Exception 
	{
		when(commentService.saveUpdate(MasterData.getCommentDetails())).thenReturn(true); 
		
		List<VisitorCommentsDto> commentFromdb = commentService.getCommentById(visitorCommentDto.getPostId());
		
	    yakshaAssert(currentTest(), commentFromdb != null ? true : false, businessTestFile);
	}

	//--------------------------------------------------------------------------------------------------------------------------------
	@Test
	public void testCommentServiceImplTest() throws Exception 
	{
		boolean value = commentService.saveUpdate(MasterData.getCommentDetails());
		
	    yakshaAssert(currentTest(), value ? true : false, businessTestFile);
	}
	
	//--------------------------------------------------------------------------------------------------------------------------------
	@Test 
	public void testViewAllCommentsImplTest() throws Exception 
	{
		VisitorCommentsDto value = MasterData.getCommentDetails();
		
		VisitorComments comments = new VisitorComments("10", "11", "Cricket", "I like this sport.");

		when(commentService.getVisitorCommentsDto(comments)).thenReturn(value);
		
		VisitorCommentsDto commentFromdb = commentService.getVisitorCommentsDto(comments);
	
	    yakshaAssert(currentTest(), commentFromdb==value ? true : false, businessTestFile);
	}
	
	//--------------------------------------------------------------------------------------------------------------------------------
	@Test 
	public void testViewAllCommentsImplTest2() throws Exception 
	{ 
		when(commentService.getVisitorCommentsDto(new VisitorComments())).thenReturn(null);
		  
		List<VisitorCommentsDto> commentFromdb = commentService.getCommentById(visitorCommentDto.getPostId());

	    yakshaAssert(currentTest(), commentFromdb==null ? true : false, businessTestFile);
	}	 	
}