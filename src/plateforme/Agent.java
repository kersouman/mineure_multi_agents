package plateforme;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public abstract class Agent extends Thread {
	
	protected Donnees donnees;
	protected Environnement environnement;
	protected ArrayList<Message> boiteAuxLettres = 
			new ArrayList<Message>();
	
	protected ArrayList<String> etatCsv =
			new ArrayList<String>();
	
	public abstract void percevoir();
	
	public abstract int deliberer();
	
	public abstract void agir(int codeAction);
	
	public void send(Message message) {
		this.environnement.post(message);
	}
	
	public synchronized void post(Message message) {
		this.boiteAuxLettres.add(message);
	}
	
	public abstract void sePresenter();
	public abstract void getEtatTour(int compteurTour);
	public abstract void ecrireEtatCsv() throws FileNotFoundException, 
												UnsupportedEncodingException,
												IOException;
	
	public void run() {
		this.sePresenter();
		int compteurTour = 0;
		while(compteurTour < 20000) {
			this.percevoir();
			int codeAction = this.deliberer();
			this.agir(codeAction);
			this.getEtatTour(compteurTour);
			compteurTour++;
		}
		try {
			this.ecrireEtatCsv();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
