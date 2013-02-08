package pathfind;

public class Arc {
	
	private final Node nodeDepart;
	private final Node nodeArrive;
	private final int distance;
	
	public Arc(Node n1, Node n2, int d) {
		nodeDepart = n1;
		nodeArrive = n2;
		distance = d;
	}

	public Node getNodeDepart() {
		return nodeDepart;
	}

	public Node getNodeArrive() {
		return nodeArrive;
	}

	public int getDistance() {
		return distance;
	}
	
}
