package com.youhubs.forum.bean;

import java.util.Date;

public class Post {
	private int id;
	private int pid; // parent id
	private int rootId;
	private String title;
	private String content;
	private boolean isLeaf;
	private Date pdate = new Date();

	public Post() {
	}

	public Post(int id, int pid, int rootId, String title, String content, boolean isLeaf, Date pdate) {
		this(pid, rootId, title, content, isLeaf);
		this.id = id;
		this.pdate = pdate;
	}

	public Post(int pid, int rootId, String title, String content, boolean isLeaf) {
		this.pid = pid;
		this.rootId = rootId;
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
}
