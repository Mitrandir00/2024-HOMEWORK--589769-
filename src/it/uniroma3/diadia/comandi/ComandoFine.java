package it.uniroma3.diadia.comandi;

import it.unirmo3.diadia.IO;
import it.unirmo3.diadia.Partita;

public class ComandoFine implements Comando{

	@Override
	public void esegui(Partita partita, IO io) {
		partita.setFinita();
	}

	@Override
	public void setParametro(String parametro, IO io) {
	}
	
}
