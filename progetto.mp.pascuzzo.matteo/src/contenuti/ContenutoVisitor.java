package contenuti;

public interface ContenutoVisitor {
	
	void visitVideo(Video video);
	
	void visitLive(Live live);
	
	void visitPlaylist(Playlist playlist);

}
