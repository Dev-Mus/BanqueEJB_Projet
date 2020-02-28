package com.versionbeta.banque.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Entity implementation class for Entity: Operation
 *
 */
@Entity

public class Operation implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long numOperation;
	private Date dateOperation;
	private double montant;

	@ManyToOne
	private Compte compte;

	@ManyToOne
	private Employe employe;
	private int typeOperation;

	public int gettypeOperation() {
		return typeOperation;
	}

	public void settypeOperation(int typeOperation) {
		this.typeOperation = typeOperation;
	}

	private static final long serialVersionUID = 1L;

	public Operation(double montant, Compte compte, Employe employe, int typeOperation) {
		super();
		this.dateOperation = new Date();
		this.typeOperation = typeOperation;
		this.montant = montant;
		this.compte = compte;
		this.employe = employe;
	}

	public Operation(long numOperation, Date dateOperation, double montant, Compte compte, Employe employe, int typeOperation) {
		super();
		this.numOperation = numOperation;
		this.typeOperation = typeOperation;
		this.dateOperation = dateOperation;
		this.montant = montant;
		this.compte = compte;
		this.employe = employe;
	}

	public Operation() {
		super();
	}

	@Override
	public String toString() {
		return "Operation [numOperation=" + numOperation + ", dateOperation=" + dateOperation + ", montant=" + montant
				+ ", compte=" + compte.toString() + ", employe=" + employe.toString() + "]";
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public long getNumOperation() {
		return this.numOperation;
	}

	public void setNumOperation(long numOperation) {
		this.numOperation = numOperation;
	}

	public Date getdateOperation() {
		return this.dateOperation;
	}

	public void setdateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	public double getMontant() {
		return this.montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

}
