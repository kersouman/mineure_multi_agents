package philosophes;

import plateforme.ObjetEnvironnement;

public class Fourchette implements ObjetEnvironnement {
	
	private int numero = 0;
	private boolean estDispo = true;
	
	Fourchette(int numero) {
		this.numero = numero;
	}
	
	// Ne sert à rien dans l'implémentation actuelle
	@Override
	public int getNom() {
		// TODO Auto-generated method stub
		return this.numero;
	}

	@Override
	public Object getObjet() {
		// TODO Auto-generated method stub
		return this.estDispo;
	}
	
	@Override
	public void setObjet(Object objet) {
		// TODO Auto-generated method stub
		this.estDispo = (boolean)objet;
	}

}
