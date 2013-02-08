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
	 * Crée les arêtes du graphe à partir des sommets.
	 * @return graph connexe
	 */
	public Graph generationGraph() {
		ArrayList<Mur> murs = affichage.Bipbip.murs;
		
		//TODO : virer les points superflus
		//génération initiale
		for (Mur m : murs) {
			for (Node porte : m.getPortes()) {
				//générer points des portes
			}
			//générer points extrémités des murs + arcs ?
		}
		
		//génération finale
		while (!nodes.isEmpty()) {
			Node n = nodes.get(0);
			//première idée : tous les nodes d'une même pièce sont fortement connexes.
			if (n.getType() instanceof TypePiece) {
				for (Node autreNode : nodes) {
					//TODO : HT1 : pièces vides
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
