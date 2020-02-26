package com.versionbeta.banque.session;

import java.util.List;

import javax.ejb.Remote;

import com.versionbeta.banque.entity.Compte;

/**
 * autor : Ouali Mustapha 
 */
@Remote
public interface BanqueRemote {
	public Compte addCompte(Compte compte);
	public Compte getCompte(long numCompte);
	public List<Compte> getListCompte(); 
	
	public void verser(long numCompte, double solde);
	public void retirer(long numCompte, double solde);
	public void virement(long numCompteVerser, long numCompteRetirer, double solde);
}
