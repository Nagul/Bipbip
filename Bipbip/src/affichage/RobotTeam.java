package affichage;

import java.util.ArrayList;

import entities.Robot;
import entities.VirtualRobot;

import pathfind.Node;


public class RobotTeam {

	private ArrayList<VirtualRobot> team;

	public RobotTeam() {
		team = new ArrayList<VirtualRobot>();
	}
	
	public void initialize(ArrayList<Node> starts) {
		team.add(new VirtualRobot(starts.get(0), 0, new Robot("192.168.0.36")));
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
