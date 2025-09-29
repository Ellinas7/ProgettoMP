package lettori;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

import contenuti.Video;

public class VolumeDecoratorTest {

	@Test
	public void testGetInfoNonMuto() {
		Video video = new Video("aVideo", 5, false, 0);
		LettoreVideo lettoreVideo = new LettoreVideoBase(video);
		LettoreVideo lettoreVideoConVolume = new VolumeDecorator(lettoreVideo, 50);

		lettoreVideoConVolume.riproduci();

		assertThat(lettoreVideoConVolume.getInfoVideo()).isEqualTo("Titolo: aVideo - Durata: 5 - Volume: 50");
	}

	@Test
	public void testGetInfoMuto() {
		Video video = new Video("aVideo", 5, false, 0);
		LettoreVideo lettoreVideo = new LettoreVideoBase(video);
		LettoreVideo lettoreVideoConVolume = new VolumeDecorator(lettoreVideo, 50);

		lettoreVideoConVolume.pausa();

		assertThat(lettoreVideoConVolume.getInfoVideo()).isEqualTo("Titolo: aVideo - Durata: 5 - Volume: Muto");
	}

}
