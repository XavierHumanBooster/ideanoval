package com.humanbooster.controllers;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		Collections.sort(hashMap,new Comparator<HashMap<Integer, Integer>>() {

			@Override
			public int compare(HashMap<Integer, Integer> o1, HashMap<Integer, Integer> o2) {
				// TODO Auto-generated method stub
				return 0;
			}
		});
		System.out.println(hashMap);
		return null;
		
		Collections.sort(array, new Comparator<String>()
	    {
	           public int compare(String o1, String o2)
	           {
	                  return tree2.get(o1).compareTo(tree2.get(o2));
	            }
	    });
	 
	    for (String cle : array) {
	        System.out.println(cle + " : " + tree2.get(cle));
	    }
	}

}
