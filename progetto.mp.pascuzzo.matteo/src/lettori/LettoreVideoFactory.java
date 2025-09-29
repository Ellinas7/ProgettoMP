package lettori;

import contenuti.Contenuto;

public final class LettoreVideoFactory {

	private LettoreVideoFactory() {
	}

	public static LettoreVideo conSottotitoli(Contenuto contenuto, String linguaSottotitoli) {
		return new SottotitoliDecorator(new LettoreVideoBase(contenuto), linguaSottotitoli);
	}

	public static LettoreVideo conVolume(Contenuto contenuto, int volume) {
		return new VolumeDecorator(new LettoreVideoBase(contenuto), volume);
	}
	
}