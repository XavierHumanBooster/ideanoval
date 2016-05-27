package com.humanbooster.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.humanbooster.business.Administrator;
import com.humanbooster.business.Category;
import com.humanbooster.business.CommentaryAlert;
import com.humanbooster.business.EvaluableIdea;
import com.humanbooster.business.IdeaAlert;
import com.humanbooster.business.UserLambda;
import com.humanbooster.services.CategoryService;
import com.humanbooster.services.CommentaryAlertService;
import com.humanbooster.services.IdeaAlertService;
import com.humanbooster.services.IdeaService;
import com.humanbooster.services.UserService;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private IdeaAlertService ideaAlertService;
	
	@Autowired
	private CommentaryAlertService commentaryAlertService;
	
	@Autowired
	private IdeaService ideaService;

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
			session.setAttribute("pseudoUser", admin.getPseudoUser());
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
		map.put("attempApprouvedNumber", userService.findAllNotApprouvedUser().size());
		map.put("alertsIdeaNumber", ideaAlertService.findAllIdeaAlert().size());
		map.put("alertsCommentaryNumber", commentaryAlertService.findAllCommentaryAlert().size());
		
		return new ModelAndView("adminPanel", map);
	}
	
	//======================================
	//= Panel Admin Validation Inscription =
	//======================================
	@RequestMapping(value = "/validationInscription", method = RequestMethod.GET)
	public ModelAndView affichageAdminValidationInscription(Map<String, Object> map) {
		List<UserLambda> notApprouved = userService.findAllNotApprouvedUser();
		map.put("attempApprouved", notApprouved);
		map.put("attempApprouvedNumber", notApprouved.size());
		
		return new ModelAndView("adminValidationInscription", map);
	}
		
	@RequestMapping(value= "/validationInscription", method = RequestMethod.POST)
	public ModelAndView buttonValidationInscription(@RequestParam Map<String, Object> map) {
		UserLambda user = userService.findUserById(Integer.parseInt((String) map.get("id")));
		user.setApprouvedUser(true);
		userService.updateUser(user);
		
		return affichageAdminValidationInscription(map);
	}
	
	@RequestMapping(value = "/annulationInscription", method = RequestMethod.POST)
	public ModelAndView buttonAnnulationInscription(@RequestParam Map<String, Object> map) {
		userService.deleteUser(userService.findUserById(Integer.parseInt((String) map.get("id"))));
		
		return affichageAdminValidationInscription(map);
	}
	
	//================================
	//= Panel Admin Gestion Category =
	//================================
	@RequestMapping(value = "/gestionCategory", method = RequestMethod.GET)
	public ModelAndView affichageAdminGestionCategory(Map<String, Object> map) {
		List<Category> categories = categoryService.getAllCategory();
		map.put("categories", categories);
		map.put("categoriesNumber", categories.size());
		map.put("category", new Category());
		
		return new ModelAndView("adminAjoutCategory", map);
	}
	
	@RequestMapping(value = "/gestionCategory", method = RequestMethod.POST)
	public ModelAndView addCategory(@ModelAttribute("category") Category category, Map<String, Object> map) {
		List<Category> categories = categoryService.getAllCategory();
		boolean alreadyExist = false;
		for (Category cat : categories) {
			if (cat.getLabelCategory().equalsIgnoreCase(category.getLabelCategory().trim())) {
				alreadyExist = true;
				break;
			}
		}
		if (alreadyExist) {
			map.put("errorMsg", "La catégorie existe déjà");
		} else {
			categoryService.addCategory(category);
		}	
		return affichageAdminGestionCategory(map);
	}
	
	//==============================
	//= Panel Admin Gestion Alerte =
	//==============================
	@RequestMapping(value = "/gestionAlerte", method = RequestMethod.GET)
	public ModelAndView affichageAdminGestionAlerte(Map<String, Object> map) {
		List<IdeaAlert> alertsIdea = ideaAlertService.findAllIdeaAlert();
		List<CommentaryAlert> alertsCommentary = commentaryAlertService.findAllCommentaryAlert();
		
		map.put("alertsIdea", alertsIdea);
		map.put("alertsIdeaNumber", alertsIdea.size());
		map.put("alertsCommentary", alertsCommentary);
		map.put("alertsCommentaryNumber", alertsCommentary.size());
		
		return new ModelAndView("adminGestionAlerte", map);
	}
	
	@RequestMapping(value = "/gestionAlerte", method = RequestMethod.POST)
	public ModelAndView adminActionAlerte(@RequestParam Map<String, Object> map) {
		String action = new String((String) map.get("actionAndId")).substring(0, 1);
		int id = Integer.parseInt(new String((String) map.get("actionAndId")).substring(1));
		IdeaAlert alert = ideaAlertService.findIdeaAlertByIdIdea(id);
		
			//ACTION 0 --> DISABLE IDEA AND REMOVE IDEAALERT
			if (action.equals("0")) {
				if (ideaAlertService.deleteIdeaAlert(alert)) {
					EvaluableIdea idea = (EvaluableIdea) ideaService.findIdeaById(id);
					idea.setAvailableIdea(false);
					ideaService.updateIdea(idea);
				} else {
					map.put("errorMsg", "Erreur durant l'action de désactivation");
				}
			//ACTION 1 --> REMOVE IDEAALERT ONLY
			} else if (action.equals("1")) {
				if (ideaAlertService.deleteIdeaAlert(alert)) {
					
				} else {
					map.put("errorMsg", "Erreur durant l'action d'ignorance");
				}
			//ACTION 2 --> 	
			} else if (action.equals("2")) {
				
			}
		return affichageAdminGestionAlerte(map);
	}
}
