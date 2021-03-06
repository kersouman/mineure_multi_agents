package philosophes;

import plateforme.Donnees;

public class DonneesPhilosophe extends Donnees {

	public static int CPT_PHILOSOPHES = 0;
	
	public final static int VAR_PENSER = 10;
	public final static int VAR_MANGER = -5;
	public final static int SEUIL_FAIM = 100;
	public final static int SEUIL_RASSASIE = 0;
	public final static int SEUIL_LACHER = 50;
	
	public enum Etat {
		ATTENTE_FOURCHETTE,
		EN_TRAIN_DE_MANGER,
		EN_TRAIN_DE_PENSER
	}
	
	public DonneesPhilosophe() {
		this.donnees.put("numero", 
				new Integer(DonneesPhilosophe.CPT_PHILOSOPHES));
		DonneesPhilosophe.CPT_PHILOSOPHES++;
		
		this.donnees.put("faim", new Integer(0));
		
		this.donnees.put("cpt_pensee", new Integer(0));
		this.donnees.put("cpt_famine", new Integer(0));
		
		this.donnees.put("f_gauche", new Boolean(false));
		this.donnees.put("f_gauche_dispo", new Boolean(true));
		this.donnees.put("f_droite", new Boolean(false));
		this.donnees.put("f_droite_dispo", new Boolean(true));
		
		this.donnees.put("etat", Etat.EN_TRAIN_DE_PENSER);
		
		this.donnees.put("besoin_lacher", new Boolean(false));
	}
	
}
