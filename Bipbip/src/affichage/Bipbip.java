package affichage;

import java.util.ArrayList;

import pathfind.*;


import com.trolltech.qt.gui.QApplication;

public class Bipbip {
	
	public static ArrayList<Wall> walls;
	public static RobotTeam team;
	
	public static void main(String[] args) {
		
		walls = new ArrayList<Wall>();
		
		SalleTest salleTest = new SalleTest();
		salleTest.initialisation();
		ArrayList<Node> listUser = salleTest.getListUser();
		
		/*
		Hopital hopital = new Hopital();
		hopital.initialisation();
		ArrayList<Node> listUser = hopital.getListUser();
		*/
		
		
		team = new RobotTeam(listUser.get(0));
		team.initialize();
		
		
		QApplication.initialize(args);
		WidgetClient test = new WidgetClient(listUser);
		//WidgetDev test = new WidgetDev(listUser);
		test.show();
		QApplication.exec();
		
	}

}
