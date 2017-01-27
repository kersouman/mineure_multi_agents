package philosophes;

import java.util.ArrayList;
import java.util.Hashtable;

import plateforme.Agent;
import plateforme.Environnement;
import plateforme.ObjetEnvironnement;

public class Table extends Environnement {

	protected Table(Hashtable<String, ObjetEnvironnement> fourchettes) {
		// TODO Auto-generated constructor stub
		super(fourchettes);
	}

	@Override
	public boolean agir(int[] donneesAction) {
		/*
		 *  Décomposition du tableau donneesAction
		 *  0 : code de l'action
		 *  1 : numéro de l'agent (et de la fourchette à sa gauche
		 *  La suite ne sert pas encore (et peut-être jamais)
		 */
		int codeAction 		= donneesAction[0];
		String f_courant	= "Fourchette " + donneesAction[1];
		String f_suivant	= "Fourchette " + 
				(donneesAction[1] + 1)%DonneesPhilosophe.CPT_PHILOSOPHES;
		boolean estEffectue = false;
		
		switch (codeAction) {
		// Action prendre
		case 1:
			if((boolean)this.percevoir(f_courant)
					&& (boolean)this.percevoir(f_suivant)) {
				synchronized(this.objets.get(f_courant)) {
					this.objets.get(f_courant).setObjet(new Boolean(false));
				}
				synchronized(this.objets.get(f_suivant)) {
					this.objets.get(f_suivant).setObjet(new Boolean(false));
				}
				estEffectue = true;
			}
			break;
		// Action poser
		case 2:
			if(!((boolean)this.percevoir(f_courant)) &&
					!((boolean)this.percevoir(f_suivant))) {
				synchronized(this.objets.get(f_courant)) {
					this.objets.get(f_courant).setObjet(new Boolean(true));
				}
				synchronized(this.objets.get(f_suivant)) {
					this.objets.get(f_suivant).setObjet(new Boolean(true));
				}
				estEffectue = true;
			}
			break;
		default:
			break;
		}
		
		return estEffectue;
	}
	
}
