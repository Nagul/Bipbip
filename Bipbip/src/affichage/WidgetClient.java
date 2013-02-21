package affichage;
import java.util.ArrayList;

import pathfind.*;

import com.trolltech.qt.core.Qt;
import com.trolltech.qt.core.Qt.PenCapStyle;
import com.trolltech.qt.gui.QBrush;
import com.trolltech.qt.gui.QColor;
import com.trolltech.qt.gui.QGraphicsScene;
import com.trolltech.qt.gui.QGraphicsView;
import com.trolltech.qt.gui.QIcon;
import com.trolltech.qt.gui.QMainWindow;
import com.trolltech.qt.gui.QPen;
import com.trolltech.qt.gui.QToolBar;


public class WidgetClient extends QMainWindow {
	
	private QGraphicsView view;
	private QGraphicsScene scene;
	private QToolBar toolbar;
	private pathfind.GenerateurGraph gG;
	private ArrayList<Node> nodesAl;
	
	private int step;//juste pour des tests
	private RechercheGraph rG;
	
	//pinceaux
	
	private final QBrush brushBlack = new QBrush(QColor.black, Qt.BrushStyle.SolidPattern);
	private final QPen penWhite = new QPen(QColor.white);
	private final QBrush brushWhite = new QBrush(QColor.white, Qt.BrushStyle.SolidPattern);
	private final QPen penRed = new QPen(QColor.red, 2);
	private final QBrush brushRed = new QBrush(QColor.red, Qt.BrushStyle.SolidPattern);
	private final QPen penBlue = new QPen(QColor.blue, 2);
	private final QBrush brushBlue = new QBrush(QColor.blue, Qt.BrushStyle.SolidPattern);
	private final QPen penGreen = new QPen(QColor.green, 2);
	private final QBrush brushGreen = new QBrush(QColor.green, Qt.BrushStyle.SolidPattern);

	//pinceau pour les murs
	private QPen penBlack = new QPen(QColor.black);
	
	public WidgetClient(ArrayList<Node> nodes) {
		super();
		step = 0;
		
		nodesAl = (ArrayList<Node>) nodes.clone();
		//generation du graphe
		gG = new GenerateurGraph(nodes);
		gG.generationGraph();
		gG.getGraph().garderConnexe(nodesAl.get(0));
		
		rG = new RechercheGraph(gG.getGraph());
		setToolbar();
		setScene();
	}

	private void setToolbar() {
		toolbar = new QToolBar("Toolbar");
		
		final QIcon runButton = new QIcon("./ressources/runButton.png");
		toolbar.addAction(runButton, "Run", this, "run()");
		final QIcon stopButton = new QIcon("./ressources/stopButton.png");
		toolbar.addAction(stopButton, "Stop");
		final QIcon optionButton = new QIcon("./ressources/optionButton.png");
		toolbar.addAction(optionButton, "Option");
		final QIcon zoomButton = new QIcon("./ressources/zoomButton.png");
		toolbar.addAction(zoomButton, "Zoom", this, "zoom()");
		final QIcon dezoomButton = new QIcon("./ressources/dezoomButton.png");
		toolbar.addAction(dezoomButton, "Dézoom", this, "dezoom()");
		
		this.addToolBar(toolbar);
	}
	
	private void setScene() {
		scene = new QGraphicsScene(this);
		scene.setSceneRect(0, 0, 1000, 1000);
		
		//hopital
		scene.addRect(0, 0, 1000, 1000, penWhite, brushWhite);
		
		//nodes utilisateurs
		for (Node nUser : nodesAl) {
			if (nUser.getType() instanceof TypePiece) {
				scene.addEllipse(nUser.getAbscisse(), nUser.getOrdonnee(), 10, 10, penGreen, brushGreen);
			}
		}
				
		//affichage des murs et portes
		penBlack.setCapStyle(PenCapStyle.FlatCap);
		for (Mur m : Bipbip.murs) {
			penBlack.setWidthF(2*m.getEpaisseur());
			scene.addLine(m.getBoutDebut().getAbscisse(), m.getBoutDebut().getOrdonnee(), m.getBoutFin().getAbscisse(), m.getBoutFin().getOrdonnee(), penBlack);
			//TODO : joli affichage des portes
			if (m.getPortes()!=null) {
				for (Node n : m.getPortes()) {
					scene.addEllipse(n.getAbscisse(), n.getOrdonnee(), 10, 10, penBlue, brushBlue);
				}
			}
		}
		
		
		view = new QGraphicsView(scene);
		view.setBackgroundBrush(brushBlack);
		this.setCentralWidget(view);
	}
	
	private void zoom() {
		view.scale(2,2);
	}

	private void dezoom() {
		view.scale(0.5,0.5);
	}

	private void run() {
		if (step == 0) {
			Chemin chemin = rG.plusCourtChemin(nodesAl.get(0), nodesAl.get(1));
			System.out.println(chemin.getDistance());
			for (int i = 0; i < chemin.getChemin().size() - 1; i++) {
				scene.addLine(chemin.getChemin().get(i).getAbscisse(), chemin.getChemin().get(i).getOrdonnee(), chemin.getChemin().get(i + 1).getAbscisse(),chemin.getChemin().get(i + 1).getOrdonnee(), penRed);
			}
			//affichage du chemin choisi EN BOURRIN
			step += 1;
		} else if (step == 1) {
			Chemin chemin = rG.plusCourtChemin(nodesAl.get(0), nodesAl.get(2));
			System.out.println(chemin.getDistance());
			for (int i = 0; i < chemin.getChemin().size() - 1; i++) {
				scene.addLine(chemin.getChemin().get(i).getAbscisse(), chemin.getChemin().get(i).getOrdonnee(), chemin.getChemin().get(i + 1).getAbscisse(),chemin.getChemin().get(i + 1).getOrdonnee(), penGreen);
			}
			step += 1;
		} else {
			Chemin chemin = rG.plusCourtChemin(nodesAl.get(1), nodesAl.get(2));
			System.out.println(chemin.getDistance());
			for (int i = 0; i < chemin.getChemin().size() - 1; i++) {
				scene.addLine(chemin.getChemin().get(i).getAbscisse(), chemin.getChemin().get(i).getOrdonnee(), chemin.getChemin().get(i + 1).getAbscisse(),chemin.getChemin().get(i + 1).getOrdonnee(), penBlue);
			}
			step += 1;
		}
	}

}
