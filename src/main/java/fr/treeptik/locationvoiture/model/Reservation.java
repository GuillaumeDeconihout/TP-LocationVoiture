package fr.treeptik.locationvoiture.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Reservation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	
	
	@JoinColumn(name="voitureId")
	@ManyToOne
	private Voiture voiture;
	
	@JoinColumn(name="clientId")
	@ManyToOne()
	private Client client;
	
	@NotNull
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dateReservation;
	
	@NotNull
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date datePriseVehicule;
	
	@NotNull
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dateRetourVehicule;
	
	public Reservation() {
	}

	public Reservation(Integer id, Voiture voiture, Client client,
			Date dateReservation, Date datePriseVehicule,
			Date dateRetourVehicule) {
		super();
		Id = id;
		this.voiture = voiture;
		this.client = client;
		this.dateReservation = dateReservation;
		this.datePriseVehicule = datePriseVehicule;
		this.dateRetourVehicule = dateRetourVehicule;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Voiture getVoiture() {
		return voiture;
	}

	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Date getDateReservation() {
		return dateReservation;
	}

	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}

	public Date getDatePriseVehicule() {
		return datePriseVehicule;
	}

	public void setDatePriseVehicule(Date datePriseVehicule) {
		this.datePriseVehicule = datePriseVehicule;
	}

	public Date getDateRetourVehicule() {
		return dateRetourVehicule;
	}

	public void setDateRetourVehicule(Date dateRetourVehicule) {
		this.dateRetourVehicule = dateRetourVehicule;
	}

	@Override
	public String toString() {
		return "Reservation [Id=" + Id + ", voiture=" + voiture + ", client="
				+ client + ", dateReservation=" + dateReservation
				+ ", datePriseVehicule=" + datePriseVehicule
				+ ", dateRetourVehicule=" + dateRetourVehicule + "]";
	}
	
}
