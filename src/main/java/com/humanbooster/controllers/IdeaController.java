package com.humanbooster.controllers;

import java.io.File;
import java.io.IOException;
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
import com.humanbooster.business.Commentary;
import com.humanbooster.business.CommentaryAlert;
import com.humanbooster.business.EvaluableIdea;
import com.humanbooster.business.Idea;
import com.humanbooster.business.IdeaAlert;
import com.humanbooster.business.UserLambda;
import com.humanbooster.services.CategoryService;
import com.humanbooster.services.CommentaryAlertService;
import com.humanbooster.services.CommentaryService;
import com.humanbooster.services.IdeaAlertService;
import com.humanbooster.services.IdeaService;
import com.humanbooster.services.UserService;
import com.humanbooster.utils.Picture;

@Controller
public class IdeaController {

	@Autowired
	private HttpSession session;

	@Autowired
	private IdeaService ideaService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private PollController pollController;
	
	@Autowired
	private CommentaryService commentaryService;
	
	@Autowired
	private IdeaAlertService ideaAlertService;
	
	@Autowired
	private CommentaryAlertService commentaryAlertService;
	
	private UserLambda userLambda;
	

	
	// ======================
	// Post publishChoice
	// ======================
	
	@RequestMapping(value = "/publishChoice", method = RequestMethod.POST)
	public ModelAndView accueilPublish(@RequestParam Map<String, Object> map) {
		if(map.get("choice").equals("idea")){
			return accueilPublishIdea(map);
		}else if(map.get("choice").equals("poll")){
			return pollController.accueilPublishPoll(map);
		}else{
			return accueilPublish(map);
		}
		
	}

	// ======================
	// Getter publishIdea
	// ======================

	@RequestMapping(value = "/publishIdea", method = RequestMethod.GET)
	public ModelAndView accueilPublishIdea(@RequestParam Map<String, Object> map) {
		map.put("evaluableIdea", new EvaluableIdea());
		userLambda = (UserLambda) userService.findUserById((int) session.getAttribute("idUser"));
		List<Category> listeCategory = categoryService.getAllCategory();
		map.put("listeCategory", listeCategory);
		return new ModelAndView("addIdea", map);
	}
	
	// ======================
	// publishIdea post
	// ======================

	@RequestMapping(value = "/publishIdea", method = RequestMethod.POST)
	public String InscriptionIdea(@ModelAttribute("evaluableIdea") EvaluableIdea evaluableIdea, BindingResult result,
			@RequestParam Map<String, Object> map) {

		System.out.println(evaluableIdea.toString());
		
		if(!evaluableIdea.getImageUp().exists()){
		evaluableIdea.setPictureIdea("default.jpg");
		}else{
		int lastIndex = ideaService.getAllIdFromIdea().size();
		String extension = Picture.getFileExtension(evaluableIdea.getImageUp().getName());
		File imageEnregistrer = new File(
				"C:\\Users\\hb\\Documents\\GitHub\\ideanoval\\src\\main\\webapp\\resources\\Images\\" + (lastIndex + 1) + "." + extension);
		try {
			imageEnregistrer.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			Picture.copyFile(evaluableIdea.getImageUp(), imageEnregistrer);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		evaluableIdea.setPictureIdea(imageEnregistrer.getName());
		}
		
		evaluableIdea.setUserLambda(userLambda);
		
		
		Category category = categoryService.getCategorybyId(Integer.parseInt((String) map.get("category.idCategory")));
		
		evaluableIdea.setCategory(category);



		if (ideaService.addIdea(evaluableIdea)) {
			return "ideaOk";
		} else {
			return "addIdea";
		}

	}
	
	// ======================
	// affichageIdea Get
	// ======================

	@RequestMapping(value = "/affichageIdea", method = RequestMethod.GET)
	public ModelAndView affichageIdea(@RequestParam Map<String, Object> map) {
		Commentary newCommentary = new Commentary();
		Idea idea = ideaService.findIdeaById(Integer.parseInt((String) map.get("id")));
		List<Commentary> listeCommentary = commentaryService.getCommentarysByIdIdea(idea.getIdIdea());
		map.put("listeCommentary", listeCommentary);
		map.put("idea", idea);
		map.put("newCommentary", newCommentary);
		return new ModelAndView("viewIdea", map);
	}
	
	@RequestMapping(value="/affichageIdea", method = RequestMethod.POST)
	public ModelAndView ajoutCommentaire(@ModelAttribute("newCommentary") Commentary commentary, BindingResult result,
			@RequestParam Map<String, Object> map) {
		commentary.setUser(userService.findUserById((int) session.getAttribute("idUser")));
		commentary.setEvaluableIdea(ideaService.findEvaluableIdeaByID(Integer.parseInt((String) map.get("id")))); 
		
		commentaryService.addCommentary(commentary);
			
		return affichageIdea(map);
	}
	
	@RequestMapping(value="/affichageIdea/alertIdea", method = RequestMethod.GET)
	public ModelAndView alertIdea(@RequestParam Map<String, Object> map) {
			EvaluableIdea evaluableIdea = ideaService.findEvaluableIdeaByID(Integer.parseInt((String) map.get("idea")));
			UserLambda userLambda = userService.findUserById(Integer.parseInt((String) map.get("user")));
			
			IdeaAlert ideaAlert = new IdeaAlert(evaluableIdea, userLambda);
			ideaAlertService.addIdeaAlert(ideaAlert);
			
		
		map.put("id", String.valueOf(evaluableIdea.getIdIdea()));
		return affichageIdea(map);
	}
	
	@RequestMapping(value="/affichageIdea/alertCommentary", method = RequestMethod.GET)
	public ModelAndView alertCommentary(@RequestParam Map<String, Object> map) {
			Commentary commentary = commentaryService.findCommentaryById(Integer.parseInt((String) map.get("commentary")));
			UserLambda userLambda = userService.findUserById(Integer.parseInt((String) map.get("user")));
			
			CommentaryAlert commentaryAlert = new CommentaryAlert(commentary, userLambda);
			commentaryAlertService.addCommentaryAlert(commentaryAlert);
			
			map.put("id", String.valueOf(commentary.getEvaluableIdea().getIdIdea()));		
		return affichageIdea(map);
	}

}
