package fr.treeptik.locationvoiture.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.treeptik.locationvoiture.exception.ServiceException;
import fr.treeptik.locationvoiture.model.Voiture;
import fr.treeptik.locationvoiture.services.VoitureService;
import fr.treeptik.locationvoiture.validator.VoitureValidator;

@Controller
@RequestMapping(value = "Voiture")
public class VoitureController {

	@Autowired
	private VoitureService voitureService;
	
	@Autowired
	private VoitureValidator validator;


	@RequestMapping(value = "/voiture.do", method = RequestMethod.GET)
	public ModelAndView initForm() {
		Voiture voiture = new Voiture();
		ModelAndView modelAndView = new ModelAndView("Voiture/saisie-voiture",
				"voiture", voiture);
		return modelAndView;
	}

	@RequestMapping(value = "/voiture.do", method = RequestMethod.POST)
	public ModelAndView SaveVoiture(@Valid Voiture voiture, BindingResult errors) throws ServiceException {
		
		validator.validate(voiture, errors);
		
		if(errors.hasErrors()){
			ModelAndView modelAndView = new ModelAndView("Voiture/saisie-voiture",
					"voiture", voiture);
			return modelAndView;
		}
		voiture = voitureService.save(voiture);
		return new ModelAndView("redirect:listervoiture.do");
	}

	@RequestMapping(value = "/modifiervoiture.do", method = RequestMethod.GET)
	public ModelAndView modifierVoiture(@RequestParam("id") Integer id)
			throws ServiceException {
		Voiture voiture = voitureService.findById(id);
		ModelAndView modelAndView = new ModelAndView("Voiture/modification-voiture",
				"voiture", voiture);
		return modelAndView;
	}

	@RequestMapping(value = "/modifiervoiture.do", method = RequestMethod.POST)
	public ModelAndView updateVoiture(@Valid Voiture voiture, BindingResult errors) throws ServiceException {
		
		validator.validate(voiture, errors);
		
		if(errors.hasErrors()){
			ModelAndView modelAndView = new ModelAndView("Voiture/modification-voiture",
					"voiture", voiture);
			return modelAndView;
		}
		voiture = voitureService.update(voiture);
		return new ModelAndView("redirect:listervoiture.do");
	}

	@RequestMapping(value = "/supprimervoiture.do", method = RequestMethod.GET)
	public ModelAndView deleteVoiture(@RequestParam("id") Integer id)
			throws ServiceException {
		if (!voitureService.hasReservation(id)) {
			voitureService.remove(id);
		} 
			
			return new ModelAndView("redirect:listervoiture.do");
	}

	@RequestMapping(value = {"/index.do","/listervoiture.do"}, method = RequestMethod.GET)
	public ModelAndView listerVoiture() throws ServiceException {
		List<Voiture> voitures = voitureService.findAll();
		ModelAndView modelAndView = new ModelAndView("Voiture/list-voiture",
				"voitures", voitures);
		return modelAndView;
	}

}
