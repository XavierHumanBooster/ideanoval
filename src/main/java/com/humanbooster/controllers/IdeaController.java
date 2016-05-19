package com.humanbooster.controllers;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.humanbooster.business.EvaluableIdea;
import com.humanbooster.services.IdeaService;

@Controller
public class IdeaController {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private IdeaService ideaService;
	
	// ======================
	// Getter publish
	// ======================

	
	@RequestMapping(value = "/publish", method = RequestMethod.GET)
	public ModelAndView accueilPublishIdea(Map<String, Object> map) {
		map.put("evaluableIdea", new EvaluableIdea());
		return new ModelAndView("/idea", map);
	}
	
	// ======================
	// publishIdea post
	// ======================

	
	@RequestMapping(value = "/publishIdea", method = RequestMethod.POST)
	public String Inscription(@ModelAttribute("evaluableIdea") EvaluableIdea evaluableIdea, BindingResult result, Map<String, Object> map) {

		if (ideaService.addIdea(evaluableIdea)) {
			return "ideaOk";
		} else {
			return "idea";
		}

	}
	
}
