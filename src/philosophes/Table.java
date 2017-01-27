package philosophes;

import java.util.Hashtable;

import plateforme.Environnement;
import plateforme.Message;
import plateforme.ObjetEnvironnement;

public class Table extends Environnement {

	protected Table(Hashtable<String, ObjetEnvironnement> fourchettes) {
		// TODO Auto-generated constructor stub
		super(fourchettes);
	}

	@Override
	public void post(Message message) {
		int[] destinataires = {-1,-1};
		destinataires[0] = 
				(message.getEmetteur()+DonneesPhilosophe.CPT_PHILOSOPHES-1)%DonneesPhilosophe.CPT_PHILOSOPHES;
		destinataires[1] = 
				(message.getEmetteur()+1)%DonneesPhilosophe.CPT_PHILOSOPHES;
		this.agents.get(destinataires[0]).post(message);
		this.agents.get(destinataires[1]).post(message);
	}
	
	@Override
	public synchronized boolean agir(int[] donneesAction) {
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
				this.objets.get(f_courant).setObjet(new Boolean(false));
				this.objets.get(f_suivant).setObjet(new Boolean(false));
				estEffectue = true;
			}
			break;
		// Action poser
		case 2:
			if(!((boolean)this.percevoir(f_courant)) &&
					!((boolean)this.percevoir(f_suivant))) {
				this.objets.get(f_courant).setObjet(new Boolean(true));
				this.objets.get(f_suivant).setObjet(new Boolean(true));
				estEffectue = true;
			}
			break;
		default:
			break;
		}
		
		return estEffectue;
	}
	
}
