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
import com.humanbooster.business.EvaluableIdea;
import com.humanbooster.business.UserLambda;
import com.humanbooster.services.CategoryService;
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

}
