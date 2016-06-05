package com.humanbooster.controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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

import com.humanbooster.business.Category;
import com.humanbooster.business.OptionPoll;
import com.humanbooster.business.Poll;
import com.humanbooster.business.UserLambda;
import com.humanbooster.services.CategoryService;
import com.humanbooster.services.IdeaService;
import com.humanbooster.services.OptionPollService;
import com.humanbooster.services.UserService;
import com.humanbooster.utils.Picture;

@Controller
public class PollController {

	@Autowired
	private HttpSession session;

	@Autowired
	private IdeaService ideaService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private OptionPollService optionPollService;
		
	private UserLambda userLambda;
	
	

	// ======================
	// Getter publishPoll
	// ======================

	@RequestMapping(value = "/publishPoll", method = RequestMethod.GET)
	public ModelAndView accueilPublishPoll(@RequestParam Map<String, Object> map) {
		map.put("poll", new Poll());
		userLambda = (UserLambda) userService.findUserById((int) session.getAttribute("idUser"));
		List<Category> listeCategory = categoryService.getAllCategory();
		map.put("listeCategory", listeCategory);
		return new ModelAndView("addPoll", map);
	}
	

	// ======================
	// publishIdea post
	// ======================

	@RequestMapping(value = "/publishPoll", method = RequestMethod.POST)
	public ModelAndView InscriptionPoll(@ModelAttribute("poll") Poll poll, BindingResult result,
			@RequestParam Map<String, Object> map) {

		
		if(!poll.getImageUp().exists()){
		poll.setPictureIdea("default.jpg");
		}else{
		int lastIndex = ideaService.getAllIdFromIdea().size();
		String extension = Picture.getFileExtension(poll.getImageUp().getName());
		File imageEnregistrer = new File(
				"C:\\Users\\hb\\Documents\\GitHub\\ideanoval\\src\\main\\webapp\\resources\\Images\\" + (lastIndex + 1) + "." + extension);
		try {
			imageEnregistrer.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			Picture.copyFile(poll.getImageUp(), imageEnregistrer);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		poll.setPictureIdea(imageEnregistrer.getName());
		}
		poll.setUserLambda(userLambda);
		
		
		Category category = categoryService.getCategorybyId(Integer.parseInt((String) map.get("category.idCategory")));
		
		poll.setCategory(category);



		if (ideaService.addIdea(poll)) {
			poll = (Poll) ideaService.findIdeaByTitle(poll.getTitleIdea());
			session.setAttribute("idPoll", poll.getIdIdea());
			return new ModelAndView("addOtherPoll", map);
		} else {
			return new ModelAndView("addPoll", map);

		}

	}
	
	// ======================
	// Post publishPerso
	// ======================
	
	@RequestMapping(value = "/publishPerso", method = RequestMethod.POST)
	public ModelAndView accueilPerso(@RequestParam Map<String, Object> map) {
		if(map.get("perso").equals("yes")){
			return accueilPollWithPerso(map);
		}else if(map.get("perso").equals("no")){
			return accueilPollWithoutPerso(map);
		}else{
			return accueilPerso(map);
		}
	}
		// ======================
		// Get pollWithPerso
		// ======================
		@RequestMapping(value = "/pollWithPerso", method = RequestMethod.POST)
		public ModelAndView accueilPollWithPerso(@RequestParam Map<String, Object> map) {
			return new ModelAndView("addPollWithPersonal", map);
		}
	
		// ======================
		// Get pollWithoutPerso
		// ======================
		@RequestMapping(value = "/pollWithoutPerso", method = RequestMethod.POST)
		public ModelAndView accueilPollWithoutPerso(@RequestParam Map<String, Object> map) {
			return new ModelAndView("addPollWithoutPersonal", map);

		}
		
		

		// ======================
		// Post publishOptionPollWithPersonal
		// ======================
		@RequestMapping(value = "/publishOptionPollWithPersonal", method = RequestMethod.POST)
		public ModelAndView publishOptionPollWithPersonal(@RequestParam Map<String, Object> map) {
			List<Poll> polls = new ArrayList<>();
			OptionPoll optionPoll = new OptionPoll();
			optionPoll.setValueOptionPoll("Autre");
			polls.add((Poll) ideaService.findIdeaById( (int) session.getAttribute("idPoll")));
			optionPoll.setPolls(polls);
			optionPollService.addOptionPoll(optionPoll);

			
			for(int i =1; i<5 ;i++){
				if(!map.get("rep"+i).equals("")){
					optionPoll.setValueOptionPoll((String) map.get("rep"+i));
					optionPoll.setPolls(polls);
					optionPollService.addOptionPoll(optionPoll);
				}
			
			}
			return new ModelAndView("addPollOk", map);

		}
		
		

		// ======================
		// Post publishOptionPollWithoutPersonal
		// ======================
		@RequestMapping(value = "/publishOptionPollWithoutPersonal", method = RequestMethod.POST)
		public ModelAndView publishOptionPollWithoutPersonal(@RequestParam Map<String, Object> map) {
			OptionPoll optionPoll = new OptionPoll();
			List<Poll> polls = new ArrayList<>();
			polls.add((Poll) ideaService.findIdeaById( (int)session.getAttribute("idPoll")));

					
			for(int i=1; i<6 ;i++){
				if(!map.get("rep"+i).equals("")){
					optionPoll.setValueOptionPoll((String) map.get("rep"+i));
					optionPoll.setPolls(polls);
					optionPollService.addOptionPoll(optionPoll);
				}
			}
			return new ModelAndView("addPollOk", map);
		}
		

}
