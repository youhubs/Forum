package com.youhubs.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.youhubs.forum.bean.Post;
import com.youhubs.forum.dao.PostDAO;

@Controller
public class PostController {

	@Autowired
	private PostDAO postDAO;

	@RequestMapping(value = "/")
	public ModelAndView listPost(ModelAndView mav) {
		List<Post> posts = postDAO.listRootPost();
		mav.addObject("posts", posts);
		mav.setViewName("index");

		return mav;
	}

}
