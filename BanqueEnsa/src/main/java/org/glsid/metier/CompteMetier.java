package org.glsid.metier;

import org.glsid.entities.Compte;

public interface CompteMetier {

	public Compte savecompte(Compte cp);
	public Compte getcompte(String code);
}
