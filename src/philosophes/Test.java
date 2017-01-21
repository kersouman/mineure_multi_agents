package philosophes;

import java.util.ArrayList;
import java.util.Hashtable;

import plateforme.Agent;
import plateforme.Environnement;
import plateforme.ObjetEnvironnement;

public class Test {

	public static void main(String[] args) {

		Hashtable<String,ObjetEnvironnement> fourchettes = 
				new Hashtable<String,ObjetEnvironnement>();
		for (int i = 0; i < 5; i++) {
			fourchettes.put("Fourchette " + i, new Fourchette(i));
		}
		Environnement table = new Table(fourchettes);
		
		ArrayList<Agent> philosophes = new ArrayList<Agent>();
		for (int i = 0; i < 5; i++) {
			philosophes.add(new Philosophe((Table)table,
					new DonneesPhilosophe()));
		}
		
		table.addAgent(philosophes);
		
		for (int i = 0; i < 5; i++) {
			philosophes.get(i).start();
		}
	}
	
}
