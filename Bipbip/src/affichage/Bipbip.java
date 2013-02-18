package affichage;

import java.util.ArrayList;

import pathfind.*;


import com.trolltech.qt.gui.QApplication;

public class Bipbip {
	
	public static ArrayList<Mur> murs;
	
	//TODO : mettre dans une classe à part
	public static void main(String[] args) {
		
		murs = new ArrayList<Mur>();
		
		 
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
		
		Node porte1 = new Node(500, 400, "porteTest", new pathfind.TypePiece("0"));
		ArrayList<Node> listPortes1 = new ArrayList<Node>();
		listPortes1.add(porte1);
		
		Node porte2 = new Node(300, 750, "porteTest", new pathfind.TypePiece("0"));
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
		Mur m6 = new Mur(n23, n24, 30, null, "mE6", tc, tpB);
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
		Mur m23 = new Mur(n23, n22, 30, null, "mP23", tpB, tc);
		murs.add(m23);

		Node user1 = new Node(450, 250, "user1", new pathfind.TypePiece("Piece du haut"));
		Node user2 = new Node(550, 700, "user2", new pathfind.TypePiece("Piece du bas"));
		ArrayList<Node> listUser = new ArrayList<Node>();
		listUser.add(user1);
		listUser.add(user2);
	
		
		/*
		
		// EXEMPLE REEL
		// On part de une chambre du haut = 50 de large
		
		//Couloirs et pièces
		TypeCouloir tc = new TypeCouloir("Couloir");
		
		TypeExterieur te = new TypeExterieur("Exterieur");
		
		TypePiece tpC01 = new TypePiece("Chambre 01");
		TypePiece tpC02 = new TypePiece("Chambre 02");
		TypePiece tpC03 = new TypePiece("Chambre 03");
		TypePiece tpC04 = new TypePiece("Chambre 04");
		TypePiece tpC05 = new TypePiece("Chambre 05");
		TypePiece tpC06 = new TypePiece("Chambre 06");
		TypePiece tpC07 = new TypePiece("Chambre 07");
		TypePiece tpC08 = new TypePiece("Chambre 08");
		TypePiece tpC09 = new TypePiece("Chambre 09");
		TypePiece tpC10 = new TypePiece("Chambre 10");
		TypePiece tpC11 = new TypePiece("Chambre 11");
		TypePiece tpC12 = new TypePiece("Chambre 12");
		TypePiece tpC13 = new TypePiece("Chambre 13");
		TypePiece tpC14 = new TypePiece("Chambre 14");
		TypePiece tpC15 = new TypePiece("Chambre 15");
		TypePiece tpC16 = new TypePiece("Chambre 16");
		TypePiece tpC17 = new TypePiece("Chambre 17");
		TypePiece tpC18 = new TypePiece("Chambre 18");
		
		TypePiece tpINF = new TypePiece("Infirmerie");
		
		//meilleur nommage ?
		TypePiece tpD01 = new TypePiece("Divers 01");
		TypePiece tpD02 = new TypePiece("Divers 02");
		TypePiece tpD03 = new TypePiece("Divers 03");
		TypePiece tpD04 = new TypePiece("Divers 04");
		TypePiece tpD05 = new TypePiece("Divers 05");
		TypePiece tpD06 = new TypePiece("Divers 06");
		TypePiece tpD07 = new TypePiece("Divers 07");
		TypePiece tpD08 = new TypePiece("Divers 08");
		TypePiece tpD09 = new TypePiece("Divers 09");
		TypePiece tpD010 = new TypePiece("Divers 10");
		
		//Murs Extérieurs Haut
		Node mEH1 = new Node (50, 50);
		Node mEH2 = new Node (100, 50);
		Node mEH3 = new Node (150, 50);
		Node mEH4 = new Node (200, 50);
		Node mEH5 = new Node (250, 50);
		Node mEH6 = new Node (300, 50);
		Node mEH7 = new Node (350, 50);
		Node mEH8 = new Node (400, 50);
		Node mEH9 = new Node (450, 50);
		Node mEH10 = new Node (500, 50);
		Node mEH11 = new Node (550, 50);
		Node mEH12 = new Node (600, 50);
		Node mEH13 = new Node (650, 50);
		Node mEH14 = new Node (700, 50);
		
		murs.add(new Mur(mEH1, mEH2, 5, null, "mEH1", te, tpC09));
		murs.add(new Mur(mEH2, mEH3, 5, null, "mEH2", te, tpC08));
		murs.add(new Mur(mEH3, mEH4, 5, null, "mEH3", te, tpC07));
		murs.add(new Mur(mEH4, mEH5, 5, null, "mEH4", te, tpC06));
		murs.add(new Mur(mEH5, mEH6, 5, null, "mEH5", te, tpC05));
		murs.add(new Mur(mEH6, mEH7, 5, null, "mEH6", te, tpD01));
		murs.add(new Mur(mEH7, mEH8, 5, null, "mEH7", te, tpC04));
		murs.add(new Mur(mEH8, mEH9, 5, null, "mEH8", te, tpC03));
		murs.add(new Mur(mEH9, mEH10, 5, null, "mEH9", te, tpC02));
		murs.add(new Mur(mEH10, mEH11, 5, null, "mEH10", te, tpC01));
		murs.add(new Mur(mEH11, mEH12, 5, null, "mEH11", te, tpD02));
		murs.add(new Mur(mEH12, mEH13, 5, null, "mEH12", te, tpD03));
		murs.add(new Mur(mEH13, mEH14, 5, null, "mEH13", te, tpD04));	
		
		//Murs Extérieurs Droite
		Node mED1 = new Node (700, 150);
		Node mED2 = new Node (700, 350);
		Node mED3 = new Node (800, 350);
		Node mED4 = new Node (800, 500);
		
		murs.add(new Mur(mEH14, mED1, 5, null, "mED1", te, tpD04));
		murs.add(new Mur(mED1, mED2, 5, null, "mED2", te, tc));
		murs.add(new Mur(mED2, mED3, 5, null, "mED3", te, tpINF));
		murs.add(new Mur(mED3, mED4, 5, null, "mED4", te, tpINF));
		
		
		
		//Murs Extérieurs Bas
		Node mEB1 = new Node (600, 500);
		Node mEB2 = new Node (520, 500);
		Node mEB3 = new Node (480, 500);
		Node mEB4 = new Node (450, 500);
		Node mEB5 = new Node (420, 500);
		Node mEB6 = new Node (365, 500);
		Node mEB7 = new Node (310, 500);
		Node mEB8 = new Node (255, 500);
		Node mEB9 = new Node (200, 500);
		Node mEB10 = new Node (145, 500);
		Node mEB11 = new Node (90, 500);
		Node mEB12 = new Node (35, 500);
		
		murs.add(new Mur(mED4, mEB1, 5, null, "mEB1", te, tpINF));
		murs.add(new Mur(mEB1, mEB2, 5, null, "mEB2", te, tpD05));
		murs.add(new Mur(mEB2, mEB3, 5, null, "mEB3", te, tpD06));
		murs.add(new Mur(mEB3, mEB4, 5, null, "mEB4", te, tc));
		murs.add(new Mur(mEB4, mEB5, 5, null, "mEB5", te, tpD07));
		murs.add(new Mur(mEB5, mEB6, 5, null, "mEB6", te, tpC18));
		murs.add(new Mur(mEB6, mEB7, 5, null, "mEB7", te, tpC17));
		murs.add(new Mur(mEB7, mEB8, 5, null, "mEB8", te, tpC16));
		murs.add(new Mur(mEB8, mEB9, 5, null, "mEB9", te, tpC15));
		murs.add(new Mur(mEB9, mEB10, 5, null, "mEB10", te, tpC14));
		murs.add(new Mur(mEB10, mEB11, 5, null, "mEB11", te, tpC13));
		murs.add(new Mur(mEB11, mEB12, 5, null, "mEB12", te, tpC12));
		
		
		//Murs Extérieurs Gauche
		Node mEG1 = new Node (35, 450);
		Node mEG2 = new Node (35, 420);
		Node mEG3 = new Node (35, 390);
		Node mEG4 = new Node (50, 390);
		Node mEG5 = new Node (50, 285);
		Node mEG6 = new Node (50, 180);
		Node mEG7 = new Node (50, 150);
		
		murs.add(new Mur(mEB12, mEG1, 5, null, "mEG1", te, tpC12));
		murs.add(new Mur(mEG1, mEG2, 5, null, "mEG2", te, tc));
		murs.add(new Mur(mEG2, mEG3, 5, null, "mEG3", te, tpD08));
		murs.add(new Mur(mEG3, mEG4, 5, null, "mEG4", te, tc));
		murs.add(new Mur(mEG4, mEG5, 5, null, "mEG5", te, tpC10));
		murs.add(new Mur(mEG5, mEG6, 5, null, "mEG6", te, tpC11));
		murs.add(new Mur(mEG6, mEG7, 5, null, "mEG7", te, tc));
		murs.add(new Mur(mEG7, mEH1, 5, null, "mEG8", te, tpC09));
		
		
		//Rangée de pièces du haut
		Node pIH1 = new Node (100, 150);
		Node pIH2 = new Node (150, 150);
		Node pIH3 = new Node (200, 150);
		Node pIH4 = new Node (250, 150);
		Node pIH5 = new Node (300, 150);
		Node pIH6 = new Node (350, 150);
		Node pIH7 = new Node (400, 150);
		Node pIH8 = new Node (450, 150);
		Node pIH9 = new Node (500, 150);
		Node pIH10 = new Node (550, 150);
		Node pIH11 = new Node (600, 150);
		Node pIH12 = new Node (650, 150);
		
		Node porteC09 = new Node(70, 150, "porteC09", null);
		ArrayList<Node> listPortesC09 = new ArrayList<Node>();
		listPortesC09.add(porteC09);
		Node porteC08 = new Node(130, 150, "porteC08", null);
		ArrayList<Node> listPortesC08 = new ArrayList<Node>();
		listPortesC08.add(porteC08);
		Node porteC07 = new Node(170, 150, "porteC07", null);
		ArrayList<Node> listPortesC07 = new ArrayList<Node>();
		listPortesC07.add(porteC07);
		Node porteC06 = new Node(230, 150, "porteC06", null);
		ArrayList<Node> listPortesC06 = new ArrayList<Node>();
		listPortesC06.add(porteC06);
		Node porteC05 = new Node(270, 150, "porteC05", null);
		ArrayList<Node> listPortesC05 = new ArrayList<Node>();
		listPortesC05.add(porteC05);
		Node porteD01 = new Node(330, 150, "porteD01", null);
		ArrayList<Node> listPortesD01 = new ArrayList<Node>();
		listPortesD01.add(porteD01);
		Node porteC04 = new Node(370, 150, "porteC04", null);
		ArrayList<Node> listPortesC04 = new ArrayList<Node>();
		listPortesC04.add(porteC04);
		Node porteC03 = new Node(430, 150, "porteC03", null);
		ArrayList<Node> listPortesC03 = new ArrayList<Node>();
		listPortesC03.add(porteC03);
		Node porteC02 = new Node(470, 150, "porteC02", null);
		ArrayList<Node> listPortesC02 = new ArrayList<Node>();
		listPortesC02.add(porteC02);
		Node porteC01 = new Node(530, 150, "porteC01", null);
		ArrayList<Node> listPortesC01 = new ArrayList<Node>();
		listPortesC01.add(porteC01);
		Node porteD02 = new Node(570, 150, "porteD02", null);
		ArrayList<Node> listPortesD02 = new ArrayList<Node>();
		listPortesD02.add(porteD02);
		Node porteD03 = new Node(630, 150, "porteD03", null);
		ArrayList<Node> listPortesD03 = new ArrayList<Node>();
		listPortesD03.add(porteD03);
		Node porteD04 = new Node(670, 150, "porteD04", null);
		ArrayList<Node> listPortesD04 = new ArrayList<Node>();
		listPortesD04.add(porteD04);
		
		murs.add(new Mur(mEG7, pIH1, 2, listPortesC09, "mIH1", tpC09, tc));
		murs.add(new Mur(pIH1, mEH2, 2, null, "mIH2", tpC09, tpC08));
		murs.add(new Mur(pIH1, pIH2, 2, listPortesC08, "mIH1", tpC08, tc));
		murs.add(new Mur(pIH2, mEH3, 2, null, "mIH2", tpC08, tpC07));
		murs.add(new Mur(pIH2, pIH3, 2, listPortesC07, "mIH1", tpC07, tc));
		murs.add(new Mur(pIH3, mEH4, 2, null, "mIH2", tpC07, tpC06));
		murs.add(new Mur(pIH3, pIH4, 2, listPortesC06, "mIH1", tpC06, tc));
		murs.add(new Mur(pIH4, mEH5, 2, null, "mIH2", tpC06, tpC05));
		murs.add(new Mur(pIH4, pIH5, 2, listPortesC05, "mIH1", tpC05, tc));
		murs.add(new Mur(pIH5, mEH6, 2, null, "mIH2", tpC05, tpD01));
		murs.add(new Mur(pIH5, pIH6, 2, listPortesD01, "mIH1", tpD01, tc));
		murs.add(new Mur(pIH6, mEH7, 2, null, "mIH2", tpD01, tpC04));
		murs.add(new Mur(pIH6, pIH7, 2, listPortesC04, "mIH1", tpC04, tc));
		murs.add(new Mur(pIH7, mEH8, 2, null, "mIH2", tpC04, tpC03));
		murs.add(new Mur(pIH7, pIH8, 2, listPortesC03, "mIH1", tpC03, tc));
		murs.add(new Mur(pIH8, mEH9, 2, null, "mIH2", tpC03, tpC02));
		murs.add(new Mur(pIH8, pIH9, 2, listPortesC02, "mIH1", tpC02, tc));
		murs.add(new Mur(pIH9, mEH10, 2, null, "mIH2", tpC02, tpC01));
		murs.add(new Mur(pIH9, pIH10, 2, listPortesC01, "mIH1", tpC01, tc));
		murs.add(new Mur(pIH10, mEH11, 2, null, "mIH2", tpC01, tpD02));
		murs.add(new Mur(pIH10, pIH11, 2, listPortesD02, "mIH1", tpD02, tc));
		murs.add(new Mur(pIH11, mEH12, 2, null, "mIH2", tpD02, tpD03));
		murs.add(new Mur(pIH11, pIH12, 2, listPortesD03, "mIH1", tpD03, tc));
		murs.add(new Mur(pIH12, mEH13, 2, null, "mIH2", tpD03, tpD04));
		murs.add(new Mur(pIH12, mED1, 2, listPortesD04, "mIH1", tpD04, tc));
		
		
		
		
		//Points d'intérêts
		
		Node user1 = new Node(60, 60, "user1", tpC09);
		ArrayList<Node> listUser = new ArrayList<Node>();
		listUser.add(user1);

		*/
		
		
		QApplication.initialize(args);
		//WidgetClient test = new WidgetClient(listUser);
		WidgetDev test = new WidgetDev(listUser);
		test.show();
		QApplication.exec();
	}

}
