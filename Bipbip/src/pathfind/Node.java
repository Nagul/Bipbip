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
	
	public Node(double a, double o) {
		abscisse = a;
		ordonnee = o;
		nom = null;
		type = null;
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
	
	//TODO : utilite ?
	/**
	 * Fonction permettant de vérifier si un node d'un mur appartient
	 * au voisinage d'un autre mur ou pas.
	 * @param murTest le mur auquel le node appartient
	 * @return le mur auquel le node appartient
	 */
	public Mur appartientAutreMur(Mur murTest) {
		for (Mur m : affichage.Bipbip.murs) {
			if((this.equals(m.getBoutDebut())
					||this.equals(m.getBoutFin())
					||this.calculerDistance(m.getBoutDebut()) + this.calculerDistance(m.getBoutFin()) < m.getBoutDebut().calculerDistance(m.getBoutFin()) + 1
					)&&!murTest.equals(m)) {
				return m;
			}
		}
		return null;
	}
	
	/*
	 * calcul l'angle formé avec un autre node par rapport aux conventions
	 */
	//TODO : tester
	public int angleAutreNode(Node autreNode) {
		double a = this.getAbscisse() - autreNode.getAbscisse();
		double b = this.getOrdonnee() - autreNode.getOrdonnee();
		double q = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
		double[] directeur = new double[2];
		directeur[0] = -a/q;
		directeur[1] = -b/q;
		if (directeur[1]<= 0) {
			return (int) (Math.acos(directeur[0])*360/(2*Math.PI));
		} else {
			return (int) (360 - Math.acos(directeur[0])*360/(2*Math.PI));
		}
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
