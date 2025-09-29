package contenuti;

import java.util.Collection;

public class Playlist implements Contenuto {

	private String titolo;
	private Collection<Video> videoInPlaylist;
	private int durata;
	private int visualizzazioniTotali;
	private boolean monetizzato;

	public Playlist(String titolo, Collection<Video> videoInPlaylist,
			int durata, int visualizzazioniTotali,
			boolean monetizzato) {
		this.titolo = titolo;
		this.videoInPlaylist = videoInPlaylist;
		this.durata = durata;
		this.visualizzazioniTotali = visualizzazioniTotali;
		this.monetizzato = monetizzato;
	}

	public String getTitolo() {
		return titolo;
	}

	@Override
	public boolean isMonetizzato() {
		return monetizzato;
	}

	public int getDurata() {
		durata = calcolaDurataPlaylist();
		return durata;
	}

	public void aggiungiVideo(Video video) {
		videoInPlaylist.add(video);
		visualizzazioniTotali = getVisualizzazioniTotali();
		durata = getDurata();
	}

	public int getNumeroVideo() {
		return videoInPlaylist.size();
	}

	public int getVisualizzazioniTotali() {
		visualizzazioniTotali = calcolaVisualizzazioniPlaylist();
		return visualizzazioniTotali;
	}

	//package-private ai fini di test
	int calcolaVisualizzazioniPlaylist() {
		return videoInPlaylist.stream()
				.mapToInt(Video::getVisualizzazioni).sum();
	}

	//package-private ai fini di test
	int calcolaDurataPlaylist() {
		return videoInPlaylist.stream()
				.mapToInt(Video::getDurata).sum();
	}

	@Override
	public void accept(ContenutoVisitor visitor) {
		visitor.visitPlaylist(this);
	}

	public void avviaRiproduzionePlaylistConSottotitoli(String linguaSottotitoli) {
		videoInPlaylist.forEach(v -> v.avviaRiproduzioneVideoConSottotitoli(linguaSottotitoli));
	}

	public void avviaRiproduzionePlaylistConVolume(int volume) {
		videoInPlaylist.forEach(v -> v.avviaRiproduzioneVideoConVolume(volume));
	}
	
}