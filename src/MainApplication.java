/**
 * A simple text editor
 * @author Mark Holland, Álvaro Ponce Arévalo
 * 2013
 */



import com.trolltech.qt.core.QDate;
import com.trolltech.qt.core.QFile;
import com.trolltech.qt.core.QFileInfo;
import com.trolltech.qt.core.QSize;
import com.trolltech.qt.core.QTextStream;
import com.trolltech.qt.core.Qt;
import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QCloseEvent;
import com.trolltech.qt.gui.QCursor;
import com.trolltech.qt.gui.QFileDialog;
import com.trolltech.qt.gui.QFont;
import com.trolltech.qt.gui.QIcon;
import com.trolltech.qt.gui.QLabel;
import com.trolltech.qt.gui.QLineEdit;
import com.trolltech.qt.gui.QMainWindow;
import com.trolltech.qt.gui.QMessageBox;
import com.trolltech.qt.gui.QTextCursor;

public class MainApplication extends QMainWindow {

    Ui_MainApplication ui = new Ui_MainApplication();
    private String curFile = "";								//Current File name
    FindDialog findDialog = null;
    ReplaceDialog replaceDialog = null;
    AboutDialog aboutDialog = null;
    Calendar calendarDialog = null;
    QTextCursor cursor;
    QLineEdit wordCountEdit;									//Read only text box
    QLabel wordCountLabel;										//Label for word count box
    

    public static void main(String[] args) {
        QApplication.initialize(args);

        MainApplication textEditor = new MainApplication();
        textEditor.show();

        QApplication.exec();
    }

    
    public MainApplication() {
        ui.setupUi(this);
        move(300, 50);
        setWindowIcon(new QIcon("icons/Application_48x48.png"));
        ui.editor.textChanged.connect(this, "documentWasModified()");    //Used for detecting save behavior and updating word count
        setCurrentFile("");												 //Blank file has no file name
        
        cursor = new QTextCursor();					 					 //Cursor for returning found selections and where to replace
        cursor.setPosition(0);											 //Start cursor at beginning of document
        
        findDialog = new FindDialog(this);								 //Instantiate a find dialog
        findDialog.find.connect(this, "find(String)");					 //Connect find method
        findDialog.findClose.connect(this, "findClose()");				 //When closing find dialogue set cursor to beginning but not in ui
        
        replaceDialog = new ReplaceDialog(this);						 //Instantiate a replace dialog
        replaceDialog.replace.connect(this, "replace(String, String)");  //Connect replace method
        replaceDialog.replaceClose.connect(this, "replaceClose()");		 //When closing replace dialogue set cursor to beginning but not in ui
        
        aboutDialog = new AboutDialog(this);							 //Instantiate an About dialog
         
        wordCountLabel = new QLabel("Word Count:");						 //Instantiate word count label with text
        wordCountEdit = new QLineEdit();							     //Instantiate Word count box
        wordCountEdit.setReadOnly(true);								 //Make word count box read only
        wordCountEdit.setText("0");										 //Blank document has zero words
        wordCountEdit.setAlignment(Qt.AlignmentFlag.AlignRight);		 //Align word count value to the right of the word count box
        wordCountEdit.setMaximumSize(new QSize(50, 20));				 //Set size of word count box
        
        ui.statusbar.addPermanentWidget(wordCountLabel);				 //Use permanent add as it will always be visible
        
        ui.statusbar.addPermanentWidget(wordCountEdit);					 //Use permanent add as it will always be visible
        
        calendarDialog = new Calendar();								 //Instantiate a Calendar dialog
        calendarDialog.CalendarDate.connect(this, "calendar(QDate)");	 //Connect date selection to calendar method
    }

    /**
     * Creates a new document, if current has been modified checks if wants to save
     */
    private void on_action_New_triggered() {
    	if(checkAndSave()) {											 //Check if user wishes to save current document
    		ui.editor.clear();											 //Clears the document
    		ui.statusbar.showMessage(tr("New document"), 2000);			 //Status bar message
    		setCurrentFile("");											 //Blank document has empty file name
    	}
    }
    
