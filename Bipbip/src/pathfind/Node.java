package pathfind;

public class Node {
	
	private final double abscisse;
	private final double ordonnee;
	private final String nom;
	private final TypeNode type;
	
	public Node(double a, double o, String n, TypeNode t) {
		abscisse = a;
		ordonnee = o;
		nom = n;
		type = t;
	}

	public double getAbscisse() {
		return abscisse;
	}

	public double getOrdonnee() {
		return ordonnee;
	}
	
	public String getNom() {
		return nom;
	}

	public TypeNode getType() {
		return type;
	}
	
	public double calculerDistance(Node other) {
		return  Math.sqrt(Math.pow(this.abscisse - other.getAbscisse(), 2) 
				+ Math.pow(this.ordonnee - other.getOrdonnee(), 2));
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (Double.doubleToLongBits(abscisse) != Double
				.doubleToLongBits(other.abscisse))
			return false;
		if (Double.doubleToLongBits(ordonnee) != Double
				.doubleToLongBits(other.ordonnee))
			return false;
		return true;
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(abscisse);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(ordonnee);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	public String toString() {
		return (nom + " [" + abscisse + ", " + ordonnee + "]");
	}
	
}
