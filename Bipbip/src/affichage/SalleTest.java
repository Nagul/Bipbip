package affichage;

import java.util.ArrayList;

import pathfind.Wall;
import pathfind.Node;
import pathfind.TypeCouloir;
import pathfind.TypeExterieur;
import pathfind.TypePiece;

public class SalleTest {
	
	private ArrayList<Node> listUser; 
	
	public SalleTest() {
		listUser = new ArrayList<Node>();
	}
	
	
	public void initialisation() {

		ArrayList<Wall> murs = Bipbip.walls;
		
		//couloir, piece
		TypeCouloir tc = new TypeCouloir("Couloir");
		TypeExterieur te = new TypeExterieur("Exterieur");
		
		TypePiece tp1 = new TypePiece("Chambre 01");
		TypePiece tp2 = new TypePiece("Chambre 02");
		TypePiece tp3 = new TypePiece("Chambre 03");
		TypePiece tp4 = new TypePiece("Chambre 04");
		TypePiece tp5 = new TypePiece("Chambre 05");
		TypePiece tp6 = new TypePiece("Chambre 06");
		TypePiece tp7 = new TypePiece("Chambre 07");
		TypePiece tp8 = new TypePiece("Chambre 08");
		TypePiece tp9 = new TypePiece("Chambre 09");
		TypePiece tp10 = new TypePiece("Chambre 10");
		TypePiece tp11 = new TypePiece("Chambre 11");
		
		//Walls exterieur Haut
		Node nEH1 = new Node(0, 0);
		Node nEH2 = new Node(110, 0);
		Node nEH3 = new Node(380, 0);
		Node nEH4 = new Node(730, 0);
		
		murs.add(new Wall(nEH1, nEH2, 5, null, "mEH1", te, tp1));
		murs.add(new Wall(nEH2, nEH3, 5, null, "mEH2", te, tp2));
		murs.add(new Wall(nEH3, nEH4, 5, null, "mEH3", te, tp3));
		
		//Walls exterieur Droite
		Node nED1 = new Node(730, 90);
		Node nED2 = new Node(730, 660);
		
		murs.add(new Wall(nEH4, nED1, 5, null, "mED1", te, tp3));
		murs.add(new Wall(nED1, nED2, 5, null, "mED2", te, tc));
		
		//Walls exterieur Bas
		Node nEB1 = new Node(630, 660);
		Node nEB2 = new Node(450, 660);
		Node nEB3 = new Node(360, 660);
		Node nEB4 = new Node(290, 660);
		Node nEB5 = new Node(0, 660);
		
		murs.add(new Wall(nED2, nEB1, 5, null, "mEB1", te, tc));
		murs.add(new Wall(nEB1, nEB2, 5, null, "mEB2", te, tp11));
		murs.add(new Wall(nEB2, nEB3, 5, null, "mEB3", te, tc));
		murs.add(new Wall(nEB3, nEB4, 5, null, "mEB4", te, tp10));
		murs.add(new Wall(nEB4, nEB5, 5, null, "mEB5", te, tp9));
		
		//Walls exterieur Gauche
		Node nEG1 = new Node(0, 540);
		Node nEG2 = new Node(0, 360);
		Node nEG3 = new Node(0, 180);
		Node nEG4 = new Node(0, 90);
		
		murs.add(new Wall(nEB5, nEG1, 5, null, "mEG1", te, tp9));
		murs.add(new Wall(nEG1, nEG2, 5, null, "mEG2", te, tc));
		murs.add(new Wall(nEG2, nEG3, 5, null, "mEG3", te, tp4));
		murs.add(new Wall(nEG3, nEG4, 5, null, "mEG4", te, tc));
		murs.add(new Wall(nEG4, nEH1, 5, null, "mEG5", te, tp1));
		
		//Pieces 1 -> 3
		Node nIP1P2 = new Node(110, 90);
		Node nIP2P3 = new Node(380, 90);
		
		Node porteP1 = new Node(20, 90, "porteP1", null);
		Node porteP2 = new Node(210, 90, "porteP2", null);
		Node porteP3 = new Node(480, 90, "porteP3", null);
		
		murs.add(new Wall(nEG4, nIP1P2, 10, porteP1, "mIP1", tp1, tc));
		murs.add(new Wall(nIP1P2, nIP2P3, 10, porteP2, "mIP2", tp2, tc));
		murs.add(new Wall(nIP2P3, nED1, 10, porteP3, "mIP3", tp3, tc));
		
		murs.add(new Wall(nIP1P2, nEH2, 10, null, "mIP1P2", tp1, tp2));
		murs.add(new Wall(nIP2P3, nEH3, 10, null, "mIP2P3", tp2, tp3));
		
		//Piece 4
		Node nIP4H = new Node(70, 180);
		Node nIP4B = new Node(70, 360);
		
		Node porteP4 = new Node(70, 340, "porteP4", null);
		
		murs.add(new Wall(nEG3, nIP4H, 10, null, "mIP4H", tc, tp4));
		murs.add(new Wall(nIP4H, nIP4B, 10, porteP4, "mIP4D", tc, tp4));
		murs.add(new Wall(nIP4B, nEG2, 10, null, "mIP4B", tc, tp4));
		
		//Piece 5
		Node nIP5HG = new Node(160, 200);
		Node nIP5HD = new Node(360, 200);
		Node nIP5BG = new Node(160, 270);
		Node nIP5BD = new Node(360, 270);
		
		Node porteP5H = new Node(270, 200, "porteP5H", null);
		Node porteP5B = new Node(270, 270, "porteP5B", null);
		
		murs.add(new Wall(nIP5HG, nIP5HD, 10, porteP5H, "mIP5H", tc, tp5));
		murs.add(new Wall(nIP5HD, nIP5BD, 10, null, "mIP5D", tc, tp5));
		murs.add(new Wall(nIP5BD, nIP5BG, 10, porteP5B, "mIP5B", tc, tp5));
		murs.add(new Wall(nIP5BG, nIP5HG, 10, null, "mIP5G", tc, tp5));
		
		//Pieces 6 -> 7
		Node nIP6HG = new Node(450, 200);
		Node nIP6HD = new Node(630, 200);
		Node nIP6P7G = new Node(450, 270);
		Node nIP6P7D = new Node(630, 270);
		Node nIP7BG = new Node(450, 340);
		Node nIP7BD = new Node(630, 340);
		
		Node porteP6 = new Node(540, 200, "porteP6", null);
		Node porteP7 = new Node(540, 340, "porteP7", null);
		
		murs.add(new Wall(nIP6HG, nIP6HD, 10, porteP6, "mIP6H", tc, tp6));
		murs.add(new Wall(nIP6HD, nIP6P7D, 10, null, "mIP6D", tc, tp6));
		murs.add(new Wall(nIP6P7D, nIP7BD, 10, null, "mIP7D", tc, tp7));
		murs.add(new Wall(nIP7BD, nIP7BG, 10, porteP7, "mIP7B", tc, tp7));
		murs.add(new Wall(nIP7BG, nIP6P7G, 10, null, "mIP7D", tc, tp7));
		murs.add(new Wall(nIP6P7G, nIP6HG, 10, null, "mIP6D", tc, tp6));
		
		murs.add(new Wall(nIP6P7G, nIP6P7D, 10, null, "mIP6P7", tp6, tp7));	
		
		//Piece 8
		Node nIP8HG = new Node(160, 380);
		Node nIP8HD = new Node(360, 380);
		Node nIP8BG = new Node(160, 450);
		Node nIP8BD = new Node(360, 450);
		
		Node porteP8H = new Node(270, 380, "porteP8H", null);
		Node porteP8B = new Node(270, 450, "porteP8B", null);
		
		murs.add(new Wall(nIP8HG, nIP8HD, 10, porteP8H, "mIP8H", tc, tp8));
		murs.add(new Wall(nIP8HD, nIP8BD, 10, null, "mIP8D", tc, tp8));
		murs.add(new Wall(nIP8BD, nIP8BG, 10, porteP8B, "mIP8B", tc, tp8));
		murs.add(new Wall(nIP8BG, nIP8HG, 10, null, "mIP8G", tc, tp8));
		
		//Pieces 9 -> 10
		Node nIP9P10 = new Node(290, 540);
		Node nIP10HD = new Node(360, 540);
		
		Node porteP9 = new Node(180, 540, "porteP9", null);
		Node porteP10 = new Node(360, 630, "porteP10", null);
		
		murs.add(new Wall(nEG1, nIP9P10, 10, porteP9, "mIP9H", tc, tp9));
		murs.add(new Wall(nIP9P10, nIP10HD, 10, null, "mIP9H", tc, tp10));
		murs.add(new Wall(nIP10HD, nEB3, 10, porteP10, "mIP9D", tc, tp10));
		
		murs.add(new Wall(nIP9P10, nEB4, 10, null, "mIP9P10", tp10, tp9));
		
		//Piece 11
		Node nIP11HG = new Node(450, 450);
		Node nIP11HD = new Node(630, 450);
		
		Node porteP11 = new Node(540, 450, "porteP11", null);
		
		murs.add(new Wall(nEB2, nIP11HG, 10, null, "mIP11G", tc, tp11));
		murs.add(new Wall(nIP11HG, nIP11HD, 10, porteP11, "mIP11H", tc, tp11));
		murs.add(new Wall(nIP11HD, nEB1, 10, null, "mIP11D", tc, tp11));
		
		//point de depart/arrive
		listUser.add(new Node(640, 50, "user3", tp3));
		listUser.add(new Node(50, 40, "user1", tp1));
		listUser.add(new Node(600, 600, "user2", tp11));

		
		/*
		//passage piéton
		Node carrefour1 = new Node(115, 145, "carrefour1", tc);
		listUser.add(carrefour1);
		Node carrefour2 = new Node(400, 145, "carrefour2", tc);
		listUser.add(carrefour2);
		Node carrefour3 = new Node(115, 330, "carrefour3", tc);
		listUser.add(carrefour3);
		Node carrefour4 = new Node(400, 330, "carrefour4", tc);
		listUser.add(carrefour4);
		Node carrefour5 = new Node(400, 400, "carrefour5", tc);
		listUser.add(carrefour5);
		Node carrefour6 = new Node(630, 400, "carrefour6", tc);
		listUser.add(carrefour6);
		Node carrefour7 = new Node(160, 500, "carrefour7", tc);
		listUser.add(carrefour7);
		Node carrefour8 = new Node(370, 500, "carrefour8", tc);
		listUser.add(carrefour8);
		*/
		
	}
	
	public ArrayList<Node> getListUser() {
		return listUser;
	}

}
