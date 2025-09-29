package model;

import java.util.Collection;
import java.util.Set;

import contenuti.Contenuto;
import contenuti.ModerazioneVisitor;
import contenuti.MonetizzazioneVisitor;

public class Canale {

	private final String idProprietario;
	private final Set<Utente> iscritti;
	private final Collection<Contenuto> contenutiPubblicati;

	public Canale(String idProprietario, Set<Utente> iscritti, 
			Collection<Contenuto> contenutiPubblicati) {
		this.idProprietario = idProprietario;
		this.iscritti = iscritti;
		this.contenutiPubblicati = contenutiPubblicati;
	}

	public String getIdProprietario() {
		return idProprietario;
	}

	public void iscrizione(Utente utente) {
		iscritti.add(utente);
	}

	public void disiscrizione(Utente utente) {
		iscritti.remove(utente);
	}

	private void inviaNotificaCaricamentoContenuto(Contenuto contenuto) {
		iscritti.forEach(i -> 
		i.notificaCaricamentoContenuto("Aggiunto nuovo contenuto: " + contenuto.getTitolo()));
	}

	public void pubblicaContenuto(Contenuto contenuto) {
		contenutiPubblicati.add(contenuto);
		inviaNotificaCaricamentoContenuto(contenuto);
	}

	public int calcolaGuadagni() {
		MonetizzazioneVisitor visitor = new MonetizzazioneVisitor();
		contenutiPubblicati.forEach(c -> c.accept(visitor));
		return visitor.getGuadagnoTotale();
	}

	public String valutaCanale() {
		ModerazioneVisitor visitor = new ModerazioneVisitor();
		contenutiPubblicati.forEach(c -> c.accept(visitor));
		return visitor.getRapportoContenuto();
	}

}