package fr.treeptik.locationvoiture.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import fr.treeptik.locationvoiture.model.Voiture;

@Component
public class VoitureValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		
		
		// pour lui dire qu'on va valider des Voiture, au pire return true
		return arg0.getClass().equals(Voiture.class);
	}

	@Override
	public void validate(Object voiture, Errors errors) {
		Voiture v =(Voiture) voiture;
		if(v.getMarque().equalsIgnoreCase(v.getModele())){
			errors.rejectValue("modele", "saisie-voiture.modele.equalsmarque");
		}
	}
	
	

}
