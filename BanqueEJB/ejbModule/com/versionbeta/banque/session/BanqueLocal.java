package com.versionbeta.banque.session;

import java.util.List;

import javax.ejb.Local;

import com.versionbeta.banque.entity.Client;
import com.versionbeta.banque.entity.Compte;
import com.versionbeta.banque.entity.Employe;

/**
  * autor : Ouali Mustapha 
  */
@Local
public interface BanqueLocal {

	// for entity client
	public Client addClient(Client client);
	public Client getClient(long code);

	/***************************************************************/	
	// for entity Employe
	public Employe addEmploye(Employe employe);
	public Employe getEmploye(long numEmploye);
	
	/***************************************************************/	
	/***************************************************************/	

	// for entity compte
	public Compte addCompte(double solde, long codeClient, long numEmploye);
	public Compte addCompte(Compte compte);
	public Compte getCompte(long numCompte);
	public List<Compte> getListCompte(); 
	
	/***************************************************************/	
	/***************************************************************/	
	
	public void versement(long numCompte, double montant, long numEmploye);	
	public void retrait(long numCompte, double montant, long numEmploye);
	public void virement(long numCompteRetirer, long numCompteVerser, double montant, long numEmploye);

	public void verser(long numCompte, double solde);
	public void retirer(long numCompte, double solde);
	public void virement(long numCompteVerser, long numCompteRetirer, double solde);
}
