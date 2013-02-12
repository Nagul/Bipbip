package affichage;

import java.util.ArrayList;

import pathfind.Mur;
import pathfind.Node;


import com.trolltech.qt.gui.QApplication;

public class Bipbip {
	
	public static ArrayList<Mur> murs;
	
	public static void main(String[] args) {
		
		murs = new ArrayList<Mur>();
		
		Node n1 = new Node(150, 150);
		Node n2 = new Node(550, 150);
		Node n3 = new Node(550, 450);
		Node n4 = new Node(150, 450);
		Mur m1 = new Mur(n1, n2, 30, null, "mH");
		Mur m2 = new Mur(n3, n2, 20, null, "mV");
		Mur m3 = new Mur(n4, n3, 20, null, "mO");
		murs.add(m1);
		murs.add(m2);
		murs.add(m3);
		
		QApplication.initialize(args);
		Widget test = new Widget();
		test.show();
		QApplication.exec();
	}

}
