package affichage;

import java.util.ArrayList;

import entities.Robot;
import entities.RobotVirtuel;

import pathfind.Node;


public class EquipeRobot {

	private ArrayList<RobotVirtuel> equipe;
	private Node depart;

	public EquipeRobot(Node d) {
		equipe = new ArrayList<RobotVirtuel>();
		depart = d;
	}
	
	public void initialize() {
		//TODO : adresse IP
		equipe.add(new RobotVirtuel(depart, 0, new Robot("192.168.0.36")));
	}

	public ArrayList<RobotVirtuel> getEquipe() {
		return equipe;
	}
	
}
