package fr.treeptik.locationvoiture.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Voiture implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	
	@NotBlank
	@Size(max=32)
	private String marque;
	
	@NotBlank
	@Size(max=32)
	private String modele;
	
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dateMiseEnCirculation;
	
	
	
	public Voiture() {
	}

	public Voiture(Integer id, String marque, String modele,
			Date dateMiseEnCirculation) {
		super();
		Id = id;
		this.marque = marque;
		this.modele = modele;
		this.dateMiseEnCirculation = dateMiseEnCirculation;
	}




	public Integer getId() {
		return Id;
	}


	public void setId(Integer id) {
		Id = id;
	}


	public String getMarque() {
		return marque;
	}


	public void setMarque(String marque) {
		this.marque = marque;
	}


	public String getModele() {
		return modele;
	}


	public void setModele(String modele) {
		this.modele = modele;
	}




	public Date getDateMiseEnCirculation() {
		return dateMiseEnCirculation;
	}




	public void setDateMiseEnCirculation(Date dateMiseEnCirculation) {
		this.dateMiseEnCirculation = dateMiseEnCirculation;
	}
	
	

}
