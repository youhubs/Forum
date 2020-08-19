package com.youhubs.forum.dao;

import java.util.List;

import com.youhubs.forum.bean.PageIndex;
import com.youhubs.forum.bean.Post;

public interface PostDAO {

	public int addPost(Post post);

	public int updatePost(Post post);

	public Post getPostById(Integer id);

	public int deletePostById(Integer id);

	public List<Post> listPost();

	public List<Post> listRootPost();

	public PageIndex<Post> listPostByPage(int curPage);
}
