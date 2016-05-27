package com.humanbooster.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.humanbooster.business.Idea;
import com.humanbooster.business.UserLambda;
import com.humanbooster.services.IdeaService;
import com.humanbooster.services.UserService;
import com.humanbooster.utils.SendMail;

@Controller
public class UserController {

	@Autowired
	private HttpSession session;

	@Autowired
	private UserService userService;
	
	@Autowired
	private IdeaService ideaService;

	// ======================
	// Getter index page
	// ======================

	@RequestMapping(value = "/pageAccueil", method = RequestMethod.GET)
	public ModelAndView connexionIndex(Map<String, Object> map) {
		try{
		UserLambda user = (UserLambda) userService.findUserById((int) session.getAttribute("idUser"));
		map.put("pseudoUser", user.getPseudoUser());
		}catch (NullPointerException e){
			e.printStackTrace();
		}
		List<Idea> listeIdea = ideaService.findEnableIdea();
		System.out.println(listeIdea.toString());
		map.put("listeIdea", listeIdea);
		map.put("listeSize", listeIdea.size());
		System.out.println(listeIdea.size());
		return new ModelAndView("pageAccueil", map);
	}

	// ======================
	// post login
	// ======================

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam Map<String, Object> map) {
		if (userService.connectUser((String) map.get("loginUser"), (String) map.get("passwordUser"))) {
			UserLambda user = (UserLambda) userService.findUserByMail((String) map.get("loginUser"));
			session.setAttribute("idUser", user.getIdUser());
			return connexionIndex(map);
		} else {
			map.put("userLambda", new UserLambda());
			return new ModelAndView("/loginRegister", map);
		}
	}

	// ======================
	// Getter register
	// ======================

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView accueilInscription(Map<String, Object> map) {
		map.put("userLambda", new UserLambda());
		return new ModelAndView("/loginRegister", map);
	}

	// ======================
	// Register post
	// ======================

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String Inscription(@ModelAttribute("userLambda") UserLambda userLambda, BindingResult result,
			Map<String, Object> map) {

		if (userService.addUser(userLambda) && SendMail.envoyerMailSMTP(userLambda.getLoginUser())) {
			return "sendMail";
		} else {
			return "loginRegister";
		}

	}

}
