package org.spring.my;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.spring.my.dao.PostRepository;
import org.spring.my.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.GsonBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SampleTest {

	@Autowired
	PostRepository postRepository;

	@Test
	@Ignore
	public void test(){
		List<Post>posts = postRepository.selectAllPost();

		System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(posts));
	}

	@Test
	public void test2(){
		List<Post>posts = postRepository.selectAllUserPost();

		System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(posts));
	}
}
