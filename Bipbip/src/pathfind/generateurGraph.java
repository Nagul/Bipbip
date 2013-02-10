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
	 * Crée les arêtes du graphe à partir des sommets.
	 * @return graph connexe
	 */
	public Graph generationGraph() {
		
		//TODO : virer les points superflus
		//génération initiale
		//TODO : virer pour les tests
		double aNode;
		double oNode;
		Chemin chemin;
		Node nodeCourant1;
		Node nodeCourant2;
		
		for (Mur m : TestRechercheGraph.murs) {
			Vector<Double> normale = m.getNormale();
			
			//TODO : condition pour générer les nodes des murs
			//TODO : sinon, nodeCourant = null
			aNode = m.getBoutDebut().getAbscisse() + normale.get(0)*m.getEpaisseur();
			oNode = m.getBoutDebut().getOrdonnee() + normale.get(1)*m.getEpaisseur();
			nodeCourant1 = new Node(aNode, oNode, m.getBoutDebut().getNom() + "1", m.getBoutDebut().getType());
			
			aNode = m.getBoutDebut().getAbscisse() - normale.get(0)*m.getEpaisseur();
			oNode = m.getBoutDebut().getOrdonnee() - normale.get(1)*m.getEpaisseur();
			nodeCourant2 = new Node(aNode, oNode, m.getBoutDebut().getNom() + "2", m.getBoutDebut().getType());


			//TODO : raffinner condition pour créer l'arc (si les deux existent)
			if (nodeCourant1!=null&&nodeCourant2!=null) {
				chemin = new Chemin();
				chemin.addEtape(nodeCourant1);
				//TODO : créer un truc pour tourner par rapport au bout du mur
				chemin.addEtape(nodeCourant2);
				graph.addArc(new Arc(nodeCourant1, nodeCourant2, chemin));
			}

			//TODO : BESOIN DE TRIER LES PORTES PAR RAPPORT A DEBUT -> FIN
			for (Node porte : m.getPortes()) {
				//TODO : donner nom explicatif + génération TypeNode
				aNode = porte.getAbscisse() + normale.get(0)*m.getEpaisseur();
				oNode = porte.getOrdonnee() + normale.get(1)*m.getEpaisseur();
				Node nodePorte1 = new Node(aNode, oNode, porte.getNom() + "1", porte.getType());
				graph.addNode(nodePorte1);
				
				aNode = porte.getAbscisse() - normale.get(0)*m.getEpaisseur();
				oNode = porte.getOrdonnee() - normale.get(1)*m.getEpaisseur();
				Node nodePorte2 = new Node(aNode, oNode, porte.getNom() + "2", porte.getType());
				graph.addNode(nodePorte2);
				
				chemin = new Chemin();
				chemin.addEtape(nodePorte1);
				chemin.addEtape(nodePorte2);
				graph.addArc(new Arc(nodePorte1, nodePorte2, chemin));

				if (nodeCourant1!=null) {
					chemin = new Chemin();
					chemin.addEtape(nodeCourant1);
					chemin.addEtape(nodePorte1);
					graph.addArc(new Arc(nodeCourant1, nodePorte1, chemin));
				}

				if (nodeCourant2!=null) {
					chemin = new Chemin();
					chemin.addEtape(nodeCourant2);
					chemin.addEtape(nodePorte2);
					graph.addArc(new Arc(nodeCourant2, nodePorte2, chemin));
				}

				nodeCourant1 = nodePorte1;
				nodeCourant2 = nodePorte2;
			}
			
			aNode = m.getBoutFin().getAbscisse() + normale.get(0)*m.getEpaisseur();
			oNode = m.getBoutFin().getOrdonnee() + normale.get(1)*m.getEpaisseur();
			Node nodeMur1 = new Node(aNode, oNode, m.getBoutFin().getNom() + "1", m.getBoutFin().getType());
			
			aNode = m.getBoutFin().getAbscisse() - normale.get(0)*m.getEpaisseur();
			oNode = m.getBoutFin().getOrdonnee() - normale.get(1)*m.getEpaisseur();
			Node nodeMur2 = new Node(aNode, oNode, m.getBoutFin().getNom() + "2", m.getBoutFin().getType());
			
			//TODO : raffinner
			if (nodeCourant1!=null&&nodeCourant2!=null) {
				chemin = new Chemin();
				chemin.addEtape(nodeMur1);
				//TODO : créer un truc pour tourner par rapport au bout du mur
				chemin.addEtape(nodeMur2);
				graph.addArc(new Arc(nodeMur1, nodeMur2, chemin));
			}

			if (nodeCourant1!=null&&nodeMur1!=null) {
				chemin = new Chemin();
				chemin.addEtape(nodeCourant1);
				chemin.addEtape(nodeMur1);
				graph.addArc(new Arc(nodeCourant1, nodeMur1, chemin));
			}

			if (nodeCourant2!=null&&nodeMur2!=null) {
				chemin = new Chemin();
				chemin.addEtape(nodeCourant2);
				chemin.addEtape(nodeMur2);
				graph.addArc(new Arc(nodeCourant2, nodeMur2, chemin));
			}

		}
		
		//génération finale
		while ((nodes!=null)&&(!nodes.isEmpty())) {
			Node n = nodes.get(0);
			//première idée : tous les nodes d'une même pièce sont fortement connexes.
			if (n.getType() instanceof TypePiece) {
				for (Node autreNode : nodes) {
					//TODO : HT1 : pièces vides
					if (n.getType().getId()==autreNode.getType().getId()) {
						chemin = new Chemin();
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
