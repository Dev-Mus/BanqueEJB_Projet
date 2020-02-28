package com.versionbeta.service;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.versionbeta.banque.entity.Client;
import com.versionbeta.banque.entity.Compte;
import com.versionbeta.banque.entity.Employe;
import com.versionbeta.banque.session.BanqueLocal;

@WebService
public class BanqueService {
	@EJB
	private BanqueLocal banqueLocal;

	// for Client
	@WebMethod
	public Client addClient(@WebParam(name = "nom") String nom) {
		return banqueLocal.addClient(new Client(nom));
	}

	@WebMethod
	public Client getClient(@WebParam(name = "code") long code) {
		return banqueLocal.getClient(code);
	}

	// for Employe
	@WebMethod
	public Employe addEmploye(@WebParam(name = "nom") String nom) {
		return banqueLocal.addEmploye(new Employe(nom));
	}

	@WebMethod
	public Employe getEmploye(@WebParam(name = "numEmploye") long numEmploye) {
		return banqueLocal.getEmploye(numEmploye);
	}

	// for Compte
	@WebMethod
	public Compte addCompte(@WebParam(name = "solde") double solde, @WebParam(name = "codeClient") long codeClient,
			@WebParam(name = "numEmploye") long numEmploye) {
		return banqueLocal.addCompte(solde, codeClient, numEmploye);
	}
//
//	@WebMethod 
//	public Compte addCompte(@WebParam(name = "solde") double solde) {
//		return banqueLocal.addCompte(new Compte(solde));
//	}

	@WebMethod
	public Compte getCompte(@WebParam(name = "numCompte") long numCompte) {
		return banqueLocal.getCompte(numCompte);
	}

	// for Operation
	@WebMethod
	public void versement(@WebParam(name = "numCompte") long numCompte, @WebParam(name = "montant") double montant,
			@WebParam(name = "numEmploye") long numEmploye) {
		banqueLocal.versement(numCompte, montant, numCompte);
	}

	@WebMethod
	public void retrait(@WebParam(name = "numCompte") long numCompte, @WebParam(name = "montant") double montant,
			@WebParam(name = "numEmploye") long numEmploye) {
		banqueLocal.retrait(numCompte, montant, numCompte);
	}

	@WebMethod
	public void virement(@WebParam(name = "numCompteRetirer") long numCompteRetirer,
			@WebParam(name = "numCompteVerser") long numCompteVerser, @WebParam(name = "montant") double montant,
			@WebParam(name = "numEmploye") long numEmploye) {
		banqueLocal.virement(numCompteRetirer, numCompteVerser, montant, numEmploye);
	}
}
