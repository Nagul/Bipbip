package pathfind;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class rechercheGraph {

	private Graph graph;

	public rechercheGraph(Graph g) {
		graph = g;
	}

	public ArrayList<Node> plusCourtChemin(Node depart, Node arrive) {
		
		ArrayList<Node> chemin = new ArrayList<Node>();
		//initialisation
		//Q : liste tri�e des noeuds non encore optimis�s.
		ArrayList<valeurNode> Q = new ArrayList<valeurNode>();
		valeurNode newVN;
		for (Node n : graph.getNodes()) {
			if (!n.equals(depart)) {
				newVN = new valeurNode(n, Integer.MAX_VALUE, null);
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
			
			//cas o� les points restants sont innaccessible
			if (valeurNodeMin.getDistance() == Integer.MAX_VALUE) {
				throw new Error("Le robot ne peut atteindre cette destination");
			}
			
			//cas o� le Node destination est le minimal : fini
			if (valeurNodeMin.getNode().equals(arrive)) {
				valeurNode nodeChemin = valeurNodeMin;
				while (nodeChemin != null) {
					chemin.add(nodeChemin.getNode());
					nodeChemin = nodeChemin.getPrecedent();
				}
				break;
			}
			
			//on enl�ve le noeud courant
			Q.remove(valeurNodeMin);

			Node nodeVoisin;
			for (Arc arcVoisin : graph.getArcs(valeurNodeMin.getNode())) {
				nodeVoisin = arcVoisin.getNodeArrive();
				for (valeurNode vnv : Q) {
					if (vnv.getNode().equals(nodeVoisin)) {
						int alt = valeurNodeMin.getDistance() + arcVoisin.getDistance();
						if (alt < vnv.getDistance()) {
							vnv.setDistance(alt);
							vnv.setPrecedent(valeurNodeMin);
							Collections.sort(Q);
						}
					}
				}
			}
		}

		Collections.reverse(chemin);
		return chemin;
	}
	
	private class valeurNode implements Comparable<valeurNode>{
		
		private Node node;
		private int distance;
		private valeurNode precedent;
		
		public valeurNode(Node n, int d, valeurNode p) {
			node = n;
			distance = d;
			precedent = p;
		}

		public Node getNode() {
			return node;
		}
		
		public int getDistance() {
			return distance;
		}

		public valeurNode getPrecedent() {
			return precedent;
		}

		public void setDistance(int distance) {
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

