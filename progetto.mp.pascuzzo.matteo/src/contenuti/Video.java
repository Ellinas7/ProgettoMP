package contenuti;

import lettori.LettoreVideo;
import lettori.LettoreVideoFactory;

public class Video implements Contenuto {

	private String titolo;
	private int durata;
	private int visualizzazioni;
	private boolean monetizzato;

	public Video(String titolo, int durata
			,boolean monetizzato, int visualizzazioni) {
		this.titolo = titolo;
		this.durata = durata;
		this.monetizzato = monetizzato;
		this.visualizzazioni = visualizzazioni;
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

	public int getVisualizzazioni() {
		return visualizzazioni;
	}

	@Override
	public void accept(ContenutoVisitor visitor) {
		visitor.visitVideo(this);
	}

	public void avviaRiproduzioneVideoConSottotitoli(String linguaSottotitoli) {
		visualizzazioni++;
		LettoreVideo videoConSottotitoli =
				LettoreVideoFactory.conSottotitoli(this, linguaSottotitoli);
		videoConSottotitoli.riproduci();
	}

	public void avviaRiproduzioneVideoConVolume(int volume) {
		visualizzazioni++;
		LettoreVideo videoConVolume =
				LettoreVideoFactory.conVolume(this, volume);
		videoConVolume.riproduci();
	}

}