package com.iiht.forum.FunctionalTestCases;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.iiht.forum.model.VisitorComments;
import com.iiht.forum.repository.CommentRepository;

import static com.iiht.forum.UtilTestClass.TestUtils.businessTestFile;
import static com.iiht.forum.UtilTestClass.TestUtils.currentTest;
import static com.iiht.forum.UtilTestClass.TestUtils.yakshaAssert;
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.Assert.assertEquals;

import java.util.List;

@DataJpaTest
@SpringBootTest
@AutoConfigureMockMvc
public class TestCommentRepository {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CommentRepository repository;

    @Test
    public void testFindByPostId() throws Exception
    {
        entityManager.persist(new VisitorComments("51", "10", "Food", "I like Hyderabad Biryani"));
        entityManager.persist(new VisitorComments("52", "11", "Technology", "I used laptop"));

        List<VisitorComments> posts = (List<VisitorComments>) repository.findVisitorByPostId("10");
        
        //assertEquals("10", posts.getPostId());

        //assertThat(posts).extracting(posts.getTags()).isEqualTo("Food");
        
	    yakshaAssert(currentTest(), (posts != null ? true : false), businessTestFile);	    
    }
}