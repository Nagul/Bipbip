package robot;

import entities.Command;
import entities.Parameter;
import entities.Robot;
import pathfind.Arc;
import pathfind.Chemin;
import pathfind.Node;
import pathfind.TypeCouloir;
import pathfind.TypePiece;

public class RobotVirtuel {

	private Node dernierNode;
	private Arc arcCourant;
	private double clock;
	//orientation par rapport à DROITE, sens trigo, en degree
	private int orientation;
	private double vitesse;
	private Robot robot;
	
	public RobotVirtuel(Node depart, int orientationInit, Robot r) {
		dernierNode = depart;
		arcCourant = null;
		clock = 0;
		orientation = orientationInit;
		vitesse = 10;//à changer
		robot = r;
	}

	public double[] getPosition() {
		double[] position = new double[2];
		
		if (arcCourant==null) {
			//pas en mouvement
			position[0] = dernierNode.getAbscisse();
			position[1] = dernierNode.getOrdonnee();
		} else {
			//en mouvement
			//TODO : adapter ça en chemin et pas en arc
			double distance = arcCourant.getChemin().getDistance();
			position[0] = arcCourant.getNodeDepart().getAbscisse()
					+ (arcCourant.getNodeArrive().getAbscisse() - arcCourant.getNodeDepart().getAbscisse())
					*clock*vitesse/distance;
			position[1] = arcCourant.getNodeDepart().getOrdonnee()
					+ (arcCourant.getNodeArrive().getOrdonnee() - arcCourant.getNodeDepart().getOrdonnee())
					*clock*vitesse/distance;
		}
		
		return position;
	}
	
	//TODO : gérer le cas des chmins et non des arcs
	public void sendInstruction(Chemin chemin) {
		int i;
		int angle;
		int distance;
		Command command;
		Node depart;
		Node arrive;
		
		for (i = 0; i < chemin.getChemin().size() - 1; i++) {
			depart = chemin.getChemin().get(i);
			arrive = chemin.getChemin().get(i + 1);
			
			if (depart.getType() instanceof TypePiece
					&&arrive.getType() instanceof TypePiece) {
				//cas déplacement à l'intérieur d'une piece
				//s'orienter face a l'objectif
				command = new Command();
				command.setAction(Command.TURN);
				angle = depart.angleAutreNode(arrive) - orientation;
				command.addParameter(new Parameter("angle", angle), 0);
				robot.addCommand(command);
				//se deplacer
				command = new Command();
				command.setAction(1);
				distance = (int) depart.calculerDistance(arrive);
				command.addParameter(new Parameter("distance", distance), 0);
				robot.addCommand(command);
				
			} else if ((depart.getType() instanceof TypePiece
					&&arrive.getType() instanceof TypeCouloir)
					||(depart.getType() instanceof TypeCouloir
							&&arrive.getType() instanceof TypePiece)) {
				//cas passer une porte
				//s'orienter face a l'objectif
				command = new Command();
				command.setAction(2);
				//TODO : rajouter paramètre
				robot.addCommand(command);
				//se deplacer
				command = new Command();
				command.setAction(1);
				//TODO : rajouter paramètre
				robot.addCommand(command);
				
			} else {
				//cas suivre un mur
				command = new Command();
				command.setAction(3);
				//TODO : rajouter paramètre
				robot.addCommand(command);
			}
		}
	}
	
	public Node getDernierNode() {
		return dernierNode;
	}

	public Arc getArcCourant() {
		return arcCourant;
	}

	public double getClock() {
		return clock;
	}

	public double getOrientation() {
		return orientation;
	}
	
}
