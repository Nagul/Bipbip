package pathfind;

import java.util.ArrayList;
import java.util.Collections;

public class RechercheGraph {

	private Graph graph;

	public RechercheGraph(Graph g) {
		graph = g;
	}

	public Chemin plusCourtChemin(Node depart, Node arrive) {
		
		Chemin chemin = new Chemin();
		//initialisation
		//Q : liste triée des noeuds non encore optimisés.
		ArrayList<valeurNode> Q = new ArrayList<valeurNode>();
		valeurNode newVN;
		for (Node n : graph.getNodes()) {
			if (!n.equals(depart)) {
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
			
			//cas où les points restants sont innaccessible
			if (valeurNodeMin.getDistance() == Double.MAX_VALUE) {
				return null;
			}
			
			//cas où le Node destination est le minimal : fini
			if (valeurNodeMin.getNode().equals(arrive)) {
				valeurNode nodeChemin = valeurNodeMin;
				while (nodeChemin != null) {
					chemin.addEtape(nodeChemin.getNode());
					nodeChemin = nodeChemin.getPrecedent();
				}
				break;
			}
			
			//on enlève le noeud courant
			Q.remove(valeurNodeMin);

			Node nodeVoisin;
			for (Arc arcVoisin : graph.getArcs(valeurNodeMin.getNode())) {
				nodeVoisin = arcVoisin.getNodeArrive();
				for (valeurNode vnv : Q) {
					if (vnv.getNode().equals(nodeVoisin)) {
						double alt = valeurNodeMin.getDistance() + arcVoisin.getChemin().getDistance();
						if (alt < vnv.getDistance()) {
							vnv.setDistance(alt);
							vnv.setPrecedent(valeurNodeMin);
							Collections.sort(Q);
						}
					}
				}
			}
		}

		chemin.reverse();
		chemin.calculerDistance();
		return chemin;
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

