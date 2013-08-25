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
import fr.treeptik.locationvoiture.model.Client;
import fr.treeptik.locationvoiture.services.ClientService;

@Controller
@RequestMapping(value = "Client")
public class ClientController {

	@Autowired
	private ClientService clientService;

	@RequestMapping(value = "/client.do", method = RequestMethod.GET)
	public ModelAndView initForm() {
		Client client = new Client();
		ModelAndView modelAndView = new ModelAndView("Client/saisie-client", "client",
				client);
		return modelAndView;
	}

	@RequestMapping(value = "/client.do", method = RequestMethod.POST)
	public ModelAndView SaveClient(@Valid Client client, BindingResult errors)
			throws ServiceException {

		if (errors.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("Client/saisie-client",
					"client", client);
			return modelAndView;
		}
		client = clientService.save(client);
		return new ModelAndView("redirect:listerclient.do");
	}

	@RequestMapping(value = "/modifierclient.do", method = RequestMethod.GET)
	public ModelAndView modifierClient(@RequestParam("id") Integer id)
			throws ServiceException {
		Client client = clientService.findById(id);
		ModelAndView modelAndView = new ModelAndView("Client/modification-client",
				"client", client);
		return modelAndView;
	}

	@RequestMapping(value = "/modifierclient.do", method = RequestMethod.POST)
	public ModelAndView updateClient(@Valid Client client, BindingResult errors)
			throws ServiceException {
		if (errors.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("Client/modification-client",
					"client", client);
			return modelAndView;
		}
		client = clientService.update(client);
		return new ModelAndView("redirect:listerclient.do");
	}

	@RequestMapping(value = "/supprimerclient.do", method = RequestMethod.GET)
	public ModelAndView deleteClient(@RequestParam("id") Integer id)
			throws ServiceException {
		if (!clientService.hasReservation(id)) {
			clientService.remove(id);
		} 
			
			return new ModelAndView("redirect:listerclient.do");
	}

	@RequestMapping(value = {"/index.do","/listerclient.do"}, method = RequestMethod.GET)
	public ModelAndView listerClient() throws ServiceException {
		List<Client> clients = clientService.findAll();
		ModelAndView modelAndView = new ModelAndView("Client/list-client", "clients",
				clients);
		return modelAndView;
	}

}
