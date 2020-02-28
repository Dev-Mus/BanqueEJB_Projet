package com.versionbeta.banque.entity;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;

import javax.persistence.*;

import java.util.List;

/**
 * Entity implementation class for Entity: Client autor : Ouali Mustapha
 */
@Entity

public class Client implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long code;

	private String nom;

	private static final long serialVersionUID = 1L;

	public Client(String nom) {
		super();
		this.nom = nom;
	}

	public Client(long code, String nom) {
		super();
		this.code = code;
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Client [code=" + code + ", nom=" + nom + "]";
	}

	public Client() {
		super();
	}

	public long getCode() {
		return this.code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
