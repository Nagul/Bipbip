package affichage;

import java.util.ArrayList;

import pathfind.*;


import com.trolltech.qt.gui.QApplication;

public class Bipbip {
	
	public static ArrayList<Mur> murs;
	
	public static void main(String[] args) {
		
		murs = new ArrayList<Mur>();
		
		
		SalleTest salleTest = new SalleTest();
		salleTest.initialisation();
		ArrayList<Node> listUser = salleTest.getListUser();
		
		/*
		Hopital hopital = new Hopital();
		hopital.initialisation();
		ArrayList<Node> listUser = hopital.getListUser();
		*/
		
		QApplication.initialize(args);
		//WidgetClient test = new WidgetClient(listUser);
		WidgetDev test = new WidgetDev(listUser);
		test.show();
		QApplication.exec();
	}

}
