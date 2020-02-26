package com.versionbeta.service;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.versionbeta.banque.entity.Compte;
import com.versionbeta.banque.session.BanqueLocal;

@WebService
public class BanqueService {
	@EJB
	private BanqueLocal banqueLocal;

	@WebMethod
	public Compte addCompte(@WebParam(name = "solde") double solde,
			@WebParam(name = "dateCreation") Date dateCreation) {
		return banqueLocal.addCompte(new Compte(solde, dateCreation));
	}

	@WebMethod
	public Compte getCompte(@WebParam(name = "numCompte") long numCompte) {
		return banqueLocal.getCompte(numCompte);
	}

	@WebMethod
	public List<Compte> getListCompte() {
		return banqueLocal.getListCompte();
	}

	@WebMethod
	public void verser(@WebParam(name = "numCompte") long numCompte, @WebParam(name = "solde") double solde) {
		banqueLocal.verser(numCompte, solde);
	}

	@WebMethod
	public void retirer(@WebParam(name = "numCompte") long numCompte, @WebParam(name = "solde") double solde) {
		banqueLocal.retirer(numCompte, solde);
	}

	@WebMethod
	public void virement(@WebParam(name = "numCompteRetirer") long numCompteRetirer,
			@WebParam(name = "numCompte") long numCompteVerser, @WebParam(name = "solde") double solde) {
		banqueLocal.virement(numCompteRetirer, numCompteVerser, solde);
	}
}
