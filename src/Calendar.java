/**
 * A simple text editor
 * @author Mark Holland, Álvaro Ponce Arévalo
 * 2013
 */

import com.trolltech.qt.core.QDate;
import com.trolltech.qt.gui.QCalendarWidget;
import com.trolltech.qt.gui.QDialog;

public class Calendar extends QDialog {

    Ui_Calendar ui = new Ui_Calendar();
    QDate date;
    
    public Signal1<QDate> CalendarDate =							//Signal for the Qdate selected by the user
            new Signal1<QDate>();
    
    public Calendar() {
        ui.setupUi(this);
        setWindowTitle("Date");
    }
    
    /**
     * When insert button clicked the selected
     * QDate is emitted
     */
    public void on_insertButton_clicked(){
    	CalendarDate.emit(date);									//Emit the selected date
    	this.accept();												//Close the dialog
    }
    
    /**
     * Close dialog when cancel button clicked
     */
    public void on_cancelButton_clicked(){
    	this.reject();												//Close the dialog						
    }
    
    public void on_calendarWidget_selectionChanged() {
    	date = ui.calendarWidget.selectedDate();
    }
 
}//End of Dialog
