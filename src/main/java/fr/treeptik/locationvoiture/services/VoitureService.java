package fr.treeptik.locationvoiture.services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.treeptik.locationvoiture.exception.ServiceException;
import fr.treeptik.locationvoiture.model.Voiture;

@Service
public interface VoitureService {

	Voiture save(Voiture voiture) throws ServiceException;

	Voiture findById(Integer Id) throws ServiceException;

	void remove(Integer id) throws ServiceException;

	List<Voiture> findAll() throws ServiceException;

	Voiture update(Voiture voiture) throws ServiceException;

	boolean hasReservation(Integer id) throws ServiceException;

	List<Voiture> findAllConcatSort() throws ServiceException;
	
	List<Voiture> findAllAvailableByPeriod(Date datePrise, Date dateRetour) throws ServiceException;

}
