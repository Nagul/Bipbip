package affichage;

import java.util.ArrayList;

import entities.Robot;

import pathfind.Node;

import robot.RobotVirtuel;

public class EquipeRobot {

	private ArrayList<RobotVirtuel> equipe;
	private Node depart;

	public EquipeRobot(Node d) {
		equipe = new ArrayList<RobotVirtuel>();
		depart = d;
	}
	
	public void initialize() {
		//TODO : adresse IP
		equipe.add(new RobotVirtuel(depart, 0, new Robot("")));
	}

	public ArrayList<RobotVirtuel> getEquipe() {
		return equipe;
	}
	
}
