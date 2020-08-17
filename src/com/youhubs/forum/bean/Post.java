package com.youhubs.forum.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Post {
	private int id;
	private int pid; // parent id
	private int rootId;
	private int level;
	private String title;
	private String content;
	private boolean isLeaf;
	private Date pdate = new Date();

	public Post() {
	}

	public Post(int id, int pid, int rootId, int level, String title, String content, boolean isLeaf, Date pdate) {
		this(pid, rootId, level, title, content, isLeaf);
		this.id = id;
		this.pdate = pdate;
	}

	public Post(int pid, int rootId, int level, String title, String content, boolean isLeaf) {
		this.pid = pid;
		this.rootId = rootId;
		this.level = level;
		this.title = title;
		this.content = content;
		this.isLeaf = isLeaf;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getRootId() {
		return rootId;
	}

	public void setRootId(int rootId) {
		this.rootId = rootId;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isLeaf() {
		return isLeaf;
	}

	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	public Date getPdate() {
		return pdate;
	}

	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}

	public void initFromRs(ResultSet rs) {
		try {
			setId(rs.getInt("id"));
			setPid(rs.getInt("pid"));
			setRootId(rs.getInt("rootid"));
			setTitle(rs.getString("title"));
			setLeaf(rs.getInt("isleaf") == 0);
			setPdate(rs.getTimestamp("pdate"));
			setContent(rs.getString("cont"));
			setLevel(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
