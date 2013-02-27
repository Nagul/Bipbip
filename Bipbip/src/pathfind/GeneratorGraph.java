package pathfind;

import java.util.ArrayList;
import java.util.HashMap;

public class GeneratorGraph {
	
	private Graph graph;
	private ArrayList<Node> nodes;
	
	/**
	 * Constructor for GeneratorGraph
	 * @param n the users nodes such as special location in rooms
	 */
	public GeneratorGraph(ArrayList<Node> n) {
		graph = new Graph();
		nodes = n;
	}
	
	/**
	 * generate the graph so we can calculate the orders to send
	 * @return the generated graph
	 */
	public Graph generatateGraph() {
		
		//generation initiale
		// TODO : pas generer les points qui sont en type exterieur
		double epaisseur;
		Path chemin;
		Wall autreWall;
		double[] normale;
		double[] coord = new double[2];
		Node nodeCourant1;
		Node nodeCourant2;
		Node nodeNew1;
		Node nodeNew2;
		
		double ecartement = 30;
		
		HashMap<Wall, murEtBout> mapAdjacenceWall = this.mapWallAdjacents();
		
		for (Wall m : affichage.Bipbip.walls) {
			normale = m.getNormal();
			epaisseur = m.getWidth() + ecartement;
			
			if (mapAdjacenceWall.get(m).getWallVecteur()[0]==null) {
				//Cas bout de mur seul.
				coord[0] = m.getCornerStart().getAbscissa() + normale[0]*epaisseur;
				coord[1] = m.getCornerStart().getOrdinate() + normale[1]*epaisseur;
				nodeCourant1 = new Node(coord[0], coord[1], m.getName() + "D1", m.getRoomDirect());
				graph.addNode(nodeCourant1);
				
				coord[0] = m.getCornerStart().getAbscissa() - normale[0]*epaisseur;
				coord[1] = m.getCornerStart().getOrdinate() - normale[1]*epaisseur;
				nodeCourant2 = new Node(coord[0], coord[1], m.getName() + "D2", m.getRoomIndirect());
				graph.addNode(nodeCourant2);
				
				chemin = new Path();
				chemin.addStep(nodeCourant1);
				//TODO : creer un truc pour tourner par rapport au bout du mur
				chemin.addStep(nodeCourant2);
				graph.addArc(new Arc(nodeCourant1, nodeCourant2, chemin));
				
			} else {
				//cas plusieurs murs
				
				autreWall = mapAdjacenceWall.get(m).getWallVecteur()[0];

				coord = m.getIntersection(autreWall, true, !mapAdjacenceWall.get(m).getWallBout()[0]);

				if (coord==null) {
					coord = new double[2];
					coord[0] = m.getCornerStart().getAbscissa() + normale[0]*epaisseur;
					coord[1] = m.getCornerStart().getOrdinate() + normale[1]*epaisseur;
				}
				nodeCourant1 = graph.searchNode(coord[0], coord[1]);
				if (nodeCourant1==null) {
					nodeCourant1 = new Node(coord[0], coord[1], m.getName() + "|" + autreWall.getName(), m.getRoomDirect());
					graph.addNode(nodeCourant1);
				}


				autreWall = mapAdjacenceWall.get(m).getWallVecteur()[1];
				
				coord = m.getIntersection(autreWall, false, mapAdjacenceWall.get(m).getWallBout()[1]);
				
				if (coord==null) {
					coord = new double[2];
					coord[0] = m.getCornerStart().getAbscissa() - normale[0]*epaisseur;
					coord[1] = m.getCornerStart().getOrdinate() - normale[1]*epaisseur;
				}
				nodeCourant2 = graph.searchNode(coord[0], coord[1]);
				if (nodeCourant2==null) {
					nodeCourant2 = new Node(coord[0], coord[1], m.getName() + "|" + autreWall.getName(), m.getRoomIndirect());
					graph.addNode(nodeCourant2);
				}
			}


			//TODO : BESOIN DE TRIER LES PORTES PAR RAPPORT A DEBUT -> FIN
			if (m.getDoors()!=null) {
				for (Node porte : m.getDoors()) {
					coord[0] = porte.getAbscissa() + normale[0]*epaisseur;
					coord[1] = porte.getOrdinate() + normale[1]*epaisseur;
					nodeNew1 = new Node(coord[0], coord[1], porte.getName() + "1", m.getRoomDirect());
					graph.addNode(nodeNew1);

					coord[0] = porte.getAbscissa() - normale[0]*epaisseur;
					coord[1] = porte.getOrdinate() - normale[1]*epaisseur;
					nodeNew2 = new Node(coord[0], coord[1], porte.getName() + "2", m.getRoomIndirect());
					graph.addNode(nodeNew2);

					chemin = new Path();
					chemin.addStep(nodeNew1);
					chemin.addStep(nodeNew2);
					graph.addArc(new Arc(nodeNew1, nodeNew2, chemin));

					chemin = new Path();
					chemin.addStep(nodeCourant1);
					chemin.addStep(nodeNew1);
					graph.addArc(new Arc(nodeCourant1, nodeNew1, chemin));

					chemin = new Path();
					chemin.addStep(nodeCourant2);
					chemin.addStep(nodeNew2);
					graph.addArc(new Arc(nodeCourant2, nodeNew2, chemin));

					nodeCourant1 = nodeNew1;
					nodeCourant2 = nodeNew2;
				}
			}
			
			
			if (mapAdjacenceWall.get(m).getWallVecteur()[2]==null) {
				//Cas bout de mur seul.
				coord[0] = m.getCornerEnd().getAbscissa() + normale[0]*epaisseur;
				coord[1] = m.getCornerEnd().getOrdinate() + normale[1]*epaisseur;
				nodeNew1 = new Node(coord[0], coord[1], m.getName() + "F1", m.getRoomDirect());
				graph.addNode(nodeNew1);
				
				coord[0] = m.getCornerEnd().getAbscissa() - normale[0]*epaisseur;
				coord[1] = m.getCornerEnd().getOrdinate() - normale[1]*epaisseur;
				nodeNew2 = new Node(coord[0], coord[1], m.getName() + "F2", m.getRoomIndirect());
				graph.addNode(nodeNew2);
				
				chemin = new Path();
				chemin.addStep(nodeNew1);
				//TODO : creer un truc pour tourner par rapport au bout du mur
				chemin.addStep(nodeNew2);
				graph.addArc(new Arc(nodeNew1, nodeNew2, chemin));
					
			} else {
				
				autreWall = mapAdjacenceWall.get(m).getWallVecteur()[2];


				coord = m.getIntersection(autreWall, true, mapAdjacenceWall.get(m).getWallBout()[2]);

				if (coord==null) {
					coord = new double[2];
					coord[0] = m.getCornerEnd().getAbscissa() + normale[0]*epaisseur;
					coord[1] = m.getCornerEnd().getOrdinate() + normale[1]*epaisseur;
				}
				nodeNew1 = graph.searchNode(coord[0], coord[1]);
				if (nodeNew1==null) {
					nodeNew1 = new Node(coord[0], coord[1], m.getName() + "|" + autreWall.getName(), m.getRoomDirect());
					graph.addNode(nodeNew1);
				}

				autreWall = mapAdjacenceWall.get(m).getWallVecteur()[3];

				coord = m.getIntersection(autreWall, false, !mapAdjacenceWall.get(m).getWallBout()[3]);

				if (coord==null) {
					coord = new double[2];
					coord[0] = m.getCornerEnd().getAbscissa() - normale[0]*epaisseur;
					coord[1] = m.getCornerEnd().getOrdinate() - normale[1]*epaisseur;
				}
				nodeNew2 = graph.searchNode(coord[0], coord[1]);
				if (nodeNew2==null) {
					nodeNew2 = new Node(coord[0], coord[1], m.getName() + "|" + autreWall.getName(), m.getRoomIndirect());
					graph.addNode(nodeNew2);
				}
			}
			
			chemin = new Path();
			chemin.addStep(nodeCourant1);
			chemin.addStep(nodeNew1);
			graph.addArc(new Arc(nodeCourant1, nodeNew1, chemin));
			
			chemin = new Path();
			chemin.addStep(nodeCourant2);
			chemin.addStep(nodeNew2);
			graph.addArc(new Arc(nodeCourant2, nodeNew2, chemin));
			
		}

		//generation finale
		while ((nodes!=null)&&(!nodes.isEmpty())) {
			Node n = nodes.get(0);
			graph.addNode(n);
			//première idee : tous les nodes d'une même pièce sont fortement connexes.
			if (n.getType() instanceof TypePiece) {
				for (Node autreNode : graph.getNodes()) {
					//TODO : HT1 : pièces vides
					if (n.getType().getId()==autreNode.getType().getId()
							&&!n.equals(autreNode)) {
						chemin = new Path();
						chemin.addStep(n);
						chemin.addStep(autreNode);
						Arc a = new Arc(n, autreNode, chemin);
						graph.addArc(a);
					}
				}
			} else if (n.getType() instanceof TypeCouloir) {
				//passages pietons
				/*
				 * Première idee basique : placer les passage
				 * a la main, puis les relier a tous les trucs a proximite
				 */
				for (Node autreNode : graph.getNodes()) {
					if (n.getType().getId()==autreNode.getType().getId()
							&&!n.equals(autreNode)
							&&n.calculateDistance(autreNode)<70) {
						chemin = new Path();
						chemin.addStep(n);
						chemin.addStep(autreNode);
						Arc a = new Arc(n, autreNode, chemin);
						graph.addArc(a);
					}
				}
			}
			nodes.remove(0);
		}
		return graph;
	}

