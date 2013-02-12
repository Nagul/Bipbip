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
	private final String nom;
	
	/* TODO : mettre les mf points dans le COULOIR et pas dans la piece
	 */
	
	public Mur(Node bd, Node bf, double e, ArrayList<Node> p, String n) {
		BoutDebut = bd;
		BoutFin = bf;
		epaisseur = e;
		portes = p;
		nom = n;
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
	
	public String getNom() {
		return nom;
	}
	
	public Double[] getNormale() {
		Double[] normale = new Double[2];
		double a = BoutDebut.getAbscisse() - BoutFin.getAbscisse();
		double b = BoutDebut.getOrdonnee() - BoutFin.getOrdonnee();
		double q = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
		normale[0] = new Double(b/q);
		normale[1] = new Double(-a/q);
		return normale;
	}
	
	public Double[] getDirecteur() {
		Double[] directeur = new Double[2];
		double a = BoutFin.getAbscisse() - BoutDebut.getAbscisse();
		double b = BoutFin.getOrdonnee() - BoutDebut.getOrdonnee();
		double q = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
		directeur[0] = new Double(a/q);
		directeur[1] = new Double(b/q);
		return directeur;
	}
	
	//TODO : A FAIRE
	public double ecartDirection(Mur m) {
		return 0;
	}
	
}
