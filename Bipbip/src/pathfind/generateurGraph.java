package pathfind;

import java.util.ArrayList;

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
		ArrayList<Mur> murs = affichage.Bipbip.murs;
		
		//TODO : virer les points superflus
		//g�n�ration initiale
		for (Mur m : murs) {
			for (Node porte : m.getPortes()) {
				//g�n�rer points des portes
			}
			//g�n�rer points extr�mit�s des murs + arcs ?
		}
		
		//g�n�ration finale
		while (!nodes.isEmpty()) {
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
