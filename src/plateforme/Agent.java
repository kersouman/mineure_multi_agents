package plateforme;

public abstract class Agent extends Thread {
	
	protected Donnees donnees;
	protected Environnement environnement;
	
	public abstract void percevoir();
	
	public abstract int deliberer();
	
	public abstract void agir(int codeAction);
	
	public void boucle_procedurale() {
		this.percevoir();
		int codeAction = this.deliberer();
		this.agir(codeAction);
	}
	
}
