package com.iiht.forum.serviceTest;

import static com.iiht.forum.UtilTestClass.TestUtils.businessTestFile;
import static com.iiht.forum.UtilTestClass.TestUtils.currentTest;
import static com.iiht.forum.UtilTestClass.TestUtils.yakshaAssert;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.iiht.forum.UtilTestClass.MasterData;
import com.iiht.forum.dto.VisitorPostsDto;
import com.iiht.forum.model.VisitorPosts;
import com.iiht.forum.service.PostService;

public class TestPostService 
{
	@Mock
    private RestTemplate restTemplate;
	
	@Mock
	private VisitorPostsDto visitorPostDto;

	@Mock
	private PostService postService;

	// -------------------------------------------------------------------------------------------------------------------
	@Before
	public void setup() 
	{
		MockitoAnnotations.initMocks(this);
	}

	//----------------------------------------------------------------------------------------------
	@Test
    public void givenMockingIsDoneByMockito_whenGetIsCalled_shouldReturnMockedObject() throws Exception
	{
        VisitorPosts posts = new VisitorPosts("1", "Cricket", "World Sport", "This sport world cup is played every 4 years");
        
        Mockito.when(restTemplate.getForEntity("http://localhost:8766/getPostById/1", VisitorPosts.class)).thenReturn(new ResponseEntity<VisitorPosts>(posts, HttpStatus.OK));
 
        VisitorPostsDto post = postService.getPostById(posts.getId());

        //Assert.assertEquals(posts, post);
	    yakshaAssert(currentTest(), post != null ? true : false, businessTestFile);
    }
	
	//----------------------------------------------------------------------------------------------
	@Test
	public void testSavePostsTest() throws Exception 
	{
	    when(postService.saveUpdate(MasterData.getPostDetails())).thenReturn(true);
		
	    List<VisitorPostsDto> postFromdb = postService.getAllPosts();
		
	    yakshaAssert(currentTest(), postFromdb != null ? true : false, businessTestFile);
	}

	//--------------------------------------------------------------------------------------------------------------------------------
	@Test 
	public void testSavePostsTest1() throws Exception 
	{
		when(postService.saveUpdate(MasterData.getPostDetails())).thenReturn(true); 
		
		VisitorPostsDto postFromdb = postService.getPostById(visitorPostDto.getId());
		
	    yakshaAssert(currentTest(), postFromdb != null ? true : false, businessTestFile);
	}

	//--------------------------------------------------------------------------------------------------------------------------------
	@Test
	public void testSavePostServiceTest() throws Exception 
	{
		boolean value = postService.saveUpdate(MasterData.getPostDetails());
	
	    yakshaAssert(currentTest(), value ? true : false, businessTestFile);
	}

	//--------------------------------------------------------------------------------------------------------------------------------
	@Test
	public void testViewAllPostsImplTest() throws Exception 
	{	
		List<VisitorPostsDto> list = new ArrayList<VisitorPostsDto>();
		list.add(new VisitorPostsDto());
		list.add(new VisitorPostsDto());

		when(postService.getAllPosts()).thenReturn((List<VisitorPostsDto>) list);
		
		List<VisitorPostsDto> postFromdb = postService.getAllPosts();
	    
		yakshaAssert(currentTest(), postFromdb==list ? true : false, businessTestFile);
	}

	//--------------------------------------------------------------------------------------------------------------------------------
	@Test
	public void testViewAllPostsImplTest1() throws Exception 
	{ 
		VisitorPostsDto value = MasterData.getPostDetails();
		
		VisitorPosts posts = new VisitorPosts("10", "World Sport", "Cricket", "This Sport is played around the Globe...");

		when(postService.getVisitorPostsDto(posts)).thenReturn(value);
		
		VisitorPostsDto postFromdb = postService.getVisitorPostsDto(posts);
	
	    yakshaAssert(currentTest(), postFromdb==value ? true : false, businessTestFile);
	}
	  
	//--------------------------------------------------------------------------------------------------------------------------------
	@Test 
	public void testViewAllPostsImplTest2() throws Exception 
	{ 
		when(postService.getAllPosts()).thenReturn(null);

		List<VisitorPostsDto> postsFromdb = postService.getAllPosts();
	    
		yakshaAssert(currentTest(), postsFromdb==null ? true : false, businessTestFile);
	}
	//--------------------------------------------------------------------------------------------------------------------------------
	@Test 
	public void testViewAllPostsImplTest3() throws Exception 
	{ 
		when(postService.getVisitorPostsDto(new VisitorPosts())).thenReturn(null);

		VisitorPostsDto postFromdb = postService.getPostById(visitorPostDto.getId());

	    yakshaAssert(currentTest(), postFromdb==null ? true : false, businessTestFile);
	}
}