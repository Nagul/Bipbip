package pathfind;

import java.util.ArrayList;
import java.util.Collections;

public class GraphSearch {

	private Graph graph;

	public GraphSearch(Graph g) {
		graph = g;
	}

	/**
	 * Calculate the shorter path from node start to node target following Dijkstra's algorithm
	 * @param start the start Node
	 * @param target the target Node
	 * @return the shorter path if start and target are connected, otherwise null
	 */
	public ArrayList<Arc> shorterPath(Node start, Node target) {
		
		ArrayList<Arc> path = new ArrayList<Arc>();
		Arc arcCourant;
		//initialisation
		//Q : liste triee des noeuds non encore optimises.
		ArrayList<valeurNode> Q = new ArrayList<valeurNode>();
		valeurNode newVN;
		for (Node n : graph.getNodes()) {
			if (!n.equals(start)) {
				newVN = new valeurNode(n, Double.MAX_VALUE, null);
				Q.add(newVN);
			} else {
				newVN = new valeurNode(n, 0, null);
				Q.add(0, newVN);
			}
		}
		
		//boucle principale
		valeurNode valeurNodeMin;
		while (!Q.isEmpty()) {
			//recherche du noeud minimal
			valeurNodeMin = Q.get(0);
			
			//cas ou les points restants sont innaccessible
			if (valeurNodeMin.getDistance() == Double.MAX_VALUE) {
				return null;
			}
			
			//cas ou le Node destination est le minimal : fini
			if (valeurNodeMin.getNode().equals(target)) {
				valeurNode nodeChemin = valeurNodeMin;
				while (nodeChemin.getPrecedent() != null) {
					arcCourant = graph.getArc(nodeChemin.getPrecedent().getNode(), nodeChemin.getNode());
					path.add(arcCourant);
					nodeChemin = nodeChemin.getPrecedent();
				}
				break;
			}
			
			//on enlève le noeud courant
			Q.remove(valeurNodeMin);

			Node nodeVoisin;
			for (Arc arcVoisin : graph.getArcs(valeurNodeMin.getNode())) {
				nodeVoisin = arcVoisin.getNodeTarget();
				for (valeurNode vnv : Q) {
					if (vnv.getNode().equals(nodeVoisin)) {
						double alt = valeurNodeMin.getDistance() + arcVoisin.getPath().getDistance();
						if (alt < vnv.getDistance()) {
							vnv.setDistance(alt);
							vnv.setPrecedent(valeurNodeMin);
							Collections.sort(Q);
						}
					}
				}
			}
		}

		Collections.reverse(path);
		return path;
	}
	
	private class valeurNode implements Comparable<valeurNode>{
		
		private Node node;
		private double distance;
		private valeurNode precedent;
		
		public valeurNode(Node n, double d, valeurNode p) {
			node = n;
			distance = d;
			precedent = p;
		}

		public Node getNode() {
			return node;
		}
		
		public double getDistance() {
			return distance;
		}

		public valeurNode getPrecedent() {
			return precedent;
		}

		public void setDistance(double distance) {
			this.distance = distance;
		}

		public void setPrecedent(valeurNode precedent) {
			this.precedent = precedent;
		}
		
		public int compareTo(valeurNode other) {
			if (this.distance < other.getDistance()) {
				return -1;
			} else if (this.distance > other.getDistance()) {
				return 1;
			} else {
				return 0;
			}
		}
	}
	
}

