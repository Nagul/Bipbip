package entities;

import java.util.ArrayList;

import pathfind.Arc;
import pathfind.Node;
import pathfind.Side;

public class VirtualRobot implements Runnable {

	private Node lastNode;
	private Arc currentArc;
	private double clock;	//TODO
	private int orientation;	//to abscissa/ordinate axis
	private int speed;
	private Robot robot;
	
	private int step;
	private ArrayList<Node> targets;
	
	public VirtualRobot(Node start, int orientationInit, Robot r) {
		lastNode = start;
		currentArc = null;
		clock = 0;
		orientation = orientationInit;
		speed = 75;
		robot = r;
		step = 0;
		targets = affichage.Bipbip.salleTest.getPathExample(r);
	}

	public double[] getPosition() {
		double[] position = new double[2];
		
		if (currentArc==null) {
			//moving
			position[0] = lastNode.getAbscissa();
			position[1] = lastNode.getOrdinate();
		} else {
			//not moving
			//TODO : better feedback with path instead of node
			double distance = currentArc.getPath().getDistance();
			position[0] = currentArc.getNodeStart().getAbscissa()
					+ (currentArc.getNodeTarget().getAbscissa() - currentArc.getNodeStart().getAbscissa())
					*clock*speed/distance;
			position[1] = currentArc.getNodeStart().getOrdinate()
					+ (currentArc.getNodeTarget().getOrdinate() - currentArc.getNodeStart().getOrdinate())
					*clock*speed/distance;
		}
		
		return position;
	}
	
	/**
	 * Send the needed instructions to the robot
	 * @param path the path calculated by GraphSearc.shortherDistance
	 */
	public void sendInstruction(ArrayList<Arc> path) {
		int i;
		int angle;
		int distance;
		Command command;
		Node depart;
		Node arrive;
		Arc arcMove;
		
		for (i = 0; i < path.size(); i++) {
			arcMove = path.get(i);
			depart = arcMove.getNodeStart();
			arrive = arcMove.getNodeTarget();
			
			if (arcMove.getSide()==Side.None) {
				//moving in/out a room
				//orientation
				command = new Command();
				command.setAction(Command.TURN);
				angle = depart.angleAutreNode(arrive) - orientation;
				if (angle > 180) {
					angle -= 360;
				} else if (angle < -180) {
					angle += 360;
				}
				command.addParameter(new Parameter("angle", angle), 0);
				robot.addCommand(command);
				orientation += angle;
				System.out.println(angle);
				//move
				command = new Command();
				command.setAction(Command.FORWARD);
				distance = (int) depart.calculateDistance(arrive);
				command.addParameter(new Parameter("distance", distance), 0);
				robot.addCommand(command);
				
			} else {
				//follow a wall
				//orientation
				command = new Command();
				command.setAction(Command.TURN);
				angle = depart.angleAutreNode(arrive) - orientation;
				if (angle > 180) {
					angle -= 360;
				} else if (angle < -180) {
					angle += 360;
				}
				command.addParameter(new Parameter("angle", angle), 0);
				robot.addCommand(command);
				orientation += angle;
				System.out.println(angle);
				//move
				command = new Command();
				command.setAction(Command.FOLLOW_WALL);
				distance = (int) depart.calculateDistance(arrive);
				if (arcMove.getSide()==Side.Left) {
					command.addParameter(new Parameter("direction", Command.LEFT_CROSSING), 0);
				} else {
					command.addParameter(new Parameter("direction", Command.RIGHT_CROSSING), 0);
				}
				command.addParameter(new Parameter("distance", distance), 1);
				robot.addCommand(command);
			}
			
		}
		command = new Command();
		command.setAction(Command.STOP);
		robot.addCommand(command);
		robot.executeStack();
	}
	
	
	public Node getLastNode() {
		return lastNode;
	}

	public Arc getCurrentArc() {
		return currentArc;
	}

	public double getClock() {
		return clock;
	}

	public double getOrientation() {
		return orientation;
	}
	
	public Robot getRobot() {
		return robot;
	}

	public void getNextInstruction() {
		
		if (step < targets.size() - 1) {
			ArrayList<Arc> path = affichage.Bipbip.graphSearch.shorterPath(targets.get(step), targets.get(step + 1));
			this.sendInstruction(path);
			affichage.Bipbip.test.drawPath(path);
		}
		
		step += 1;
	}
	
	@SuppressWarnings("static-access")
	public void run() {
		String log;
		String[] tmp;
		
		this.getNextInstruction();
		
		while (true) {
			log = robot.getFeedback();
			if (!log.equals("")) {
				tmp = log.split("<br/>");
				for (int i = 0; i < tmp.length; i++){
					Feedback f = new Feedback(tmp[i]);
					if (f.getAction().equals("stop")) {
						robot.clearCommands();
						try {
							Thread.currentThread().sleep(1000);
						} catch (Exception e) {
							System.out.println(e);
						}
						this.getNextInstruction();
					} else if (f.getAction().equals("obstacle")) {
						//TODO
					}
					System.out.println(f.toString());
				}
			}
			try {
				Thread.currentThread().sleep(1000);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
}
