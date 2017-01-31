package plateforme;

public abstract class Message {

	private int emetteur = -1;
	private int codeMessage = -1;
	
	public Message(int emetteur, int codeMessage) {
		this.emetteur = emetteur;
		this.codeMessage = codeMessage;
	}
	
	public int getEmetteur() {
		return this.emetteur;
	}
	
	public int getCodeMessage() {
		return this.codeMessage;
	}	
}
