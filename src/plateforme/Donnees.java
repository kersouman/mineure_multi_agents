package plateforme;

import java.util.Hashtable;

public abstract class Donnees {

	protected Hashtable<String, Object> donnees =
			new Hashtable<String, Object>();
	
	public Object get(String clef) {
		return donnees.get(clef);
	}
	
	public void set(String clef, Object valeur) {
		this.donnees.put(clef, valeur);
	}

}
