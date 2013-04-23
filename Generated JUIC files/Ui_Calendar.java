/********************************************************************************
** Form generated from reading ui file 'Calendar.jui'
**
** Created: Wed 17. Apr 18:17:11 2013
**      by: Qt User Interface Compiler version 4.5.2
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_Calendar implements com.trolltech.qt.QUiForm<QWidget>
{
    public QVBoxLayout verticalLayout_2;
    public QVBoxLayout verticalLayout;
    public QCalendarWidget calendarWidget;
    public QHBoxLayout horizontalLayout;
    public QPushButton insertButton;
    public QSpacerItem horizontalSpacer;
    public QPushButton cancelButton;

    public Ui_Calendar() { super(); }

    public void setupUi(QWidget Calendar)
    {
        Calendar.setObjectName("Calendar");
        Calendar.resize(new QSize(241, 219).expandedTo(Calendar.minimumSizeHint()));
        verticalLayout_2 = new QVBoxLayout(Calendar);
        verticalLayout_2.setObjectName("verticalLayout_2");
        verticalLayout = new QVBoxLayout();
        verticalLayout.setObjectName("verticalLayout");
        calendarWidget = new QCalendarWidget(Calendar);
        calendarWidget.setObjectName("calendarWidget");
        calendarWidget.setFirstDayOfWeek(com.trolltech.qt.core.Qt.DayOfWeek.Monday);
        calendarWidget.setVerticalHeaderFormat(com.trolltech.qt.gui.QCalendarWidget.VerticalHeaderFormat.NoVerticalHeader);
        calendarWidget.setDateEditEnabled(true);

        verticalLayout.addWidget(calendarWidget);

        horizontalLayout = new QHBoxLayout();
        horizontalLayout.setObjectName("horizontalLayout");
        insertButton = new QPushButton(Calendar);
        insertButton.setObjectName("insertButton");

        horizontalLayout.addWidget(insertButton);

        horizontalSpacer = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        horizontalLayout.addItem(horizontalSpacer);

        cancelButton = new QPushButton(Calendar);
        cancelButton.setObjectName("cancelButton");

        horizontalLayout.addWidget(cancelButton);


        verticalLayout.addLayout(horizontalLayout);


        verticalLayout_2.addLayout(verticalLayout);

        retranslateUi(Calendar);

        Calendar.connectSlotsByName();
    } // setupUi

    void retranslateUi(QWidget Calendar)
    {
        Calendar.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("Calendar", "Form", null));
        insertButton.setText(com.trolltech.qt.core.QCoreApplication.translate("Calendar", "Insert", null));
        cancelButton.setText(com.trolltech.qt.core.QCoreApplication.translate("Calendar", "Cancel", null));
    } // retranslateUi

}

