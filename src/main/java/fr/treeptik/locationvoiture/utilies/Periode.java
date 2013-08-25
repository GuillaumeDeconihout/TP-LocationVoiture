package fr.treeptik.locationvoiture.utilies;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Periode implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	Date dateDebut;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	Date dateFin;
	
	public Periode() {
	}

	public Periode(Date dateDebut, Date dateFin) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	
	
}
