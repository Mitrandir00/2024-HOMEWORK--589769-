package it.uniroma3.diadia.comandi;

import it.unirmo3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.unirmo3.diadia.IO;

public class ComandoPosa implements Comando {

	private String oggetto;
	
	public ComandoPosa(String parametro) {
		this.oggetto = parametro;
	}

	@Override
	public void esegui(Partita partita, IO io) {
		if(oggetto==null) {
			io.mostraMessaggio("Quale oggetto vuoi posare?");
			oggetto = io.leggiRiga();
		}
		if(partita.giocatore.borsa.hasAttrezzo(oggetto)== false) {
			io.mostraMessaggio("Non hai questo attrezzo nella borsa");
		}
		else {
			Attrezzo attrezzo = partita.giocatore.borsa.getAttrezzo(oggetto);
			partita.giocatore.borsa.removeAttrezzo(this.oggetto);
			partita.stanzaCorrente.addAttrezzo(attrezzo);
			io.mostraMessaggio("Hai lasciato "+oggetto);
		}
	}

	@Override
	public void setParametro(String parametro, IO io) {	
		this.oggetto = parametro;
	}

}
