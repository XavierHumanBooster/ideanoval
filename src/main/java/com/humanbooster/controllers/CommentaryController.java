package com.humanbooster.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.humanbooster.services.CommentaryService;

@Controller
public class CommentaryController {
	

	@Autowired
	private CommentaryService commentaryService;
	
	
	
	

}
