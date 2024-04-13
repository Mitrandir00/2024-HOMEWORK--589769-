package it.unirmo3.diadia;


import java.util.Scanner;

import it.uniroma3.diadia.IOConsole.IOConsole;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	static final private String[] elencoComandi = {".vai\n.borsa\n.raccogli\n.posa\n.aiuto\n.fine\n"};

	private Partita partita;

	public Attrezzo attrezzo;

	public IOConsole IO;


	public DiaDia() {
		this.partita = new Partita();
		this.IO = new IOConsole();

	}

	public void gioca() {
		String istruzione;

		this.IO.mostraMessaggio(MESSAGGIO_BENVENUTO);		
		do		

			istruzione = IO.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		if(this.partita.giocatore.getCfu()==0) {
			IOConsole IO = new IOConsole();
			this.IO.mostraMessaggio("Hai perso tutti i tuoi CFU :(");
			this.fine(); 
			return true;
		}
		Comando comandoDaEseguire = new Comando(istruzione);
		if(istruzione.isBlank()) return false;//AGGIUNTO DA ME
		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai")) {
			this.vai(comandoDaEseguire.getParametro());
		}
		else if (comandoDaEseguire.getNome().equals("aiuto")) {
			this.aiuto();
		}
		else if (comandoDaEseguire.getNome().equals("borsa")) {
			this.borsa();
		}
		else if (comandoDaEseguire.getNome().equals("raccogli")) {
			this.raccogli(comandoDaEseguire.getParametro());
		}
		else if (comandoDaEseguire.getNome().equals("posa")) {
			this.posa(comandoDaEseguire.getParametro());
		}
		else
			IO.mostraMessaggio("Comando sconosciuto");
		if (this.partita.vinta()) {
			IO.mostraMessaggio("Hai vinto!");
			return true;
		} else
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			IO.mostraMessaggio(elencoComandi[i]+" ");
		System.out.println();
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null) {
			IO.mostraMessaggio("Dove vuoi andare ?");
			direzione = IO.leggiRiga();
		}
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			IO.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.giocatore.getCfu();
			cfu--;
			this.partita.giocatore.setCfu(cfu);
		}
		IO.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		IO.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}


	private void borsa() {
		IO.mostraMessaggio(this.partita.giocatore.borsa.toString());
		IO.mostraMessaggio("Questi sono i tuoi CFU attuali: "+this.partita.giocatore.getCfu());
	}

	private void raccogli(String oggetto) {
		if(oggetto==null) {
			IO.mostraMessaggio("Quale oggetto vuoi raccogliere?");
			oggetto = IO.leggiRiga();
		}
		if(this.partita.stanzaCorrente.hasAttrezzo(oggetto)==false) {
			this.partita.giocatore.Raccogli(null);
		}
		else {
			this.attrezzo = new Attrezzo("ciao", 3);
			this.attrezzo = this.partita.stanzaCorrente.getAttrezzo(oggetto);
			if (this.partita.giocatore.Raccogli(attrezzo) == true) {
				this.partita.stanzaCorrente.removeAttrezzo(this.attrezzo.nome);
			}
		}
	}

	private void posa(String oggetto) {
		if(oggetto==null) {
			IO.mostraMessaggio("Quale oggetto vuoi posare?");
			oggetto = IO.leggiRiga();
		}
		if(this.partita.giocatore.borsa.hasAttrezzo(oggetto)== false) {
			IO.mostraMessaggio("Non hai questo attrezzo nella borsa");
		}
		else {
			this.attrezzo = new Attrezzo("ciao", 2);
			this.attrezzo = this.partita.giocatore.borsa.getAttrezzo(oggetto);
			this.partita.giocatore.borsa.removeAttrezzo(oggetto);
			this.partita.stanzaCorrente.addAttrezzo(this.attrezzo);
			IO.mostraMessaggio("Hai lasciato "+oggetto);
		}

	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
		IOConsole IO = new IOConsole();
	}
}