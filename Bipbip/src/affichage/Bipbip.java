package affichage;

import java.util.ArrayList;

import pathfind.*;


import com.trolltech.qt.gui.QApplication;

public class Bipbip {
	
	public static ArrayList<Mur> murs;
	
	public static void main(String[] args) {
		
		murs = new ArrayList<Mur>();
		
		/* TESTS DIFFICILES
		Node n1 = new Node(200, 150);
		Node n2 = new Node(600, 150);
		Node n3 = new Node(600, 450);
		Node n4 = new Node(200, 450);
		Node n5 = new Node(800, 100);

		Node porte1 = new Node(300, 150, "porteTest", new pathfind.TypePorte("0"));
		ArrayList<Node> listPortes1 = new ArrayList<Node>();
		listPortes1.add(porte1);
		
		Node porte2 = new Node(400, 300, "porteTest", new pathfind.TypePorte("0"));
		ArrayList<Node> listPortes2 = new ArrayList<Node>();
		listPortes2.add(porte2);
		
		Mur m1 = new Mur(n2, n1, 30, listPortes1, "mH");
		murs.add(m1);
		Mur m2 = new Mur(n2, n4, 20, listPortes2, "mV");
		murs.add(m2);
		Mur m3 = new Mur(n4, n3, 20, null, "mO");
		murs.add(m3);
		Mur m4 = new Mur(n2, n3, 20, null, "mT");
		murs.add(m4);
		Mur m5 = new Mur(n2, n5, 20, null, "mZ");
		murs.add(m5);
		*/
		
		Node n1 = new Node (100, 100);
		Node n2 = new Node (900, 100);
		Node n3 = new Node (900, 900);
		Node n4 = new Node (100, 900);
		
		Node n11 = new Node (300, 100);
		Node n12 = new Node (700, 100);
		Node n13 = new Node (700, 400);
		Node n14 = new Node (300, 400);
		
		Node n21 = new Node (300, 600);
		Node n22 = new Node (700, 600);
		Node n23 = new Node (700, 900);
		Node n24 = new Node (300, 900);
		
		Node porte1 = new Node(500, 400, "porteTest", new pathfind.TypePorte("0"));
		ArrayList<Node> listPortes1 = new ArrayList<Node>();
		listPortes1.add(porte1);
		
		Node porte2 = new Node(300, 750, "porteTest", new pathfind.TypePorte("0"));
		ArrayList<Node> listPortes2 = new ArrayList<Node>();
		listPortes2.add(porte2);
		
		TypeCouloir tc = new TypeCouloir("couloir");
		TypePiece tpH = new TypePiece("Piece du haut");
		TypePiece tpB = new TypePiece("Piece du bas");
		
		//murs extérieurs
		Mur m1 = new Mur(n11, n1, 30, null, "mE1", tc, tc);
		murs.add(m1);
		Mur m2 = new Mur(n11, n12, 30, null, "mE2", tc, tpH);
		murs.add(m2);
		Mur m3 = new Mur(n2, n12, 30, null, "mE3", tc, tc);
		murs.add(m3);
		Mur m4 = new Mur(n2, n3, 30, null, "mE4", tc, tc);
		murs.add(m4);
		Mur m5 = new Mur(n3, n23, 30, null, "mE5", tc, tc);
		murs.add(m5);
		Mur m6 = new Mur(n24, n23, 30, null, "mE6", tpB, tc);
		murs.add(m6);
		Mur m7 = new Mur(n24, n4, 30, null, "mE7", tc, tc);
		murs.add(m7);
		Mur m8 = new Mur(n4, n1, 30, null, "mE8", tc, tc);
		murs.add(m8);
		
		Mur m11 = new Mur(n13, n12, 30, null, "mP11", tpH, tc);
		murs.add(m11);
		Mur m12 = new Mur(n13, n14, 30, listPortes1, "mP12", tc, tpH);
		murs.add(m12);
		Mur m13 = new Mur(n11, n14, 30, null, "mP13", tpH, tc);
		murs.add(m13);
		
		Mur m21 = new Mur(n24, n21, 30, listPortes2, "mP21", tc, tpB);
		murs.add(m21);
		Mur m22 = new Mur(n21, n22, 30, null, "mP22", tc, tpB);
		murs.add(m22);
		Mur m23 = new Mur(n22, n23, 30, null, "mP23", tc, tpB);
		murs.add(m23);

		Node user1 = new Node(500, 250, "user1", new pathfind.TypePiece("Piece du haut"));
		Node user2 = new Node(500, 750, "user2", new pathfind.TypePiece("Piece du bas"));
		ArrayList<Node> listUser = new ArrayList<Node>();
		listUser.add(user1);
		listUser.add(user2);
		
		QApplication.initialize(args);
		//WidgetClient test = new WidgetClient(listUser);
		WidgetDev test = new WidgetDev(listUser);
		test.show();
		QApplication.exec();
	}

}
