package com.versionbeta.banque.session;

import java.util.List;

import javax.ejb.Local;

import com.versionbeta.banque.entity.Compte;

/**
  * autor : Ouali Mustapha 
  */
@Local
public interface BanqueLocal {
	public Compte addCompte(Compte compte);
	public Compte getCompte(long numCompte);
	public List<Compte> getListCompte(); 
	
	public void verser(long numCompte, double solde);
	public void retirer(long numCompte, double solde);
	public void virement(long numCompteVerser, long numCompteRetirer, double solde);
}
