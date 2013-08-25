package fr.treeptik.locationvoiture.services;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.treeptik.locationvoiture.exception.ServiceException;
import fr.treeptik.locationvoiture.model.Client;

@Service
public interface ClientService {

	Client save(Client client) throws ServiceException;

	Client findById(Integer Id) throws ServiceException;

	void remove(Integer id) throws ServiceException;

	List<Client> findAll() throws ServiceException;

	Client update(Client client) throws ServiceException;

	boolean hasReservation(Integer id)throws ServiceException;

	List<Client> findAllConcatSort() throws ServiceException;

}
