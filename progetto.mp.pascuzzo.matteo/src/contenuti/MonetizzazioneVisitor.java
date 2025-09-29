package contenuti;

public class MonetizzazioneVisitor implements ContenutoVisitor {
	
	private static final int GUADAGNO_MILLE_VIEWS_VIDEO = 4;
	private static final int GUADAGNO_MILLE_VIEWS_PLAYLIST = 3;
	private static final int PERCENTUALE_DONAZIONI = 10;
	private static final int GUADAGNO_MILLE_SPETTATORE = 2;

	private int guadagnoTotale;

	public MonetizzazioneVisitor() {
		this.guadagnoTotale = 0;
	}

	@Override
	public void visitVideo(Video video) {
		if(video.isMonetizzato() && video.getDurata() >= 60) {
			int guadagnoVideo = (video.getVisualizzazioni() / 1000) 
					* GUADAGNO_MILLE_VIEWS_VIDEO;
			guadagnoTotale += guadagnoVideo;
		}
	}

	@Override
	public void visitLive(Live live) {
		if(live.isMonetizzato()) {
			int guadagnoSpettatori = (live.getSpettatori() * GUADAGNO_MILLE_SPETTATORE) / 1000;
			int guadagnoDonazioni = live.getDonazioni() / PERCENTUALE_DONAZIONI;
			guadagnoTotale += guadagnoSpettatori + guadagnoDonazioni;
		}
	}

	@Override
	public void visitPlaylist(Playlist playlist) {
		if(playlist.isMonetizzato()) {
			int guadagnoPlaylist = (playlist.getVisualizzazioniTotali() / 1000) 
					* GUADAGNO_MILLE_VIEWS_PLAYLIST;
			guadagnoTotale += guadagnoPlaylist;
		}
	}
	
	public int getGuadagnoTotale() {
		return guadagnoTotale;
	}

}