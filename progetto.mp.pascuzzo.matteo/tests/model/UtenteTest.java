package model;

import static org.assertj.core.api.Assertions.*;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import contenuti.*;

public class UtenteTest {

	@Test
	public void testIscrivitiAlCanaleNonAncoraIscritto() {
		Set<Canale> iscrizioniUtente1 = new HashSet<>();
		Utente utente1 = new Utente(null, iscrizioniUtente1, null, null);

		Set<Utente> iscrittiCanale = new HashSet<>();
		Collection<Contenuto> videoCanaleProva = new ArrayList<>();
		Canale canaleProva = new Canale(null, iscrittiCanale, videoCanaleProva);

		assertThat(iscrittiCanale.isEmpty()).isTrue();

		utente1.iscrivitiAlCanale(canaleProva);
		assertThat(iscrittiCanale.contains(utente1)).isTrue();
	}

	@Test
	public void testIscrivitiAlCanaleGiaIscritto() {
		Set<Canale> iscrizioniUtente1 = new HashSet<>();
		Utente utente1 = new Utente(null, iscrizioniUtente1, null, null);

		Set<Utente> iscrittiCanale = new HashSet<>();
		Collection<Contenuto> videoCanaleProva = new ArrayList<>();
		Canale canaleProva = new Canale(null, iscrittiCanale, videoCanaleProva);

		assertThat(iscrittiCanale.isEmpty()).isTrue();

		utente1.iscrivitiAlCanale(canaleProva);
		assertThat(iscrittiCanale.contains(utente1)).isTrue();

		utente1.iscrivitiAlCanale(canaleProva);
		assertThat(iscrittiCanale.size()).isEqualTo(1);
	}

	@Test
	public void testDisiscrivitiDalCanaleIscritto() {
		Set<Canale> iscrizioniUtente1 = new HashSet<>();
		Utente utente1 = new Utente(null, iscrizioniUtente1, null, null);

		Set<Utente> iscrittiCanale = new HashSet<>();
		Collection<Contenuto> videoCanaleProva = new ArrayList<>();
		Canale canaleProva = new Canale(null, iscrittiCanale, videoCanaleProva);

		utente1.iscrivitiAlCanale(canaleProva);
		assertThat(iscrittiCanale.contains(utente1)).isTrue();

		utente1.disiscrivitiDalCanale(canaleProva);
		assertThat(iscrittiCanale.contains(utente1)).isFalse();
	}


	@Test
	public void testDisiscrivitiDalCanaleNonIscritto() {
		Set<Canale> iscrizioniUtente1 = new HashSet<>();
		Utente utente1 = new Utente(null, iscrizioniUtente1, null, null);

		Set<Utente> iscrittiCanale = new HashSet<>();
		Collection<Contenuto> videoCanaleProva = new ArrayList<>();
		Canale canaleProva = new Canale(null, null, videoCanaleProva);

		assertThat(iscrittiCanale.isEmpty()).isTrue();

		utente1.disiscrivitiDalCanale(canaleProva);
		assertThat(iscrittiCanale.isEmpty()).isTrue();
	}

	@Test
	public void testCaricaContenuto() {
		Video video = new Video("aVideo", 5, false, 0);
		Collection<Contenuto> videoPubblicati = new ArrayList<>();
		Set<Utente> iscrittiCanale = new HashSet<>();
		Canale canaleProva = new Canale("01", iscrittiCanale, videoPubblicati);
		Utente creator = new Utente("01", null, null, canaleProva);

		assertThat(videoPubblicati.isEmpty()).isTrue();

		creator.caricaContenuto(video);
		assertThat(videoPubblicati.contains(video)).isTrue();
	}

	@Test
	public void testCaricaContenutoIdNonUguali() {
		Video video = new Video("aVideo", 5, false, 0);
		Collection<Contenuto> videoPubblicati = new ArrayList<>();
		Set<Utente> iscrittiCanale = new HashSet<>();
		Collection<String> notificheCanaleProva = new ArrayList<>();
		Canale canaleProva = new Canale("01", iscrittiCanale, videoPubblicati);
		Utente creator = new Utente("02", null, notificheCanaleProva, canaleProva);

		assertThat(videoPubblicati.isEmpty()).isTrue();

		creator.caricaContenuto(video);
		assertThat(videoPubblicati.contains(video)).isFalse();
	}

}
