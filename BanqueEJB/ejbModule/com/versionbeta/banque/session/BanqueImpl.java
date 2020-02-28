package com.versionbeta.banque.session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.versionbeta.banque.entity.Operation;
import com.versionbeta.banque.entity.Client;
import com.versionbeta.banque.entity.Compte;
import com.versionbeta.banque.entity.Employe;

/**
 * Session Bean implementation class BanqueImpl autor : Ouali Mustapha
 */
@Stateless(name = "BK")
public class BanqueImpl implements BanqueRemote, BanqueLocal {

	@PersistenceContext(unitName = "BanqueEJB")
	private EntityManager entityManager;

	@Override
	public Client addClient(Client client) {
		entityManager.persist(client);
		return client;
	}

	@Override
	public Client getClient(long code) {
		Client client = entityManager.find(Client.class, code);
		if (client == null)
			throw new RuntimeException("Client introuvable ? ... ");
		return client;
	}

	/***************************************************************/

	@Override
	public Employe addEmploye(Employe employe) {
		entityManager.persist(employe);
		return employe;
	}

	@Override
	public Employe getEmploye(long numEmploye) {
		Employe Employe = entityManager.find(Employe.class, numEmploye);
		if (Employe == null)
			throw new RuntimeException("Employe introuvable ? ... ");
		return Employe;
	}

	/***************************************************************/
	/***************************************************************/
	@Override
	public Compte addCompte(double solde, long codeClient, long numEmploye) {
		Compte compte = new Compte(solde, getClient(codeClient), getEmploye(numEmploye));
		entityManager.persist(compte);
		return compte;
	}

	/***************************************************************/

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

	/***************************************************************/
	/***************************************************************/

	private Operation addOperation(Operation operation, double montant) {
		entityManager.persist(operation);
		if (operation.gettypeOperation() == 1)
			operation.getCompte().setSolde(operation.getCompte().getSolde() + montant);
		else
			operation.getCompte().setSolde(operation.getCompte().getSolde() - montant);
		return operation;
	}

	@Override
	public void versement(long numCompte, double montant, long numEmploye) {
		addOperation(new Operation(montant, getCompte(numCompte), getEmploye(numEmploye), 1), montant);
	}

	@Override
	public void retrait(long numCompte, double montant, long numEmploye) {
		if (getCompte(numCompte).getSolde() >= montant)
			addOperation(new Operation(montant, getCompte(numCompte), getEmploye(numEmploye), 0), montant);
		else
			throw new RuntimeException("solde insuffisant ? ... ");
	}

	@Override
	public void virement(long numCompteRetirer, long numCompteVerser, double montant, long numEmploye) {
		retrait(numCompteRetirer, montant, numEmploye);
		versement(numCompteVerser, montant, numEmploye);
	}

	/***************************************************************/
	/***************************************************************/

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
