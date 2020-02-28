package client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.versionbeta.banque.entity.Client;
import com.versionbeta.banque.entity.Compte;
import com.versionbeta.banque.entity.Employe;
import com.versionbeta.banque.session.BanqueRemote;

public class ClientRemote {

	public static BanqueRemote proxy = null;

	public static String getJbossExported(String appname, String moduleName, String beanName, String remoteInterace) {
		return "ejb:" + appname + "/" + moduleName + "/" + beanName + "!" + remoteInterace;
	}

	public static void main(String[] args) {
		System.out
				.println("\t**************************\n\t*... Debut Client RMI ....\n\t**************************\n");
		try {
			Context context = new InitialContext();
			proxy = (BanqueRemote) context
					.lookup(getJbossExported("BanqueWebEAR", "BanqueEJB", "BK", BanqueRemote.class.getName()));
			System.out.println(" debut connexion RMI ... utlise interface Remote");
			ajouteClients();

			ajouteEmployes();

			ajouteComptes();

//			proxy.retrait(4, 1000, 1);
//			proxy.versement(1, 1000, 1);
//			proxy.virement(2, 3, 4000, 2);
//			System.out.println("apres les operations ...");
			for (int i = 1; i < 5; i++)
				System.out.println(proxy.getCompte(1));

			Scanner scanner = new Scanner(System.in);
			int var;
			double montant;
			long numCompteVerser, numCompteRetirer, numCompte, numEmploye;
			do {
				System.out.println(
						"choix? \n1- ajoute client \n2- ajoute employe\n3- ajoute virement, \n4- ajoute retrait\n5- ajoute versement\n6- affiche Client \n7- affich employe \n8- addcompte \n9- affich compte \n10-exit");
				var = scanner.nextInt();
				scanner.nextLine();
				switch (var) {
				case 1:
					System.out.println("entrer le nom de client \n\t");
					proxy.addClient(new Client(scanner.nextLine()));
					break;

				case 2:
					System.out.println("entrer le nom de employe\n\t");
					proxy.addEmploye(new Employe(scanner.nextLine()));
					break;

				case 3:
					System.out.println("entrer numCompteRetirer n\t");
					numCompteRetirer = scanner.nextLong();
					scanner.nextLine();
					System.out.println("entrer numCompteVersement n\t");
					numCompteVerser = scanner.nextLong();
					scanner.nextLine();
					System.out.println("entrer montant n\t");
					montant = scanner.nextDouble();
					scanner.nextLine();
					System.out.println("entrer num employe n\t");
					numEmploye = scanner.nextLong();
					scanner.nextLine();
					proxy.virement(numCompteRetirer, numCompteVerser, montant, numEmploye);
					break;

				case 4:
					System.out.println("entrer numCompteRetirer n\t");
					numCompte = scanner.nextLong();
					scanner.nextLine();
					System.out.println("entrer montant n\t");
					montant = scanner.nextDouble();
					scanner.nextLine();
					System.out.println("entrer num employe n\t");
					numEmploye = scanner.nextLong();
					scanner.nextLine();
					proxy.retrait(numCompte, montant, numEmploye);
					break;

				case 5:
					System.out.println("entrer numCompteVerse n\t");
					numCompte = scanner.nextLong();
					scanner.nextLine();
					System.out.println("entrer montant n\t");
					montant = scanner.nextDouble();
					scanner.nextLine();
					System.out.println("entrer num employe n\t");
					numEmploye = scanner.nextLong();
					scanner.nextLine();
					proxy.versement(numCompte, montant, numEmploye);
					break;

				case 6:
					System.out.println("entrer num client n\t");
					numEmploye = scanner.nextLong();
					scanner.nextLine();
					System.out.println("\t* " + proxy.getClient(numEmploye));
					break;
				case 7:
					System.out.println("entrer num employe n\t");
					numEmploye = scanner.nextLong();
					scanner.nextLine();
					System.out.println("\t* " + proxy.getEmploye(numEmploye));
					break;
				case 8:
					System.out.println("entrer num employe n\t");
					numEmploye = scanner.nextLong();
					scanner.nextLine();
					System.out.println("entrer num client n\t");
					numCompte = scanner.nextLong();
					scanner.nextLine();
					System.out.println("entrer montant n\t");
					montant = scanner.nextDouble();
					scanner.nextLine();
					proxy.addCompte(new Compte(montant, proxy.getClient(numCompte), proxy.getEmploye(numEmploye)));
					break;
				case 9:
					System.out.println("entrer num compte n\t");
					numEmploye = scanner.nextLong();
					scanner.nextLine();
					System.out.println("\t* " + proxy.getCompte(numEmploye));
					break;
				case 10:
					break;
				default:
					System.out.println("entrer 1 ou 2\n\n");
				}
			} while (var != 10);

		} catch (NamingException e) {
			e.printStackTrace();
		}
		System.out
				.println("\n\t**************************\n\t*... Fin Client RMI ....\n\t**************************\n");

	}

	public static void ajouteClients() {
		System.out.println("Debut: ajouteClients()\n**********************************");
		ArrayList<Client> listClients = new ArrayList<Client>();
		listClients.add(new Client("said"));
		listClients.add(new Client("Mohemed"));
		listClients.add(new Client("Mustapha"));
		listClients.add(new Client("Farid"));
		listClients.add(new Client("Ali"));
		int i = 1;
		for (Client client : listClients) {
			proxy.addClient(client);
			System.out.println("\t* " + proxy.getClient(i));
			i++;
		}
		System.out.println("\n**********************************\nFin: ajouteClients()\n\n\n");
	}

	public static void ajouteEmployes() {
		System.out.println("Debut: ajouteEmployes()\n**********************************");
		ArrayList<Employe> listEmployes = new ArrayList<Employe>();
		listEmployes.add(new Employe("rachid"));
		listEmployes.add(new Employe("madjid"));
		listEmployes.add(new Employe("toto"));
		listEmployes.add(new Employe("Mus"));
		int i = 1;
		for (Employe employe : listEmployes) {
			proxy.addEmploye(employe);
			System.out.println("\t** " + proxy.getEmploye(i));
			i++;
		}
		System.out.println("\n**********************************\nFin: ajouteEmployes()\n\n\n");
	}

	public static void ajouteComptes() {
		System.out.println("Debut: ajouteComptes()\n**********************************");
		ArrayList<Compte> listComptes = new ArrayList<Compte>();
		listComptes.add(new Compte(70000, proxy.getClient(1), proxy.getEmploye(1)));
		listComptes.add(new Compte(9000, proxy.getClient(2), proxy.getEmploye(2)));
		listComptes.add(new Compte(3000, proxy.getClient(3), proxy.getEmploye(1)));
		listComptes.add(new Compte(18000));
		int i = 1;
		for (Compte compte : listComptes) {
			proxy.addCompte(compte);
			System.out.println("\t*** " + proxy.getCompte(i));
			i++;
		}
		System.out.println("\n**********************************\nFin: ajouteComptes()\n\n\n");
	}
}
