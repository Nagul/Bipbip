package pathfind;

public class Node {
	
	private final int abscisse;
	private final int ordonnee;
	private final String nom;
	
	public Node(int a, int o, String n) {
		abscisse = a;
		ordonnee = o;
		nom = n;
	}

	public int getAbscisse() {
		return abscisse;
	}

	public int getOrdonnee() {
		return ordonnee;
	}
	
	public String getNom() {
		return nom;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (abscisse != other.abscisse)
			return false;
		if (ordonnee != other.ordonnee)
			return false;
		return true;
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + abscisse;
		result = prime * result + ordonnee;
		return result;
	}
	
	public String toString() {
		return (nom + " [" + abscisse + ", " + ordonnee + "]");
	}
	
}
