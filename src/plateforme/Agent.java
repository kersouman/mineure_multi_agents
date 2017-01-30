package plateforme;

import java.util.ArrayList;

public abstract class Agent extends Thread {
	
	protected Donnees donnees;
	protected Environnement environnement;
	protected ArrayList<Message> boiteAuxLettres = 
			new ArrayList<Message>();
	
	public abstract void percevoir();
	
	public abstract int deliberer();
	
	public abstract void agir(int codeAction);
	
	public void send(Message message) {
		this.environnement.post(message);
	}
	
	public synchronized void post(Message message) {
		this.boiteAuxLettres.add(message);
	}
	
	public void boucle_procedurale() {
		this.percevoir();
		int codeAction = this.deliberer();
		this.agir(codeAction);
	}
	
}
