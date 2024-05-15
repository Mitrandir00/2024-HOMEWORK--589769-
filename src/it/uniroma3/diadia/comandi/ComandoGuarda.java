package it.uniroma3.diadia.comandi;

import it.unirmo3.diadia.Partita;
import it.unirmo3.diadia.IO;

public class ComandoGuarda implements Comando{

	@Override
	public void esegui(Partita partita, IO io) {
		partita.giocatore.borsa.getSortedSetOrdinatoPerPeso();
		io.mostraMessaggio(partita.giocatore.borsa.toString());
		io.mostraMessaggio(partita.getStanzaCorrente().toString());
		io.mostraMessaggio("Questi sono i tuoi CFU attuali: "+partita.giocatore.getCfu());
		
	}

	@Override
	public void setParametro(String parametro, IO io) {
	}

}
