package fr.treeptik.locationvoiture.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.locationvoiture.dao.ReservationDAO;
import fr.treeptik.locationvoiture.exception.DAOException;
import fr.treeptik.locationvoiture.exception.ServiceException;
import fr.treeptik.locationvoiture.model.Reservation;
import fr.treeptik.locationvoiture.services.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationDAO reservationDAO;

	@Override
	@Transactional
	public Reservation save(Reservation reservation) throws ServiceException {
		try {
			reservation = reservationDAO.save(reservation);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
		return reservation;
	}

	@Override
	public Reservation findById(Integer Id) throws ServiceException {
		Reservation reservation = new Reservation();
		try {
			reservation = reservationDAO.findById(Id);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
		return reservation;
	}

	@Override
	@Transactional
	public void remove(Integer id) throws ServiceException {
		try {
			reservationDAO.remove(id);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public List<Reservation> findAll() throws ServiceException {
		try {
			List<Reservation> reservations = new ArrayList<>();
			reservations = reservationDAO.findAll();
			return reservations;
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}

	@Override
	@Transactional
	public Reservation update(Reservation reservation) throws ServiceException {
		try {
			reservation = reservationDAO.update(reservation);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
		return reservation;
	}
}
