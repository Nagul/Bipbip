import com.trolltech.qt.gui.QApplication;

public class Bipbip {
	
	public static void main(String[] args) {
		
		QApplication.initialize(args);
		Widget test = new Widget();
		test.show();
		QApplication.exec();
	}

}
