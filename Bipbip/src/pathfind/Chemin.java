package pathfind;

import java.util.ArrayList;

public class Chemin {

	private double distance;
	private ArrayList<Node> chemin;
	
	
	public Chemin() {
		distance = 0;
		chemin = new ArrayList<Node>();
	}
	
	public void addEtape(Node n) {
		chemin.add(n);
	}
	
	public void calculerDistance() {
		for (int i = 0; i < chemin.size() - 1; i++) {
			distance += chemin.get(i).calculerDistance(chemin.get(i + 1));
		}
	}
	
	public ArrayList<Node> getChemin() {
		return chemin;
	}
	
	public double getDistance() {
		return distance;
	}

	//TODO : utilité ?
	public Node getDepart() {
		return chemin.get(0);
	}

	public Node getArrivee() {
		return chemin.get(chemin.size() - 1);
	}
	
	
	
}
