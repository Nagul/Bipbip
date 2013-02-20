package pathfind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Graph {
	
	private HashMap<Node, ArrayList<Arc>> graph;
	
	public Graph() {
		graph = new HashMap<Node, ArrayList<Arc>>();
	}
	
	public HashMap<Node, ArrayList<Arc>> getGraph() {
		return graph;
	}

	public void addNode(Node n) {
		graph.put(n, new ArrayList<Arc>());
	}
	
	public void addArc(Arc a) {
		graph.get(a.getNodeDepart()).add(a);
		Arc ai = new Arc(a.getNodeArrive(), a.getNodeDepart(), a.getChemin());
		graph.get(a.getNodeArrive()).add(ai);
	}
	
	public Set<Node> getNodes() {
		return graph.keySet();
	}
	
	public ArrayList<Node> getVoisins(Node n) {
		ArrayList<Node> voisins = new ArrayList<Node>();
		for (Arc a : graph.get(n)) {
			voisins.add(a.getNodeArrive());
		}
		return voisins;
	}
	
	public ArrayList<Arc> getArcs(Node n) {
		return graph.get(n);
	}
	
	public Node rechercheNode(double aNode, double oNode) {
		Node nodeRecherche = new Node(aNode, oNode);
		for (Node n : graph.keySet()) {
			if (n.equals(nodeRecherche)) {
				return n;
			}
		}
		return null;
	}
	
	/*
	 * Supprimer les points du graphe non connexe au node nodeSource
	 */
	//TODO : OPTIMISER
	public void garderConnexe(Node nodeSource) {
		RechercheGraph rG = new RechercheGraph(this);
		HashMap<Node, ArrayList<Arc>> gClone = (HashMap<Node, ArrayList<Arc>>) graph.clone();
		Set<Node> kS = graph.keySet();
		for (Node n : gClone.keySet()) {
			if (rG.plusCourtChemin(nodeSource, n)==null) {
				kS.remove(n);
			}
		}
	}

}
