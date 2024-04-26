package it.uniroma3.diadia.comandi;

import it.unirmo3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.unirmo3.diadia.IO;

public class ComandoVai implements Comando {
	private String direzione;
	
	public ComandoVai(String Parametro) {
		this.direzione = Parametro;
	}

	@Override
	public void setParametro(String parametro, IO io) {
	}

	/**
	 * esecuzione del comando
	 */
	@Override
	public void esegui(Partita partita, IO io) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;
		if(direzione==null) {
			io.mostraMessaggio("Dove vuoi andare?\nDevi specificare una direzione");
			return;
		}
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
		if(prossimaStanza==null) {
			io.mostraMessaggio("Direzione inesistente");
			return;
		}
		partita.setStanzaCorrente(prossimaStanza);
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		io.mostraMessaggio(partita.getStanzaCorrente().toString());
		
	}


}
