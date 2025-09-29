package model;

import java.util.Collection;

import java.util.Set;

import contenuti.Contenuto;

public class Utente {

	private String idUtente;
	private Set<Canale> iscrizioni;
	private Collection<String> notifiche;
	private Canale canale;

	public Utente(String idUtente, Set<Canale> iscrizioni, 
			Collection<String> notifiche, Canale canale) {
		this.idUtente = idUtente;
		this.iscrizioni = iscrizioni;
		this.notifiche = notifiche;
		this.canale = canale;
	}

	public void iscrivitiAlCanale(Canale canale) {
		if(iscrizioni.add(canale)) {
			canale.iscrizione(this);
		}
	}

	public void disiscrivitiDalCanale(Canale canale) {
		if(iscrizioni.remove(canale)) {
			canale.disiscrizione(this);
		}
	}

	public void notificaCaricamentoContenuto(String titolo) {
		notifiche.add(titolo);
	}

	public void caricaContenuto(Contenuto contenuto) {
		if(canale.getIdProprietario().equals(this.idUtente)) {
			canale.pubblicaContenuto(contenuto);
		} else {
			notifiche.add("Impossibile caricare il contenuto: " + contenuto.getTitolo());
		}
	}

	public int calcolaGuadagniCanale(Canale canale) {
		return canale.calcolaGuadagni();
	}

	public String riceviValutazioneCanale(Canale canale) {
		return canale.valutaCanale();
	}

}