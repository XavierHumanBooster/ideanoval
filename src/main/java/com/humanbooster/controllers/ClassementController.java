package com.humanbooster.controllers;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.humanbooster.business.Mark;
import com.humanbooster.services.CommentaryService;
import com.humanbooster.services.IdeaService;
import com.humanbooster.services.MarkService;
import com.humanbooster.services.UserService;
import com.humanbooster.utils.ValueComparator;

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
		List<Mark> listMark = markService.getAllMark();
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for (Mark mark : listMark) {
			if(hashMap.containsKey(mark.getEvaluableIdea().getIdIdea())){
				int valur = hashMap.get(mark.getEvaluableIdea().getIdIdea()) + mark.getValueMark();
				hashMap.replace(mark.getEvaluableIdea().getIdIdea(), hashMap.get(mark.getEvaluableIdea().getIdIdea()), valur);
			}else{
				hashMap.put(mark.getEvaluableIdea().getIdIdea(), mark.getValueMark());
			}
		}
		hashMap.put(1, 20);
		hashMap.put(4, 80);
		hashMap.put(7, 2);
		hashMap.put(10, 28);
		hashMap.put(8, 15);
		hashMap.put(0, 47);
		ValueComparator comparateur = new ValueComparator(hashMap);
		TreeMap<Integer,Integer> mapTriee = new TreeMap<Integer,Integer>(comparateur);
		System.out.println("map non-triée: "+hashMap); //La commande suivante affichera map non-triée: {A=99.5, B=67.4, C=65.2}.
		mapTriee.putAll(hashMap);
		System.out.println("resultat du tri: "+mapTriee); //La commande suivante affichera résultat: {C=65.2, B=67.4, A=99.5}.
		//System.out.println(hashMap);
		
		mapTriee.get(arg0);
		return null;
	}

}
