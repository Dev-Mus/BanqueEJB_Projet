package com.versionbeta.banque.entity;

import java.io.Serializable;
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
		private Date dateCreation;
		private static final long serialVersionUID = 1L;
		
		public Compte(double solde, Date dateCreation) {
			super();
			this.solde = solde;
			this.dateCreation = dateCreation;
		}
		public Compte(long numCompte, double solde, Date dateCreation) {
			super();
			this.numCompte = numCompte;
			this.solde = solde;
			this.dateCreation = dateCreation;
		}
		@Override
		public String toString() {
			return "Compte [numCompte=" + numCompte + ", solde=" + solde + ", dateCreation=" + dateCreation + "]";
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
