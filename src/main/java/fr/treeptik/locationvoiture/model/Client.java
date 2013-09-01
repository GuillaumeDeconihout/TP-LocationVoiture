package fr.treeptik.locationvoiture.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Client implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	
	
	@NotBlank
	@Size(max=64)
	private String nom;
	
	@NotBlank
	@Size(max=64)
	private String prenom;
	
	@NotEmpty
	@Size(max=128)
	@Email
	private String email;
	
	public Client() {
	}

	public Client(Integer id, String nom, String prenom, String email) {
		super();
		Id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Client [Id=" + Id + ", nom=" + nom + ", prenom=" + prenom
				+ ", email=" + email + "]";
	}
	
	
}
