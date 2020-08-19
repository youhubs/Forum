package com.youhubs.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.youhubs.forum.dao.PostDAO;

@Controller
public class PostController {

	@Autowired
	private PostDAO postDAO;

}
