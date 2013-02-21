package affichage;

import java.util.ArrayList;

import pathfind.Mur;
import pathfind.Node;
import pathfind.TypeCouloir;
import pathfind.TypeExterieur;
import pathfind.TypePiece;

public class Hopital {

	private ArrayList<Node> listUser; 
	
	public Hopital() {
		listUser = new ArrayList<Node>();
	}

	public void initialisation() {

		ArrayList<Mur> murs = Bipbip.murs;

		//couloir et pièces
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
		TypePiece tpD10 = new TypePiece("Divers 10");
		TypePiece tpD11 = new TypePiece("Divers 11");
		TypePiece tpD12 = new TypePiece("Divers 12");
		TypePiece tpD13 = new TypePiece("Divers 13");
		TypePiece tpD14 = new TypePiece("Divers 14");
		TypePiece tpD15 = new TypePiece("Divers 15");
		TypePiece tpD16 = new TypePiece("Divers 16");
		TypePiece tpD17 = new TypePiece("Divers 17");
		TypePiece tpD18 = new TypePiece("Divers 18");
		TypePiece tpD19 = new TypePiece("Divers 19");
		TypePiece tpD20 = new TypePiece("Divers 20");
		TypePiece tpD21 = new TypePiece("Divers 21");
		TypePiece tpD22 = new TypePiece("Divers 22");
		TypePiece tpD23 = new TypePiece("Divers 23");
		TypePiece tpD24 = new TypePiece("Divers 24");
		TypePiece tpD25 = new TypePiece("Divers 25");
		TypePiece tpD26 = new TypePiece("Divers 26");
		TypePiece tpD27 = new TypePiece("Divers 27");
		TypePiece tpD28 = new TypePiece("Divers 28");
		TypePiece tpD29 = new TypePiece("Divers 29");
		TypePiece tpD30 = new TypePiece("Divers 30");

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
		Node mED2 = new Node (700, 390);
		Node mED3 = new Node (800, 390);
		Node mED4 = new Node (800, 520);

		murs.add(new Mur(mEH14, mED1, 5, null, "mED1", te, tpD04));
		murs.add(new Mur(mED1, mED2, 5, null, "mED2", te, tc));
		murs.add(new Mur(mED2, mED3, 5, null, "mED3", te, tpINF));
		murs.add(new Mur(mED3, mED4, 5, null, "mED4", te, tpINF));



		//Murs Extérieurs Bas
		Node mEB1 = new Node (600, 520);
		Node mEB2 = new Node (570, 520);
		Node mEB3 = new Node (500, 520);
		Node mEB4 = new Node (470, 520);
		Node mEB5 = new Node (450, 520);
		Node mEB6 = new Node (390, 520);
		Node mEB7 = new Node (330, 520);
		Node mEB8 = new Node (270, 520);
		Node mEB9 = new Node (210, 520);
		Node mEB10 = new Node (150, 520);
		Node mEB11 = new Node (90, 520);
		Node mEB12 = new Node (30, 520);

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
		Node mEG1 = new Node (30, 460);
		Node mEG2 = new Node (30, 430);
		Node mEG3 = new Node (30, 390);
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
		Node porteC08 = new Node(130, 150, "porteC08", null);
		Node porteC07 = new Node(170, 150, "porteC07", null);
		Node porteC06 = new Node(230, 150, "porteC06", null);
		Node porteC05 = new Node(270, 150, "porteC05", null);
		Node porteD01 = new Node(330, 150, "porteD01", null);
		Node porteC04 = new Node(370, 150, "porteC04", null);
		Node porteC03 = new Node(430, 150, "porteC03", null);
		Node porteC02 = new Node(470, 150, "porteC02", null);
		Node porteC01 = new Node(530, 150, "porteC01", null);
		Node porteD02 = new Node(570, 150, "porteD02", null);
		Node porteD03 = new Node(630, 150, "porteD03", null);
		Node porteD04 = new Node(670, 150, "porteD04", null);
		
		murs.add(new Mur(mEG7, pIH1, 2, porteC09, "mIH1", tpC09, tc));
		murs.add(new Mur(pIH1, mEH2, 2, null, "mIH2", tpC09, tpC08));
		murs.add(new Mur(pIH1, pIH2, 2, porteC08, "mIH3", tpC08, tc));
		murs.add(new Mur(pIH2, mEH3, 2, null, "mIH4", tpC08, tpC07));
		murs.add(new Mur(pIH2, pIH3, 2, porteC07, "mIH5", tpC07, tc));
		murs.add(new Mur(pIH3, mEH4, 2, null, "mIH6", tpC07, tpC06));
		murs.add(new Mur(pIH3, pIH4, 2, porteC06, "mIH7", tpC06, tc));
		murs.add(new Mur(pIH4, mEH5, 2, null, "mIH8", tpC06, tpC05));
		murs.add(new Mur(pIH4, pIH5, 2, porteC05, "mIH9", tpC05, tc));
		murs.add(new Mur(pIH5, mEH6, 2, null, "mIH10", tpC05, tpD01));
		murs.add(new Mur(pIH5, pIH6, 2, porteD01, "mIH11", tpD01, tc));
		murs.add(new Mur(pIH6, mEH7, 2, null, "mIH12", tpD01, tpC04));
		murs.add(new Mur(pIH6, pIH7, 2, porteC04, "mIH13", tpC04, tc));
		murs.add(new Mur(pIH7, mEH8, 2, null, "mIH14", tpC04, tpC03));
		murs.add(new Mur(pIH7, pIH8, 2, porteC03, "mIH15", tpC03, tc));
		murs.add(new Mur(pIH8, mEH9, 2, null, "mIH16", tpC03, tpC02));
		murs.add(new Mur(pIH8, pIH9, 2, porteC02, "mIH17", tpC02, tc));
		murs.add(new Mur(pIH9, mEH10, 2, null, "mIH18", tpC02, tpC01));
		murs.add(new Mur(pIH9, pIH10, 2, porteC01, "mIH19", tpC01, tc));
		murs.add(new Mur(pIH10, mEH11, 2, null, "mIH20", tpC01, tpD02));
		murs.add(new Mur(pIH10, pIH11, 2, porteD02, "mIH21", tpD02, tc));
		murs.add(new Mur(pIH11, mEH12, 2, null, "mIH22", tpD02, tpD03));
		murs.add(new Mur(pIH11, pIH12, 2, porteD03, "mIH23", tpD03, tc));
		murs.add(new Mur(pIH12, mEH13, 2, null, "mIH24", tpD03, tpD04));
		murs.add(new Mur(pIH12, mED1, 2, porteD04, "mIH25", tpD04, tc));
		
		//bloc milieu Gauche-gauche
		Node pIG1 = new Node (130, 430);
		Node pIG2 = new Node (130, 390);
		Node pIG3 = new Node (130, 285);
		Node pIG4 = new Node (130, 180);
		
		Node porteC10 = new Node(130, 232, "porteC10", null);
		Node porteC11 = new Node(130, 337, "porteC11", null);
		Node porteD08 = new Node(130, 405, "porteD08", null);
		
		murs.add(new Mur(mEG6, pIG4, 2, null, "mIG1", tc, tpC10));
		murs.add(new Mur(pIG4, pIG3, 2, porteC10, "mIG2", tc, tpC10));
		murs.add(new Mur(pIG3, mEG5, 2, null, "mIG3", tpC11, tpC10));
		//TODO : bug à investiguer en inversant les points ci-dessous
		murs.add(new Mur(pIG2, pIG3, 2, porteC11, "mIG4", tpC11, tc));
		murs.add(new Mur(pIG2, mEG4, 2, null, "mIG5", tpD08, tpC11));
		murs.add(new Mur(pIG2, pIG1, 2, porteD08, "mIG6", tc, tpD08));
		murs.add(new Mur(pIG1, mEG2, 2, null, "mIG7", tc, tpD08));
		
		//bloc milieu Gauche-milieu-haut
		// ET bloc milieu Gauche-milieu-bas
		Node pIGH1 = new Node (160, 180);
		Node pIGH2 = new Node (190, 180);
		Node pIGH3 = new Node (210, 180);
		Node pIGH4 = new Node (280, 180);
		Node pIGH5 = new Node (350, 180);
		Node pIGH6 = new Node (350, 230);
		Node pIGH7 = new Node (280, 230);
		Node pIGH8 = new Node (210, 230);
		Node pIGH9 = new Node (190, 230);
		Node pIGH10 = new Node (160, 230);
		
		Node pIGB1 = new Node (160, 390);
		Node pIGB2 = new Node (210, 390);
		Node pIGB3 = new Node (270, 390);
		Node pIGB4 = new Node (285, 390);
		Node pIGB5 = new Node (310, 390);
		Node pIGB6 = new Node (350, 390);
		Node pIGB7 = new Node (350, 430);
		Node pIGB8 = new Node (310, 430);
		Node pIGB9 = new Node (285, 430);
		Node pIGB10 = new Node (270, 430);
		Node pIGB11 = new Node (210, 430);
		Node pIGB12 = new Node (160, 430);
		
		Node porteD09 = new Node(180, 180, "porteD09", null);
		Node porteD10 = new Node(200, 180, "porteD10", null);
		Node porteD11 = new Node(220, 180, "porteD11", null);
		Node porteD12 = new Node(350, 220, "porteD12", null);
		
		Node porteD13 = new Node(200, 430, "porteD13", null);
		Node porteD14 = new Node(260, 430, "porteD14", null);
		Node porteD15 = new Node(270, 405, "porteD15", null);
		Node porteD16 = new Node(300, 430, "porteD16", null);
		Node porteD17 = new Node(350, 405, "porteD17", null);
		
		murs.add(new Mur(pIGH1, pIGH2, 2, porteD09, "mIGH1", tc, tpD09));
		murs.add(new Mur(pIGH2, pIGH9, 2, null, "mIGH2", tpD10, tpD09));
		//bug
		murs.add(new Mur(pIGH3, pIGH2, 2, porteD10, "mIGH3", tpD10, tc));
		murs.add(new Mur(pIGH3, pIGH8, 2, null, "mIGH4", tpD11, tpD10));
		murs.add(new Mur(pIGH3, pIGH4, 2, porteD11, "mIGH5", tc, tpD11));
		murs.add(new Mur(pIGH4, pIGH7, 2, null, "mIGH6", tpD12, tpD11));
		//
		murs.add(new Mur(pIGH5, pIGH4, 2, null, "mIGH7", tpD12, tc));
		murs.add(new Mur(pIGH5, pIGH6, 2, porteD12, "mIGH8", tc, tpD12));
		murs.add(new Mur(pIGH6, pIGB6, 2, null, "mIGH9", tc, tc));
		murs.add(new Mur(pIGH6, pIGH7, 2, null, "mIGH10", tc, tpD12));
		murs.add(new Mur(pIGH7, pIGH8, 2, null, "mIGH11", tc, tpD11));
		murs.add(new Mur(pIGH8, pIGH9, 2, null, "mIGH12", tc, tpD10));
		murs.add(new Mur(pIGH9, pIGH10, 2, null, "mIGH13", tc, tpD09));
		murs.add(new Mur(pIGH10, pIGH1, 2, null, "mIGH14", tc, tpD09));
			
		murs.add(new Mur(pIGH10, pIGB1, 2, null, "mIGB1", tc, tc));
		murs.add(new Mur(pIGB1, pIGB2, 2, null, "mIGB2", tc, tpD13));
		murs.add(new Mur(pIGB2, pIGB11, 2, null, "mIGB3", tpD14, tpD13));
		murs.add(new Mur(pIGB2, pIGB3, 2, null, "mIGB4", tc, tpD14));
		murs.add(new Mur(pIGB3, pIGB10, 2, porteD15, "mIGB5", tpD15, tpD14));
		murs.add(new Mur(pIGB3, pIGB4, 2, null, "mIGB6", tc, tpD15));
		murs.add(new Mur(pIGB4, pIGB9, 2, null, "mIGB7", tpD16, tpD15));
		murs.add(new Mur(pIGB4, pIGB5, 2, null, "mIGB8", tc, tpD16));
		murs.add(new Mur(pIGB5, pIGB8, 2, null, "mIGB9", tpD17, tpD16));
		murs.add(new Mur(pIGB5, pIGB6, 2, null, "mIGB10", tc, tpD17));
		//
		murs.add(new Mur(pIGB7, pIGB6, 2, porteD17, "mIGB11", tpD17, tc));
		murs.add(new Mur(pIGB7, pIGB8, 2, null, "mIGB12", tc, tpD17));
		//
		murs.add(new Mur(pIGB9, pIGB8, 2, porteD16, "mIGB13", tpD16, tc));
		murs.add(new Mur(pIGB9, pIGB10, 2, null, "mIGB14", tc, tpD15));
		//
		murs.add(new Mur(pIGB11, pIGB10, 2, porteD14, "mIGB15", tpD14, tc));
		murs.add(new Mur(pIGB11, pIGB12, 2, porteD13, "mIGB16", tc, tpD13));
		murs.add(new Mur(pIGB12, pIGB1, 2, null, "mIGB17", tc, tpD13));
		
		//bloc milieu Droite-milieu-haut
		Node pIDH1 = new Node (380, 180);
		Node pIDH2 = new Node (460, 180);
		Node pIDH3 = new Node (460, 200);
		Node pIDH4 = new Node (470, 200);
		Node pIDH5 = new Node (470, 230);
		Node pIDH6 = new Node (460, 230);
		Node pIDH7 = new Node (460, 280);
		Node pIDH8 = new Node (420, 280);
		Node pIDH9 = new Node (380, 280);
		Node pIDH10 = new Node (380, 230);
		Node pIDH11 = new Node (420, 230);
		
		Node porteD18 = new Node(470, 215, "porteD18", null);
		Node porteD19 = new Node(380, 260, "porteD19", null);
		Node porteD20 = new Node(460, 250, "porteD20", null);
		
		murs.add(new Mur(pIDH1, pIDH2, 2, null, "mIDH1", tc, tpD18));
		murs.add(new Mur(pIDH2, pIDH3, 2, null, "mIDH2", tc, tpD18));
		murs.add(new Mur(pIDH3, pIDH4, 2, null, "mIDH3", tc, tpD18));
		murs.add(new Mur(pIDH4, pIDH5, 2, porteD18, "mIDH4", tc, tpD18));
		murs.add(new Mur(pIDH5, pIDH6, 2, null, "mIDH5", tc, tpD18));
		murs.add(new Mur(pIDH6, pIDH11, 2, null, "mIDH6", tpD20, tpD18));
		murs.add(new Mur(pIDH6, pIDH7, 2, porteD20, "mIDH7", tc, tpD20));
		murs.add(new Mur(pIDH7, pIDH8, 2, null, "mIDH8", tc, tpD20));
		murs.add(new Mur(pIDH8, pIDH11, 2, null, "mIDH9", tpD19, tpD20));
		//
		murs.add(new Mur(pIDH9, pIDH8, 2, null, "mIDH10", tpD19, tc));
		//
		murs.add(new Mur(pIDH10, pIDH9, 2, porteD19, "mIDH11", tpD19, tc));
		murs.add(new Mur(pIDH10, pIDH11, 2, null, "mIDH12", tpD18, tpD19));
		murs.add(new Mur(pIDH10, pIDH1, 2, null, "mIDH13", tc, tpD18));
		
		//bloc milieu Droite-milieu-bas
		Node pIDB1 = new Node (380, 310);
		Node pIDB2 = new Node (440, 310);
		Node pIDB3 = new Node (470, 310);
		Node pIDB4 = new Node (470, 430);
		Node pIDB5 = new Node (440, 430);
		Node pIDB6 = new Node (410, 430);
		Node pIDB7 = new Node (380, 430);
		Node pIDB8 = new Node (380, 390);
		Node pIDB9 = new Node (410, 390);
		Node pIDB10 = new Node (440, 390);
		
		Node porteD21 = new Node(380, 320, "porteD21", null);
		Node porteD23 = new Node(400, 430, "porteD23", null);
		Node porteD24 = new Node(420, 430, "porteD24", null);
		
		murs.add(new Mur(pIDB1, pIDB2, 2, null, "mIDB1", tc, tpD21));
		murs.add(new Mur(pIDB2, pIDB3, 2, null, "mIDB2", tc, tpD22));
		murs.add(new Mur(pIDB3, pIDB4, 2, null, "mIDB3", tc, tpD22));
		murs.add(new Mur(pIDB4, pIDB5, 2, null, "mIDB4", tc, tpD22));
		murs.add(new Mur(pIDB5, pIDB6, 2, porteD24, "mIDB5", tc, tpD24));
		murs.add(new Mur(pIDB6, pIDB7, 2, porteD23, "mIDB6", tc, tpD23));
		murs.add(new Mur(pIDB7, pIDB8, 2, null, "mIDB7", tc, tpD23));
		murs.add(new Mur(pIDB8, pIDB1, 2, porteD21, "mIDB8", tc, tpD21));
		murs.add(new Mur(pIDB2, pIDB10, 2, null, "mIDB9", tpD22, tpD21));
		murs.add(new Mur(pIDB10, pIDB5, 2, null, "mIDB10", tpD22, tpD24));
		murs.add(new Mur(pIDB10, pIDB9, 2, null, "mIDB11", tpD24, tpD21));
		murs.add(new Mur(pIDB9, pIDB6, 2, null, "mIDB12", tpD24, tpD23));
		murs.add(new Mur(pIDB9, pIDB8, 2, null, "mIDB13", tpD23, tpD21));
		
		//bloc milieu Droite-droite
		Node pID1 = new Node (500, 180);
		Node pID2 = new Node (610, 180);
		Node pID3 = new Node (640, 180);
		Node pID4 = new Node (660, 180);
		Node pID5 = new Node (660, 200);
		Node pID6 = new Node (640, 200);
		Node pID7 = new Node (640, 230);
		Node pID8 = new Node (660, 230);
		Node pID9 = new Node (660, 280);
		Node pID10 = new Node (550, 280);
		Node pID11 = new Node (550, 230);
		Node pID12 = new Node (500, 230);
		Node pID13 = new Node (610, 230);
		
		Node porteD25 = new Node(580, 180, "porteD25", null);
		Node porteD26 = new Node(620, 180, "porteD26", null);
		
		murs.add(new Mur(pID1, pID2, 2, porteD25, "mID1", tpD25, tc));
		murs.add(new Mur(pID2, pID13, 2, null, "mID2", tpD25, tpD26));
		murs.add(new Mur(pID2, pID3, 2, porteD26, "mID3", tpD26, tc));
		murs.add(new Mur(pID3, pID6, 2, null, "mID4", tpD26, tc));
		murs.add(new Mur(pID3, pID4, 2, null, "mID5", tc, tc));
		murs.add(new Mur(pID4, pID5, 2, null, "mID6", tc, tc));
		murs.add(new Mur(pID5, pID6, 2, null, "mID7", tc, tc));
		murs.add(new Mur(pID6, pID7, 2, null, "mID8", tpD26, tc));
		murs.add(new Mur(pID7, pID13, 2, null, "mID9", tpD26, tc));
		murs.add(new Mur(pID7, pID8, 2, null, "mID10", tc, tc));
		murs.add(new Mur(pID8, pID9, 2, null, "mID11", tc, tc));
		murs.add(new Mur(pID9, pID10, 2, null, "mID12", tc, tc));
		murs.add(new Mur(pID10, pID11, 2, null, "mID13", tc, tc));
		murs.add(new Mur(pID11, pID13, 2, null, "mID14", tc, tpD25));
		murs.add(new Mur(pID11, pID12, 2, null, "mID15", tpD25, tc));
		murs.add(new Mur(pID12, pID1, 2, null, "mID16", tpD25, tc));
		
		//bloc infirmerie
		Node pII1 = new Node (500, 310);
		Node pII2 = new Node (550, 310);
		Node pII3 = new Node (640, 310);
		Node pII4 = new Node (500, 390);
		Node pII5 = new Node (520, 390);
		Node pII6 = new Node (550, 390);
		Node pII7 = new Node (600, 390);
		Node pII8 = new Node (640, 390);
		Node pII9 = new Node (500, 430);
		Node pII10 = new Node (520, 430);
		Node pII11 = new Node (600, 430);
		Node pII12 = new Node (500, 460);
		Node pII13 = new Node (570, 460);
		Node pII14 = new Node (570, 480);
		Node pII15 = new Node (600, 480);
		
		Node porteD27 = new Node(510, 310, "porteD27", null);
		Node porteD29 = new Node(550, 430, "porteD29", null);
		Node porteD05 = new Node(585, 480, "porteD05", null);
		Node porteD06 = new Node(530, 460, "porteD06", null);
		Node porteINF = new Node(670, 390, "porteINF", null);
		
		
		murs.add(new Mur(pII1, pII2, 2, porteD27, "mII1", tc, tpD27));
		murs.add(new Mur(pII2, pII3, 2, null, "mII2", tc, tc));
		murs.add(new Mur(pII1, pII4, 2, null, "mII3", tpD27, tc));
		murs.add(new Mur(pII2, pII6, 2, null, "mII4", tc, tpD27));
		murs.add(new Mur(pII3, pII8, 2, null, "mII5", tc, tc));
		murs.add(new Mur(pII4, pII5, 2, null, "mII6", tpD27, tpD28));
		murs.add(new Mur(pII5, pII6, 2, null, "mII7", tpD27, tpD29));
		murs.add(new Mur(pII6, pII7, 2, null, "mII8", tc, tpD29));
		murs.add(new Mur(pII7, pII8, 2, null, "mII9", tc, tpINF));
		murs.add(new Mur(pII8, mED2, 2, porteINF, "mII10", tc, tpINF));
		murs.add(new Mur(pII4, pII9, 2, null, "mII11", tpD28, tc));
		murs.add(new Mur(pII5, pII10, 2, null, "mII12", tpD29, tpD28));
		murs.add(new Mur(pII7, pII11, 2, null, "mII13", tpINF, tpD29));
		//TODO : bug inversion point
		murs.add(new Mur(pII10, pII9, 2, null, "mII14", tc, tpD28));
		murs.add(new Mur(pII10, pII11, 2, porteD29, "mII15", tpD29, tc));
		murs.add(new Mur(mEB3, pII12, 2, null, "mII16", tc, tpD06));
		murs.add(new Mur(pII12, pII13, 2, porteD06, "mII17", tc, tpD06));
		murs.add(new Mur(pII13, pII14, 2, null, "mII18", tc, tpD06));
		murs.add(new Mur(pII14, mEB2, 2, null, "mII19", tpD05, tpD06));
		murs.add(new Mur(pII14, pII15, 2, porteD05, "mII20", tc, tpD05));
		murs.add(new Mur(pII15, pII11, 2, null, "mII21", tc, tpINF));
		murs.add(new Mur(pII15, mEB1, 2, null, "mII22", tpINF, tpD05));
		
		//bloc Bas
		Node pIB1 = new Node (90, 460);
		Node pIB2 = new Node (150, 460);
		Node pIB3 = new Node (210, 460);
		Node pIB4 = new Node (270, 460);
		Node pIB5 = new Node (330, 460);
		Node pIB6 = new Node (390, 460);
		Node pIB7 = new Node (450, 460);
		Node pIB8 = new Node (470, 460);
		Node pIB9 = new Node (450, 480);
		Node pIB10 = new Node (470, 480);
		
		Node porteC12 = new Node(50, 460, "porteC12", null);
		Node porteC13 = new Node(130, 460, "porteC13", null);
		Node porteC14 = new Node(170, 460, "porteC14", null);
		Node porteC15 = new Node(250, 460, "porteC15", null);
		Node porteC16 = new Node(290, 460, "porteC16", null);
		Node porteC17 = new Node(370, 460, "porteC17", null);
		Node porteC18 = new Node(410, 460, "porteC18", null);
		Node porteD30 = new Node(470, 470, "porteD30", null);
		
		murs.add(new Mur(mEG1, pIB1, 2, porteC12, "mIB1", tc, tpC12));
		murs.add(new Mur(pIB1, pIB2, 2, porteC13, "mIB2", tc, tpC13));
		murs.add(new Mur(pIB2, pIB3, 2, porteC14, "mIB3", tc, tpC14));
		murs.add(new Mur(pIB3, pIB4, 2, porteC15, "mIB4", tc, tpC15));
		murs.add(new Mur(pIB4, pIB5, 2, porteC16, "mIB5", tc, tpC16));
		murs.add(new Mur(pIB5, pIB6, 2, porteC17, "mIB6", tc, tpC17));
		murs.add(new Mur(pIB6, pIB7, 2, porteC18, "mIB7", tc, tpC18));
		murs.add(new Mur(pIB7, pIB8, 2, null, "mIB8", tc, tpD30));
		murs.add(new Mur(pIB8, pIB10, 2, porteD30, "mIB9", tc, tpD30));
		murs.add(new Mur(pIB10, mEB4, 2, null, "mIB10", tc, tpD07));
		murs.add(new Mur(pIB9, pIB7, 2, null, "mIB11", tpC18, tc));
		murs.add(new Mur(pIB9, pIB10, 2, null, "mIB12", tpD30, tpD07));
		murs.add(new Mur(pIB9, mEB5, 2, null, "mIB13", tpD07, tpC18));

		murs.add(new Mur(pIB1, mEB11, 2, null, "mIB10", tpC12, tpC13));
		murs.add(new Mur(pIB2, mEB10, 2, null, "mIB11", tpC13, tpC14));
		murs.add(new Mur(pIB3, mEB9, 2, null, "mIB12", tpC14, tpC15));
		murs.add(new Mur(pIB4, mEB8, 2, null, "mIB13", tpC15, tpC16));
		murs.add(new Mur(pIB5, mEB7, 2, null, "mIB10", tpC16, tpC17));
		murs.add(new Mur(pIB6, mEB6, 2, null, "mIB11", tpC17, tpC18));


		//Points d'intérêts
		Node user1 = new Node(60, 480, "user1", tpC12);
		listUser.add(user1);

		Node user2 = new Node(650, 500, "user2", tpINF);
		listUser.add(user2);
		
		Node user3 = new Node(80, 100, "user2", tpC09);
		listUser.add(user3);
		
		
		Node carrefour1 = new Node(485, 445, "carrefour1", tc);
		listUser.add(carrefour1);
		Node carrefour2 = new Node(365, 445, "carrefour2", tc);
		listUser.add(carrefour2);
		Node carrefour3 = new Node(146, 442, "carrefour3", tc);
		listUser.add(carrefour3);
		Node carrefour4 = new Node(146, 168, "carrefour4", tc);
		listUser.add(carrefour4);
		Node carrefour5 = new Node(366, 168, "carrefour5", tc);
		listUser.add(carrefour5);
		Node carrefour6 = new Node(374, 293, "carrefour6", tc);
		listUser.add(carrefour6);
		Node carrefour7 = new Node(474, 293, "carrefour7", tc);
		listUser.add(carrefour7);
	}
	
	public ArrayList<Node> getListUser() {
		return listUser;
	}

}
