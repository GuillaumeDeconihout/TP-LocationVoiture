package fr.treeptik.locationvoiture.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import fr.treeptik.locationvoiture.dao.ClientDAO;
import fr.treeptik.locationvoiture.exception.DAOException;
import fr.treeptik.locationvoiture.model.Client;
import fr.treeptik.locationvoiture.model.Reservation;

@Repository
public class ClientDAOJPA extends GenericDAOJPA<Client, Integer> implements ClientDAO {
	
	public ClientDAOJPA() {
		super(Client.class);
	}

	@Override
	public List<Reservation> reservationById(Integer id) throws DAOException {
		TypedQuery<Reservation> query = entitymanager.createQuery("select res from Reservation res where res.client.id=:id",Reservation.class);
		query.setParameter("id", id);
		return query.getResultList();
	}

	@Override
	public List<Client> findAllConcatSort() throws DAOException {
		List<Client> clients = new ArrayList<>(10);
		TypedQuery<Client> query = entitymanager.createQuery("select cli from Client cli order by cli.nom,cli.prenom",Client.class);
		clients = query.getResultList();
		return clients;
	}

}
