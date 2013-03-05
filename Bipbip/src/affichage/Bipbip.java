package affichage;

import java.util.ArrayList;

import pathfind.*;


import com.trolltech.qt.gui.QApplication;

public class Bipbip {
	
	public static ArrayList<Wall> walls;
	public static RobotTeam team;
	public static SalleTest salleTest;
	public static GraphSearch graphSearch;
	//public static Hopital hopital;
	public static WidgetClient test;
	//public static WidgetDev test;
	
	public static void main(String[] args) {
		
		walls = new ArrayList<Wall>();
		
		salleTest = new SalleTest();
		salleTest.initialisation();
		ArrayList<Node> listUser = salleTest.getListUser();
		
		/*
		Hopital hopital = new Hopital();
		hopital.initialisation();
		ArrayList<Node> listUser = hopital.getListUser();
		*/
		
		
		team = new RobotTeam();
		team.initialize(salleTest.getStarts());
		
		QApplication.initialize(args);
		test = new WidgetClient(listUser);
		//test = new WidgetDev(listUser);
		test.show();
		QApplication.exec();
		
	}

}
