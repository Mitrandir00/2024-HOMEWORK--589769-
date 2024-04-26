package it.uniroma3.diadia.comandi;

import it.unirmo3.diadia.Partita;
import it.unirmo3.diadia.IO;

public class ComandoNonValido implements Comando{

	@Override
	public void esegui(Partita partita, IO io) {
		io.mostraMessaggio("Questo comando non è valido\nSe non ricordi i comandi scrivi 'aiuto'");
	}

	@Override
	public void setParametro(String parametro, IO io) {
		
	}

}
