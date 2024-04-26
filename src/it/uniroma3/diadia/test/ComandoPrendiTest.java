package it.uniroma3.diadia.test;

import org.junit.Test;

import it.unirmo3.diadia.IOConsole;
import it.unirmo3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPrendi;

public class ComandoPrendiTest {

	@Test
	public void testEsegui() {
		Partita partita = new Partita();
		IOConsole io = new IOConsole();
		ComandoPrendi comando = new ComandoPrendi(null);
		comando.esegui(partita, io);
	}
	
	@Test
	public void testEsegui_oggettoAssente() {
		Partita partita = new Partita();
		IOConsole io = new IOConsole();
		ComandoPrendi comando = new ComandoPrendi("ascia");
		comando.esegui(partita, io);
	}
	
	@Test
	public void testEsegui_oggettoPresente() {
		Partita partita = new Partita();
		IOConsole io = new IOConsole();
		Attrezzo ascia =  new Attrezzo("ascia", 5);
		ComandoPrendi comando = new ComandoPrendi("ascia");
		partita.getGiocatore().borsa.addAttrezzo(ascia);
		comando.esegui(partita, io);
	}

}
