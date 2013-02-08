package pathfind;

public class TestRechercheGraph {
	
	public static void main(String[] args) {
	
		Node n1 = new Node(0, 0, "n1");
		Node n2 = new Node(0, 1, "n2");
		Node n3 = new Node(1, 0, "n3");
		Node n4 = new Node(1, 1, "n4");
		Node n5 = new Node(2, 1, "n5");
		Arc a1 = new Arc(n2, n1, 2);
		Arc a2 = new Arc(n1, n3, 4);
		Arc a3 = new Arc(n2, n3, 1);
		Arc a4 = new Arc(n2, n4, 5);
		Arc a5 = new Arc(n3, n4, 3);
		Arc a6 = new Arc(n1, n5, 1);
		Arc a7 = new Arc(n5, n4, 6);
		
		Graph graph = new Graph();
		graph.addNode(n1);
		graph.addNode(n2);
		graph.addNode(n3);
		graph.addNode(n4);
		graph.addNode(n5);
		graph.addArc(a1);
		graph.addArc(a2);
		graph.addArc(a3);
		graph.addArc(a4);
		graph.addArc(a5);
		
		rechercheGraph rG = new rechercheGraph(graph);
		System.out.println(rG.plusCourtChemin(n1, n5));
		
	}

}
