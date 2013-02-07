package affichage;

import java.util.ArrayList;

import pathfind.Mur;


import com.trolltech.qt.gui.QApplication;

public class Bipbip {
	
	public static ArrayList<Mur> murs;
	
	public static void main(String[] args) {
		
		murs = new ArrayList<Mur>();
		//murs exterieur
		murs.add(new Mur(100, 100, 800, 2));//N
		murs.add(new Mur(100, 900, 802, 2));//S
		murs.add(new Mur(100, 100, 2, 800));//W
		murs.add(new Mur(900, 100, 2, 800));//E
		
		//exemple de piece
		murs.add(new Mur(150, 500, 300, 20));//N
		murs.add(new Mur(150, 700, 320, 20));//S
		murs.add(new Mur(150, 500, 20, 200));//W
		murs.add(new Mur(450, 500, 20, 200));//E
		
		
		QApplication.initialize(args);
		Widget test = new Widget();
		test.show();
		QApplication.exec();
	}

}
