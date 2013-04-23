/********************************************************************************
** Form generated from reading ui file 'MainApplication.jui'
**
** Created: Mon 22. Apr 18:37:40 2013
**      by: Qt User Interface Compiler version 4.5.2
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_MainApplication implements com.trolltech.qt.QUiForm<QMainWindow>
{
    public QAction action_New;
    public QAction action_Open;
    public QAction action_Save;
    public QAction action_Quit;
    public QAction action_About;
    public QAction action_Copy;
    public QAction action_Cut;
    public QAction action_Paste;
    public QAction action_SaveAs;
    public QAction action_Find;
    public QAction action_Replace;
    public QAction action_Date;
    public QAction action_Undo;
    public QAction action_Redo;
    public QAction action_SelectAll;
    public QAction action_Italic;
    public QAction action_Underline;
    public QAction action_Bold;
    public QWidget centralwidget;
    public QHBoxLayout horizontalLayout;
    public QTextEdit editor;
    public QMenuBar menubar;
    public QMenu menu_File;
    public QMenu menu_About;
    public QMenu menuEdit;
    public QMenu menuInset;
    public QMenu menuSearch;
    public QStatusBar statusbar;
    public QToolBar toolBar;

    public Ui_MainApplication() { super(); }

    public void setupUi(QMainWindow MainApplication)
    {
        MainApplication.setObjectName("MainApplication");
        MainApplication.resize(new QSize(800, 600).expandedTo(MainApplication.minimumSizeHint()));
        action_New = new QAction(MainApplication);
        action_New.setObjectName("action_New");
        action_New.setIcon(new QIcon(new QPixmap("classpath:icons/New_48x48.png")));
        action_Open = new QAction(MainApplication);
        action_Open.setObjectName("action_Open");
        action_Open.setIcon(new QIcon(new QPixmap("classpath:icons/Open_48x48.png")));
        action_Save = new QAction(MainApplication);
        action_Save.setObjectName("action_Save");
        action_Save.setIcon(new QIcon(new QPixmap("classpath:icons/Save_48x48.png")));
        action_Quit = new QAction(MainApplication);
        action_Quit.setObjectName("action_Quit");
        action_About = new QAction(MainApplication);
        action_About.setObjectName("action_About");
        action_Copy = new QAction(MainApplication);
        action_Copy.setObjectName("action_Copy");
        action_Copy.setIcon(new QIcon(new QPixmap("classpath:icons/Copy_48x48.png")));
        action_Cut = new QAction(MainApplication);
        action_Cut.setObjectName("action_Cut");
        action_Cut.setIcon(new QIcon(new QPixmap("classpath:icons/Cut_48x48.png")));
        action_Paste = new QAction(MainApplication);
        action_Paste.setObjectName("action_Paste");
        action_Paste.setIcon(new QIcon(new QPixmap("classpath:icons/Paste_48x48.png")));
        action_SaveAs = new QAction(MainApplication);
        action_SaveAs.setObjectName("action_SaveAs");
        action_Find = new QAction(MainApplication);
        action_Find.setObjectName("action_Find");
        action_Find.setIcon(new QIcon(new QPixmap("classpath:icons/Find_48x48.png")));
        action_Replace = new QAction(MainApplication);
        action_Replace.setObjectName("action_Replace");
        action_Replace.setIcon(new QIcon(new QPixmap("classpath:icons/Replace_48x48.png")));
        action_Date = new QAction(MainApplication);
        action_Date.setObjectName("action_Date");
        action_Undo = new QAction(MainApplication);
        action_Undo.setObjectName("action_Undo");
        action_Undo.setIcon(new QIcon(new QPixmap("classpath:icons/Undo_48x48.png")));
        action_Redo = new QAction(MainApplication);
        action_Redo.setObjectName("action_Redo");
        action_Redo.setIcon(new QIcon(new QPixmap("classpath:icons/Redo_48x48.png")));
        action_SelectAll = new QAction(MainApplication);
        action_SelectAll.setObjectName("action_SelectAll");
        action_SelectAll.setIcon(new QIcon(new QPixmap("classpath:icons/Select_48x48.png")));
        action_Italic = new QAction(MainApplication);
        action_Italic.setObjectName("action_Italic");
        action_Italic.setIcon(new QIcon(new QPixmap("classpath:icons/italic_48x48.png")));
        action_Underline = new QAction(MainApplication);
        action_Underline.setObjectName("action_Underline");
        action_Underline.setIcon(new QIcon(new QPixmap("classpath:icons/Underline_48x48.png")));
        action_Bold = new QAction(MainApplication);
        action_Bold.setObjectName("action_Bold");
        action_Bold.setIcon(new QIcon(new QPixmap("classpath:icons/Bold_48x48.png")));
        centralwidget = new QWidget(MainApplication);
        centralwidget.setObjectName("centralwidget");
        horizontalLayout = new QHBoxLayout(centralwidget);
        horizontalLayout.setMargin(0);
        horizontalLayout.setObjectName("horizontalLayout");
        editor = new QTextEdit(centralwidget);
        editor.setObjectName("editor");

        horizontalLayout.addWidget(editor);

        MainApplication.setCentralWidget(centralwidget);
        menubar = new QMenuBar(MainApplication);
        menubar.setObjectName("menubar");
        menubar.setGeometry(new QRect(0, 0, 800, 21));
        menu_File = new QMenu(menubar);
        menu_File.setObjectName("menu_File");
        menu_About = new QMenu(menubar);
        menu_About.setObjectName("menu_About");
        menuEdit = new QMenu(menubar);
        menuEdit.setObjectName("menuEdit");
        menuInset = new QMenu(menubar);
        menuInset.setObjectName("menuInset");
        menuSearch = new QMenu(menubar);
        menuSearch.setObjectName("menuSearch");
        MainApplication.setMenuBar(menubar);
        statusbar = new QStatusBar(MainApplication);
        statusbar.setObjectName("statusbar");
        MainApplication.setStatusBar(statusbar);
        toolBar = new QToolBar(MainApplication);
        toolBar.setObjectName("toolBar");
        MainApplication.addToolBar(com.trolltech.qt.core.Qt.ToolBarArea.TopToolBarArea, toolBar);

        menubar.addAction(menu_File.menuAction());
        menubar.addAction(menuEdit.menuAction());
        menubar.addAction(menuInset.menuAction());
        menubar.addAction(menuSearch.menuAction());
        menubar.addAction(menu_About.menuAction());
        menu_File.addAction(action_New);
        menu_File.addAction(action_Open);
        menu_File.addAction(action_Save);
        menu_File.addAction(action_SaveAs);
        menu_File.addSeparator();
        menu_File.addSeparator();
        menu_File.addAction(action_Quit);
        menu_About.addAction(action_About);
        menuEdit.addAction(action_Undo);
        menuEdit.addAction(action_Redo);
        menuEdit.addSeparator();
        menuEdit.addAction(action_Cut);
        menuEdit.addAction(action_Copy);
        menuEdit.addAction(action_Paste);
        menuEdit.addAction(action_SelectAll);
        menuEdit.addSeparator();
        menuInset.addAction(action_Date);
        menuSearch.addAction(action_Find);
        menuSearch.addAction(action_Replace);
        toolBar.addAction(action_New);
        toolBar.addAction(action_Open);
        toolBar.addAction(action_Save);
        toolBar.addSeparator();
        toolBar.addAction(action_Cut);
        toolBar.addAction(action_Copy);
        toolBar.addAction(action_Paste);
        toolBar.addAction(action_SelectAll);
        toolBar.addSeparator();
        toolBar.addAction(action_Undo);
        toolBar.addAction(action_Redo);
        toolBar.addSeparator();
        toolBar.addAction(action_Find);
        toolBar.addAction(action_Replace);
        toolBar.addSeparator();
        toolBar.addAction(action_Bold);
        toolBar.addAction(action_Italic);
        toolBar.addAction(action_Underline);
        toolBar.addSeparator();
        retranslateUi(MainApplication);

        MainApplication.connectSlotsByName();
    } // setupUi

    void retranslateUi(QMainWindow MainApplication)
    {
        MainApplication.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "MainWindow", null));
        action_New.setText(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "&New", null));
        action_New.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "Create a new document", null));
        action_New.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "Ctrl+N", null));
        action_Open.setText(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "&Open...", null));
        action_Open.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "Open an existing document", null));
        action_Open.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "Ctrl+O", null));
        action_Save.setText(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "&Save", null));
        action_Save.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "Save the current document", null));
        action_Save.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "Ctrl+S", null));
        action_Quit.setText(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "&Quit", null));
        action_Quit.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "Quit the application", null));
        action_Quit.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "Ctrl+Q", null));
        action_About.setText(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "&About", null));
        action_About.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "About the application", null));
        action_Copy.setText(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "&Copy", null));
        action_Copy.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "Copy", null));
        action_Copy.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "Ctrl+C", null));
        action_Cut.setText(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "&Cut", null));
        action_Cut.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "Cut", null));
        action_Cut.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "Ctrl+X", null));
        action_Paste.setText(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "&Paste", null));
        action_Paste.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "Paste", null));
        action_Paste.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "Ctrl+V", null));
        action_SaveAs.setText(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "&Save As...", null));
        action_SaveAs.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "Save As", null));
        action_SaveAs.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "Ctrl+Shift+S", null));
        action_Find.setText(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "&Find", null));
        action_Find.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "Find", null));
        action_Find.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "Ctrl+F", null));
        action_Replace.setText(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "&Replace", null));
        action_Replace.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "Replace", null));
        action_Replace.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "Ctrl+H", null));
        action_Date.setText(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "&Date", null));
        action_Date.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "Insert a Date", null));
        action_Date.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "Ctrl+D", null));
        action_Undo.setText(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "&Undo", null));
        action_Undo.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "Undo", null));
        action_Undo.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "Ctrl+Z", null));
        action_Redo.setText(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "&Redo", null));
        action_Redo.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "Redo", null));
        action_Redo.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "Ctrl+Y", null));
        action_SelectAll.setText(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "&Select All", null));
        action_SelectAll.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "Select All", null));
        action_SelectAll.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "Ctrl+A", null));
        action_Italic.setText(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "&Italic", null));
        action_Italic.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "Italic", null));
        action_Italic.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "Ctrl+I", null));
        action_Underline.setText(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "&Underline", null));
        action_Underline.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "Underline", null));
        action_Underline.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "Ctrl+U", null));
        action_Bold.setText(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "&Bold", null));
        action_Bold.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "Bold", null));
        action_Bold.setShortcut(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "Ctrl+B", null));
        menu_File.setTitle(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "&File", null));
        menu_About.setTitle(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "&About", null));
        menuEdit.setTitle(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "Edit", null));
        menuInset.setTitle(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "Insert", null));
        menuSearch.setTitle(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "Search", null));
        toolBar.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("MainApplication", "toolBar", null));
    } // retranslateUi

}

