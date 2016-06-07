package com.humanbooster.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.humanbooster.business.Administrator;
import com.humanbooster.services.CommentaryService;
import com.humanbooster.services.IdeaService;
import com.humanbooster.services.MarkService;
import com.humanbooster.services.UserService;

@Controller
@RequestMapping(value = "/classement")
public class ClassementController {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private IdeaService ideaService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MarkService markService;
	
	@Autowired
	private CommentaryService commentaryService;

	public ClassementController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView initClassementAndShowIt(Map<String, Object> map) {
		ideaService.getTenBestIdea();
		System.out.println(markService.getAllMark());
		return null;
	}

}
