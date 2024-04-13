package it.uniroma3.diadia.giocatore;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Attrezzo[] attrezzi;
	public int numeroAttrezzi;
	private int pesoMax;


	public Borsa() {
		this.pesoMax = DEFAULT_PESO_MAX_BORSA;
		this.attrezzi = new Attrezzo[10]; // speriamo bastino...
		this.numeroAttrezzi = 0;
	}


	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		if (this.numeroAttrezzi==10)
			return false;
		this.attrezzi[this.numeroAttrezzi] = attrezzo;
		this.numeroAttrezzi++;
		return true;
	}


	public int getPesoMax() {
		return pesoMax;
	}


	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
				a = attrezzi[i];
		return a;
	}


	public int getPeso() {
		int peso = 0;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			peso += this.attrezzi[i].getPeso();
		return peso;
	}


	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}


	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}


	public boolean removeAttrezzo(String nomeAttrezzo) {
		boolean a = false;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			if (this.attrezzi[i].getNome().equals(nomeAttrezzo)) {
				attrezzi[i] = null;
				a = true;
				this.numeroAttrezzi--;
				break;
			}
		return a;
	}


	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (int i= 0; i<this.numeroAttrezzi; i++)
				s.append(attrezzi[i].toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
}
