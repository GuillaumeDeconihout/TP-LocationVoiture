package fr.treeptik.locationvoiture.dao;

import java.util.List;

import fr.treeptik.locationvoiture.exception.DAOException;
import fr.treeptik.locationvoiture.model.Reservation;
import fr.treeptik.locationvoiture.model.Voiture;

public interface VoitureDAO extends GenericDAO<Voiture, Integer> {

	List<Reservation> reservationById(Integer id)throws DAOException;

	List<Voiture> findAllConcatSort() throws DAOException;
	

}
