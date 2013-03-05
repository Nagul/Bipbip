package affichage;

import java.util.ArrayList;

import entities.Robot;
import entities.VirtualRobot;

import pathfind.Node;


public class RobotTeam {

	private ArrayList<VirtualRobot> team;
	private Node start;

	public RobotTeam(Node s) {
		team = new ArrayList<VirtualRobot>();
		start = s;
	}
	
	public void initialize() {
		//TODO : adresse IP
		team.add(new VirtualRobot(start, 0, new Robot("192.168.0.36")));
	}

	public ArrayList<VirtualRobot> getTeam() {
		return team;
	}
	
	public void run() {
		for (VirtualRobot r : team) {
			r.run();
		}
	}
	
}
