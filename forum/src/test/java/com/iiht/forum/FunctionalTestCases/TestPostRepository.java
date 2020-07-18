package com.iiht.forum.FunctionalTestCases;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.iiht.forum.model.VisitorPosts;
import com.iiht.forum.repository.PostRepository;

import static com.iiht.forum.UtilTestClass.TestUtils.businessTestFile;
import static com.iiht.forum.UtilTestClass.TestUtils.currentTest;
import static com.iiht.forum.UtilTestClass.TestUtils.yakshaAssert;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

//@ExtendWith(SpringExtension.class)
@DataJpaTest
@SpringBootTest
@AutoConfigureMockMvc
public class TestPostRepository {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PostRepository repository;

    @Test
    public void testFindByPostId() throws Exception
    {
        entityManager.persist(new VisitorPosts("10", "Cooking", "Food", "Hyderabad Biryani is very famous."));
        entityManager.persist(new VisitorPosts("11", "Computers", "Technology", "Used to compute for the given inputs."));

        VisitorPosts posts = repository.findPostById("10");
        
        //assertEquals("10", posts.getId());

        //assertThat(posts).extracting(posts.getTitle()).isEqualTo("Cooking");
        
	    yakshaAssert(currentTest(), (posts != null ? true : false), businessTestFile);	    
    }
}