package it.uniroma3.diadia.test;
import org.junit.Test;

import it.unirmo3.diadia.Partita;

public class PartitaTest {

	@Test
	public void testIsFinita_CFU0() {
		 Partita gioco = new Partita();
		 gioco.finita = false;
		 gioco.stanzaCorrente = gioco.labirinto.stanzaIniziale;
		 gioco.giocatore.cfu = 0;
		 gioco.isFinita();
	}
	
	@Test
	public void testIsFinita_Vittoria() {
		 Partita gioco = new Partita();
		 gioco.finita = false;
		 gioco.stanzaCorrente = gioco.labirinto.stanzaVincente;
		 gioco.giocatore.cfu = 5;
		 gioco.isFinita();
	}
	
	@Test
	public void testIsFinita_Finita() {
		 Partita gioco = new Partita();
		 gioco.finita = true;
		 gioco.stanzaCorrente = gioco.labirinto.stanzaIniziale;
		 gioco.giocatore.cfu = 5;
		 gioco.isFinita();
	}
}
