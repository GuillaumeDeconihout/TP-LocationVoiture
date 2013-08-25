package fr.treeptik.locationvoiture.dao;

import java.util.List;

import fr.treeptik.locationvoiture.exception.DAOException;
import fr.treeptik.locationvoiture.model.Reservation;


public interface ReservationDAO extends GenericDAO<Reservation, Integer> {

	List<Reservation> findByVoitureId(Integer id)throws DAOException;
	

}
