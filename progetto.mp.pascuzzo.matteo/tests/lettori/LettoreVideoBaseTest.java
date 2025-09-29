package lettori;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

import contenuti.Video;

public class LettoreVideoBaseTest {

	@Test
	public void testRiproduci() {
		Video video = new Video("aVideo", 5, false, 0);
		LettoreVideo lettoreVideo = new LettoreVideoBase(video);

		assertThat(lettoreVideo.getInRiproduzione()).isFalse();

		lettoreVideo.riproduci();
		assertThat(lettoreVideo.getInRiproduzione()).isTrue();
	}

	@Test
	public void testPausa() {
		Video video = new Video("aVideo", 5, false, 0);
		LettoreVideo lettoreVideo = new LettoreVideoBase(video);

		lettoreVideo.riproduci();
		assertThat(lettoreVideo.getInRiproduzione()).isTrue();

		lettoreVideo.pausa();
		assertThat(lettoreVideo.getInRiproduzione()).isFalse();
	}

	@Test
	public void testGetInfoVideo() {
		Video video = new Video("aVideo", 5, false, 0);
		LettoreVideo lettoreVideo = new LettoreVideoBase(video);

		assertThat(lettoreVideo.getInfoVideo()).isEqualTo("Titolo: aVideo - Durata: 5");
	}

}
