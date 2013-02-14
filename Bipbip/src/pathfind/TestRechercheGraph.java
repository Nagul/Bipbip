package pathfind;

import java.util.ArrayList;

public class TestRechercheGraph {
	
	public static ArrayList<Mur> murs;
	
	public static void main(String[] args) {
		
		/*TEST DJISTRUC : OK
		Node n1 = new Node(0, 0, "n1", null);
		Node n2 = new Node(0, 1, "n2", null);
		Node n3 = new Node(1, 0, "n3", null);
		Node n4 = new Node(1, 1, "n4", null);
		Node n5 = new Node(2, 1, "n5", null);
		
		Arc a1 = new Arc(n2, n1, 2, null);
		Arc a2 = new Arc(n1, n3, 4, null);
		Arc a3 = new Arc(n2, n3, 1, null);
		Arc a4 = new Arc(n2, n4, 5, null);
		Arc a5 = new Arc(n3, n4, 3, null);
		Arc a6 = new Arc(n1, n5, 1, null);
		Arc a7 = new Arc(n5, n4, 6, null);
		
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
		graph.addArc(a6);
		graph.addArc(a7);
		
		rechercheGraph rG = new rechercheGraph(graph);
		System.out.println(rG.plusCourtChemin(n1, n5));
		*/
		
		/*
		Node n1 = new Node(0, 0, "n1", null);
		Node n2 = new Node(1, 1, "n2", null);
		Chemin ch = new Chemin();
		ch.addEtape(n1);
		ch.addEtape(n2);
		ch.calculerDistance();
		System.out.println(ch.getDistance());
		*/
		
		/*
		Node porte = new Node(5, 0, "porteTest", new TypePorte("0"));
		ArrayList<Node> portes = new ArrayList<Node>();
		portes.add(porte);
		*/

		Node n1 = new Node(0, 0);
		Node n2 = new Node(50, 0);
		Node n3 = new Node(50, 0);

					
		//Mur m1 = new Mur(n1, n2, 3, null, "mH");
		//Mur m2 = new Mur(n1, n3, 2, null, "mV");
		//System.out.println(m1.ecartDirection(m2));

	}

}
