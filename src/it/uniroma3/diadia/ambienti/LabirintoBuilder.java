package it.uniroma3.diadia.ambienti;

import java.util.Iterator;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder extends Labirinto {

	private Labirinto Labirinto;
	public LabirintoBuilder () {
		Labirinto = new Labirinto();
	}

	public LabirintoBuilder addStanza(String a) {
		Stanza c = new Stanza(a);
		this.Labirinto.lab.add(c);
		return this;
	}
	
	public LabirintoBuilder addStanzaBloccata(String stanza, String direzione, String chiave) {
		Stanza c = new StanzaBloccata(stanza, direzione, chiave);
		this.Labirinto.lab.add(c);
		return this;
	}
	
	public LabirintoBuilder addStanzaBuia(String stanza, String chiave) {
		Stanza c = new StanzaBuia(stanza, chiave);
		this.Labirinto.lab.add(c);
		return this;
	}
	
	public LabirintoBuilder addStanzaMagica(String stanza, int a) {
		Stanza c = new StanzaMagica(stanza, a);
		this.Labirinto.lab.add(c);
		return this;
	}

	public LabirintoBuilder addStanzaIniziale(String a) {
		Stanza c = new Stanza(a);
		this.Labirinto.setStanzaInizaile(c);
		this.Labirinto.lab.add(c);
		return this;
	}

	public LabirintoBuilder addStanzaVincente(String a) {
		Stanza c = new Stanza(a);
		this.Labirinto.setStanzaFinale(c);
		this.Labirinto.lab.add(c);
		return this;
	}

	public LabirintoBuilder addAdiacenza(String inizio, String aggiungi, String direzione) {
		Iterator<Stanza> iteratore = this.Labirinto.lab.iterator();
		Stanza a = new Stanza("totò");
		while(iteratore.hasNext()&&!(a.getNome().equals(inizio))) {
			a = iteratore.next();
		}
		Iterator<Stanza> iteratore2 = this.Labirinto.lab.iterator();
		Stanza b = new Stanza("peppino");
		while(iteratore2.hasNext()&&!(b.getNome().equals(aggiungi))) {
			b = iteratore2.next();
			}
		a.impostaStanzaAdiacente(direzione, b);
		return this;
	}

	public LabirintoBuilder addAttrezzo(String nome, int a) {
		Attrezzo attrezzo = new Attrezzo(nome,a);
		Iterator<Stanza> iteratore2 = this.Labirinto.lab.iterator();
		Stanza c = new Stanza("pappa");
		while(iteratore2.hasNext()) {
			c=iteratore2.next();
		}
		c.addAttrezzo(attrezzo);
		return this;
	}

	public Labirinto getLabirinto() {
		return this.Labirinto;
	}

}
