package affichage;
import pathfind.Arc;
import pathfind.Mur;
import pathfind.Node;
import pathfind.generateurGraph;

import com.trolltech.qt.core.Qt;
import com.trolltech.qt.gui.QBrush;
import com.trolltech.qt.gui.QColor;
import com.trolltech.qt.gui.QGraphicsScene;
import com.trolltech.qt.gui.QGraphicsView;
import com.trolltech.qt.gui.QIcon;
import com.trolltech.qt.gui.QMainWindow;
import com.trolltech.qt.gui.QPen;
import com.trolltech.qt.gui.QToolBar;


public class Widget extends QMainWindow {
	
	private QGraphicsView view;
	private QGraphicsScene scene;
	private QToolBar toolbar;
	private pathfind.generateurGraph gG;
	
	//pinceaux
	
	private final QBrush brushBlack = new QBrush(QColor.black, Qt.BrushStyle.SolidPattern);
	private final QPen penWhite = new QPen(QColor.white);
	private final QBrush brushWhite = new QBrush(QColor.white, Qt.BrushStyle.SolidPattern);
	private final QPen penRed = new QPen(QColor.red);
	private final QBrush brushRed = new QBrush(QColor.red, Qt.BrushStyle.SolidPattern);

	//pinceau pour les murs
	private QPen penBlack = new QPen(QColor.black);
	
	public Widget() {
		super();
		
		//generation du graphe
		gG = new generateurGraph(null);
		gG.generationGraph();
		
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
		scene.addRect(100, 100, 800, 800, penWhite, brushWhite);
		
		//affichage des murs
		for (Mur m : Bipbip.murs) {
			penBlack.setWidthF(m.getEpaisseur());
			scene.addLine(m.getBoutDebut().getAbscisse(), m.getBoutDebut().getOrdonnee(), m.getBoutFin().getAbscisse(), m.getBoutFin().getOrdonnee(), penBlack);
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
		//affichage des Nodes et arcs (on affiche 2 fois les arcs mais osef)
		for (Node n : gG.getGraph().getNodes()) {
			scene.addEllipse(n.getAbscisse(), n.getOrdonnee(), 3, 3, penRed, brushRed);
			for (Arc a : gG.getGraph().getArcs(n)) {
				scene.addLine(a.getNodeDepart().getAbscisse(), a.getNodeDepart().getOrdonnee(), a.getNodeArrive().getAbscisse(), a.getNodeArrive().getOrdonnee(), penRed);
			}
		}
	}
	
}
