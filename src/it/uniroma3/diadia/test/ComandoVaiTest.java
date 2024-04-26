package it.uniroma3.diadia.test;

import org.junit.Test;

import it.unirmo3.diadia.IOConsole;
import it.unirmo3.diadia.Partita;
import it.uniroma3.diadia.comandi.ComandoVai;

public class ComandoVaiTest {

	@Test
	public void testEsegui_null() {
		Partita partita = new Partita();
		IOConsole io = new IOConsole();
		ComandoVai comando = new ComandoVai(null);
		comando.esegui(partita, io);
	}
	
	@Test
	public void testEsegui_direzione() {
		Partita partita = new Partita();
		IOConsole io = new IOConsole();
		ComandoVai comando = new ComandoVai("sud");
		comando.esegui(partita, io);
	}
	
	@Test
	public void testEsegui_nonEsistente() {
		Partita partita = new Partita();
		IOConsole io = new IOConsole();
		partita.getStanzaCorrente().impostaStanzaAdiacente("sud", null);
		ComandoVai comando = new ComandoVai("sud");
		comando.esegui(partita, io);
	}

}
