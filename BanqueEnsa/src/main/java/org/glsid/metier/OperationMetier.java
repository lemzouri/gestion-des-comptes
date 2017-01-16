package org.glsid.metier;

public interface OperationMetier {

	public boolean verser(String code,double montant,Long codeemp);
	public boolean retirer(String code,double montant,Long codeemp);
	public boolean virement(String cpte1,String cpte2,double montant,Long codeemp);
	public PageOperation getOperations(String codecompte,int page,int size);
}
