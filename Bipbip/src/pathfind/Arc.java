package pathfind;

public class Arc {
	
	private final Node nodeDepart;
	private final Node nodeArrive;
	private final Chemin chemin;
	
	public Arc(Node n1, Node n2, Chemin c) {
		nodeDepart = n1;
		nodeArrive = n2;
		chemin = c;
	}

	public Node getNodeDepart() {
		return nodeDepart;
	}

	public Node getNodeArrive() {
		return nodeArrive;
	}

	public Chemin getChemin() {
		return chemin;
	}
	
}
