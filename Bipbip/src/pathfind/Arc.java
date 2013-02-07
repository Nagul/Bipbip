package pathfind;

public class Arc {
	
	private final Node node1;
	private final Node node2;
	private final int distance;
	
	public Arc(Node n1, Node n2, int d) {
		node1 = n1;
		node2 = n2;
		distance = d;
	}

}
