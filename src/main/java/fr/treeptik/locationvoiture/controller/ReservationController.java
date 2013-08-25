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
import fr.treeptik.locationvoiture.model.Reservation;
import fr.treeptik.locationvoiture.model.Voiture;
import fr.treeptik.locationvoiture.services.ClientService;
import fr.treeptik.locationvoiture.services.ReservationService;
import fr.treeptik.locationvoiture.services.VoitureService;
import fr.treeptik.locationvoiture.utilies.Periode;
import fr.treeptik.locationvoiture.validator.ReservationValidator;

@Controller
@RequestMapping(value = "Reservation")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;

	@Autowired
	private ClientService clientService;

	@Autowired
	private VoitureService voitureService;

	@Autowired
	private ReservationValidator validator;

	@RequestMapping(value = "/reservation.do", method = RequestMethod.GET)
	public ModelAndView initForm(Reservation reservation)
			throws ServiceException {
		List<Client> listClients = clientService.findAllConcatSort();
		List<Voiture> listVoitures = voitureService.findAllConcatSort();

		ModelAndView modelAndView = new ModelAndView(
				"Reservation/saisie-reservation", "reservation", reservation);

		modelAndView.addObject("clients", listClients);
		modelAndView.addObject("voitures", listVoitures);

		return modelAndView;
	}

	@RequestMapping(value = "/reservation.do", method = RequestMethod.POST)
	public ModelAndView SaveReservation(@Valid Reservation reservation,
			BindingResult errors) throws ServiceException {

		if (errors.hasErrors()) {
			return initForm(reservation);
		} else {
			validator.validate(reservation, errors);
			if (errors.hasErrors()) {
				return initForm(reservation);
			}
		}

		reservation = reservationService.save(reservation);
		return new ModelAndView("redirect:listerreservation.do");
	}

	@RequestMapping(value = "/modifierreservation.do", method = RequestMethod.GET)
	public ModelAndView modifierReservation(@RequestParam("id") Integer id)
			throws ServiceException {
		Reservation reservation = reservationService.findById(id);
		ModelAndView modelAndView = new ModelAndView(
				"Reservation/modification-reservation", "reservation",
				reservation);

		List<Client> listClients = clientService.findAllConcatSort();
		List<Voiture> listVoitures = voitureService.findAllConcatSort();

		modelAndView.addObject("clients", listClients);
		modelAndView.addObject("voitures", listVoitures);

		return modelAndView;
	}

	@RequestMapping(value = "/modifierreservation.do", method = RequestMethod.POST)
	public ModelAndView updateReservation(@Valid Reservation reservation,
			BindingResult errors) throws ServiceException {

		if (errors.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView(
					"Reservation/modification-reservation", "reservation",
					reservation);

			List<Client> listClients = clientService.findAllConcatSort();
			List<Voiture> listVoitures = voitureService.findAll();

			modelAndView.addObject("clients", listClients);
			modelAndView.addObject("voitures", listVoitures);

			return modelAndView;
		} else {
			validator.validate(reservation, errors);
			if (errors.hasErrors()) {
				ModelAndView modelAndView = new ModelAndView(
						"Reservation/modification-reservation", "reservation",
						reservation);

				List<Client> listClients = clientService.findAll();
				List<Voiture> listVoitures = voitureService.findAll();

				modelAndView.addObject("clients", listClients);
				modelAndView.addObject("voitures", listVoitures);

				return modelAndView;
			}
		}

		reservation = reservationService.update(reservation);
		return new ModelAndView("redirect:listerreservation.do");
	}

	@RequestMapping(value = "/supprimerreservation.do", method = RequestMethod.GET)
	public String deleteReservation(@RequestParam("id") Integer id)
			throws ServiceException {
		reservationService.remove(id);
		return "redirect:listerreservation.do";
	}

	@RequestMapping(value = { "/index.do", "/listerreservation.do" }, method = RequestMethod.GET)
	public ModelAndView listerReservation() throws ServiceException {
		List<Reservation> reservations = reservationService.findAll();
		ModelAndView modelAndView = new ModelAndView(
				"Reservation/list-reservation", "reservations", reservations);
		return modelAndView;
	}

	@RequestMapping(value = "/recherche-vehicules-dispo.do", method = RequestMethod.GET)
	public ModelAndView searchAvailablesCars() throws ServiceException {
		Periode periode = new Periode();
		ModelAndView modelAndView = new ModelAndView(
				"Reservation/recherche-vehicule-dispo","periode",periode);
		return modelAndView;
	}
	
	@RequestMapping(value = "/recherche-vehicules-dispo.do", method = RequestMethod.POST)
	public ModelAndView DisplayAvailablesCars(Periode periode) throws ServiceException {
		List<Voiture> voitures = voitureService.findAllAvailableByPeriod(periode.getDateDebut(),periode.getDateFin());
		ModelAndView modelAndView = new ModelAndView(
				"Reservation/list-vehicule-dispo","voitures",voitures);
		return modelAndView;
	}

}
