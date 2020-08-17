package com.youhubs.forum.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.youhubs.forum.bean.User;
import com.youhubs.forum.dao.UserDAO;

@Controller
public class UserController {

	@Autowired
	private UserDAO userDAO;

	@RequestMapping(value = "/")
	public String home() {
		return "index";
	}

	@RequestMapping(value = "/users")
	public ModelAndView listUser(ModelAndView mav) {
		List<User> users = userDAO.listUser();
		mav.addObject("users", users);
		mav.setViewName("admin");

		return mav;
	}

	@RequestMapping(value = "/new-user", method = RequestMethod.GET)
	public ModelAndView newUser(ModelAndView mav) {
		User user = new User();
		mav.addObject("user", user);
		mav.setViewName("user_form");

		return mav;
	}

	@RequestMapping(value = "/save-user", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute User user) {
		if (user.getId() == null) {
			userDAO.addUser(user);
		} else {
			userDAO.updateUser(user);
		}

		return new ModelAndView("redirect:/users");
	}

	@RequestMapping(value = "/edit-user", method = RequestMethod.GET)
	public ModelAndView editUser(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		User user = userDAO.getUser(id);

		ModelAndView mav = new ModelAndView("user_form");
		mav.addObject("user", user);

		return mav;
	}

	@RequestMapping(value = "/delete-user", method = RequestMethod.GET)
	public ModelAndView deleteUser(@RequestParam Integer id) {
		userDAO.deleteUser(id);

		return new ModelAndView("redirect:/users");
	}
}
