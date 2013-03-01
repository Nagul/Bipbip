package pathfind;

public class Node {
	
	private final double abscissa;
	private final double ordinate;
	private final String name;
	private final TypeNode type;
	
	/**
	 * 
	 * @param a the abscissa of the node
	 * @param o the ordinate of the node
	 * @param n the name of the node
	 * @param t the type of the node
	 */
	public Node(double a, double o, String n, TypeNode t) {
		abscissa = a;
		ordinate = o;
		name = n;
		type = t;
	}
	
	/**
	 * Create a new Node without name or type
	 * @param a the abscissa of the node
	 * @param o the ordinate of the node
	 */
	public Node(double a, double o) {
		abscissa = a;
		ordinate = o;
		name = null;
		type = null;
	}

	public double getAbscissa() {
		return abscissa;
	}

	public double getOrdinate() {
		return ordinate;
	}
	
	public String getName() {
		return name;
	}

	public TypeNode getType() {
		return type;
	}
	
	/**
	 * Calculate the euclidean distance between this node and another node
	 * @param otherNode
	 * @return the euclidean distance between this node and another node
	 */
	public double calculateDistance(Node otherNode) {
		return  Math.sqrt(Math.pow(this.abscissa - otherNode.getAbscissa(), 2) 
				+ Math.pow(this.ordinate - otherNode.getOrdinate(), 2));
	}
	
	//TODO : utilite ?
	/**
	 * Fonction permettant de verifier si un node d'un mur appartient
	 * au voisinage d'un autre mur ou pas.
	 * @param murTest le mur auquel le node appartient
	 * @return le mur auquel le node appartient
	 */
	public Wall appartientAutreMur(Wall murTest) {
		for (Wall m : affichage.Bipbip.walls) {
			if((this.equals(m.getCornerStart())
					||this.equals(m.getCornerEnd())
					||this.calculateDistance(m.getCornerStart()) + this.calculateDistance(m.getCornerEnd()) < m.getCornerStart().calculateDistance(m.getCornerEnd()) + 1
					)&&!murTest.equals(m)) {
				return m;
			}
		}
		return null;
	}

	/**
	 * Calculate the angle formed between the abscissa axis and the vector (thisNode, otherNode)
	 * @param otherNode the other node to define the vector
	 * @return the angle formed between the abscissa axis and the vector (thisNode, otherNode)
	 */
	public int angleAutreNode(Node otherNode) {
		double a = otherNode.getAbscissa() - this.abscissa;
		double b = otherNode.getOrdinate() - this.ordinate;
		double q = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
		double[] directeur = new double[2];
		directeur[0] = a/q;
		directeur[1] = b/q;
		if (directeur[1] >= 0) {
			return (int) (Math.acos(directeur[0])*360/(2*Math.PI));
		} else {
			return (int) (360-Math.acos(directeur[0])*360/(2*Math.PI));
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (Double.doubleToLongBits(abscissa) != Double
				.doubleToLongBits(other.abscissa))
			return false;
		if (Double.doubleToLongBits(ordinate) != Double
				.doubleToLongBits(other.ordinate))
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(abscissa);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(ordinate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	@Override
	public String toString() {
		return (name + " [" + abscissa + ", " + ordinate + "]");
	}
	
}
