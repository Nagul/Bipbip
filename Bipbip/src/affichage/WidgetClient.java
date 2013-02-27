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
	private pathfind.GeneratorGraph gG;
	private ArrayList<Node> nodesAl;
	
	private int step;//juste pour des tests
	private GraphSearch rG;
	
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
	
	@SuppressWarnings("unchecked")
	public WidgetClient(ArrayList<Node> nodes) {
		super();
		step = 0;
		
		nodesAl = (ArrayList<Node>) nodes.clone();
		//generation du graphe
		gG = new GeneratorGraph(nodes);
		gG.generatateGraph();
		gG.getGraph().keepConnected(nodesAl.get(0));
		
		rG = new GraphSearch(gG.getGraph());
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
				scene.addEllipse(nUser.getAbscissa(), nUser.getOrdinate(), 10, 10, penGreen, brushGreen);
			}
		}
				
		//affichage des murs et portes
		penBlack.setCapStyle(PenCapStyle.FlatCap);
		for (Wall m : Bipbip.walls) {
			penBlack.setWidthF(2*m.getWidth());
			scene.addLine(m.getCornerStart().getAbscissa(), m.getCornerStart().getOrdinate(), m.getCornerEnd().getAbscissa(), m.getCornerEnd().getOrdinate(), penBlack);
			//TODO : joli affichage des portes
			if (m.getDoors()!=null) {
				for (Node n : m.getDoors()) {
					scene.addEllipse(n.getAbscissa(), n.getOrdinate(), 10, 10, penBlue, brushBlue);
				}
			}
		}
		
		
		view = new QGraphicsView(scene);
		view.setBackgroundBrush(brushBlack);
		this.setCentralWidget(view);
	}
	
	@SuppressWarnings("unused")
	private void zoom() {
		view.scale(2,2);
	}

	@SuppressWarnings("unused")
	private void dezoom() {
		view.scale(0.5,0.5);
	}

	@SuppressWarnings("unused")
	private void run() {
		Path chemin;
		if (step == 0) {
			chemin = rG.shorterPath(nodesAl.get(0), nodesAl.get(1));
			System.out.println(chemin.getDistance());
			for (int i = 0; i < chemin.getPath().size() - 1; i++) {
				scene.addLine(chemin.getPath().get(i).getAbscissa(), chemin.getPath().get(i).getOrdinate(), chemin.getPath().get(i + 1).getAbscissa(),chemin.getPath().get(i + 1).getOrdinate(), penRed);
			}
			//affichage du chemin choisi EN BOURRIN
			step += 1;
		} else if (step == 1) {
			chemin = rG.shorterPath(nodesAl.get(0), nodesAl.get(2));
			System.out.println(chemin.getDistance());
			for (int i = 0; i < chemin.getPath().size() - 1; i++) {
				scene.addLine(chemin.getPath().get(i).getAbscissa(), chemin.getPath().get(i).getOrdinate(), chemin.getPath().get(i + 1).getAbscissa(),chemin.getPath().get(i + 1).getOrdinate(), penGreen);
			}
			step += 1;
		} else {
			chemin = rG.shorterPath(nodesAl.get(1), nodesAl.get(2));
			System.out.println(chemin.getDistance());
			for (int i = 0; i < chemin.getPath().size() - 1; i++) {
				scene.addLine(chemin.getPath().get(i).getAbscissa(), chemin.getPath().get(i).getOrdinate(), chemin.getPath().get(i + 1).getAbscissa(),chemin.getPath().get(i + 1).getOrdinate(), penBlue);
			}
			step += 1;
		}
		Bipbip.equipe.getEquipe().get(0).sendInstruction(chemin);
	}

}
