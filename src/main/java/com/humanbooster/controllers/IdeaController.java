package com.humanbooster.controllers;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
	public String Inscription(@ModelAttribute("evaluableIdea") EvaluableIdea evaluableIdea, BindingResult result,
			Map<String, Object> map) {

		System.out.println(evaluableIdea.toString());
		
		if(!evaluableIdea.getImageUp().exists()){
		evaluableIdea.setPictureIdea("default.jpg");
		}else{
		int lastIndex = ideaService.getAllIdFromIdea().size();
		String extension = getFileExtension(evaluableIdea.getImageUp().getName());
		File imageEnregistrer = new File(
				"C:\\Users\\hb\\Documents\\GitHub\\ideanoval\\image\\" + (lastIndex + 1) + "." + extension);
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

		if (ideaService.addIdea(evaluableIdea)) {
			return "ideaOk";
		} else {
			return "idea";
		}

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
