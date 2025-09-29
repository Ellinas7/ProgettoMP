package lettori;

public class SottotitoliDecorator extends LettoreVideoDecorator {

	private boolean sottotitoliAttivati;
	private String linguaSottotitoli;

	public SottotitoliDecorator(LettoreVideo lettoreVideo, 
			String linguaSottotitoli) {
		super(lettoreVideo);
		this.sottotitoliAttivati = true;
		this.linguaSottotitoli = linguaSottotitoli;
	}

	@Override
	public void riproduci() {
		super.riproduci();
		attivaSottotitoli();
	}

	@Override
	public void pausa() {
		super.pausa();
		disattivaSottotitoli();
	}

	@Override
	public String getInfoVideo() {
		String infoBase = super.getInfoVideo();
		if(sottotitoliAttivati) {
			return infoBase += " - Sottotitoli: " + linguaSottotitoli;
		}
		return infoBase + " - Sottotitoli: No";
	}

	private void attivaSottotitoli() {
		sottotitoliAttivati = true;
	}

	private void disattivaSottotitoli() {
		sottotitoliAttivati = false;
	}

}