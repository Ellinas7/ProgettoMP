package lettori;

public class VolumeDecorator extends LettoreVideoDecorator {

	private int volume;
	private boolean muto;

	public VolumeDecorator(LettoreVideo lettoreVideo,
			int volume) {
		super(lettoreVideo);
		this.muto = false;
		setVolume(volume);
	}

	@Override
	public void riproduci() {
		super.riproduci();
		setVolume(volume);
	}

	@Override
	public void pausa() {
		super.pausa();
		mutaVideo();
	}

	@Override
	public String getInfoVideo() {
		String volumeInfo = muto ? "Muto" : "" + volume;
		return super.getInfoVideo() + " - Volume: " + volumeInfo;
	}

	private void setVolume(int volume) {
		if(volume > 0 && volume <= 100) {
			this.volume = volume;
			this.muto = false;
		} else {
			this.muto = true;
			this.volume = 0;
		}
	}

	private void mutaVideo() {
		this.muto = true;
	}

}