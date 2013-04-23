/**
 * A simple text editor
 * @author Mark Holland, Álvaro Ponce Arévalo
 * 2013
 */

import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.gui.QPixmap;
import com.trolltech.qt.gui.QWidget;

public class AboutDialog extends QDialog {

    Ui_About ui = new Ui_About();

    public AboutDialog(QWidget parent) {
        super(parent);
        ui.setupUi(this);
        setWindowTitle("About.");
        ui.IconLabel.setPixmap(new QPixmap("classpath:icons/Application_full.png"));
        ui.aboutCloseButton.clicked.connect(this, "accept()");
    }
}
