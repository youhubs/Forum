package com.youhubs.forum.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.youhubs.forum.bean.Topic;

public class TopicDAOImpl implements TopicDAO {

	private JdbcTemplate jdbcTemplate;

	public TopicDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Topic> listTopic() {
		String sql = "SELECT * FROM Topic";

		RowMapper<Topic> rowMapper = new RowMapper<Topic>() {
			@Override
			public Topic mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer tid = rs.getInt("tid");
				String name = rs.getString("name");
				String content = rs.getString("content");
				String image = rs.getString("image");
				return new Topic(tid, name, content, image);
			}
		};

		return jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public List<String> listImage() {
		// TODO Auto-generated method stub
		return null;
	}

}
