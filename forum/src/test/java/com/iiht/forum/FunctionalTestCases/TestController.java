package com.iiht.forum.FunctionalTestCases;

import static com.iiht.forum.UtilTestClass.TestUtils.businessTestFile;
import static com.iiht.forum.UtilTestClass.TestUtils.currentTest;
import static com.iiht.forum.UtilTestClass.TestUtils.yakshaAssert;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.CollectionUtils;

import com.iiht.forum.UtilTestClass.JSONUtils;
import com.iiht.forum.controller.VisitorCommentController;
import com.iiht.forum.controller.VisitorPostController;
import com.iiht.forum.dto.VisitorCommentsDto;
import com.iiht.forum.dto.VisitorPostsDto;
import com.iiht.forum.service.CommentService;
import com.iiht.forum.service.PostService;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT, classes = VisitorPostController.class)
@AutoConfigureMockMvc 
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class TestController 
{	
	@Mock
	private PostService postService;

	@Mock
	private CommentService commentService;

	@InjectMocks
	private VisitorPostController visitorPostController;

	@InjectMocks
	private VisitorCommentController visitorCommentController;
	
	// -------------------------------------------------------------------------------------------------------------------
	/*
	 * Description : This test is to perform setup for Mockito initiations
	 */
	@Before public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
		//this.mockMvc = MockMvcBuilders.standaloneSetup(visitorPostController).build(); 
	}
	  
	//-----------------------------------------------------------------------------
	/*
	 * Description : This test is to perform add new post in the Forum
	 */
	@Test 
	public void testAddPost() throws Exception { 
        VisitorPostsDto post2 = JSONUtils.createPostDto("4", "Foot Ball", "Field Game", "World Sport. Great Sport");
        ResponseEntity<Boolean> responseEntity = visitorPostController.saveUpdate(post2);
        yakshaAssert(currentTest(), (responseEntity.getStatusCodeValue() > 0 ? true : false), businessTestFile);
	}
	  
	//-----------------------------------------------------------------------------
	/*
	 * Description : This test is to perform view all the posts from database
	 */
	@Test 
	public void testViewAllPosts() throws Exception { 
        // Given input
		VisitorPostsDto post1 = JSONUtils.createPostDto("6", "Kabbadi", "India Sport", "Good Sport. Propularly played by all eastern countries.");
		VisitorPostsDto post2 = JSONUtils.createPostDto("7", "Ko Ko", "India Sport", "Good Sport. Propularly played by all states in India.");
		VisitorPostsDto post3 = JSONUtils.createPostDto("8", "Chess", "World Sport", "Great Sport. Propularly played by all countries.");
        List<VisitorPostsDto> list = new ArrayList<VisitorPostsDto>();
        list.add(post1);
        list.add(post2);
        list.add(post3);
        // when
        when(postService.getAllPosts()).thenReturn(list);
        List<VisitorPostsDto> fromController = postService.getAllPosts();
        // then
        assertThat(fromController.size()).isEqualTo(3);
        assertThat(fromController.get(0).getTitle()).isEqualTo(post1.getTitle());
        assertThat(fromController.get(0).getTags()).isEqualTo(post1.getTags());
        assertThat(fromController.get(0).getPostDescription()).isEqualTo(post1.getPostDescription());

        assertThat(fromController.get(0).getTitle()).isEqualTo(post1.getTitle());
        assertThat(fromController.get(1).getTags()).isEqualTo(post2.getTags());
        assertThat(fromController.get(2).getPostDescription()).isEqualTo(post3.getPostDescription());
        yakshaAssert(currentTest(), (fromController.size() == 3 ? true : false), businessTestFile);
	}
	  
	//-----------------------------------------------------------------------------
	/*
	 * Description : This test is to perform check the null operation against view all posts operation
	 */
	@Test 
	public void testViewAllPostsCase() throws Exception {
 		List<VisitorPostsDto> list = new ArrayList<VisitorPostsDto>();
		when(postService.getAllPosts()).thenReturn(list);
        // when
        List<VisitorPostsDto> fromController = postService.getAllPosts();
        // then
        assertThat(fromController.size()).isEqualTo(0);
		yakshaAssert(currentTest(), (fromController.size() == 0 ? true : false) ? true : false, businessTestFile); 
	}
	  
	//---------------------------------------------------------------------------
	/*
	 * Description : This test is to perform add a comment and check the status of the operation
	 */
	@Test 
	public void testAddComments() throws Exception { 
        VisitorCommentsDto comment = JSONUtils.createCommentDto("4", "5", "Field Game", "I like this sport");
        ResponseEntity<Boolean> responseEntity = visitorCommentController.saveUpdate(comment);
        yakshaAssert(currentTest(), (responseEntity.getStatusCodeValue() > 0 ? true : false), businessTestFile);
	}
	  
	//---------------------------------------------------------------------------
	/*
	 * Description : This test is to perform to view all the discussions of the posts
	 */
	@Test 
	public void testViewAllDiscussions() throws Exception { 
	    // Given input
		VisitorPostsDto post1 = JSONUtils.createPostDto("6", "Kabbadi", "India Sport", "Good Sport. Propularly played by all eastern countries.");
		VisitorPostsDto post2 = JSONUtils.createPostDto("7", "Ko Ko", "India Sport", "Good Sport. Propularly played by all states in India.");
		VisitorPostsDto post3 = JSONUtils.createPostDto("8", "Chess", "World Sport", "Great Sport. Propularly played by all countries.");
	    List<VisitorPostsDto> list = new ArrayList<VisitorPostsDto>();
	    list.add(post1);
	    list.add(post2);
	    list.add(post3);
	    HashMap<String, String> discussion = new HashMap<String, String>();
		if(!CollectionUtils.isEmpty(list)) {
			for(VisitorPostsDto p : list) {
				discussion.put(p.getId(), p.getTitle());
			}
		}
	    // when
	    when(postService.getAllPosts()).thenReturn(list);
	    Map<String, String> fromController = (Map<String, String>) visitorPostController.getAllDiscussions().getBody();
	    assertThat(fromController.size()).isEqualTo(3);
	    Set<String> s = fromController.keySet();
	    Iterator<String> it = s.iterator();
	    while(it.hasNext()) {
	    	System.out.println("Value : "+it.next());
	    }	    
	    yakshaAssert(currentTest(), (fromController.size() == 3 ? true : false), businessTestFile);
	}
}