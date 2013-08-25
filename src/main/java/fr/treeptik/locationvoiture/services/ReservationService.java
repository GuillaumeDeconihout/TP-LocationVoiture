package fr.treeptik.locationvoiture.services;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.treeptik.locationvoiture.exception.ServiceException;
import fr.treeptik.locationvoiture.model.Reservation;

@Service
public interface ReservationService {

	Reservation save(Reservation reservation) throws ServiceException;

	Reservation findById(Integer Id) throws ServiceException;

	void remove(Integer id) throws ServiceException;

	List<Reservation> findAll() throws ServiceException;

	Reservation update(Reservation reservation) throws ServiceException;

}
