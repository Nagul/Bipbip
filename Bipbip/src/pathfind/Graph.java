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

	public Set<Node> getNodes() {
		return graph.keySet();
	}
	
	public ArrayList<Arc> getArcs(Node n) {
		return graph.get(n);
	}
	
	/**
	 * Add a node to the graph
	 * @param n the node to add
	 */
	public void addNode(Node n) {
		graph.put(n, new ArrayList<Arc>());
	}
	
	/**
	 * Add a arc to the graph
	 * @param a the arc to add
	 */
	public void addArc(Arc a) {
		graph.get(a.getNodeStart()).add(a);
		//Arc ai = new Arc(a.getNodeTarget(), a.getNodeStart(), a.getPath());
		//graph.get(a.getNodeTarget()).add(ai);
	}
	
	//Depreciated ?
	public ArrayList<Node> getVoisins(Node n) {
		ArrayList<Node> voisins = new ArrayList<Node>();
		for (Arc a : graph.get(n)) {
			voisins.add(a.getNodeTarget());
		}
		return voisins;
	}

	public Arc getArcsEnd(Node n) {
		for (ArrayList<Arc> aA : graph.values()) {
			for (Arc a : aA) {
				if (a.getNodeTarget()==n) {
					return a;
				}
			}
		}
		return null;
	}

	public Arc getArc (Node start, Node end) {
		for (Arc a : graph.get(start)) {
			if (a.getNodeTarget()==end) {
				return a;
			}
		}
		return null;
	}
	
	
	/**
	 * Search for a node with a certain abscissa and ordinate
	 * @param aNode the abscissa of the node to look for
	 * @param oNode the ordinate of the node to look for
	 * @return the node if found, otherwise null
	 */
	public Node searchNode(double aNode, double oNode) {
		Node nodeRecherche = new Node(aNode, oNode);
		for (Node n : graph.keySet()) {
			if (n.equals(nodeRecherche)) {
				return n;
			}
		}
		return null;
	}
	
	/**
	 * keep only the nodes connected to the node root
	 * @param nodeRoot the node root
	 */
	//TODO : OPTIMISE
	public void keepConnected(Node nodeRoot) {
		GraphSearch rG = new GraphSearch(this);
		@SuppressWarnings("unchecked")
		HashMap<Node, ArrayList<Arc>> gClone = (HashMap<Node, ArrayList<Arc>>) graph.clone();
		Set<Node> kS = graph.keySet();
		for (Node n : gClone.keySet()) {
			if (rG.shorterPath(nodeRoot, n)==null) {
				kS.remove(n);
			}
		}
	}

}
