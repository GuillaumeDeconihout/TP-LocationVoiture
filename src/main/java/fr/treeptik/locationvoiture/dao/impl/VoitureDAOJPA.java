package fr.treeptik.locationvoiture.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import fr.treeptik.locationvoiture.dao.VoitureDAO;
import fr.treeptik.locationvoiture.exception.DAOException;
import fr.treeptik.locationvoiture.model.Reservation;
import fr.treeptik.locationvoiture.model.Voiture;

@Repository
public class VoitureDAOJPA extends GenericDAOJPA<Voiture, Integer> implements VoitureDAO {
	
	public VoitureDAOJPA() {
		super(Voiture.class);
	}

	@Override
	public List<Reservation> reservationById(Integer id) throws DAOException {
		TypedQuery<Reservation> query = entitymanager.createQuery("select res from Reservation res where res.voiture.id=:id",Reservation.class);
		query.setParameter("id", id);
		return query.getResultList();
	}

	@Override
	public List<Voiture> findAllConcatSort() throws DAOException {
		List<Voiture> voitures = new ArrayList<>(10);
		TypedQuery<Voiture> query = entitymanager.createQuery("select voi from Voiture voi order by voi.marque,voi.modele",Voiture.class);
		voitures = query.getResultList();
		return voitures;
	}

}