	public Graph getGraph() {
		return graph;
	}


	private HashMap<Wall, murEtBout> mapWallAdjacents() {
		HashMap<Wall, murEtBout> hm = new HashMap<Wall, murEtBout>();
		Wall[] murVecteur;
		boolean[] murBout;
		murEtBout meb;
		ArrayList<Wall> murListDebut = new ArrayList<Wall>();
		ArrayList<Wall> murListFin = new ArrayList<Wall>();
		Wall murMin;
		Wall murMax;
		double ecartMin = 0;
		double ecartMax = 0;

		for (Wall m : affichage.Bipbip.walls) {
			murVecteur = new Wall[4];
			murBout = new boolean[4];
			murListDebut.clear();
			murListFin.clear();
			//rechercher les murs touchant
			for (Wall autreM : affichage.Bipbip.walls) {
				if((m.getCornerStart().equals(autreM.getCornerStart())
						||m.getCornerStart().equals(autreM.getCornerEnd()))
						&&!m.equals(autreM)) {
					murListDebut.add(autreM);
				}
				if((m.getCornerEnd().equals(autreM.getCornerStart())
						||m.getCornerEnd().equals(autreM.getCornerEnd()))
						&&!m.equals(autreM)) {
					murListFin.add(autreM);
				}
			}
			
			//rechercher parmis les murs touchant ceux qui sont a cote
			murMin = null;
			murMax = null;
			for (Wall autreM : murListDebut) {
				if (murMin==null) {
					if (autreM.getCornerStart().equals(m.getCornerStart())) {
						ecartMin = m.calculateAngle(autreM);
					} else if (m.calculateAngle(autreM) - Math.PI >= 0) {
						ecartMin = m.calculateAngle(autreM) - Math.PI;
					} else {
						ecartMin = m.calculateAngle(autreM) + Math.PI;
					}
					murMin = autreM;
					
				} else if (autreM.getCornerStart().equals(m.getCornerStart())
						&&m.calculateAngle(autreM) < ecartMin) {
					ecartMin = m.calculateAngle(autreM);
					murMin = autreM;
					
				} else if (autreM.getCornerEnd().equals(m.getCornerStart())
						&&m.calculateAngle(autreM) - Math.PI < ecartMin
						&&m.calculateAngle(autreM) - Math.PI >= 0) {
					ecartMin = m.calculateAngle(autreM) - Math.PI;
					murMin = autreM;
				}

				if (murMax==null) {
					if (autreM.getCornerStart().equals(m.getCornerStart())) {
						ecartMax = m.calculateAngle(autreM);
					} else if (m.calculateAngle(autreM) + Math.PI < 2*Math.PI) {
						ecartMax = m.calculateAngle(autreM) + Math.PI;
					} else {
						ecartMax = m.calculateAngle(autreM) - Math.PI;
					}
					murMax = autreM;
					
				} else if (autreM.getCornerStart().equals(m.getCornerStart())
						&&m.calculateAngle(autreM) > ecartMax) {
					ecartMax = m.calculateAngle(autreM);
					murMax = autreM;
					
				} else if (autreM.getCornerEnd().equals(m.getCornerStart())
						&&m.calculateAngle(autreM) + Math.PI > ecartMax
						&&m.calculateAngle(autreM) + Math.PI < 2*Math.PI) {
					ecartMax = m.calculateAngle(autreM) + Math.PI;
					murMax = autreM;
				}

			}

			murVecteur[1] = murMin;
			if (murMin!=null) {
				murBout[1] = murMin.getCornerStart().equals(m.getCornerStart());
			}

			murVecteur[0] = murMax;
			if (murMax!=null) {
				murBout[0] = murMax.getCornerStart().equals(m.getCornerStart());
			}

			murMin = null;
			murMax = null;
			for (Wall autreM : murListFin) {
				if (murMin==null) {
					if (!autreM.getCornerStart().equals(m.getCornerEnd())) {
						ecartMin = m.calculateAngle(autreM);
					} else if (m.calculateAngle(autreM) + Math.PI < 2*Math.PI) {
						ecartMin = m.calculateAngle(autreM) + Math.PI;
					} else {
						ecartMin = m.calculateAngle(autreM) - Math.PI;
					}
					murMin = autreM;
					
				} else if (autreM.getCornerStart().equals(m.getCornerEnd())
						&&m.calculateAngle(autreM) + Math.PI > ecartMin
						&&m.calculateAngle(autreM) + Math.PI < 2*Math.PI) {
					ecartMin = m.calculateAngle(autreM) + Math.PI;
					murMin = autreM;
					
				} else if (autreM.getCornerEnd().equals(m.getCornerEnd())
						&&m.calculateAngle(autreM) > ecartMin) {
					ecartMin = m.calculateAngle(autreM);
					murMin = autreM;
				}

				if (murMax==null) {
					if (!autreM.getCornerStart().equals(m.getCornerEnd())) {
						ecartMax = m.calculateAngle(autreM);
					} else if (m.calculateAngle(autreM) - Math.PI >= 0) {
						ecartMax = m.calculateAngle(autreM) - Math.PI;
					} else {
						ecartMax = m.calculateAngle(autreM) + Math.PI;
					}
					murMax = autreM;
					
				} else if (autreM.getCornerStart().equals(m.getCornerEnd())
						&&m.calculateAngle(autreM) - Math.PI < ecartMax
						&&m.calculateAngle(autreM) - Math.PI >= 0) {
					ecartMax = m.calculateAngle(autreM) - Math.PI;
					murMax = autreM;
					
				} else if (autreM.getCornerEnd().equals(m.getCornerEnd())
						&&(m.calculateAngle(autreM) < ecartMax || murMax==null)) {
					ecartMax = m.calculateAngle(autreM);
					murMax = autreM;
				}

			}

			murVecteur[3] = murMin;
			if (murMin!=null) {
				murBout[3] = murMin.getCornerStart().equals(m.getCornerEnd());
			}

			murVecteur[2] = murMax;
			if (murMax!=null) {
				murBout[2] = murMax.getCornerStart().equals(m.getCornerEnd());
			}

			meb = new murEtBout(murVecteur, murBout);
			hm.put(m, meb);
		}
		
		return hm;
	}
	
	//Class permettant juste de faire rentrer le bordel dans la hashmap
	private class murEtBout {
		
		private Wall[] murVecteur;
		private boolean[] murBout;
		
		public murEtBout(Wall[] mv, boolean[] mb) {
			murVecteur = mv;
			murBout = mb;
		}

		public Wall[] getWallVecteur() {
			return murVecteur;
		}

		public boolean[] getWallBout() {
			return murBout;
		}	
		
	}

}
