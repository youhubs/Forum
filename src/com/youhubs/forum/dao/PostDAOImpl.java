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

import com.youhubs.forum.bean.PageIndex;
import com.youhubs.forum.bean.Post;

public class PostDAOImpl implements PostDAO {

	private JdbcTemplate jdbcTemplate;

	public PostDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int addPost(Post p) {
		String sql = "INSERT INTO Post (pid, rootid, title, content, isleaf, pdate) VALUES (?, ?, ?, ?, ?, ?)";
		return jdbcTemplate.update(sql, p.getPid(), p.getRootId(), p.getTitle(), p.getContent(), p.isLeaf(),
				p.getPdate());
	}

	@Override
	public int updatePost(Post p) {
		String sql = "UPDATE Post SET pid=?, rootid=?, title=?, content=?, isleaf=? WHERE id=?";
		return jdbcTemplate.update(sql, p.getPid(), p.getRootId(), p.getTitle(), p.getContent(), p.isLeaf(), p.getId());
	}

	@Override
	public Post getPostById(Integer id) {
		String sql = "SELECT * FROM Post WHERE id=" + id;

		ResultSetExtractor<Post> extractor = new ResultSetExtractor<Post>() {
			@Override
			public Post extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					Integer pid = rs.getInt("pid");
					Integer rootid = rs.getInt("rootid");
					String title = rs.getString("title");
					String content = rs.getString("content");
					Boolean isleaf = rs.getBoolean("isleaf");
					Date pdate = rs.getDate("pdate");
					return new Post(id, pid, rootid, title, content, isleaf, pdate);
				}
				return null;
			}
		};

		return jdbcTemplate.query(sql, extractor);
	}

	@Override
	public int deletePostById(Integer id) {
		String sql = "DELETE FROM Post WHERE id=" + id;
		return jdbcTemplate.update(sql);
	}

	@Override
	public List<Post> listPost() {
		String sql = "SELECT * FROM Post";

		RowMapper<Post> rowMapper = new RowMapper<Post>() {
			@Override
			public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id = rs.getInt("id");
				Integer pid = rs.getInt("pid");
				Integer rootid = rs.getInt("rootid");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Boolean isleaf = rs.getBoolean("isleaf");
				Date pdate = rs.getDate("pdate");
				return new Post(id, pid, rootid, title, content, isleaf, pdate);
			}
		};

		return jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public List<Post> listRootPost() {
		String sql = "SELECT * FROM Post WHERE pid=0";

		RowMapper<Post> rowMapper = new RowMapper<Post>() {
			@Override
			public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id = rs.getInt("id");
				Integer pid = rs.getInt("pid");
				Integer rootid = rs.getInt("rootid");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Boolean isleaf = rs.getBoolean("isleaf");
				Date pdate = rs.getDate("pdate");
				return new Post(id, pid, rootid, title, content, isleaf, pdate);
			}
		};

		return jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public PageIndex<Post> listPostByPage(int curPage) {
		int limit = 4;
		int offset = (curPage - 1) * limit;
		int allCount = this.listRootPost().size();
		int allPage = 0;
		if (allCount <= limit) {
			allPage = 1;
		} else if (allCount / limit == 0) {
			allPage = allCount / limit;
		} else {
			allPage = allCount / limit + 1;
		}

		String sql = "SELECT * FROM Post p WHERE p.pid=0 ORDER BY p.pdate DESC LIMIT " + offset + ", " + limit;
		RowMapper<Post> rowMapper = new RowMapper<Post>() {
			@Override
			public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id = rs.getInt("id");
				Integer pid = rs.getInt("pid");
				Integer rootid = rs.getInt("rootid");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Boolean isleaf = rs.getBoolean("isleaf");
				Date pdate = rs.getDate("pdate");
				return new Post(id, pid, rootid, title, content, isleaf, pdate);
			}
		};

		List<Post> posts = jdbcTemplate.query(sql, rowMapper);

		PageIndex<Post> pageIndex = new PageIndex<>(allPage, curPage);
		pageIndex.setList(posts);

		return pageIndex;
	}
}
