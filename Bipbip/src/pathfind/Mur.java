package pathfind;

import java.util.ArrayList;

public class Mur {

	//abscisse/ordonnee du coin en haut à gauche
	private final Node BoutDebut;
	private final Node BoutFin;
	//longueur : taille du mur suivant l'abscisse
	private final double epaisseur;//à partir du centre
	private final ArrayList<Node> portes;
	
	/* TODO : mettre les mf points dans le COULOIR et pas dans la piece
	 */
	
	public Mur(Node bd, Node bf, double e, ArrayList<Node> p) {
		BoutDebut = bd;
		BoutFin = bf;
		epaisseur = e;
		portes = p;
	}

	public Node getBoutDebut() {
		return BoutDebut;
	}

	public Node getBoutFin() {
		return BoutFin;
	}

	public double getEpaisseur() {
		return epaisseur;
	}

	public ArrayList<Node> getPortes() {
		return portes;
	}
	
}
