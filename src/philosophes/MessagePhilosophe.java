package philosophes;

import plateforme.Message;

public class MessagePhilosophe extends Message {

	public MessagePhilosophe(int emetteur, int codeMessage) {
		super(emetteur, codeMessage);
	}
	
	/*
	 * Le codeMessage donne l'information sur la nature du message
	 * En l'occurence, on n'a besoin que d'un seul code puisqu'on ne 
	 * demande qu'à lâcher les fourchettes
	 * 1 : demande de lâcher de fourchettes
	 */
	
}
