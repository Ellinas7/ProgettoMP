package lettori;

import java.util.Objects;


import contenuti.Contenuto;

public class LettoreVideoBase implements LettoreVideo {

	private Contenuto contenuto;
	private boolean inRiproduzione;
	private String infoVideo;

	public LettoreVideoBase(Contenuto contenuto) {
		Objects.requireNonNull(contenuto, "Scegliere un contenuto da riprodurre");
		this.contenuto = contenuto;
		this.inRiproduzione = false;
	}

	@Override
	public void riproduci() {
		inRiproduzione = true;
	}

	@Override
	public void pausa() {
		if(inRiproduzione) {
			inRiproduzione = false;
		}
	}

	@Override
	public String getInfoVideo() {
		infoVideo = "Titolo: " + contenuto.getTitolo() + " - Durata: " + contenuto.getDurata();
		return infoVideo;
	}

	@Override
	public boolean getInRiproduzione() {
		return inRiproduzione;
	}

}