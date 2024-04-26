package it.uniroma3.diadia.test;

import org.junit.Test;

import it.unirmo3.diadia.IOConsole;
import it.unirmo3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPosa;

public class ComandoPosaTest {

	@Test
	public void testEsegui_null() {
		Partita partita = new Partita();
		IOConsole io = new IOConsole();
		ComandoPosa comando = new ComandoPosa("gino");
		comando.esegui(partita, io);
	}
	
	@Test
	public void testEsegui_Presente() {
		Partita partita = new Partita();
		IOConsole io = new IOConsole();
		ComandoPosa posa = new ComandoPosa("osso");
		Attrezzo osso = new Attrezzo("osso", 3);
		partita.getGiocatore().borsa.addAttrezzo(osso);
		posa.esegui(partita, io);
	}
	
	@Test
	public void testEsegui_assente() {
		Partita partita = new Partita();
		IOConsole io = new IOConsole();
		ComandoPosa posa = new ComandoPosa("palo");
		Attrezzo osso = new Attrezzo("osso", 3);
		partita.getGiocatore().borsa.addAttrezzo(osso);
		posa.esegui(partita, io);
	}

}
