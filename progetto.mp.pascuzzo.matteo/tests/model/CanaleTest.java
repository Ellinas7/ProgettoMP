package model;

import static org.assertj.core.api.Assertions.*;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import contenuti.*;

public class CanaleTest {

	@Test
	public void testInviaNotificaCaricamentoVideo() {
		Set<Canale> iscrizioniUtente1 = new HashSet<>();
		Collection<String> notificheUtente1 = new ArrayList<>();
		Utente utente1 = new Utente(null, iscrizioniUtente1, notificheUtente1, null);

		Set<Utente> iscrittiCanale = new HashSet<>();
		Collection<Contenuto> videoCanaleProva = new ArrayList<>();
		Canale canaleProva = new Canale("01", iscrittiCanale, videoCanaleProva);
		Utente creator = new Utente("01", null, null, canaleProva);

		Video video = new Video("aVideo", 5, false, 0);
		Video video2 = new Video("anotherVideo", 10, false, 0);

		utente1.iscrivitiAlCanale(canaleProva);
		creator.caricaContenuto(video);
		assertThat(notificheUtente1.contains("Aggiunto nuovo contenuto: " + video.getTitolo())).isTrue();

		utente1.disiscrivitiDalCanale(canaleProva);
		creator.caricaContenuto(video2);
		assertThat(notificheUtente1.contains(video2.getTitolo())).isFalse();
	}

	@Test
	public void testCalcolaGuadagniTuttoMonetizzato() {
		Collection<Contenuto> contenutiCanale = new ArrayList<>();

		Video video = new Video(null, 100, true, 2000);
		Live live = new Live(null, 0, 1000, true, 50);
		Collection<Video> videoPlaylist = new ArrayList<>();
		Video video1 = new Video(null, 0, false, 200);
		Video video2 = new Video(null, 0, false, 300);
		Playlist playlist = new Playlist(null, videoPlaylist, 0, 0, true);
		playlist.aggiungiVideo(video1);
		playlist.aggiungiVideo(video2);

		contenutiCanale.add(video);
		contenutiCanale.add(live);
		contenutiCanale.add(playlist);

		Canale canale = new Canale(null, null, contenutiCanale);

		assertThat(canale.calcolaGuadagni()).isEqualTo(15);
	}

	@Test
	public void testValutaCanale() {
		Collection<Contenuto> contenutiCanale = new ArrayList<>();

		Video video = new Video("aScamVideo", 100, true, 0);
		Live live = new Live("aLive", 200, 1000, true, 2000);
		Collection<Video> videoPlaylist = new ArrayList<>();
		Video video1 = new Video(null, 3700, false, 3500);
		Video video2 = new Video(null, 0, false, 300);
		Playlist playlist = new Playlist("aPlaylist", videoPlaylist, 0, 0, true);
		playlist.aggiungiVideo(video1);
		playlist.aggiungiVideo(video2);

		contenutiCanale.add(video);
		contenutiCanale.add(live);
		contenutiCanale.add(playlist);

		Canale canale = new Canale(null, null, contenutiCanale);

		assertThat(canale.valutaCanale())
		.isEqualTo("TIPO: Video\n" +
				"Titolo: aScamVideo\n" +
				"Durata: 100\n" +
				"Il Titolo contiene la parola vietata scam\n"+
				"fine valutazione video\n" +
				"TIPO: Live\n" +
				"Titolo: aLive\n" +
				"Durata: 200\n"+
				"Alto tasso di donazioni: 2000\n"+
				"fine valutazione live\n" +
				"TIPO: Playlist\n" +
				"Titolo: aPlaylist\n" +
				"Durata: 3700\n" +
				"Durata playlist elevata: controllo manuale richiesto\n" +
				"fine valutazione playlist\n");
	}

}