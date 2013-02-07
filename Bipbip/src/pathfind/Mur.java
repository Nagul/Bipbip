package pathfind;

public class Mur {

	//abscisse/ordonnee du coin en haut à gauche
	private final int abscisse;
	private final int ordonnee;
	//longueur : taille du mur suivant l'abscisse
	private final int longueur;
	//largeur : taille du mur suivant l'ordonnee
	private final int largeur;
	
	public Mur(int a, int o, int lo, int la) {
		abscisse = a;
		ordonnee = o;
		longueur = lo;
		largeur = la;
	}

	public int getAbscisse() {
		return abscisse;
	}

	public int getOrdonnee() {
		return ordonnee;
	}

	public int getLongueur() {
		return longueur;
	}

	public int getLargeur() {
		return largeur;
	}
	
}
