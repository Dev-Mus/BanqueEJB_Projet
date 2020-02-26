package com.versionbeta.banque.session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.versionbeta.banque.entity.Compte;

/**
 * Session Bean implementation class BanqueImpl
 * autor : Ouali Mustapha 
 */
@Stateless(name = "BK")
public class BanqueImpl implements BanqueRemote, BanqueLocal {

	@PersistenceContext(unitName = "BanqueEJB")
	private EntityManager entityManager;

	@Override
	public Compte addCompte(Compte compte) {
		entityManager.persist(compte);
		return compte;
	}

	@Override
	public Compte getCompte(long numCompte) {
		Compte compte = entityManager.find(Compte.class, numCompte);
		if (compte == null)
			throw new RuntimeException("Compte introuvable ? ... ");
		return compte;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Compte> getListCompte() {
		return entityManager.createQuery("SELECT numCompte, solde, dateCreation FROM Compte").getResultList();
	}

	@Override
	public void verser(long numCompte, double solde) {
		Compte compte = getCompte(numCompte);
		compte.setSolde(compte.getSolde() + solde);
	}

	@Override
	public void retirer(long numCompte, double solde) {
		Compte compte = getCompte(numCompte);
		if (compte.getSolde() >= solde)
			compte.setSolde(compte.getSolde() - solde);
		else
			throw new RuntimeException("solde insuffisant ? ... ");

	}

	@Override
	public void virement(long numCompteRetirer, long numCompteVerser, double solde) {
		retirer(numCompteRetirer, solde);
		verser(numCompteVerser, solde);
	}

}
