package fr.treeptik.locationvoiture.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.locationvoiture.dao.VoitureDAO;
import fr.treeptik.locationvoiture.exception.DAOException;
import fr.treeptik.locationvoiture.exception.ServiceException;
import fr.treeptik.locationvoiture.model.Client;
import fr.treeptik.locationvoiture.model.Reservation;
import fr.treeptik.locationvoiture.model.Voiture;
import fr.treeptik.locationvoiture.services.VoitureService;

@Service
public class VoitureServiceImpl implements VoitureService {

	@Autowired
	private VoitureDAO voitureDAO;

	@Override
	@Transactional
	public Voiture save(Voiture voiture) throws ServiceException {
		try {
			voiture = voitureDAO.save(voiture);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
		return voiture;
	}

	@Override
	public Voiture findById(Integer Id) throws ServiceException {
		Voiture voiture = new Voiture();
		try {
			voiture = voitureDAO.findById(Id);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
		return voiture;
	}

	@Override
	@Transactional
	public void remove(Integer id) throws ServiceException {
		try {
			voitureDAO.remove(id);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public List<Voiture> findAll() throws ServiceException {
		try {
			List<Voiture> voitures = new ArrayList<>();
			voitures = voitureDAO.findAll();
			return voitures;
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}

	@Override
	@Transactional
	public Voiture update(Voiture voiture) throws ServiceException {
		try {
			voiture = voitureDAO.update(voiture);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
		return voiture;
	}

	@Override
	public boolean hasReservation(Integer id) throws ServiceException {
		try {
			List<Reservation> reservations  = voitureDAO.reservationById(id);
			if (reservations.size()==0){
			return(false);
			}
			else{
				return true;
			}
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public List<Voiture> findAllConcatSort() throws ServiceException {
		try {
			List<Voiture> voitures = new ArrayList<>();
			voitures = voitureDAO.findAllConcatSort();
			return voitures;
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}
}
