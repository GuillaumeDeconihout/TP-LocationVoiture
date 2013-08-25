package fr.treeptik.locationvoiture.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import fr.treeptik.locationvoiture.model.Reservation;

@Component
public class ReservationValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return arg0.getClass().equals(Reservation.class);
	}

	@Override
	public void validate(Object reservation, Errors errors) {
		Reservation r = (Reservation) reservation;
		if (r.getDateReservation().after(r.getDatePriseVehicule())) {
			errors.rejectValue("datePriseVehicule", "saisie-reservation.dateprisevehicule.inferieuredatereservation");
		} else {
			if (r.getDateRetourVehicule().before(r.getDatePriseVehicule())) {
				errors.rejectValue("dateRetourVehicule", "saisie-reservation.dateretourvehicule.inferieuredateprisevehicule");
			}
		}
	}
}
