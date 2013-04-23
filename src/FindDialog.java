/**
 * A simple text editor
 * @author Mark Holland, Álvaro Ponce Arévalo
 * 2013
 */

import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.gui.QHBoxLayout;
import com.trolltech.qt.gui.QIcon;
import com.trolltech.qt.gui.QLabel;
import com.trolltech.qt.gui.QLineEdit;
import com.trolltech.qt.gui.QPushButton;
import com.trolltech.qt.gui.QVBoxLayout;
import com.trolltech.qt.gui.QWidget;

public class FindDialog extends QDialog {

    Ui_findDialog ui = new Ui_findDialog();
    QLabel label;														//Find label
    QLineEdit lineEdit;													//Line edit for text to find
    QPushButton findButton;												//Button to try and find
    QPushButton closeButton;											//Button to close dialog
    
    public Signal1<String> find =										//Signal for text chosen to be found
            new Signal1<String>();
    
    public Signal0 findClose =											//Signal to close dialog
            new Signal0();
    
    public FindDialog(QWidget parent) {
        super(parent);

       
        label = new QLabel(tr("Find &what:"));							//Set find label
        lineEdit = new QLineEdit();										//Instantiate line edit
        label.setBuddy(lineEdit);										//Join label to line edit

        findButton = new QPushButton(tr("&Find"));						//Instantiate find button
        findButton.setDefault(true);									
        findButton.setEnabled(false);									//Not enabled by default

        closeButton = new QPushButton(tr("Close"));						//Instantiate close button
        
        lineEdit.textChanged.connect(this, "enableFindButton(String)");	//Connect text change to enabling find button
        findButton.clicked.connect(this, "findClicked()");				//Connect find button to method
        closeButton.clicked.connect(this, "findCloseClicked()");		//Connect close button to method
        
        /*********************Layout***********************/
        QHBoxLayout topLeftLayout = new QHBoxLayout();
        topLeftLayout.addWidget(label);
        topLeftLayout.addWidget(lineEdit);

        QVBoxLayout leftLayout = new QVBoxLayout();
        leftLayout.addLayout(topLeftLayout);
        QVBoxLayout rightLayout = new QVBoxLayout();
        rightLayout.addWidget(findButton);
        rightLayout.addWidget(closeButton);
        rightLayout.addStretch();

        QHBoxLayout mainLayout = new QHBoxLayout();
        mainLayout.addLayout(leftLayout);
        mainLayout.addLayout(rightLayout);
        setLayout(mainLayout);

        setWindowTitle(tr("Find..."));
        setFixedHeight(sizeHint().height());
    }
    
    /**
     * Find button clicked
     */
    private void findClicked() {
        String text = lineEdit.text();									//Retrieve text to find
        find.emit(text);												//Emit text to be found
    }
    
    /**
     * Close button clicked
     */
    private void findCloseClicked(){
    	findClose.emit();												//Emit close dialog
    	this.reject();
    }
    
    /**
     * Enable find button if text introduced
     * @param text
     */
    private void enableFindButton(String text) {
        findButton.setEnabled(text.length() != 0);						//Enable find button if text introduced
    }
   
}//End of dialog