    /**
     * Opens a dialog to select a document to open,
     * if current has been modified checks if wants to save 
     */
    private void on_action_Open_triggered() {
    	ui.statusbar.showMessage(tr("Open document"), 2000);			 //Status bar message
    	
    	
    	if (checkAndSave()) {											 //Check if user wishes to save current document
            String fileName = QFileDialog.getOpenFileName(this);		 //Create a file selection dialog and return the user's selection
            if (fileName.length() != 0){								 //If a file was chosen
               
            	QFile file = new QFile(fileName);						 //Assign the chosen file
            	if (!file.open(new QFile.OpenMode(						 //If invalid filename show an error message
            			QFile.OpenModeFlag.ReadOnly, 
            			QFile.OpenModeFlag.Text))) {
            		QMessageBox.warning(this, tr("Application"),
            				String.format(tr("Cannot read file %1$s:\n%2$s."),
            						fileName, file.errorString()));
            		return;
            	}

            	QTextStream in = new QTextStream(file);					//Create input stream for file contents
            	QApplication.setOverrideCursor(							//Temporarily override cursor
            			new QCursor(Qt.CursorShape.WaitCursor));
            	ui.editor.setText(in.readAll());						//Read text from stream into text box
            	QApplication.restoreOverrideCursor();					//Restore cursor

            	setCurrentFile(fileName);								//Current file is now the opened document
            	ui.statusbar.showMessage(tr("File loaded"), 2000);		//Status bar message
            }
    	}
    }
    
    /**
     * Attempts to save the current document,
     * displays a status bar message if successful
     */
    private void on_action_Save_triggered() {
    	if(save())														//If save operation successful
    		ui.statusbar.showMessage(tr("Document Saved"), 2000);       //Status bar message
    	
    }
    
    /**
     * Copy selection to clip board and show status message
     */
    private void on_action_Copy_triggered() {
    	ui.editor.copy();												//Copy selection to clip board
    	ui.statusbar.showMessage(tr("Copy"), 2000);						//Status bar message
    }
    
    /**
     * Cut selection to clip board and show status message
     */
    private void on_action_Cut_triggered() {
    	ui.editor.cut();												//Cut selection to clip board
    	ui.statusbar.showMessage(tr("Cut"), 2000);						//Status bar message
    }
    
    /**
     * Paste from clip board and show status message
     */
    private void on_action_Paste_triggered() {
    	ui.editor.paste();												//Paste from clip board
    	ui.statusbar.showMessage(tr("Paste"), 2000);					//Status bar message
    }
    
    /**
     * Select all text in the document and show status message
     */
    private void on_action_SelectAll_triggered() {
    	ui.editor.selectAll();											//Select all text in the document
    	ui.statusbar.showMessage(tr("Select All"), 2000);				//Status bar message
    }
    
    /**
     * Show find dialog
     */
    private void on_action_Find_triggered() {
    	
    	findDialog.show();												//Show mode-less find dialog
    	ui.statusbar.showMessage(tr("Find"),							//Status bar message
    			2000);
    }
    
    /**
     * Show replace dialog
     */
    private void on_action_Replace_triggered() {
    	
    	replaceDialog.show();											//Show mode-less replace dialog
    	ui.statusbar.showMessage(tr("Replace"),							//Status bar message
    			2000);								
    }
    
    /**
     * Show Calendar dialog
     */
    private void on_action_Date_triggered() {
    	calendarDialog.exec();											//Show modal Calendar dialog
    	ui.statusbar.showMessage(tr("Insert Date"),						//Status bar message
    			2000);
    }
    
    /**
     * Undo the last operation on the text
     */
    private void on_action_Undo_triggered() {	
    	ui.editor.document().undo();									//Undo the last operation on the text
    	ui.statusbar.showMessage(tr("Undo"),							//Status bar message
    			2000);
    }
    
    /**
     * Re-do the last operation on the text
     */
    private void on_action_Redo_triggered() {
    	ui.editor.document().redo();									//Re-do the last operation on the text
    	ui.statusbar.showMessage(tr("Redo"),							//Status bar message
    			2000);
    }
    
