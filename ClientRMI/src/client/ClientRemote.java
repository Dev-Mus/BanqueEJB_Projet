package client;

import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.versionbeta.banque.entity.Compte;
import com.versionbeta.banque.session.BanqueRemote;

public class ClientRemote {

	public static String getJbossExported(String appname, String moduleName, String beanName, String remoteInterace) {
		return "ejb:" + appname + "/" + moduleName + "/" + beanName + "!" + remoteInterace;
	}

	public static void main(String[] args) {
		try {
			Context context = new InitialContext();
			BanqueRemote proxy = (BanqueRemote) context
					.lookup(getJbossExported("BanqueWebEAR", "BanqueEJB", "BK", BanqueRemote.class.getName()));
			
			proxy.addCompte(new Compte(6700, new Date(120, 02, 26))); 
			proxy.addCompte(new Compte(6700, new Date(120, 02, 26))); 
//			proxy.addCompte(new Compte(300, new Date("2001-02-02")));
			System.out.println(proxy.getCompte(1).toString());
			System.out.println(proxy.getCompte(2).toString()+"\n"); 
//			proxy.virement(1, 2,1000); System.out.println(proxy.getCompte(1).toString());
			

//			List<Compte> listCompte = proxy.getListCompte();
//			for (Compte compte : listCompte)
//				if (compte != null)
//					System.out.println(compte.toString());
//				else
//					System.out.println("null");

		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

}
