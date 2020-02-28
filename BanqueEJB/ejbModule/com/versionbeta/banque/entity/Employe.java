package com.versionbeta.banque.entity;

import java.io.Serializable;
import java.lang.String;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Employe
 *
 */
@Entity

public class Employe implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long numEmploye;
	private String nomEmploye;
	private static final long serialVersionUID = 1L;

	public Employe(String nomEmploye) {
		super();
		this.nomEmploye = nomEmploye;
	}

	public Employe(long numEmploye, String nomEmploye) {
		super();
		this.numEmploye = numEmploye;
		this.nomEmploye = nomEmploye;
	}

	public Employe() {
		super();
	}   

	@Override
	public String toString() {
		return "Employe [numEmploye=" + numEmploye + ", nomEmploye=" + nomEmploye + "]";
	}

	public long getNumEmploye() {
		return this.numEmploye;
	}

	public void setNumEmploye(long numEmploye) {
		this.numEmploye = numEmploye;
	}   
	public String getNomEmploye() {
		return this.nomEmploye;
	}

	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}
   
}
