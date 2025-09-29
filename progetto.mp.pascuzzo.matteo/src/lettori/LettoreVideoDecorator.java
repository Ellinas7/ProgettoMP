package lettori;

import java.util.Objects;

public abstract class LettoreVideoDecorator implements LettoreVideo {

	private LettoreVideo lettoreVideo;

	protected LettoreVideoDecorator(LettoreVideo lettoreVideo) {
		Objects.requireNonNull(lettoreVideo, "L'oggetto decorato non può essere null");
		this.lettoreVideo = lettoreVideo;
	}

	@Override
	public void riproduci() {
		lettoreVideo.riproduci();
	}

	@Override
	public void pausa() {
		lettoreVideo.pausa();
	}

	@Override
	public String getInfoVideo() {
		return lettoreVideo.getInfoVideo();
	}

	@Override
	public boolean getInRiproduzione() {
		return lettoreVideo.getInRiproduzione();
	}

}