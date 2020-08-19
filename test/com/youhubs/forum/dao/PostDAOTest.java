package com.youhubs.forum.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.youhubs.forum.bean.Post;

class PostDAOTest {

	private static DriverManagerDataSource dataSource;
	private static PostDAO dao;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/forumdb");
		dataSource.setUsername("root");
		dataSource.setPassword("password");

		dao = new PostDAOImpl(dataSource);
	}

	@Test
	void testAddPost() {
		Post post = new Post(2, 0, 0, "first post", "This is a tesing post!", false, new Date());
		int result = dao.addPost(post);
		assertTrue(result > 0);
	}

	@Test
	void testUpdatePost() {
		Post post = new Post(2, 0, 0, "second post", "This is another tesing post!", false, new Date());
		Integer result = dao.updatePost(post);

		assertTrue(result > 0);
	}

	@Test
	void testGetPost() {
		Integer id = 1;
		Post post = dao.getPostById(id);

		assertNotNull(post);
	}

	@Test
	void testDeletePost() {
		Integer id = 3;
		int result = dao.deletePostById(id);

		assertTrue(result > 0);
	}

	@Test
	void testListPost() {
		List<Post> posts = dao.listPost();
		for (Post post : posts) {
			System.out.println(post.getTitle());
		}

		assertTrue(!posts.isEmpty());
	}
}
