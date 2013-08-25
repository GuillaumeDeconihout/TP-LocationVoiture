package fr.treeptik.locationvoiture.dao;

import java.util.List;

import fr.treeptik.locationvoiture.exception.DAOException;
import fr.treeptik.locationvoiture.model.Client;
import fr.treeptik.locationvoiture.model.Reservation;

public interface ClientDAO extends GenericDAO<Client, Integer> {

	List<Reservation> reservationById(Integer id) throws DAOException;

	List<Client> findAllConcatSort() throws DAOException;
	

}
