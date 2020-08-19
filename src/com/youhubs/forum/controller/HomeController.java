package com.youhubs.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.youhubs.forum.bean.PageIndex;
import com.youhubs.forum.bean.Post;
import com.youhubs.forum.bean.User;
import com.youhubs.forum.dao.PostDAO;
import com.youhubs.forum.dao.UserDAO;

@Controller
public class HomeController {

	@Autowired
	private PostDAO postDAO;

	@Autowired
	private UserDAO userDAO;

	@RequestMapping(value = "/")
	public ModelAndView listPost(ModelAndView mav) {
		List<Post> posts = postDAO.listRootPost();
		PageIndex<Post> pageIndex = postDAO.listPostByPage(1);
		List<User> users = userDAO.listUser();

		mav.addObject("posts", posts);
		mav.addObject("users", users);
		mav.addObject("pageIndex", pageIndex);
		mav.setViewName("index");

		return mav;
	}

}