    /**
     * Toggle text to be bold
     */
    private void on_action_Bold_triggered() {
    	if(ui.editor.fontWeight() == QFont.Weight.Bold.value())			//If already set to bold then toggles off
    		ui.editor.setFontWeight(QFont.Weight.Normal.value());
    	else
    		ui.editor.setFontWeight(QFont.Weight.Bold.value());			//Otherwise toggles bold on
    }
    
    /**
     * Toggle text in italics
     */
    private void on_action_Italic_triggered() {
    	if(ui.editor.fontItalic())										//If already set to italic then toggles off
    		ui.editor.setFontItalic(false);
    	else
    		ui.editor.setFontItalic(true);								//Otherwise toggles italics on
    }
    
    /**
     * Toggle text underlined
     */
    private void on_action_Underline_triggered() {
    	if(ui.editor.fontUnderline())									//If already set to underline then toggles off
    		ui.editor.setFontUnderline(false);
    	else
    		ui.editor.setFontUnderline(true);							//Otherwise toggles underline on
    }
    
    
    /**
     * Show the about dialog
     */
    private void on_action_About_triggered() {
    	aboutDialog.exec();												//Instantiate a modal about dialog
    	ui.statusbar.showMessage(										//Status bar message
    			tr("About the application"),
    			2000);
    }
    
    /**
     * Attempt to quit checking if document has been modified
     * and asking whether to save
     */
    private void on_action_Quit_triggered() {
    	if(checkAndSave())												//Check if user wishes to save current document
    		QApplication.instance().quit();								//Quit the application
    }
    
    /**
     * Override method to check whether to save
     * before closing
     */
    public void closeEvent(QCloseEvent event)
    {
        if (checkAndSave())												//Check if user wishes to save current document
            event.accept();												//Allow program to close
        else
            event.ignore();												//Don't close program
    }
    
    
    /**
     * Checks whether the document has been modified and asks the user if
     * wishes to save it before a destructive action.
     * Returns: true if we can proceed, or false if we should stop
     */
     
    private boolean checkAndSave() {
    	if (ui.editor.document().isModified()) {						//Checks if document has been modified
    		QMessageBox.StandardButton result = 						//Create a message box for choosing whether to save
    				QMessageBox.question(this, 
    				tr("Confirmation"),									
    				tr("The document has been modified. Do you want to save it?"),
    				new QMessageBox.StandardButtons(
    						QMessageBox.StandardButton.Yes,				
    						QMessageBox.StandardButton.No,
    						QMessageBox.StandardButton.Cancel));
    		if (result == QMessageBox.StandardButton.Yes)				//If chooses to save
    			return save();
    		else if (result == QMessageBox.StandardButton.No)			//If chooses not to save
    			return true;
    		else														//If chooses to cancel
    			return false;		
    	} else															//The document is not modified. It is safe to continue
    		return true; 												
    }
    
    /**
     * Save to file, if blank document asks for filename
     * @return true if successful, false if unsuccessful
     */
    protected boolean save() {
        if (curFile.length() == 0) {									//If blank document/file name
            return saveAs();											//Save as new document
        } else {														//Already been saved/opened
            return saveFile(curFile);									//Save with current file name
        }
    }
    
    /**
     * Save as new document
     * @return true if successful, false if unsuccessful
     */
    public boolean saveAs() {
        String fileName = QFileDialog.getSaveFileName(this);			//Open a dialog to select the file name
        if (fileName.length() == 0)									    //If empty filename selected, return failure
            return false;

        return saveFile(fileName);										//Attempt to save to chosen file name
    }
    
