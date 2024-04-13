package it.unirmo3.diadia;
import static org.junit.Assert.*;

import org.junit.Test;

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
