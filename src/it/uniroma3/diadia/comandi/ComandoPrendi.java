package it.uniroma3.diadia.comandi;

import it.unirmo3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.unirmo3.diadia.IO;

public class ComandoPrendi implements Comando {
	
	
	private String oggetto;
	
	public ComandoPrendi (String parametro) {
		this.oggetto =parametro;
	}
	@Override
	public void setParametro(String parametro, IO io) {
	}
	
	@Override
	public void esegui(Partita partita, IO io) {
		if(oggetto==null) {
			io.mostraMessaggio("Quale oggetto vuoi raccogliere?");
			oggetto = io.leggiRiga();
		}
		if(partita.stanzaCorrente.hasAttrezzo(oggetto)==false) {
			partita.giocatore.Raccogli(null);
		}
		else {
			Attrezzo attrezzo = partita.stanzaCorrente.getAttrezzo(oggetto);
			if (partita.giocatore.Raccogli(attrezzo) == true) {
				partita.stanzaCorrente.removeAttrezzo(attrezzo.nome);
			}
		}
		
	}

	

}

