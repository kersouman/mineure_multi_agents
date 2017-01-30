package philosophes;

import java.util.ArrayList;

import philosophes.DonneesPhilosophe.Etat;
import plateforme.Agent;
import plateforme.Message;

public class Philosophe extends Agent {

	public Philosophe(Table table, DonneesPhilosophe donnees) {
		this.environnement = table;
		this.donnees = donnees;
	}
	
	@Override
	public void percevoir() {
		String f_courante = "Fourchette " + donnees.get("numero");
		String f_suivante = "Fourchette " 
					+ ((int)donnees.get("numero") + 1)%DonneesPhilosophe.CPT_PHILOSOPHES;
		
		this.donnees.set("f_gauche_dispo",
				(boolean)this.environnement.percevoir(f_courante));
		this.donnees.set("f_droite_dispo", 
				(boolean)this.environnement.percevoir(f_suivante));
		
		synchronized(this) {
			for(Message message: this.boiteAuxLettres) {
				switch(message.getCodeMessage()) {
				case 1:
					this.donnees.set("besoin_lacher", new Boolean(true));
					break;
				default:
					break;
				}
			}
			this.boiteAuxLettres = new ArrayList<Message>();
		}
	}

	@Override
	public int deliberer() {
		// Précondition à l'action penser
		if(this.donnees.get("etat") == Etat.EN_TRAIN_DE_PENSER &&
				(int)this.donnees.get("faim") < DonneesPhilosophe.SEUIL_FAIM)
			return 1;
		
		// Précondition à l'action finir_penser
		if(this.donnees.get("etat") == Etat.EN_TRAIN_DE_PENSER &&
				(int)this.donnees.get("faim") >= DonneesPhilosophe.SEUIL_FAIM)
			return 2;
		
		// Précondition à l'action prendre_f
		if(this.donnees.get("etat") == Etat.ATTENTE_FOURCHETTE &&
				(boolean)this.donnees.get("f_gauche_dispo") &&
				(boolean)this.donnees.get("f_droite_dispo"))
			return 3;
		
		// Précondition à l'action commence_manger
		if(this.donnees.get("etat") == Etat.ATTENTE_FOURCHETTE &&
				(boolean)this.donnees.get("f_gauche") &&
				(boolean)this.donnees.get("f_droite"))
			return 4;
		
		// Précondition à l'action famine
		if(this.donnees.get("etat") == Etat.ATTENTE_FOURCHETTE &&
				(!((boolean)this.donnees.get("f_gauche_dispo")) ||
					!((boolean)this.donnees.get("f_droite_dispo"))))
			return 5;
		
		// Précondition à l'action finir_manger
		if(this.donnees.get("etat") == Etat.EN_TRAIN_DE_MANGER &&
				((int)this.donnees.get("faim") < DonneesPhilosophe.SEUIL_RASSASIE ||
				((int)this.donnees.get("faim") < DonneesPhilosophe.SEUIL_LACHER &&
						(boolean)this.donnees.get("besoin_lacher"))))
			return 6;
		
		// Précondition à l'action manger
		if(this.donnees.get("etat") == Etat.EN_TRAIN_DE_MANGER &&
				(int)this.donnees.get("faim") >= 0)
			return 7;
		
		return 0;
	}

	@Override
	public void agir(int codeAction) {
		// TODO Auto-generated method stub
		int[] donneesAction = {0,0};
		
		switch (codeAction) {
		
		// Action penser
		case 1:
			this.donnees.set("cpt_pensee", 
					(int)this.donnees.get("cpt_pensee") + 1);
			this.donnees.set("faim",
					(int)this.donnees.get("faim")
						+ DonneesPhilosophe.VAR_PENSER);
			this.donnees.set("besoin_lacher", new Boolean(false));
			System.out.println("Philosophe " 
					+ this.donnees.get("numero") + " : "
					+ "Je pense et mon compteur de pensées est à "
					+ this.donnees.get("cpt_pensee")
					+ " et ma faim est à "
					+ this.donnees.get("faim"));
			
			break;

		// Action finir_penser
		case 2:
			this.donnees.set("etat", Etat.ATTENTE_FOURCHETTE);
			this.donnees.set("besoin_lacher", new Boolean(false));
			System.out.println("Philosophe " + this.donnees.get("numero")
					+ " : Je me mets à attendre les fourchettes");
			
			break;
			
		// Action prendre_f
		case 3:
			donneesAction[0] = 1;
			donneesAction[1] = (int)this.donnees.get("numero");
			if(this.environnement.agir(donneesAction)) {
				this.donnees.set("f_gauche", new Boolean(true));
				this.donnees.set("f_droite", new Boolean(true));
				this.donnees.set("besoin_lacher", new Boolean(false));
				System.out.println("Philosophe " + this.donnees.get("numero")
					+ " : J'ai pris les fourchettes");
			} else {
				this.donnees.set("besoin_lacher", new Boolean(false));
				System.out.println("Philosophe " + this.donnees.get("numero")
				+ " : Je n'ai pas réussi à prendre les fourchettes");
			}
			break;
			
		// Action commencer_manger
		case 4:
			this.donnees.set("etat", Etat.EN_TRAIN_DE_MANGER);
			this.donnees.set("besoin_lacher", new Boolean(false));
			System.out.println("Philosophe " + this.donnees.get("numero")
					+ " : Je commence à manger");
			break;	
			
		// Action famine
		case 5:
			this.donnees.set("cpt_famine", 
					(int)this.donnees.get("cpt_famine")+1);
			Message message = 
				new MessagePhilosophe((int)this.donnees.get("numero"),1);
			this.send(message);
			this.donnees.set("besoin_lacher", new Boolean(false));
			System.out.println("Philosophe " + this.donnees.get("numero")
					+ " : J'attend mes fourchettes et mon compteur de "
					+ "famine est à " + this.donnees.get("cpt_famine"));
			break;
			
		// Action finir_manger
		case 6:
			donneesAction[0] = 2;
			donneesAction[1] = (int)this.donnees.get("numero");
			if(this.environnement.agir(donneesAction)) {
				this.donnees.set("f_gauche", new Boolean(false));
				this.donnees.set("f_droite", new Boolean(false));
				this.donnees.set("besoin_lacher", new Boolean(false));
				this.donnees.set("etat", Etat.EN_TRAIN_DE_PENSER);
				System.out.println("Philosophe " 
						+ this.donnees.get("numero") + " : "
						+ "Je finis de manger et je pose mes fourchettes");
			} else {
				System.out.println("Philosophe " 
						+ this.donnees.get("numero") + " : "
						+ "Je finis de manger mais je n'arrive pas à poser"
						+ " mes fourchettes");
			}
			break;
			
		// Action manger
		case 7:
			this.donnees.set("faim", 
					(int)this.donnees.get("faim") 
						+ DonneesPhilosophe.VAR_MANGER);
			System.out.println("Philosophe " + this.donnees.get("numero")
					+ " : Je mange et ma faim est à "
					+ this.donnees.get("faim"));
			break;
			
		default:
			break;
		}
	}

	public void sePresenter() {
		System.out.println("Je suis le philosophe numéro " 
					+ this.donnees.get("numero"));
	}
	
}