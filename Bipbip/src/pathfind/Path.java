package pathfind;

import java.util.ArrayList;

public class Path {

	private double distance;
	private ArrayList<Node> path;
	
	
	public Path() {
		distance = 0;
		path = new ArrayList<Node>();
	}
	
	/**
	 * Add a step to the path
	 * Update automatically the distance
	 * @param n the step to add
	 */
	public void addStep(Node n) {
		if (path.size() != 0) {
			distance += path.get(path.size() - 1).calculateDistance(n);
		}
		path.add(n);
	}
	
	public ArrayList<Node> getPath() {
		return path;
	}
	
	public double getDistance() {
		return distance;
	}
	
}
