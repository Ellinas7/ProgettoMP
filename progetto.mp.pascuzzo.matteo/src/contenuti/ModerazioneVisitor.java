package contenuti;

import java.util.Set;

public class ModerazioneVisitor implements ContenutoVisitor{

	private static final Set<String> PAROLE_VIETATE =
			Set.of("clickbait", "fake", "scam", "spam", "truffa", "virus", "hack");

	private StringBuilder rapporto;

	public ModerazioneVisitor() {
		this.rapporto = new StringBuilder();
	}

	@Override
	public void visitVideo(Video video) {
		rapporto.append("TIPO: Video\n" +
				"Titolo: " + video.getTitolo() + "\n" +
				"Durata: " + video.getDurata() + "\n");
		String titoloLowerCase = video.getTitolo().toLowerCase();
		for (String parolaVietata : PAROLE_VIETATE) {
			if (titoloLowerCase.contains(parolaVietata.toLowerCase())) {
				rapporto.append("Il Titolo contiene la parola vietata " + parolaVietata + "\n");
			}
		}
		if (video.getDurata() > 600) {
			rapporto.append("Lunghezza video eccessiva\n");
		}
		rapporto.append("fine valutazione video\n");
	}

	@Override
	public void visitLive(Live live) {
		rapporto.append("TIPO: Live\n" +
				"Titolo: " + live.getTitolo() + "\n" +
				"Durata: " + live.getDurata() + "\n");
		if (live.getSpettatori() > 10000) {
			rapporto.append("Live con molti spettatori: necessaria monitorizzazione umana\n");
		}
		if (live.getDonazioni() > 1000) {
			rapporto.append("Alto tasso di donazioni: "+ live.getDonazioni() + "\n");
		}
		rapporto.append("fine valutazione live\n");
	}

	@Override
	public void visitPlaylist(Playlist playlist) {
		rapporto.append("TIPO: Playlist\n" +
				"Titolo: " + playlist.getTitolo() + "\n" +
				"Durata: " + playlist.getDurata() + "\n");
		if (playlist.getNumeroVideo() > 100) {
			rapporto.append("Numero video playlist elevato: possibile sospetto spam\n");
		}
		if (playlist.getDurata() > 3600) {
			rapporto.append("Durata playlist elevata: controllo manuale richiesto\n");
		}
		rapporto.append("fine valutazione playlist\n");
	}

	public String getRapportoContenuto() {
		return rapporto.toString();
	}

}