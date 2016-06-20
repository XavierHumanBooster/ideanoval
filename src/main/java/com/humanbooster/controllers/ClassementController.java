package com.humanbooster.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.humanbooster.business.Commentary;
import com.humanbooster.business.Idea;
import com.humanbooster.business.Mark;
import com.humanbooster.services.CommentaryService;
import com.humanbooster.services.IdeaService;
import com.humanbooster.services.MarkService;
import com.humanbooster.services.UserService;
import com.humanbooster.utils.ValueComparator;

@Controller
@RequestMapping(value = "/classement")
public class ClassementController {

	@SuppressWarnings("unused")
	@Autowired
	private HttpSession session;

	@Autowired
	private IdeaService ideaService;

	@SuppressWarnings("unused")
	@Autowired
	private UserService userService;

	@Autowired
	private MarkService markService;

	@Autowired
	private CommentaryService commentaryService;

	public ClassementController() {
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView initClassementAndShowIt(Map<String, Object> map) {

		// on recupere toutes les votes faites sur le site
		List<Mark> listMark = markService.getAllMark();

		// on fait la somme top, flop pour chaque idée
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for (Mark mark : listMark) {
			if (hashMap.containsKey(mark.getEvaluableIdea().getIdIdea())) {
				int valur = hashMap.get(mark.getEvaluableIdea().getIdIdea()) + mark.getValueMark();
				hashMap.replace(mark.getEvaluableIdea().getIdIdea(), hashMap.get(mark.getEvaluableIdea().getIdIdea()),
						valur);
			} else {
				if(mark.getEvaluableIdea().isAvailableIdea()){
					hashMap.put(mark.getEvaluableIdea().getIdIdea(), mark.getValueMark());
				}
			}
		}

		// on crée un objet ValueComparator qui va permettre de triée la hashMap
		// par valeur du plus grande au plus petit
		ValueComparator comparateur = new ValueComparator(hashMap);

		// on recupere la hashMap triée avec un TreeMap
		TreeMap<Integer, Integer> mapTriee = new TreeMap<Integer, Integer>(comparateur);
		System.out.println("map non-triée: " + hashMap); // La commande suivante
															// affichera map
															// non-triée:
															// {A=99.5, B=67.4,
															// C=65.2}.
		mapTriee.putAll(hashMap);
		System.out.println("resultat du tri: " + mapTriee); // La commande
															// suivante
															// affichera
															// résultat:
															// {C=65.2, B=67.4,
															// A=99.5}.

		// on recupere que les 10 premières idIdea
		Iterator<Integer> it = mapTriee.keySet().iterator();
		int limite = 0;
		List<Idea> listTenBestIdea = new ArrayList<>();
		while (it.hasNext() && limite != 4) {
			System.out.println(it.next());
			// listTenBestIdea.add(ideaService.findIdeaById(it.next()));
			limite++;
		}
		// ------------------------------------------------------------------------------------------------------------------//

		List<Idea> listIdea = ideaService.getAllIdea();

		HashMap<Integer, Integer> hashMapIdea = new HashMap<>();
		for (Idea idea : listIdea) {
			if (hashMapIdea.containsKey(idea.getUserLambda().getIdUser())) {
				int valur = hashMapIdea.get(idea.getUserLambda().getIdUser()) + 1;
				hashMapIdea.replace(idea.getUserLambda().getIdUser(), hashMapIdea.get(idea.getUserLambda().getIdUser()),
						valur);
			} else {
				hashMapIdea.put(idea.getUserLambda().getIdUser(), 0);
			}
		}

		ValueComparator comparateurIdea = new ValueComparator(hashMapIdea);

		TreeMap<Integer, Integer> mapTrieeIdea = new TreeMap<Integer, Integer>(comparateurIdea);

		mapTrieeIdea.putAll(hashMapIdea);

		Iterator<Integer> itIdea = mapTrieeIdea.keySet().iterator();
		limite = 0;
		List<Idea> listTenBestUser = new ArrayList<>();
		while (itIdea.hasNext() && limite != 4) {
			System.out.println(itIdea.next());
			// listTenBestUser.add(ideaService.findIdeaById(it.next()));
			limite++;
		}
		// ------------------------------------------------------------------------------------------------------------------//

		List<Commentary> listCommentarie = commentaryService.getAllCommentary();

		HashMap<Integer, Integer> hashMapCommentary = new HashMap<>();
		for (Commentary commentary : listCommentarie) {
			if (hashMapCommentary.containsKey(commentary.getEvaluableIdea().getIdIdea())) {
				int valur = hashMapCommentary.get(commentary.getEvaluableIdea().getIdIdea()) + 1;
				hashMapCommentary.replace(commentary.getEvaluableIdea().getIdIdea(),
						hashMapCommentary.get(commentary.getEvaluableIdea().getIdIdea()), valur);
			} else {
				if(commentary.getEvaluableIdea().isAvailableIdea()){
					hashMapCommentary.put(commentary.getEvaluableIdea().getIdIdea(), 0);
				}
			}
		}

		ValueComparator comparateurCommentary = new ValueComparator(hashMapCommentary);

		TreeMap<Integer, Integer> mapTrieeCommentary = new TreeMap<Integer, Integer>(comparateurCommentary);

		mapTrieeCommentary.putAll(hashMapCommentary);

		Iterator<Integer> itCommentary = mapTrieeCommentary.keySet().iterator();
		limite = 0;
		List<Idea> listTenMostCommented = new ArrayList<>();
		while (itCommentary.hasNext() && limite != 4) {
			System.out.println(itCommentary.next());
			// listTenMostCommented.add(ideaService.findIdeaById(itCommentary.next()));
			limite++;
		}
		
		return null;
	}

}
