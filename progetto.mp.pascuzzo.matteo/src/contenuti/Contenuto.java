package contenuti;

public interface Contenuto {

	String getTitolo();
	
	int getDurata();
	
	boolean isMonetizzato();
	
	void accept(ContenutoVisitor visitor);

}