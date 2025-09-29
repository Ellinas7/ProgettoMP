package contenuti;

import lettori.LettoreVideo;
import lettori.LettoreVideoFactory;

public class Live implements Contenuto {

	private String titolo;
	private int durata;
	private int spettatori;
	private boolean monetizzato;
	private int donazioni;

	public Live(String titolo, int durata,
			int spettatori, boolean monetizzato, 
			int donazioni) {
		this.titolo = titolo;
		this.durata = durata;
		this.spettatori = spettatori;
		this.monetizzato = monetizzato;
		this.donazioni = donazioni;
	}

	@Override
	public String getTitolo() {
		return titolo;
	}

	@Override
	public boolean isMonetizzato() {
		return monetizzato;
	}

	@Override
	public int getDurata() {
		return durata;
	}

	public int getSpettatori() {
		return spettatori;
	}

	public int getDonazioni() {
		return donazioni;
	}

	@Override
	public void accept(ContenutoVisitor visitor) {
		visitor.visitLive(this);
	}

	public void avviaRiproduzioneLiveConSottotitoli(String linguaSottotitoli) {
		spettatori++;
		LettoreVideo liveConSottotitoli =
				LettoreVideoFactory.conSottotitoli(this, linguaSottotitoli);
		liveConSottotitoli.riproduci();
	}

	public void avviaRiproduzioneLiveConVolume(int volume) {
		spettatori++;
		LettoreVideo liveConVolume =
				LettoreVideoFactory.conVolume(this, volume);
		liveConVolume.riproduci();
	}

}
