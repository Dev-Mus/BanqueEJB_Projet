package com.versionbeta.banque.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Compte 
 * autor : Ouali Mustapha
 */
@Entity
public class Compte implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long numCompte;

	private double solde;

	@ManyToOne
	private Client client;

	@ManyToOne
	private Employe employe;
	
	private Date dateCreation;

	private static final long serialVersionUID = 1L;

	public Compte(double solde) {
		super();
		this.solde = solde;		
		this.dateCreation = new Date();
	}
	
	public Compte(double solde, Date dateCreation) {
		super();
		this.solde = solde;
		this.dateCreation = dateCreation;
	}
	
	public Compte(double solde, Client client, Employe employe) {
		super();
		this.solde = solde;
		this.client = client;
		this.employe = employe;
		this.dateCreation = new Date();
	}

	public Compte(double solde, Client client, Employe employe, Date dateCreation) {
		super();
		this.solde = solde;
		this.client = client;
		this.employe = employe;
		this.dateCreation = dateCreation;
	}

	@Override
	public String toString() {
		return "Compte [numCompte=" + numCompte + ", solde=" + solde + ", dateCreation=" + dateCreation + "]";
	}
	
	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}


	public Compte() {
		super();
	}

	public long getNumCompte() {
		return this.numCompte;
	}

	public void setNumCompte(long numCompte) {
		this.numCompte = numCompte;
	}

	public double getSolde() {
		return this.solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Date getDateCreation() {
		return this.dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
}
