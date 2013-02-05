import com.trolltech.qt.core.Qt;
import com.trolltech.qt.gui.QBrush;
import com.trolltech.qt.gui.QColor;
import com.trolltech.qt.gui.QGraphicsScene;
import com.trolltech.qt.gui.QGraphicsView;
import com.trolltech.qt.gui.QMainWindow;
import com.trolltech.qt.gui.QPen;
import com.trolltech.qt.gui.QToolBar;


public class Widget extends QMainWindow {
	
	private QGraphicsView view;
	private QGraphicsScene scene;
	private QToolBar toolbar;
	
	//pinceaux
	private final QPen penBlack = new QPen(QColor.black);
	private final QBrush brushBlack = new QBrush(QColor.black, Qt.BrushStyle.SolidPattern);
	private final QPen penWhite = new QPen(QColor.white);
	private final QBrush brushWhite = new QBrush(QColor.white, Qt.BrushStyle.SolidPattern);

	public Widget() {
		super();
		
		setToolbar();
		setScene();
	}

	private void setToolbar() {
		toolbar = new QToolBar("Toolbar");
		this.addToolBar(toolbar);
	}
	
	private void setScene() {
		scene = new QGraphicsScene(this);
		scene.setSceneRect(0, 0, 10, 10);
		
		view = new QGraphicsView(scene);
		view.setBackgroundBrush(brushBlack);
		this.setCentralWidget(view);
	}
}
