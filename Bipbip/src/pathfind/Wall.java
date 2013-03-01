package pathfind;

import java.util.ArrayList;

public class Wall {

	private final Node cornerStart;
	private final Node cornerEnd;
	private final double width;
	private final ArrayList<Node> doors;
	private final String name;
	private final TypeNode roomDirect;
	private final TypeNode roomIndirect;

	/**
	 * Constructor of Wall with multiples doors
	 * @param cS the Start Corner node of the wall
	 * @param cE the End Corner node of the wall
	 * @param d the doors of the wall
	 * @param w the width of the wall
	 * @param n the name of the wall
	 * @param rD the TypeNode of the building part on the normal direction
	 * @param rI the TypeNode of the building part on the non-normal direction
	 */
	public Wall(Node cS, Node cE, ArrayList<Node> d, double w, String n, TypeNode rD, TypeNode rI) {
		cornerStart = cS;
		cornerEnd = cE;
		width = w;
		doors = d;
		name = n;
		roomDirect = rD;
		roomIndirect = rI;
	}
	
	/**
	 * Constructor of Wall with only 1 door
	 * @param cS the Start Corner node of the wall
	 * @param cE the End Corner node of the wall
	 * @param w the width of the wall
	 * @param d the door of the wall
	 * @param n the name of the wall
	 * @param rD the TypeNode of the building part on the normal direction
	 * @param rI the TypeNode of the building part on the non-normal direction
	 */
	public Wall(Node cS, Node cE, double w, Node d, String n, TypeNode rD, TypeNode rI) {
		cornerStart = cS;
		cornerEnd = cE;
		width = w;
		if (d!=null) {
			doors = new ArrayList<Node>();
			doors.add(d);
		} else {
			doors = null;
		}
		name = n;
		roomDirect = rD;
		roomIndirect = rI;
	}

	public Node getCornerStart() {
		return cornerStart;
	}

	public Node getCornerEnd() {
		return cornerEnd;
	}

	public double getWidth() {
		return width;
	}

	public ArrayList<Node> getDoors() {
		return doors;
	}
	
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @param s the Side (from the robot POV) where the wall is
	 * @return
	 */
	public TypeNode getRoomDirect() {
		return roomDirect;
	}

	/**
	 * 
	 * @param s the Side (from the robot POV) where the wall is
	 * @return
	 */
	public TypeNode getRoomIndirect() {
		return roomIndirect;
	}

	/**
	 * calculate the normal of the wall
	 * @return the normal of the wall
	 */
	public double[] getNormal() {
		double[] normale = new double[2];
		double a = cornerEnd.getAbscissa() - cornerStart.getAbscissa();
		double b = cornerEnd.getOrdinate() - cornerStart.getOrdinate();
		double q = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
		normale[0] = b/q;
		normale[1] = -a/q;
		return normale;
	}

	/**
	 * calculate the vector director of the wall
	 * @return the vector director of the wall
	 */
	public double[] getDirector() {
		double[] directeur = new double[2];
		double a = cornerEnd.getAbscissa() - cornerStart.getAbscissa();
		double b = cornerEnd.getOrdinate() - cornerStart.getOrdinate();
		double q = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
		directeur[0] = a/q;
		directeur[1] = b/q;
		return directeur;
	}

	/**
	 * Calculate the angle formed by this Wall and otherWall
	 * @param otherWall the other Wall
	 * @return the angle formed by this Wall and otherWall
	 */
	//TODO : probably still a bug here
	public double calculateAngle(Wall otherWall) {
		double[] director = this.getDirector();
		double[] otherDirector = otherWall.getDirector();
		if (director[1]*otherDirector[0] - director[0]*otherDirector[1] <= 0) {
			return (Math.acos(director[0]*otherDirector[0] + director[1]*otherDirector[1]));
		} else {
			return (2*Math.PI - Math.acos(director[0]*otherDirector[0] + director[1]*otherDirector[1]));
		}
		
	}

	/**
	 *  calculate the intersection of this wall and otherWall
	 * @param otherWall the other wall
	 * @param tPos take This normal positively
	 * @param oPos take the Other normal positively
	 * @return the intersection of this wall and otherWall
	 */
	public double[] getIntersection(Wall otherWall, boolean tPos, boolean oPos, double space) {
		
		double width;
		double otherWidth;
		
		if (tPos) {
			width = this.width + space;
		} else {
			width = -this.width - space;
		}
		
		if (oPos) {
			otherWidth = otherWall.getWidth() + space;
		} else {
			otherWidth = -otherWall.getWidth() - space;
		}
		
		double[] normale = this.getNormal();
		double[] autreNormale = otherWall.getNormal();
		
		double x1 = this.getCornerStart().getAbscissa() + width*normale[0];
		double y1 = this.getCornerStart().getOrdinate() + width*normale[1];
		double x2 = this.getCornerEnd().getAbscissa() + width*normale[0];
		double y2 = this.getCornerEnd().getOrdinate() + width*normale[1];
		double x3 = otherWall.getCornerStart().getAbscissa() + otherWidth*autreNormale[0];
		double y3 = otherWall.getCornerStart().getOrdinate() + otherWidth*autreNormale[1];
		double x4 = otherWall.getCornerEnd().getAbscissa() + otherWidth*autreNormale[0];
		double y4 = otherWall.getCornerEnd().getOrdinate() + otherWidth*autreNormale[1];
		
		double d = (x1-x2)*(y3-y4) - (y1-y2)*(x3-x4);
		if (d == 0) return null;
		double xi = ((x3-x4)*(x1*y2-y1*x2)-(x1-x2)*(x3*y4-y3*x4))/d;
		double yi = ((y3-y4)*(x1*y2-y1*x2)-(y1-y2)*(x3*y4-y3*x4))/d;
		
		double[] result = new double[2];
		result[0] = xi;
		result[1] = yi;
		return result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cornerStart == null) ? 0 : cornerStart.hashCode());
		result = prime * result + ((cornerEnd == null) ? 0 : cornerEnd.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wall other = (Wall) obj;
		if (cornerStart == null) {
			if (other.cornerStart != null)
				return false;
		} else if (!cornerStart.equals(other.cornerStart))
			return false;
		if (cornerEnd == null) {
			if (other.cornerEnd != null)
				return false;
		} else if (!cornerEnd.equals(other.cornerEnd))
			return false;
		return true;
	}
	
	
	
}
