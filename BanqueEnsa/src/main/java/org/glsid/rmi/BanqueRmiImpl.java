package org.glsid.rmi;

import java.rmi.RemoteException;

import org.glsid.entities.Compte;
import org.glsid.metier.CompteMetier;
import org.glsid.metier.OperationMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myRmiService")
public class BanqueRmiImpl implements BanqueRmiRemote {
	@Autowired
	private CompteMetier compteMetier;
	@Autowired
	private OperationMetier operationMetier;

	@Override
	public Compte saveCompte(Compte cp) throws RemoteException {
		// TODO Auto-generated method stub
		return compteMetier.savecompte(cp);
	}

	@Override
	public Compte getCompte(String code) throws RemoteException {
		// TODO Auto-generated method stub
		return compteMetier.getcompte(code);
	}

	@Override
	public boolean verser(String code, double montant, Long codeemp) throws RemoteException {
		// TODO Auto-generated method stub
		return operationMetier.verser(code, montant, codeemp);
	}

	@Override
	public boolean retirer(String code, double montant, Long codeemp) throws RemoteException {
		// TODO Auto-generated method stub
		return operationMetier.retirer(code, montant, codeemp);
	}

	@Override
	public boolean virement(String cpte1, String cpte2, double montant, Long codeemp) throws RemoteException {
		// TODO Auto-generated method stub
		return operationMetier.virement(cpte1, cpte2, montant, codeemp);
	}

}
