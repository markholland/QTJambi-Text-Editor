/**
 * A simple text editor
 * @author Mark Holland, Álvaro Ponce Arévalo
 * 2013
 */


import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.gui.QHBoxLayout;
import com.trolltech.qt.gui.QLabel;
import com.trolltech.qt.gui.QLineEdit;
import com.trolltech.qt.gui.QPushButton;
import com.trolltech.qt.gui.QVBoxLayout;
import com.trolltech.qt.gui.QWidget;

public class ReplaceDialog extends QDialog {

    Ui_findDialog ui = new Ui_findDialog();
    QLabel label;
    QLabel replaceLabel;
    QLineEdit lineEdit;
    QLineEdit replaceLineEdit;
    QPushButton replaceButton;
    QPushButton closeButton;
    
    public Signal2<String, String> replace =						//Signal for passing string to replace and replace with
            new Signal2<String, String>();
    
    public Signal0 replaceClose =									//Signal to close dialog
            new Signal0();
    
    public ReplaceDialog(QWidget parent) {
        super(parent);
        label = new QLabel(tr("Replace:"));							//Set replace label
        replaceLabel = new QLabel(tr("with:"));						//Set replace with label
        lineEdit = new QLineEdit();									//Instantiate text to replace line edit
        replaceLineEdit = new QLineEdit();							//Instantiate text to replace with line edit
        label.setBuddy(lineEdit);									//Join replace label to line edit
        replaceLabel.setBuddy(replaceLineEdit);						//Join replace with label to line edit

        replaceButton = new QPushButton(tr("&Replace"));			//Instantiate replace button
        replaceButton.setDefault(true);
        replaceButton.setEnabled(false);							//Disable replace button by default

        closeButton = new QPushButton(tr("Close"));					//Instantiate close button
        
        lineEdit.textChanged.connect(this,							//Connect text change to enabling replace button
        		"enableReplaceButton(String)");	
        replaceButton.clicked.connect(this, "replaceClicked()");	//Connect replace button
        closeButton.clicked.connect(this, "replaceCloseClicked()"); //Connect close button
        
        /*********************Layout***********************/
        QHBoxLayout topLeftLayout = new QHBoxLayout();
        topLeftLayout.addWidget(label);
        topLeftLayout.addWidget(lineEdit);
        topLeftLayout.addWidget(replaceLabel);
        topLeftLayout.addWidget(replaceLineEdit);

        QVBoxLayout leftLayout = new QVBoxLayout();
        leftLayout.addLayout(topLeftLayout);
        QVBoxLayout rightLayout = new QVBoxLayout();
        rightLayout.addWidget(replaceButton);
        rightLayout.addWidget(closeButton);
        rightLayout.addStretch();

        QHBoxLayout mainLayout = new QHBoxLayout();
        mainLayout.addLayout(leftLayout);
        mainLayout.addLayout(rightLayout);
        setLayout(mainLayout);

        setWindowTitle(tr("Replace..."));
        setFixedHeight(sizeHint().height());
    }
    
    /**
     * When replace button is clicked
     * emit replace and replace with text
     */
    private void replaceClicked() {
        String text = lineEdit.text();								//Text to replace
        String replaceText = replaceLineEdit.text();				//Text to be replaced
        replace.emit(text,replaceText);								//Emit both texts
    }
    
    /**
     * When close button clicked
     * emit close signal
     */
    private void replaceCloseClicked(){
    	replaceClose.emit();										//Emit close signal
    	this.reject();														
    }
    
    /**
     * Enable replace button if text introduced
     * @param text
     */
    private void enableReplaceButton(String text) {
        replaceButton.setEnabled(text.length() != 0);			   //Enable replace button if text introduced
    }
    
}//End of dialog

