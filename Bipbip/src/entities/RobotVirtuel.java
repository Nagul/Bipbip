package entities;

import pathfind.Arc;
import pathfind.Path;
import pathfind.Node;
import pathfind.TypeCouloir;

public class RobotVirtuel {

	private Node dernierNode;
	private Arc arcCourant;
	private double clock;
	//orientation par rapport à DROITE, sens trigo, en degree
	private int orientation;
	private int vitesse;
	private Robot robot;
	
	public RobotVirtuel(Node depart, int orientationInit, Robot r) {
		dernierNode = depart;
		arcCourant = null;
		clock = 0;//à gérer
		orientation = orientationInit;
		vitesse = 75;
		robot = r;
	}

	public double[] getPosition() {
		double[] position = new double[2];
		
		if (arcCourant==null) {
			//pas en mouvement
			position[0] = dernierNode.getAbscissa();
			position[1] = dernierNode.getOrdinate();
		} else {
			//en mouvement
			//TODO : adapter ça en chemin et pas en arc
			double distance = arcCourant.getPath().getDistance();
			position[0] = arcCourant.getNodeStart().getAbscissa()
					+ (arcCourant.getNodeTarget().getAbscissa() - arcCourant.getNodeStart().getAbscissa())
					*clock*vitesse/distance;
			position[1] = arcCourant.getNodeStart().getOrdinate()
					+ (arcCourant.getNodeTarget().getOrdinate() - arcCourant.getNodeStart().getOrdinate())
					*clock*vitesse/distance;
		}
		
		return position;
	}
	
	//TODO : gérer le cas des chmins et non des arcs
	public void sendInstruction(Path chemin) {
		int i;
		int angle;
		int distance;
		Command command;
		Node depart;
		Node arrive;
		
		for (i = 0; i < chemin.getPath().size() - 1; i++) {
			depart = chemin.getPath().get(i);
			arrive = chemin.getPath().get(i + 1);
			
			if (!(depart.getType() instanceof TypeCouloir)
					||!(arrive.getType() instanceof TypeCouloir)) {
				//cas déplacement à l'intérieur d'une piece ou piece/couloir
				//s'orienter face a l'objectif
				command = new Command();
				command.setAction(Command.TURN);
				angle = depart.angleAutreNode(arrive) - orientation;
				command.addParameter(new Parameter("angle", angle), 0);
				robot.addCommand(command);
				orientation += angle;
				System.out.println(angle);
				//se deplacer
				command = new Command();
				command.setAction(Command.FORWARD);
				distance = (int) depart.calculateDistance(arrive);
				command.addParameter(new Parameter("distance", distance), 0);
				command.addParameter(new Parameter("vitesse", vitesse), 1);
				robot.addCommand(command);
				
			} else {
				//cas suivre un mur
				//s'orienter face a l'objectif
				command = new Command();
				command.setAction(Command.TURN);
				angle = depart.angleAutreNode(arrive) - orientation;
				command.addParameter(new Parameter("angle", angle), 0);
				robot.addCommand(command);
				orientation += angle;
				System.out.println(angle);
				//se deplacer
				command = new Command();
				command.setAction(Command.FOLLOW_WALL);
				distance = (int) depart.calculateDistance(arrive);
				command.addParameter(new Parameter("distance", distance), 0);
				command.addParameter(new Parameter("vitesse", vitesse), 1);
				robot.addCommand(command);
			}
		}
		command = new Command();
		command.setAction(Command.STOP);
		robot.addCommand(command);
		//robot.executeStack();
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
