package com.humanbooster.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.humanbooster.business.EvaluableIdea;
import com.humanbooster.business.Mark;
import com.humanbooster.services.IdeaService;
import com.humanbooster.services.MarkService;
import com.humanbooster.services.UserService;


@Controller
public class MarkController {
	
	@Autowired
	private MarkService markService;
	
	@Autowired
	private IdeaService ideaService;
	
	@Autowired
	private UserService userService;
		
	private Mark mark;
	
	@RequestMapping(value = "/addMarkTop", method = RequestMethod.POST)
	public void addMarkTop(	@RequestParam Map<String, Object> map) {
		int idIdea = Integer.parseInt((String) map.get("idIdea"));
		EvaluableIdea evaluableIdea = ideaService.findEvaluableIdeaByID(idIdea);
		mark = new Mark();
		mark.setEvaluableIdea(evaluableIdea);
		mark.setUserLambda(userService.findUserById(Integer.parseInt((String) map.get("idUser"))));
		mark.setValueMark(1);
		markService.addMark(mark);
		
	}
	
	@RequestMapping(value = "/addMarkFlop", method = RequestMethod.POST)
	public void addMarkFlop(@RequestParam Map<String, Object> map) {
		int idIdea = Integer.parseInt((String) map.get("idIdea"));
		EvaluableIdea evaluableIdea = ideaService.findEvaluableIdeaByID(idIdea);
		mark = new Mark();
		mark.setEvaluableIdea(evaluableIdea);
		mark.setUserLambda(userService.findUserById(Integer.parseInt((String) map.get("idUser"))));
		mark.setValueMark(-1);
		markService.addMark(mark);
		
	}

}
