package com.youhubs.forum.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.youhubs.forum.bean.User;

class UserDAOTest {
	private DriverManagerDataSource dataSource;
	private UserDAO dao;

	@BeforeEach
	void setupBeforeEach() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/forumdb");
		dataSource.setUsername("root");
		dataSource.setPassword("password");

		dao = new UserDAOImpl(dataSource);
	}

	@Test
	void testAddUser() {
		User user = new User("tiger", "tiger123", "tiger@yahoo.com");
		int result = dao.addUser(user);
		assertTrue(result > 0);
	}

	@Test
	void testUpdateUser() {
		User user = new User(2, "tigerhu", "tiger123", "tigerhu@yahoo.com");
		int result = dao.updateUser(user);

		assertTrue(result > 0);
	}

	@Test
	void testGetUser() {
		Integer id = 1;
		User user = dao.getUser(id);

		assertNotNull(user);
	}

	@Test
	void testDeleteUser() {
		Integer id = 4;
		int result = dao.deleteUser(id);

		assertTrue(result > 0);
	}

	@Test
	void testListUser() {
		List<User> users = dao.listUser();
		for (User user : users) {
			System.out.println(user);
		}

		assertTrue(!users.isEmpty());
	}

}
