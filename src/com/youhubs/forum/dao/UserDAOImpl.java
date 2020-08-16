package com.youhubs.forum.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.youhubs.forum.bean.User;

public class UserDAOImpl implements UserDAO {

	private JdbcTemplate jdbcTemplate;

	public UserDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int addUser(User user) {
		String sql = "INSERT INTO User (username, password, email, memberdate) VALUES (?, ?, ?, ?)";
		return jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getEmail(), user.getMemberDate());
	}

	@Override
	public int updateUser(User user) {
		String sql = "UPDATE User SET username=?, password=?, email=? WHERE userid=?";
		return jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getEmail(), user.getId());
	}

	@Override
	public User getUser(Integer id) {
		String sql = "SELECT * FROM User WHERE userid=" + id;

		ResultSetExtractor<User> extractor = new ResultSetExtractor<User>() {
			@Override
			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					String username = rs.getString("username");
					String password = rs.getString("password");
					String email = rs.getString("email");
					Date memberdate = rs.getDate("memberdate");
					return new User(id, username, password, email, memberdate);
				}
				return null;
			}
		};

		return jdbcTemplate.query(sql, extractor);
	}

	@Override
	public int deleteUser(Integer id) {
		String sql = "DELETE FROM User WHERE userid=" + id;
		return jdbcTemplate.update(sql);
	}

	@Override
	public List<User> listUser() {
		String sql = "SELECT * FROM User";

		RowMapper<User> rowMapper = new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id = rs.getInt("userid");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String email = rs.getString("email");
				Date memberdate = rs.getDate("memberdate");
				return new User(id, username, password, email, memberdate);
			}
		};

		return jdbcTemplate.query(sql, rowMapper);
	}
}
