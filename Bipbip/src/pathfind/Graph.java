package pathfind;

import java.util.ArrayList;
import java.util.HashMap;

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
	
	public void addArc(Node n, Arc a) {
		ArrayList<Arc> listArc = graph.get(n);
		listArc.add(a);
	}

}
