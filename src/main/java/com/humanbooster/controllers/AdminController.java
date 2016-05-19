package com.humanbooster.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.humanbooster.business.Administrator;
import com.humanbooster.business.UserLambda;
import com.humanbooster.services.UserService;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private UserService userService;

	//==================
	//= Connexion page =
	//==================	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView affichageConnexionAdmin(Map<String, Object> map) {
		map.put("administrator", new Administrator());
		
		return new ModelAndView("admin", map);
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ModelAndView connexionAdminPanel(@RequestParam Map<String, Object> map) {
		if (userService.connectAdmin((String) map.get("loginUser"), (String) map.get("passwordUser"))) {
			Administrator admin = (Administrator) userService.findUserByMail((String) map.get("loginUser"));
			session.setAttribute("idUser", admin.getIdUser());
			return affichageAdminPanel(map);
		} else {
			map.put("errorMsg", "Error during connection...");
			return affichageConnexionAdmin(map);
		}
	}
	
	//===============
	//= Panel Admin =
	//===============
	@RequestMapping(value = "/panel", method = RequestMethod.GET)
	public ModelAndView affichageAdminPanel(Map<String, Object> map) {
		List<UserLambda> notApprouved = userService.findAllNotApprouvedUser(); 
		map.put("attempApprouved", notApprouved);
		map.put("attempApprouvedNumber", notApprouved.size());
		
		return new ModelAndView("adminPanel", map);
	}
	
}
