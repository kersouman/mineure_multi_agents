package plateforme;

import java.util.ArrayList;
import java.util.Hashtable;

public abstract class Environnement {
	
	protected ArrayList<Agent> agents = new ArrayList<Agent>();
	protected Hashtable<String, ObjetEnvironnement> objets = 
			new Hashtable<String, ObjetEnvironnement>();
	
	protected Environnement(Hashtable<String, ObjetEnvironnement> objets) {
		this.objets = objets;
	}
	
	public void addAgent(ArrayList<Agent> agents) {
		this.agents = agents;
	}
	
	public Object percevoir(String clef) {
		return this.objets.get(clef).getObjet();
	}
	
	public abstract boolean agir(int[] codeAction);
}