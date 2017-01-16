package org.glsid.service;

import org.glsid.metier.OperationMetier;
import org.glsid.metier.PageOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperationRestService {
	@Autowired
	private OperationMetier operationMetier;

	@RequestMapping(value="/operations",method=RequestMethod.GET)
	public PageOperation getOperations(@RequestParam String codecompte,@RequestParam int page,@RequestParam int size) {
		return operationMetier.getOperations(codecompte, page, size);
	}

	@RequestMapping(value="/versement",method=RequestMethod.PUT)   //mis a jour du solde du compte (update=put)
	public boolean verser(@RequestParam String code,@RequestParam double montant,@RequestParam Long codeemp) {
		//requestparam parceque pas de json on envoie dans une requete
		return operationMetier.verser(code, montant, codeemp);
	}
    
	@RequestMapping(value="/retrait",method=RequestMethod.PUT) 
	public boolean retirer(@RequestParam String code,@RequestParam double montant,@RequestParam Long codeemp) {
		return operationMetier.retirer(code, montant, codeemp);
	}
    
	@RequestMapping(value="/virement",method=RequestMethod.PUT)
	public boolean virement(@RequestParam String cpte1,@RequestParam String cpte2,@RequestParam double montant,@RequestParam Long codeemp) {
		return operationMetier.virement(cpte1, cpte2, montant, codeemp);
	}

}
