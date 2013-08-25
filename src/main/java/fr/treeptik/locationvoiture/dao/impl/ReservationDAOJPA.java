package fr.treeptik.locationvoiture.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import fr.treeptik.locationvoiture.dao.ReservationDAO;
import fr.treeptik.locationvoiture.exception.DAOException;
import fr.treeptik.locationvoiture.model.Reservation;

@Repository
public class ReservationDAOJPA extends GenericDAOJPA<Reservation, Integer>
		implements ReservationDAO {

	public ReservationDAOJPA() {
		super(Reservation.class);
	}

	@Override
	public List<Reservation> findByVoitureId(Integer id) throws DAOException {
			List<Reservation> reservations = new ArrayList<>(10);
			TypedQuery<Reservation> typedQuery = entitymanager.createQuery("select res from Reservation res where res.voiture.id=:id",Reservation.class);
			typedQuery.setParameter("id", id);
			reservations = typedQuery.getResultList();
			return reservations;
	}

}
