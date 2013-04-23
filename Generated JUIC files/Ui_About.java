/********************************************************************************
** Form generated from reading ui file 'About.jui'
**
** Created: Wed 17. Apr 01:21:22 2013
**      by: Qt User Interface Compiler version 4.5.2
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_About implements com.trolltech.qt.QUiForm<QDialog>
{
    public QVBoxLayout verticalLayout_3;
    public QGroupBox aboutGroupBox;
    public QVBoxLayout verticalLayout_2;
    public QVBoxLayout verticalLayout;
    public QSpacerItem verticalSpacer_2;
    public QLabel IconLabel;
    public QLabel label;
    public QSpacerItem verticalSpacer;
    public QHBoxLayout horizontalLayout;
    public QSpacerItem horizontalSpacer;
    public QPushButton aboutCloseButton;
    public QSpacerItem horizontalSpacer_2;

    public Ui_About() { super(); }

    public void setupUi(QDialog About)
    {
        About.setObjectName("About");
        About.resize(new QSize(400, 300).expandedTo(About.minimumSizeHint()));
        verticalLayout_3 = new QVBoxLayout(About);
        verticalLayout_3.setObjectName("verticalLayout_3");
        aboutGroupBox = new QGroupBox(About);
        aboutGroupBox.setObjectName("aboutGroupBox");
        verticalLayout_2 = new QVBoxLayout(aboutGroupBox);
        verticalLayout_2.setObjectName("verticalLayout_2");
        verticalLayout = new QVBoxLayout();
        verticalLayout.setObjectName("verticalLayout");
        verticalSpacer_2 = new QSpacerItem(20, 40, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);

        verticalLayout.addItem(verticalSpacer_2);

        IconLabel = new QLabel(aboutGroupBox);
        IconLabel.setObjectName("IconLabel");
        IconLabel.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.NoFrame);
        IconLabel.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        verticalLayout.addWidget(IconLabel);

        label = new QLabel(aboutGroupBox);
        label.setObjectName("label");

        verticalLayout.addWidget(label);

        verticalSpacer = new QSpacerItem(20, 40, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);

        verticalLayout.addItem(verticalSpacer);


        verticalLayout_2.addLayout(verticalLayout);


        verticalLayout_3.addWidget(aboutGroupBox);

        horizontalLayout = new QHBoxLayout();
        horizontalLayout.setObjectName("horizontalLayout");
        horizontalSpacer = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        horizontalLayout.addItem(horizontalSpacer);

        aboutCloseButton = new QPushButton(About);
        aboutCloseButton.setObjectName("aboutCloseButton");

        horizontalLayout.addWidget(aboutCloseButton);

        horizontalSpacer_2 = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        horizontalLayout.addItem(horizontalSpacer_2);


        verticalLayout_3.addLayout(horizontalLayout);

        retranslateUi(About);
        aboutCloseButton.clicked.connect(About, "accept()");

        About.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog About)
    {
        About.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("About", "Dialog", null));
        aboutGroupBox.setTitle("");
        IconLabel.setText("");
        label.setText(com.trolltech.qt.core.QCoreApplication.translate("About", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
"p, li { white-space: pre-wrap; }\n"+
"</style></head><body style=\" font-family:'MS Shell Dlg 2'; font-size:8.25pt; font-weight:400; font-style:normal;\">\n"+
"<p align=\"center\" style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:8pt;\">A Simple Text Editor</span></p>\n"+
"<p style=\"-qt-paragraph-type:empty; margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; font-size:8pt;\"></p>\n"+
"<p align=\"center\" style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:8pt;\">Code and design by: Mark Holland, \u00c1lvaro Ponce Ar\u00e9valo</span></p></body></html>", null));
        aboutCloseButton.setText(com.trolltech.qt.core.QCoreApplication.translate("About", "Close", null));
    } // retranslateUi

}

