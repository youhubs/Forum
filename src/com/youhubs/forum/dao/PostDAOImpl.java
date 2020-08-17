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

import com.youhubs.forum.bean.Post;

public class PostDAOImpl implements PostDAO {

	private JdbcTemplate jdbcTemplate;

	public PostDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int addPost(Post p) {
		String sql = "INSERT INTO Post (pid, rootid, level, title, content, isleaf, pdate) VALUES (?, ?, ?, ?, ?, ?, ?)";
		return jdbcTemplate.update(sql, p.getPid(), p.getRootId(), p.getLevel(), p.getTitle(), p.getContent(),
				p.isLeaf(), p.getPdate());
	}

	@Override
	public int updatePost(Post p) {
		String sql = "UPDATE Post SET pid=?, rootid=?, level=?, title=?, content=?, isleaf=? WHERE postid=?";
		return jdbcTemplate.update(sql, p.getPid(), p.getRootId(), p.getLevel(), p.getTitle(), p.getContent(),
				p.isLeaf(), p.getId());
	}

	@Override
	public Post getPost(Integer id) {
		String sql = "SELECT * FROM Post WHERE postid=" + id;

		ResultSetExtractor<Post> extractor = new ResultSetExtractor<Post>() {
			@Override
			public Post extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					Integer pid = rs.getInt("pid");
					Integer rootid = rs.getInt("rootid");
					Integer level = rs.getInt("level");
					String title = rs.getString("title");
					String content = rs.getString("content");
					Boolean isleaf = rs.getBoolean("isleaf");
					Date pdate = rs.getDate("pdate");
					return new Post(id, pid, rootid, level, title, content, isleaf, pdate);
				}
				return null;
			}
		};

		return jdbcTemplate.query(sql, extractor);
	}

	@Override
	public int deletePost(Integer id) {
		String sql = "DELETE FROM Post WHERE postid=" + id;
		return jdbcTemplate.update(sql);
	}

	@Override
	public List<Post> listPost() {
		String sql = "SELECT * FROM Post";

		RowMapper<Post> rowMapper = new RowMapper<Post>() {
			@Override
			public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id = rs.getInt("postid");
				Integer pid = rs.getInt("pid");
				Integer rootid = rs.getInt("rootid");
				Integer level = rs.getInt("level");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Boolean isleaf = rs.getBoolean("isleaf");
				Date pdate = rs.getDate("pdate");
				return new Post(id, pid, rootid, level, title, content, isleaf, pdate);
			}
		};

		return jdbcTemplate.query(sql, rowMapper);
	}
}
