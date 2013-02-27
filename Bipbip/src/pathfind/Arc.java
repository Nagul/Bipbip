package pathfind;

public class Arc {
	
	private final Node nodeStart;
	private final Node nodeTarget;
	private final Path path;
	
	/**
	 * 
	 * @param nS the first node of the path
	 * @param nT the last node of the path
	 * @param p the path used by robots
	 */
	public Arc(Node nS, Node nT, Path p) {
		nodeStart = nS;
		nodeTarget = nT;
		path= p;
	}

	public Node getNodeStart() {
		return nodeStart;
	}

	public Node getNodeTarget() {
		return nodeTarget;
	}

	public Path getPath() {
		return path;
	}
	
	public String toString() {
		return "[" + nodeStart + " ," + nodeTarget + "]";
	}
	
	
	
}
