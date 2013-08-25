package fr.treeptik.locationvoiture.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.locationvoiture.dao.ClientDAO;
import fr.treeptik.locationvoiture.exception.DAOException;
import fr.treeptik.locationvoiture.exception.ServiceException;
import fr.treeptik.locationvoiture.model.Client;
import fr.treeptik.locationvoiture.model.Reservation;
import fr.treeptik.locationvoiture.services.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientDAO clientDAO;

	@Override
	@Transactional
	public Client save(Client client) throws ServiceException {
		try {
			client = clientDAO.save(client);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
		return client;
	}

	@Override
	public Client findById(Integer Id) throws ServiceException {
		Client client = new Client();
		try {
			client = clientDAO.findById(Id);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
		return client;
	}

	@Override
	@Transactional
	public void remove(Integer id) throws ServiceException {
		try {
			clientDAO.remove(id);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public List<Client> findAll() throws ServiceException {
		try {
			List<Client> clients = new ArrayList<>();
			clients = clientDAO.findAll();
			return clients;
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}

	@Override
	@Transactional
	public Client update(Client client) throws ServiceException {
		try {
			client = clientDAO.update(client);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
		return client;
	}

	@Override
	public boolean hasReservation(Integer id) throws ServiceException {
		try {
			List<Reservation> reservations = clientDAO.reservationById(id);
			if (reservations.size() == 0) {
				return (false);
			} else {
				return true;
			}
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}

	@Override
	public List<Client> findAllConcatSort() throws ServiceException {
		try {
			List<Client> clients = new ArrayList<>();
			clients = clientDAO.findAllConcatSort();
			return clients;
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}

}
