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
	
	//TODO : fusionner les cas 1 mur et n murs pour lisibilité
	/**
	 * Crée les arêtes du graphe à partir des sommets.
	 * @return graph connexe
	 */
	public Graph generationGraph() {
		
		//PUTAIN DE QT DE SENS HORAIRE DE MERDE
		//génération initiale
		double epaisseur;
		Chemin chemin;
		Mur autreMur;
		double[] normale;
		double[] coord = new double[2];
		Node nodeCourant1;
		Node nodeCourant2;
		Node nodeNew1;
		Node nodeNew2;
		
		double ecartement = 10;
		
		HashMap<Mur, murEtBout> mapAdjacenceMur = this.mapMurAdjacents();
		
		//TODO : gérer mieux le cas où l'intersection est nulle
		for (Mur m : affichage.Bipbip.murs) {
			normale = m.getNormale();
			epaisseur = m.getEpaisseur() + ecartement;
			
			if (mapAdjacenceMur.get(m).getMurVecteur()[0]==null) {
				//Cas bout de mur seul.
				coord[0] = m.getBoutDebut().getAbscisse() + normale[0]*epaisseur;
				coord[1] = m.getBoutDebut().getOrdonnee() + normale[1]*epaisseur;
				nodeCourant1 = new Node(coord[0], coord[1], m.getNom() + "D1", m.getPieceDirect());
				graph.addNode(nodeCourant1);
				
				coord[0] = m.getBoutDebut().getAbscisse() - normale[0]*epaisseur;
				coord[1] = m.getBoutDebut().getOrdonnee() - normale[1]*epaisseur;
				nodeCourant2 = new Node(coord[0], coord[1], m.getNom() + "D2", m.getPieceIndirect());
				graph.addNode(nodeCourant2);
				
				chemin = new Chemin();
				chemin.addEtape(nodeCourant1);
				//TODO : créer un truc pour tourner par rapport au bout du mur
				chemin.addEtape(nodeCourant2);
				chemin.calculerDistance();
				graph.addArc(new Arc(nodeCourant1, nodeCourant2, chemin));
				
			} else if (mapAdjacenceMur.get(m).getMurVecteur()[0].equals(mapAdjacenceMur.get(m).getMurVecteur()[1])) {
				//Cas UN mur
				autreMur = mapAdjacenceMur.get(m).getMurVecteur()[0];

				if ((mapAdjacenceMur.get(m).getMurBout()[0])) {
					coord = m.getIntersection(autreMur, true, false);
				} else {
					coord = m.getIntersection(autreMur, true, true);
				}
				if (coord==null) {
					coord = new double[2];
					coord[0] = m.getBoutDebut().getAbscisse() + normale[0]*epaisseur;
					coord[1] = m.getBoutDebut().getOrdonnee() + normale[1]*epaisseur;
				}
				nodeCourant1 = graph.rechercheNode(coord[0], coord[1]);
				if (nodeCourant1==null) {
					nodeCourant1 = new Node(coord[0], coord[1], m.getNom() + "|" + autreMur.getNom(), m.getPieceDirect());
					graph.addNode(nodeCourant1);
				}

				if (mapAdjacenceMur.get(m).getMurBout()[0]) {
					coord = m.getIntersection(autreMur, false, true);
				} else {
					coord = m.getIntersection(autreMur, false, false);
				}
				if (coord==null) {
					coord = new double[2];
					coord[0] = m.getBoutDebut().getAbscisse() - normale[0]*epaisseur;
					coord[1] = m.getBoutDebut().getOrdonnee() - normale[1]*epaisseur;
				}
				nodeCourant2 = graph.rechercheNode(coord[0], coord[1]);
				if (nodeCourant2==null) {
					nodeCourant2 = new Node(coord[0], coord[1], m.getNom() + "|" + autreMur.getNom(), m.getPieceIndirect());
					graph.addNode(nodeCourant2);
				}

				
			} else {
				//cas plusieurs murs
				
				autreMur = mapAdjacenceMur.get(m).getMurVecteur()[0];
				System.out.println("PLUSIEURS, DEBUT " + m.getNom() + autreMur.getNom());

				if (mapAdjacenceMur.get(m).getMurBout()[0]) {
					coord = m.getIntersection(autreMur, true, false);
				} else {
					coord = m.getIntersection(autreMur, true, true);
				}
				if (coord==null) {
					coord = new double[2];
					coord[0] = m.getBoutDebut().getAbscisse() + normale[0]*epaisseur;
					coord[1] = m.getBoutDebut().getOrdonnee() + normale[1]*epaisseur;
				}
				nodeCourant1 = graph.rechercheNode(coord[0], coord[1]);
				if (nodeCourant1==null) {
					nodeCourant1 = new Node(coord[0], coord[1], m.getNom() + "|" + autreMur.getNom(), m.getPieceDirect());
					graph.addNode(nodeCourant1);
				}


				autreMur = mapAdjacenceMur.get(m).getMurVecteur()[1];
				System.out.println("PLUSIEURS, DEBUT " + m.getNom() + autreMur.getNom());
				
				if (mapAdjacenceMur.get(m).getMurBout()[1]) {
					coord = m.getIntersection(autreMur, false, true);
				} else {
					coord = m.getIntersection(autreMur, false, false);
				}
				if (coord==null) {
					coord = new double[2];
					coord[0] = m.getBoutDebut().getAbscisse() - normale[0]*epaisseur;
					coord[1] = m.getBoutDebut().getOrdonnee() - normale[1]*epaisseur;
				}
				nodeCourant2 = graph.rechercheNode(coord[0], coord[1]);
				if (nodeCourant2==null) {
					nodeCourant2 = new Node(coord[0], coord[1], m.getNom() + "|" + autreMur.getNom(), m.getPieceIndirect());
					graph.addNode(nodeCourant2);
				}
			}



			//TODO : BESOIN DE TRIER LES PORTES PAR RAPPORT A DEBUT -> FIN
			if (m.getPortes()!=null) {
				for (Node porte : m.getPortes()) {
					//TODO : donner nom explicatif + génération TypeNode
					coord[0] = porte.getAbscisse() + normale[0]*epaisseur;
					coord[1] = porte.getOrdonnee() + normale[1]*epaisseur;
					nodeNew1 = new Node(coord[0], coord[1], porte.getNom() + "1", m.getPieceDirect());
					graph.addNode(nodeNew1);

					coord[0] = porte.getAbscisse() - normale[0]*epaisseur;
					coord[1] = porte.getOrdonnee() - normale[1]*epaisseur;
					nodeNew2 = new Node(coord[0], coord[1], porte.getNom() + "2", m.getPieceIndirect());
					graph.addNode(nodeNew2);

					chemin = new Chemin();
					chemin.addEtape(nodeNew1);
					chemin.addEtape(nodeNew2);
					chemin.calculerDistance();
					graph.addArc(new Arc(nodeNew1, nodeNew2, chemin));

					chemin = new Chemin();
					chemin.addEtape(nodeCourant1);
					chemin.addEtape(nodeNew1);
					chemin.calculerDistance();
					graph.addArc(new Arc(nodeCourant1, nodeNew1, chemin));

					chemin = new Chemin();
					chemin.addEtape(nodeCourant2);
					chemin.addEtape(nodeNew2);
					chemin.calculerDistance();
					graph.addArc(new Arc(nodeCourant2, nodeNew2, chemin));

					nodeCourant1 = nodeNew1;
					nodeCourant2 = nodeNew2;
				}
			}
			
			
			if (mapAdjacenceMur.get(m).getMurVecteur()[2]==null) {
				//Cas bout de mur seul.
				coord[0] = m.getBoutFin().getAbscisse() + normale[0]*epaisseur;
				coord[1] = m.getBoutFin().getOrdonnee() + normale[1]*epaisseur;
				nodeNew1 = new Node(coord[0], coord[1], m.getNom() + "F1", m.getPieceDirect());
				graph.addNode(nodeNew1);
				
				coord[0] = m.getBoutFin().getAbscisse() - normale[0]*epaisseur;
				coord[1] = m.getBoutFin().getOrdonnee() - normale[1]*epaisseur;
				nodeNew2 = new Node(coord[0], coord[1], m.getNom() + "F2", m.getPieceIndirect());
				graph.addNode(nodeNew2);
				
				chemin = new Chemin();
				chemin.addEtape(nodeNew1);
				//TODO : créer un truc pour tourner par rapport au bout du mur
				chemin.addEtape(nodeNew2);
				chemin.calculerDistance();
				graph.addArc(new Arc(nodeNew1, nodeNew2, chemin));
			} else if (mapAdjacenceMur.get(m).getMurVecteur()[2].equals(mapAdjacenceMur.get(m).getMurVecteur()[3])) {
				//Cas UN mur
				autreMur = mapAdjacenceMur.get(m).getMurVecteur()[2];

				if (mapAdjacenceMur.get(m).getMurBout()[2]) {
					coord = m.getIntersection(autreMur, true, true);
				} else {
					coord = m.getIntersection(autreMur, true, false);
				}
				if (coord==null) {
					coord = new double[2];
					coord[0] = m.getBoutFin().getAbscisse() + normale[0]*epaisseur;
					coord[1] = m.getBoutFin().getOrdonnee() + normale[1]*epaisseur;
				}
				nodeNew1 = graph.rechercheNode(coord[0], coord[1]);
				if (nodeNew1==null) {
					nodeNew1 = new Node(coord[0], coord[1], m.getNom() + "|" + autreMur.getNom(), m.getPieceDirect());
					graph.addNode(nodeNew1);
				}

				if (mapAdjacenceMur.get(m).getMurBout()[2]) {
					coord = m.getIntersection(autreMur, false, false);
				} else {
					coord = m.getIntersection(autreMur, false, true);
				}
				if (coord==null) {
					coord = new double[2];
					coord[0] = m.getBoutFin().getAbscisse() - normale[0]*epaisseur;
					coord[1] = m.getBoutFin().getOrdonnee() - normale[1]*epaisseur;
				}
				nodeNew2 = graph.rechercheNode(coord[0], coord[1]);
				if (nodeNew2==null) {
					nodeNew2 = new Node(coord[0], coord[1], m.getNom() + "|" + autreMur.getNom(), m.getPieceIndirect());
					graph.addNode(nodeNew2);
				}
				
			} else {

				
				autreMur = mapAdjacenceMur.get(m).getMurVecteur()[2];
				System.out.println("PLUSIEURS, FIN " + m.getNom() + autreMur.getNom());
				
				if (mapAdjacenceMur.get(m).getMurBout()[2]) {
					coord = m.getIntersection(autreMur, true, true);
				} else {
					coord = m.getIntersection(autreMur, true, false);
				}
				if (coord==null) {
					coord = new double[2];
					coord[0] = m.getBoutFin().getAbscisse() + normale[0]*epaisseur;
					coord[1] = m.getBoutFin().getOrdonnee() + normale[1]*epaisseur;
				}
				nodeNew1 = graph.rechercheNode(coord[0], coord[1]);
				if (nodeNew1==null) {
					nodeNew1 = new Node(coord[0], coord[1], m.getNom() + "|" + autreMur.getNom(), m.getPieceDirect());
					graph.addNode(nodeNew1);
				}


				autreMur = mapAdjacenceMur.get(m).getMurVecteur()[3];
				System.out.println("PLUSIEURS, FIN " + m.getNom() + autreMur.getNom());
				
				if (mapAdjacenceMur.get(m).getMurBout()[3]) {
					coord = m.getIntersection(autreMur, false, false);
				} else {
					coord = m.getIntersection(autreMur, false, true);
				}
				if (coord==null) {
					coord = new double[2];
					coord[0] = m.getBoutFin().getAbscisse() - normale[0]*epaisseur;
					coord[1] = m.getBoutFin().getOrdonnee() - normale[1]*epaisseur;
				}
				nodeNew2 = graph.rechercheNode(coord[0], coord[1]);
				if (nodeNew2==null) {
					nodeNew2 = new Node(coord[0], coord[1], m.getNom() + "|" + autreMur.getNom(), m.getPieceIndirect());
					graph.addNode(nodeNew2);
				}
			}
			
			chemin = new Chemin();
			chemin.addEtape(nodeCourant1);
			chemin.addEtape(nodeNew1);
			chemin.calculerDistance();
			graph.addArc(new Arc(nodeCourant1, nodeNew1, chemin));
			
			chemin = new Chemin();
			chemin.addEtape(nodeCourant2);
			chemin.addEtape(nodeNew2);
			chemin.calculerDistance();
			graph.addArc(new Arc(nodeCourant2, nodeNew2, chemin));
			
		}

		//génération finale
		while ((nodes!=null)&&(!nodes.isEmpty())) {
			Node n = nodes.get(0);
			graph.addNode(n);
			//première idée : tous les nodes d'une même pièce sont fortement connexes.
			if (n.getType() instanceof TypePiece) {
				for (Node autreNode : graph.getNodes()) {
					//TODO : HT1 : pièces vides
					if (n.getType().getId()==autreNode.getType().getId()
							&&!n.equals(autreNode)) {
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
	 *                                 [Vecteur permettant de determiner à quel bout on est]
	 */
	// TODO : CORRECTION
	// INVERSION AU NIVEAU DU SENS EN QT §§§
	private HashMap<Mur, murEtBout> mapMurAdjacents() {
		HashMap<Mur, murEtBout> hm = new HashMap<Mur, murEtBout>();
		Mur[] murVecteur;
		boolean[] murBout;
		murEtBout meb;
		ArrayList<Mur> murListDebut;
		ArrayList<Mur> murListFin;
		Mur murMin;
		Mur murMax;
		double ecartMin = 0;
		double ecartMax = 0;

		for (Mur m : affichage.Bipbip.murs) {
			murVecteur = new Mur[4];
			murBout = new boolean[4];
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
				if (murMin==null) {
					if (autreM.getBoutDebut().equals(m.getBoutDebut())) {
						ecartMin = m.ecartDirection(autreM);
					} else if (m.ecartDirection(autreM) - Math.PI >= 0) {
						ecartMin = m.ecartDirection(autreM) - Math.PI;
					} else {
						ecartMin = m.ecartDirection(autreM) + Math.PI;
					}
					murMin = autreM;
					
				} else if (autreM.getBoutDebut().equals(m.getBoutDebut())
						&&m.ecartDirection(autreM) < ecartMin) {
					ecartMin = m.ecartDirection(autreM);
					murMin = autreM;
					
				} else if (autreM.getBoutFin().equals(m.getBoutDebut())
						&&m.ecartDirection(autreM) - Math.PI < ecartMin
						&&m.ecartDirection(autreM) - Math.PI >= 0) {
					ecartMin = m.ecartDirection(autreM) - Math.PI;
					murMin = autreM;
				}

				if (murMax==null) {
					if (autreM.getBoutDebut().equals(m.getBoutDebut())) {
						ecartMax = m.ecartDirection(autreM);
					} else if (m.ecartDirection(autreM) + Math.PI < 2*Math.PI) {
						ecartMax = m.ecartDirection(autreM) + Math.PI;
					} else {
						ecartMax = m.ecartDirection(autreM) - Math.PI;
					}
					murMax = autreM;
					
				} else if (autreM.getBoutDebut().equals(m.getBoutDebut())
						&&m.ecartDirection(autreM) > ecartMax) {
					ecartMax = m.ecartDirection(autreM);
					murMax = autreM;
					
				} else if (autreM.getBoutFin().equals(m.getBoutDebut())
						&&m.ecartDirection(autreM) + Math.PI > ecartMax
						&&m.ecartDirection(autreM) + Math.PI < 2*Math.PI) {
					ecartMax = m.ecartDirection(autreM) + Math.PI;
					murMax = autreM;
				}

			}

			//TODO : INVERSION DES MURS
			murVecteur[1] = murMin;
			if (murMin!=null) {
				murBout[1] = murMin.getBoutDebut().equals(m.getBoutDebut());
			}

			murVecteur[0] = murMax;
			if (murMax!=null) {
				murBout[0] = murMax.getBoutDebut().equals(m.getBoutDebut());
			}

			murMin = null;
			murMax = null;
			for (Mur autreM : murListFin) {
				if (murMin==null) {
					if (!autreM.getBoutDebut().equals(m.getBoutFin())) {
						ecartMin = m.ecartDirection(autreM);
					} else if (m.ecartDirection(autreM) + Math.PI < 2*Math.PI) {
						ecartMin = m.ecartDirection(autreM) + Math.PI;
					} else {
						ecartMin = m.ecartDirection(autreM) - Math.PI;
					}
					murMin = autreM;
					
				} else if (autreM.getBoutDebut().equals(m.getBoutFin())
						&&m.ecartDirection(autreM) + Math.PI > ecartMin
						&&m.ecartDirection(autreM) + Math.PI < 2*Math.PI) {
					ecartMin = m.ecartDirection(autreM) + Math.PI;
					murMin = autreM;
					
				} else if (autreM.getBoutFin().equals(m.getBoutFin())
						&&m.ecartDirection(autreM) > ecartMin) {
					ecartMin = m.ecartDirection(autreM);
					murMin = autreM;
				}

				if (murMax==null) {
					if (!autreM.getBoutDebut().equals(m.getBoutFin())) {
						ecartMax = m.ecartDirection(autreM);
					} else if (m.ecartDirection(autreM) - Math.PI >= 0) {
						ecartMax = m.ecartDirection(autreM) - Math.PI;
					} else {
						ecartMax = m.ecartDirection(autreM) + Math.PI;
					}
					murMax = autreM;
					
				} else if (autreM.getBoutDebut().equals(m.getBoutFin())
						&&m.ecartDirection(autreM) - Math.PI < ecartMax
						&&m.ecartDirection(autreM) - Math.PI >= 0) {
					ecartMax = m.ecartDirection(autreM) - Math.PI;
					murMax = autreM;
					
				} else if (autreM.getBoutFin().equals(m.getBoutFin())
						&&(m.ecartDirection(autreM) < ecartMax || murMax==null)) {
					ecartMax = m.ecartDirection(autreM);
					murMax = autreM;
				}

			}

			murVecteur[3] = murMin;
			if (murMin!=null) {
				murBout[3] = murMin.getBoutDebut().equals(m.getBoutFin());
			}

			murVecteur[2] = murMax;
			if (murMax!=null) {
				murBout[2] = murMax.getBoutDebut().equals(m.getBoutFin());
			}

			meb = new murEtBout(murVecteur, murBout);
			hm.put(m, meb);
		}
		
		return hm;
	}
	
	//Class permettant juste de faire rentrer le bordel dans la hashmap
	private class murEtBout {
		
		private Mur[] murVecteur;
		private boolean[] murBout;
		
		public murEtBout(Mur[] mv, boolean[] mb) {
			murVecteur = mv;
			murBout = mb;
		}

		public Mur[] getMurVecteur() {
			return murVecteur;
		}

		public boolean[] getMurBout() {
			return murBout;
		}	
		
	}

}