    /**
     * Save to chosen file name
     * @param fileName
     * @return true if successful, false if unsuccessful
     */
    public boolean saveFile(String fileName) {
        if (!fileName.isEmpty()) {										//Check if chosen file name is empty
        	QFile file = new QFile(fileName);							//Create file object
        	if (!file.open(new QFile.OpenMode(							//Check if able to save to chosen file name
        			QFile.OpenModeFlag.WriteOnly,
        					QFile.OpenModeFlag.Text))) {
        		QMessageBox.warning(this, tr("IPCpad"),					//If invalid filename show an error message
        						String.format(tr("The file %1$s cannot be written:\n%2$s."),
        								fileName, file.errorString()));
        		return false;											//Return failure
        	}
        	QTextStream out = new QTextStream(file);					//Instantiate output stream
        	QApplication.setOverrideCursor(new							//Temporarily override cursor
        	QCursor(Qt.CursorShape.WaitCursor));
        	out.writeString(ui.editor.toPlainText());					//Write to stream from document
        	QApplication.restoreOverrideCursor();						//Restore cursor
        	setCurrentFile(fileName);									//current file name is now the chosen file name
        	statusBar().showMessage(tr("Document saved"), 2000);		//Status bar message
        	file.close();												//Close the file
        	ui.editor.document().setModified(false);					//Document no longer modified
        	return true;												//Return success
        } 
        return false;													//Return failure from empty file name
    }
    
    /**
     * Find the next occurrence of s 
     * from the current cursor position
     * @param s String to be found
     */
    public void find(String s) {
    	ui.editor.setTextCursor( cursor );								//Set ui cursor to current cursor position
		if(ui.editor.find( s )){										//If an occurrence of s is found
			cursor = ui.editor.textCursor();							//set cursor to position of found occurrence
		}else															//If no occurrence of s not found
			ui.statusbar.showMessage(tr("No matches"),					//Status bar message
    			2000);
	}
    
    /**
     * Replace the next occurrence of s for r 
     * from the current cursor position
     * @param s Text to be replace
     * @param r Text to replace with
     */
    public void replace(String s, String r) {
    	ui.editor.setTextCursor( cursor );								//Set ui cursor to current cursor position
		if(ui.editor.find( s )){										//If an occurrence of s is found
		cursor = ui.editor.textCursor();								//set cursor to position of found occurrence
		cursor.removeSelectedText();									//Remove the occurrence of s from the document
		cursor.insertText(r);											//Insert r in the place of s
		}else															//If no occurrence of s found
			ui.statusbar.showMessage(tr("No matches"),					//Status bar message
	    			2000);
	}
    
    /**
     * Insert chosen date as text into document
     * @param date
     */
    public void calendar(QDate date) {
    	ui.editor.setText(date.toString());						//Insert chosen date as text into document
    }
    
    /**
     * Return cursor position to zero after
     * closing find dialog
     */
    public void findClose() {
    	cursor.setPosition(0);											//Set cursor position to zero
    }
    
    /**
     * Return cursor position to zero after
     * closing replace dialog
     */
    public void replaceClose() {
    	cursor.setPosition(0);											//Set cursor position to zero
    }
    
    /**
     * set new file name and display current file name
     * @param fileName
     */
    public void setCurrentFile(String fileName) {
        curFile = fileName;											 	//Set current file name to new one
        ui.editor.document().setModified(false);						//Document no longer modified
        setWindowModified(false);										

        String shownName;												//File name to be displayed
        if (curFile.length() == 0)										//If blank document
            shownName = "untitled.txt";									//Default document name
        else															//If previously saved or opened document
            shownName = strippedName(curFile);							//Remove path from file name

        setWindowTitle(String.format(tr("%1$s[*] - %2$s"),				//Display file name in window title
        		shownName, tr("text editor")));
    }
    
    /**
     * Remove path from file name
     * @param fullFileName
     * @return File name without path
     */
    private static String strippedName(String fullFileName)
    {
        return new QFileInfo(fullFileName).fileName();					//Extract the file name from the full path
    }
    
    /**
     * Set window as modified and set word count
     */
    public void documentWasModified() {
        setWindowModified(ui.editor.document().isModified());			//Set window as modified
        String s = ui.editor.toPlainText();								//Copy document content to string
        String[] wordArray = s.split("\\s+");							//Split string into array of words
        int wordCount = wordArray.length;								//Get number of words
        wordCountEdit.setText(""+wordCount);							//Set number of words in text box
    }
    
}//End of Application
