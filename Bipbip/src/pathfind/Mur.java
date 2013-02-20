package pathfind;

import java.util.ArrayList;

public class Mur {

	private final Node BoutDebut;
	private final Node BoutFin;
	private final double epaisseur;
	private final ArrayList<Node> portes;
	private final String nom;
	private final TypeNode PieceDirect;
	private final TypeNode PieceIndirect;

	public Mur(Node bd, Node bf, ArrayList<Node> p, double e, String n, TypeNode pD, TypeNode pI) {
		BoutDebut = bd;
		BoutFin = bf;
		epaisseur = e;
		portes = p;
		nom = n;
		PieceDirect = pD;
		PieceIndirect = pI;
	}
	
	public Mur(Node bd, Node bf, double e, Node p, String n, TypeNode pD, TypeNode pI) {
		BoutDebut = bd;
		BoutFin = bf;
		epaisseur = e;
		if (p!=null) {
			portes = new ArrayList<Node>();
			portes.add(p);
		} else {
			portes = null;
		}
		nom = n;
		PieceDirect = pD;
		PieceIndirect = pI;
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
	
	public TypeNode getPieceDirect() {
		return PieceDirect;
	}

	public TypeNode getPieceIndirect() {
		return PieceIndirect;
	}

	public double[] getNormale() {
		double[] normale = new double[2];
		double a = BoutDebut.getAbscisse() - BoutFin.getAbscisse();
		double b = BoutDebut.getOrdonnee() - BoutFin.getOrdonnee();
		double q = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
		normale[0] = -b/q;
		normale[1] = a/q;
		return normale;
	}

	public double[] getDirecteur() {
		double[] directeur = new double[2];
		double a = BoutFin.getAbscisse() - BoutDebut.getAbscisse();
		double b = BoutFin.getOrdonnee() - BoutDebut.getOrdonnee();
		double q = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
		directeur[0] = a/q;
		directeur[1] = b/q;
		return directeur;
	}

	/*
	 * écart en angle de this à la droite passé en paramètre.
	 * ecart de 0 à PI
	 */
	//TODO : reste surement un bug ici
	public double ecartDirection(Mur autreMur) {
		double[] directeur = this.getDirecteur();
		double[] autreDirecteur = autreMur.getDirecteur();
		double[] normale = this.getNormale();
		if (normale[0]*autreDirecteur[0] + normale[1]*autreDirecteur[1] <= 0) {
			return (Math.acos(directeur[0]*autreDirecteur[0] + directeur[1]*autreDirecteur[1]));
		} else {
			return (2*Math.PI - Math.acos(directeur[0]*autreDirecteur[0] + directeur[1]*autreDirecteur[1]));
		}
		
	}
	
	/**
	 * Donne le point d'intersection entre deux murs
	 * @param autreMur
	 * @param ePos prendre la normale positivement
	 * @param auPos prendre l'autre normale positivement
	 * @return [0] : abscisse, [1] : coordonnee
	 */
	public double[] getIntersection(Mur autreMur, boolean ePos, boolean auPos) {
		
		double epaisseur;
		double autreEpaisseur;
		double ecartement = 5;
		
		if (ePos) {
			epaisseur = this.epaisseur + ecartement;
		} else {
			epaisseur = -this.epaisseur - ecartement;
		}
		
		if (auPos) {
			autreEpaisseur = autreMur.getEpaisseur() + ecartement;
		} else {
			autreEpaisseur = -autreMur.getEpaisseur() - ecartement;
		}
		
		double[] normale = this.getNormale();
		double[] autreNormale = autreMur.getNormale();
		
		double x1 = this.getBoutDebut().getAbscisse() + epaisseur*normale[0];
		double y1 = this.getBoutDebut().getOrdonnee() + epaisseur*normale[1];
		double x2 = this.getBoutFin().getAbscisse() + epaisseur*normale[0];
		double y2 = this.getBoutFin().getOrdonnee() + epaisseur*normale[1];
		double x3 = autreMur.getBoutDebut().getAbscisse() + autreEpaisseur*autreNormale[0];
		double y3 = autreMur.getBoutDebut().getOrdonnee() + autreEpaisseur*autreNormale[1];
		double x4 = autreMur.getBoutFin().getAbscisse() + autreEpaisseur*autreNormale[0];
		double y4 = autreMur.getBoutFin().getOrdonnee() + autreEpaisseur*autreNormale[1];
		
		double d = (x1-x2)*(y3-y4) - (y1-y2)*(x3-x4);
		if (d == 0) return null;
		double xi = ((x3-x4)*(x1*y2-y1*x2)-(x1-x2)*(x3*y4-y3*x4))/d;
		double yi = ((y3-y4)*(x1*y2-y1*x2)-(y1-y2)*(x3*y4-y3*x4))/d;
		
		double[] result = new double[2];
		result[0] = xi;
		result[1] = yi;
		return result;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((BoutDebut == null) ? 0 : BoutDebut.hashCode());
		result = prime * result + ((BoutFin == null) ? 0 : BoutFin.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mur other = (Mur) obj;
		if (BoutDebut == null) {
			if (other.BoutDebut != null)
				return false;
		} else if (!BoutDebut.equals(other.BoutDebut))
			return false;
		if (BoutFin == null) {
			if (other.BoutFin != null)
				return false;
		} else if (!BoutFin.equals(other.BoutFin))
			return false;
		return true;
	}
	
	
	
}
