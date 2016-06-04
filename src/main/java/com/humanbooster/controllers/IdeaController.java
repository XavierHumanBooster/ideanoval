package com.humanbooster.controllers;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
import com.humanbooster.business.EvaluableIdea;
import com.humanbooster.business.OptionPoll;
import com.humanbooster.business.Poll;
import com.humanbooster.business.UserLambda;
import com.humanbooster.services.CategoryService;
import com.humanbooster.services.IdeaService;
import com.humanbooster.services.OptionPollService;
import com.humanbooster.services.UserService;

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
	private OptionPollService optionPollService;
		
	private UserLambda userLambda;
	
	// ======================
	// Post publishChoice
	// ======================
	
	@RequestMapping(value = "/publishChoice", method = RequestMethod.POST)
	public ModelAndView accueilPublish(@RequestParam Map<String, Object> map) {
		if(map.get("choice").equals("idea")){
			return accueilPublishIdea(map);
		}else if(map.get("choice").equals("poll")){
			return accueilPublishPoll(map);
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
		String extension = getFileExtension(evaluableIdea.getImageUp().getName());
		File imageEnregistrer = new File(
				"C:\\Users\\hb\\Documents\\GitHub\\ideanoval\\src\\main\\webapp\\resources\\Images\\" + (lastIndex + 1) + "." + extension);
		try {
			imageEnregistrer.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			copyFile(evaluableIdea.getImageUp(), imageEnregistrer);
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
		String extension = getFileExtension(poll.getImageUp().getName());
		File imageEnregistrer = new File(
				"C:\\Users\\hb\\Documents\\GitHub\\ideanoval\\src\\main\\webapp\\resources\\Images\\" + (lastIndex + 1) + "." + extension);
		try {
			imageEnregistrer.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			copyFile(poll.getImageUp(), imageEnregistrer);
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
		
	
	public static String getFileExtension(String NomFichier) {
		File tmpFichier = new File(NomFichier);
		tmpFichier.getName();
		int posPoint = tmpFichier.getName().lastIndexOf('.');
		if (0 < posPoint && posPoint <= tmpFichier.getName().length() - 2) {
			return tmpFichier.getName().substring(posPoint + 1);
		}
		return "";
	}

	public void copyFile(File src, File dest) throws IOException {
		InputStream in = new BufferedInputStream(new FileInputStream(src));
		OutputStream out = new BufferedOutputStream(new FileOutputStream(dest));
		byte[] buf = new byte[4096];
		int n;
		while ((n = in.read(buf, 0, buf.length)) > 0)
			out.write(buf, 0, n);

		in.close();
		out.close();
	}
}
