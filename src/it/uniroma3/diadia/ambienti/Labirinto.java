package it.uniroma3.diadia.ambienti;
import java.util.ArrayList;
import java.util.List;

public class Labirinto {


	private Stanza stanzaVincente;
	private Stanza stanzaIniziale;
	public List<Stanza> lab;



	public Stanza getStanzaIniziale() {
		return stanzaIniziale;
	}

	public void setStanzaInizaile(Stanza stanzaInizaile) {
		this.stanzaIniziale = stanzaInizaile;
		this.lab.add(stanzaInizaile);
	}

	public void setStanzaFinale(Stanza fin) {
		this.stanzaVincente = fin;
		this.lab.add(fin);
	}


	public Labirinto() {
		//creaStanze();
		lab = new ArrayList<Stanza>();
	}

	/**
	 * Crea tutte le stanze e le porte di collegamento
	 */
	/*private void creaStanze() {

		// crea gli attrezzi 
		Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);

		// crea stanze del labirinto 
		Stanza atrio = new Stanza("Atrio");
		lab.add(atrio);
		Stanza aulaN11 = new Stanza("Aula N11");
		lab.add(aulaN11);
		Stanza aulaN10 = new Stanza("Aula N10");
		lab.add(aulaN10);
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		lab.add(laboratorio);
		Stanza biblioteca = new Stanza("Biblioteca");
		lab.add(biblioteca);

		// collega le stanze 
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);

		  //pone gli attrezzi nelle stanze 
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);

		// il gioco comincia nell'atrio
		this.stanzaIniziale = atrio;  
		this.stanzaVincente = biblioteca;
	}*/

	public Stanza getStanzaVincente() {
		return this.stanzaVincente;
	}

}
