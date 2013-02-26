package robot;

import entities.Command;
import entities.Parameter;
import entities.Robot;
import pathfind.Arc;
import pathfind.Chemin;
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
				//se deplacer
				command = new Command();
				command.setAction(Command.FORWARD);
				distance = (int) depart.calculerDistance(arrive);
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
				//se deplacer
				command = new Command();
				command.setAction(Command.FOLLOW_WALL);
				distance = (int) depart.calculerDistance(arrive);
				command.addParameter(new Parameter("distance", distance), 0);
				command.addParameter(new Parameter("vitesse", vitesse), 1);
				robot.addCommand(command);
			}
		}
		command = new Command();
		command.setAction(Command.STOP);
		robot.addCommand(command);
		robot.executeStack();
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
