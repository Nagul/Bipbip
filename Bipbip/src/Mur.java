
public class Mur {

	private final int debut;
	private final int fin;
	private final int epaisseur;
	
	public Mur(int d, int f, int e) {
		debut = d;
		fin = f;
		epaisseur = e;
	}
	
	public int getDebut() {
		return debut;
	}

	public int getFin() {
		return fin;
	}

	public int getEpaisseur() {
		return epaisseur;
	}
}
