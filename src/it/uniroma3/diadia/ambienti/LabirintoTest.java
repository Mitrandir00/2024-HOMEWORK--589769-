package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

public class LabirintoTest {

	@Test
	public void testSetStanzaInizaile_giusta() {
		Labirinto labirinto = new Labirinto();
		Stanza stanza = new Stanza("stanza iniziale");
		labirinto.setStanzaInizaile(stanza);
	}
	
	@Test
	public void testSetStanzaInizaile_sbagliata() {
		Labirinto labirinto = new Labirinto();
		Stanza stanza = new Stanza(null);
		labirinto.setStanzaInizaile(stanza);
	}
	
	@Test
	public void testSetStanzaInizaile_giàFinito() {
		Labirinto labirinto = new Labirinto();
		Stanza stanza = new Stanza("stanza finale");
		labirinto.stanzaVincente=stanza;
		labirinto.setStanzaInizaile(stanza);
	}

}
