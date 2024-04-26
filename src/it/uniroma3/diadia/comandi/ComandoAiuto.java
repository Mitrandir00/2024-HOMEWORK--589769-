package it.uniroma3.diadia.comandi;

import it.unirmo3.diadia.Partita;
import it.unirmo3.diadia.IO;
import it.unirmo3.diadia.IOConsole;

public class ComandoAiuto implements Comando{

	static final private String[] elencoComandi = {".vai\n.guarda\n.prendi\n.posa\n.aiuto\n.fine\n"};
	@Override
	public void esegui(Partita partita, IO io) {
		IO IO = new IOConsole();
		for(int i=0; i< elencoComandi.length; i++) 
			IO.mostraMessaggio(elencoComandi[i]+" ");
		System.out.println();
	}

	@Override
	public void setParametro(String parametro, IO io) {
	}

}
