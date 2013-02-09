package pathfind;

import java.util.ArrayList;
import java.util.Vector;

public class generateurGraph {
	
	private Graph graph;
	private ArrayList<Node> nodes;
	
	public generateurGraph(ArrayList<Node> n) {
		graph = new Graph();
		nodes = n;//nodes utilisateurs
	}
	
	/**
	 * Cr�e les ar�tes du graphe � partir des sommets.
	 * @return graph connexe
	 */
	public Graph generationGraph() {
		
		//TODO : virer les points superflus
		//g�n�ration initiale
		//TODO : virer pour les tests
		for (Mur m : TestRechercheGraph.murs) {
			Vector<Double> normale = m.getNormale();
			double aPorte;
			double oPorte;
			for (Node porte : m.getPortes()) {
				//donner nom explicatif + g�n�ration TypeNode
				aPorte = porte.getAbscisse() + normale.get(0)*m.getEpaisseur();
				oPorte = porte.getOrdonnee() + normale.get(1)*m.getEpaisseur();
				Node nodePorte1 = new Node(aPorte, oPorte, porte.getNom() + "1", porte.getType());
				graph.addNode(nodePorte1);
				aPorte = porte.getAbscisse() - normale.get(0)*m.getEpaisseur();
				oPorte = porte.getOrdonnee() - normale.get(1)*m.getEpaisseur();
				Node nodePorte2 = new Node(aPorte, oPorte, porte.getNom() + "2", porte.getType());
				graph.addNode(nodePorte2);
			}
			//g�n�rer points extr�mit�s des murs + arcs ?
		}
		
		//g�n�ration finale
		while ((nodes!=null)&&(!nodes.isEmpty())) {
			Node n = nodes.get(0);
			//premi�re id�e : tous les nodes d'une m�me pi�ce sont fortement connexes.
			if (n.getType() instanceof TypePiece) {
				for (Node autreNode : nodes) {
					//TODO : HT1 : pi�ces vides
					if (n.getType().getId()==autreNode.getType().getId()) {
						Chemin chemin = new Chemin();
						chemin.addEtape(n);
						chemin.addEtape(autreNode);
						chemin.calculerDistance();
						Arc a = new Arc(n, autreNode, chemin);
						graph.addArc(a);
					}
				}
			} else if (n.getType() instanceof TypeCouloir) {
				for (Node autreNode : nodes) {
					//trouver les nodes PERTINENTS ?
				}
			} else if (n.getType() instanceof TypePorte) {
				
			} else {
				throw new Error("Erreur type de node");
			}
			nodes.remove(0);
		}
		return graph;
	}

	public Graph getGraph() {
		return graph;
	}
	
}
