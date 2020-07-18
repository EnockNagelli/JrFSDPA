package com.iiht.forum.boundaryTestCases;

import static com.iiht.forum.UtilTestClass.TestUtils.boundaryTestFile;
import static com.iiht.forum.UtilTestClass.TestUtils.currentTest;
import static com.iiht.forum.UtilTestClass.TestUtils.yakshaAssert;

import java.io.IOException;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.iiht.forum.UtilTestClass.MasterData;
import com.iiht.forum.dto.VisitorCommentsDto;
import com.iiht.forum.dto.VisitorPostsDto;

@RunWith(SpringRunner.class)
public class TestEntityValidation
{
    private Validator validator;
	
    //----------------------------------------------------------------------------------------------
    @Before
    public void setUp()
    {
    	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    //----------------------------------------------------------------------------------------------
    @Test
    public void testPostSuccess() throws IOException
    {
    	VisitorPostsDto posts = MasterData.getPostDetails();
    	
        Set<ConstraintViolation<VisitorPostsDto>> violations = validator.validate(posts);
        
	    yakshaAssert(currentTest(), violations.isEmpty() ? true : false, boundaryTestFile);	    
    }
    
    //----------------------------------------------------------------------------------------------
    @Test
    public void testPostFailed() throws IOException
    {
    	VisitorPostsDto posts = MasterData.getPostDetails();
    	
    	posts.setPostDescription(null);
    	
        Set<ConstraintViolation<VisitorPostsDto>> violations = validator.validate(posts);
        
	    yakshaAssert(currentTest(), violations.isEmpty() ? true : false, boundaryTestFile);
    }

    //----------------------------------------------------------------------------------------------
    @Test
    public void testCommentSuccess() throws IOException
    {
    	VisitorCommentsDto comments = MasterData.getCommentDetails();
    	
        Set<ConstraintViolation<VisitorCommentsDto>> violations = validator.validate(comments);

	    yakshaAssert(currentTest(), violations.isEmpty() ? true : false, boundaryTestFile);
    }
    
    @Test
    public void testCommentFailed() throws IOException
    {
    	VisitorCommentsDto comments = MasterData.getCommentDetails();
    	
    	comments.setComment(null);

    	Set<ConstraintViolation<VisitorCommentsDto>> violations = validator.validate(comments);

	    yakshaAssert(currentTest(), violations.isEmpty() ? true : false, boundaryTestFile);
    }
}