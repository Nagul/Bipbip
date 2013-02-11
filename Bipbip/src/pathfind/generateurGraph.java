package pathfind;

import java.util.ArrayList;
import java.util.HashMap;
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
	//TODO : CHECKER LES CALCULS
	public Graph generationGraph() {
		
		//génération initiale
		//TODO : murs pour test
		double aNode;
		double oNode;
		double sin;
		Chemin chemin;
		Mur autreMur;
		Double[] normale;
		Double[] dir;
		Double[] autreDir;
		Node nodeCourant1;
		Node nodeCourant2;
		Node nodeNew1;
		Node nodeNew2;
		
		HashMap<Mur, Mur[]> mapAdjacenceMur = this.mapMurAdjacents();
		
		for (Mur m : affichage.Bipbip.murs) {
			normale = m.getNormale();
			dir = m.getDirecteur();
			
			if (mapAdjacenceMur.get(m)[0]==null) {
				//Cas bout de mur seul.
				aNode = m.getBoutDebut().getAbscisse() + normale[0]*m.getEpaisseur();
				oNode = m.getBoutDebut().getOrdonnee() + normale[1]*m.getEpaisseur();
				nodeCourant1 = new Node(aNode, oNode, m.getNom() + "D1", m.getBoutDebut().getType());
				graph.addNode(nodeCourant1);
				
				aNode = m.getBoutDebut().getAbscisse() - normale[0]*m.getEpaisseur();
				oNode = m.getBoutDebut().getOrdonnee() - normale[1]*m.getEpaisseur();
				nodeCourant2 = new Node(aNode, oNode, m.getNom() + "D2", m.getBoutDebut().getType());
				graph.addNode(nodeCourant2);
				
				chemin = new Chemin();
				chemin.addEtape(nodeCourant1);
				//TODO : créer un truc pour tourner par rapport au bout du mur
				chemin.addEtape(nodeCourant2);
				graph.addArc(new Arc(nodeCourant1, nodeCourant2, chemin));
			} else if (mapAdjacenceMur.get(m)[0].equals(mapAdjacenceMur.get(m)[1])) {
				//Cas UN mur
				//TODO : VERIFIER ?
				autreMur = mapAdjacenceMur.get(m)[0];
				autreDir = autreMur.getDirecteur();
				sin = dir[0]*autreDir[1] + dir[1]*autreDir[0];
				
				aNode = m.getBoutDebut().getAbscisse() + (dir[0]*autreMur.getEpaisseur() - autreDir[0]*m.getEpaisseur())*sin;
				oNode = m.getBoutDebut().getOrdonnee() + (dir[1]*autreMur.getEpaisseur() - autreDir[1]*m.getEpaisseur())*sin;
				nodeCourant1 = graph.rechercheNode(aNode, oNode);
				if (nodeCourant1==null) {
					nodeCourant1 = new Node(aNode, oNode, m.getNom() + "|" + autreMur.getNom(), m.getBoutDebut().getType());
					graph.addNode(nodeCourant1);
				}

				aNode = m.getBoutDebut().getAbscisse() - (dir[0]*autreMur.getEpaisseur() - autreDir[0]*m.getEpaisseur())*sin;
				oNode = m.getBoutDebut().getOrdonnee() - (dir[1]*autreMur.getEpaisseur() - autreDir[1]*m.getEpaisseur())*sin;
				nodeCourant2 = graph.rechercheNode(aNode, oNode);
				if (nodeCourant2==null) {
					nodeCourant2 = new Node(aNode, oNode, m.getNom() + "|" + autreMur.getNom(), m.getBoutDebut().getType());
					graph.addNode(nodeCourant2);
				}

				
			} else {
				autreMur = mapAdjacenceMur.get(m)[0];
				autreDir = autreMur.getDirecteur();
				sin = dir[0]*autreDir[1] + dir[1]*autreDir[0];

				aNode = m.getBoutDebut().getAbscisse() + (dir[0]*autreMur.getEpaisseur() + autreDir[0]*m.getEpaisseur())*sin;
				oNode = m.getBoutDebut().getOrdonnee() + (dir[1]*autreMur.getEpaisseur() + autreDir[1]*m.getEpaisseur())*sin;
				nodeCourant1 = graph.rechercheNode(aNode, oNode);
				if (nodeCourant1==null) {
					nodeCourant1 = new Node(aNode, oNode, m.getNom() + "|" + autreMur.getNom(), m.getBoutDebut().getType());
					graph.addNode(nodeCourant1);
				}


				autreMur = mapAdjacenceMur.get(m)[1];
				autreDir = autreMur.getDirecteur();
				sin = dir[0]*autreDir[1] + dir[1]*autreDir[0];

				aNode = m.getBoutDebut().getAbscisse() - (dir[0]*autreMur.getEpaisseur() + autreDir[0]*m.getEpaisseur())*sin;
				oNode = m.getBoutDebut().getOrdonnee() - (dir[1]*autreMur.getEpaisseur() + autreDir[1]*m.getEpaisseur())*sin;
				nodeCourant2 = graph.rechercheNode(aNode, oNode);
				if (nodeCourant2==null) {
					nodeCourant2 = new Node(aNode, oNode, m.getNom() + "|" + autreMur.getNom(), m.getBoutDebut().getType());
					graph.addNode(nodeCourant2);
				}
			}



			//TODO : BESOIN DE TRIER LES PORTES PAR RAPPORT A DEBUT -> FIN
			if (m.getPortes()!=null) {
				for (Node porte : m.getPortes()) {
					//TODO : donner nom explicatif + génération TypeNode
					aNode = porte.getAbscisse() + normale[0]*m.getEpaisseur();
					oNode = porte.getOrdonnee() + normale[1]*m.getEpaisseur();
					nodeNew1 = new Node(aNode, oNode, porte.getNom() + "1", porte.getType());
					graph.addNode(nodeNew1);

					aNode = porte.getAbscisse() - normale[0]*m.getEpaisseur();
					oNode = porte.getOrdonnee() - normale[1]*m.getEpaisseur();
					nodeNew2 = new Node(aNode, oNode, porte.getNom() + "2", porte.getType());
					graph.addNode(nodeNew2);

					chemin = new Chemin();
					chemin.addEtape(nodeNew1);
					chemin.addEtape(nodeNew2);
					graph.addArc(new Arc(nodeNew1, nodeNew2, chemin));

					chemin = new Chemin();
					chemin.addEtape(nodeCourant1);
					chemin.addEtape(nodeNew1);
					graph.addArc(new Arc(nodeCourant1, nodeNew1, chemin));

					chemin = new Chemin();
					chemin.addEtape(nodeCourant2);
					chemin.addEtape(nodeNew2);
					graph.addArc(new Arc(nodeCourant2, nodeNew2, chemin));

					nodeCourant1 = nodeNew1;
					nodeCourant2 = nodeNew2;
				}
			}
			
			
			if (mapAdjacenceMur.get(m)[2]==null) {
				//Cas bout de mur seul.
				aNode = m.getBoutFin().getAbscisse() + normale[0]*m.getEpaisseur();
				oNode = m.getBoutFin().getOrdonnee() + normale[1]*m.getEpaisseur();
				nodeNew1 = new Node(aNode, oNode, m.getNom() + "F1", m.getBoutDebut().getType());
				graph.addNode(nodeNew1);
				
				aNode = m.getBoutFin().getAbscisse() - normale[0]*m.getEpaisseur();
				oNode = m.getBoutFin().getOrdonnee() - normale[1]*m.getEpaisseur();
				nodeNew2 = new Node(aNode, oNode, m.getNom() + "F2", m.getBoutDebut().getType());
				graph.addNode(nodeNew2);
				
				chemin = new Chemin();
				chemin.addEtape(nodeNew1);
				//TODO : créer un truc pour tourner par rapport au bout du mur
				chemin.addEtape(nodeNew2);
				graph.addArc(new Arc(nodeNew1, nodeNew2, chemin));
			} else if (mapAdjacenceMur.get(m)[2].equals(mapAdjacenceMur.get(m)[3])) {
				//Cas UN mur
				//TODO : VERIFIER ?
				autreMur = mapAdjacenceMur.get(m)[2];
				autreDir = autreMur.getDirecteur();
				sin = dir[0]*autreDir[1] + dir[1]*autreDir[0];

				aNode = m.getBoutFin().getAbscisse() - (dir[0]*autreMur.getEpaisseur() - autreDir[0]*m.getEpaisseur())*sin;
				oNode = m.getBoutFin().getOrdonnee() - (dir[1]*autreMur.getEpaisseur() - autreDir[1]*m.getEpaisseur())*sin;
				nodeNew1 = graph.rechercheNode(aNode, oNode);
				if (nodeNew1==null) {
					nodeNew1 = new Node(aNode, oNode, m.getNom() + "|" + autreMur.getNom(), m.getBoutDebut().getType());
					graph.addNode(nodeNew1);
				}

				aNode = m.getBoutFin().getAbscisse() + (dir[0]*autreMur.getEpaisseur() - autreDir[0]*m.getEpaisseur())*sin;
				oNode = m.getBoutFin().getOrdonnee() + (dir[1]*autreMur.getEpaisseur() - autreDir[1]*m.getEpaisseur())*sin;
				nodeNew2 = graph.rechercheNode(aNode, oNode);
				if (nodeNew2==null) {
					nodeNew2 = new Node(aNode, oNode, m.getNom() + "|" + autreMur.getNom(), m.getBoutDebut().getType());
					graph.addNode(nodeNew2);
				}
				
			} else {
				autreMur = mapAdjacenceMur.get(m)[2];
				autreDir = autreMur.getDirecteur();
				sin = dir[0]*autreDir[1] + dir[1]*autreDir[0];

				aNode = m.getBoutFin().getAbscisse() - (dir[0]*autreMur.getEpaisseur() - autreDir[0]*m.getEpaisseur())*sin;
				oNode = m.getBoutFin().getOrdonnee() - (dir[1]*autreMur.getEpaisseur() - autreDir[1]*m.getEpaisseur())*sin;
				nodeNew1 = graph.rechercheNode(aNode, oNode);
				if (nodeNew1==null) {
					nodeNew1 = new Node(aNode, oNode, m.getNom() + "|" + autreMur.getNom(), m.getBoutDebut().getType());
					graph.addNode(nodeNew1);
				}


				autreMur = mapAdjacenceMur.get(m)[3];
				autreDir = autreMur.getDirecteur();
				sin = dir[0]*autreDir[1] + dir[1]*autreDir[0];

				aNode = m.getBoutFin().getAbscisse() + (dir[0]*autreMur.getEpaisseur() - autreDir[0]*m.getEpaisseur())*sin;
				oNode = m.getBoutFin().getOrdonnee() + (dir[1]*autreMur.getEpaisseur() - autreDir[1]*m.getEpaisseur())*sin;
				nodeNew2 = graph.rechercheNode(aNode, oNode);
				if (nodeNew2==null) {
					nodeNew2 = new Node(aNode, oNode, m.getNom() + "|" + autreMur.getNom(), m.getBoutDebut().getType());
					graph.addNode(nodeNew2);
				}
			}
			
			chemin = new Chemin();
			chemin.addEtape(nodeCourant1);
			chemin.addEtape(nodeNew1);
			graph.addArc(new Arc(nodeCourant1, nodeNew1, chemin));
			
			chemin = new Chemin();
			chemin.addEtape(nodeCourant2);
			chemin.addEtape(nodeNew2);
			graph.addArc(new Arc(nodeCourant2, nodeNew2, chemin));
			
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

	/*
	 * Vecteur associé à chaque mur : [murDebutDirect
	 *                                 murDebutIndirect 
	 *                                 murFinDirect
	 *                                 murFinIndirect   ]
	 */
	private HashMap<Mur, Mur[]> mapMurAdjacents() {
		HashMap<Mur, Mur[]> hm = new HashMap<Mur, Mur[]>();
		Mur[] murVecteur;
		ArrayList<Mur> murListDebut;
		ArrayList<Mur> murListFin;
		Mur murMin;
		Mur murMax;
		double ecartMin = 0;
		double ecartMax = 0;

		for (Mur m : affichage.Bipbip.murs) {
			murVecteur = new Mur[4];
			murListDebut = new ArrayList<Mur>();
			murListFin = new ArrayList<Mur>();
			//rechercher les murs touchant
			for (Mur autreM : affichage.Bipbip.murs) {
				if((m.getBoutDebut().equals(autreM.getBoutDebut())
						||m.getBoutDebut().equals(autreM.getBoutFin()))
						&&!m.equals(autreM)) {
					murListDebut.add(autreM);
				}
				if((m.getBoutFin().equals(autreM.getBoutDebut())
						||m.getBoutFin().equals(autreM.getBoutFin()))
						&&!m.equals(autreM)) {
					murListFin.add(autreM);
				}
			}
			//rechercher parmis les murs touchant ceux qui sont à coté
			murMin = null;
			murMax = null;
			for (Mur autreM : murListDebut) {
				if (murMin==null
						||m.ecartDirection(autreM) < ecartMin) {
					ecartMin = m.ecartDirection(autreM);
					murMin = autreM;
				}
				if (murMax==null
						||m.ecartDirection(autreM) > ecartMax) {
					ecartMax = m.ecartDirection(autreM);
					murMax = autreM;
				}
				murVecteur[0] = murMin;
				murVecteur[1] = murMax;
			}
			murMin = null;
			murMax = null;
			for (Mur autreM : murListFin) {
				if (murMin==null
						||m.ecartDirection(autreM) < ecartMin) {
					ecartMin = m.ecartDirection(autreM);
					murMin = autreM;
				}
				if (murMax==null
						||m.ecartDirection(autreM) > ecartMax) {
					ecartMax = m.ecartDirection(autreM);
					murMax = autreM;
				}
				murVecteur[2] = murMin;
				murVecteur[3] = murMax;
			}
			hm.put(m, murVecteur);
		}
		
		return hm;
	}

}
