package lettori;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

import contenuti.Video;

public class SottotitoliDecoratorTest {

	@Test
	public void testGetInfoVideoSottotitoliAttivati() {
		Video video = new Video("aVideo", 5, false, 0);
		LettoreVideo lettoreVideo = new LettoreVideoBase(video);
		LettoreVideo lettoreVideoConSottotitoli = new SottotitoliDecorator(lettoreVideo,
				"IT");

		lettoreVideoConSottotitoli.riproduci();

		assertThat(lettoreVideoConSottotitoli.getInfoVideo()).isEqualTo("Titolo: aVideo - Durata: 5 - Sottotitoli: IT");
	}

	@Test
	public void testGetInfoVideoSottotitoliDisattivati() {
		Video video = new Video("aVideo", 5, false, 0);
		LettoreVideo lettoreVideo = new LettoreVideoBase(video);
		LettoreVideo lettoreVideoConSottotitoli = new SottotitoliDecorator(lettoreVideo,
				"IT");

		lettoreVideoConSottotitoli.pausa();

		assertThat(lettoreVideoConSottotitoli.getInfoVideo()).isEqualTo("Titolo: aVideo - Durata: 5 - Sottotitoli: No");
	}

}
