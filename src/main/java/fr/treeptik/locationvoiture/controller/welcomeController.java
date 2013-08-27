package fr.treeptik.locationvoiture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class welcomeController {

	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public ModelAndView initForm() {
		ModelAndView modelAndView = new ModelAndView("index");
		
		return modelAndView;
	}

	

}
