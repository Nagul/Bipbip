package pathfind;

import java.util.ArrayList;
import java.util.Vector;

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
	
	public Vector<Double> getNormale() {
		Vector<Double> normale = new Vector<Double>(2);
		double a = BoutDebut.getAbscisse() - BoutFin.getAbscisse();
		double b = BoutDebut.getOrdonnee() - BoutFin.getOrdonnee();
		double q = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
		normale.add(new Double(b/q));
		normale.add(new Double(-a/q));
		return normale;
	}
	
}
