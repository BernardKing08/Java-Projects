import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class Notepad implements ActionListener{
    
    JFrame frame = new JFrame("Notepad"); 

    //Textarea component 
    JTextArea textArea;
    JScrollPane scrollPane;
    boolean wordWrapOn = false; 

    //menu component
    JMenuBar mb = new JMenuBar(); 
    JMenu menu, mEdit, mFormat, mView, mHelp; 
    JMenuItem mNew, mOpen, mSave, mSaveAs, mExit; //file menu subitems
    JMenuItem mCopy, mCut, mPaste; //edit menu sub items 
    JMenuItem mWordWrap, fontArial, fontTimes, fontcss, FS8, FS11, FS12, FS16, FS20, FS24; //Format menu subitems 
    JMenu mFont, mFontSize; //format menu submenus 
    JMenu mChangeColor; //edit menu sub menu 
    JMenuItem white, blue, black; //edit menu, change color sub menu items
    JMenuItem undo, redo; 

    //Passing the current used object to other classes
    Function_File file = new Function_File(this); 
    Function_Edit edit = new Function_Edit(this); 
    Function_Format format = new Function_Format(this);
    
    //using an arbiturature 
    UndoManager um = new UndoManager(); 

    public void go(){
        
        //frame settings
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setVisible(true);

        format.selectedFont = "Arial";
        format.createFont(16);
    }

    //settings for the TextArea 
    public void createTextArea(){

        textArea = new JTextArea(); 
        textArea.getDocument().addUndoableEditListener(
            new UndoableEditListener() {
                public void undoableEditHappened(UndoableEditEvent e){
                    um.addEdit(e.getEdit()); 
                }
            }
        );

        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        frame.add(scrollPane);
    }

    //settings for the menubar
    public void createMenuBar(){
        menu = new JMenu("File");
        mb.add(menu);

        mEdit = new JMenu("Edit");
        mb.add(mEdit);

        mFormat = new JMenu("Format");
        mb.add(mFormat);

        mView = new JMenu("View");
        mb.add(mView);

        mHelp = new JMenu("Help");
        mb.add(mHelp);

        //adding the menubar to the frame
        frame.setJMenuBar(mb);
    }

    //subitems for the fileMenu
    public void createfileMenu(){
        mNew = new JMenuItem("New"); 
        mNew.addActionListener(this);
        mNew.setActionCommand("New");
        menu.add(mNew); 

        mOpen = new JMenuItem("Open"); 
        mOpen.addActionListener(this);
        mOpen.setActionCommand("Open");
        menu.add(mOpen);

        mSave = new JMenuItem("Save"); 
        mSave.addActionListener(this);
        mSave.setActionCommand("Save");
        menu.add(mSave);

        mSaveAs = new JMenuItem("SaveAs"); 
        mSaveAs.addActionListener(this);
        mSaveAs.setActionCommand("SaveAs"); 
        menu.add(mSaveAs); 

        mExit = new JMenuItem("Exit"); 
        mExit.addActionListener(this);
        mExit.setActionCommand("Exit"); 
        menu.add(mExit); 
    }

    //subitems for format menu
    public void createFormatMenu(){
        mWordWrap = new JMenuItem("Word Wrap: off"); 
        mWordWrap.addActionListener(this);
        mWordWrap.setActionCommand("word wrap");
        mFormat.add(mWordWrap);

        mFont = new JMenu("Font");
        mFormat.add(mFont); 

        mFontSize = new JMenu("Font Size");
        mFormat.add(mFontSize); 

        //adding fonts and font sizes to font menu
        fontArial = new JMenuItem("Arial"); 
        fontArial.addActionListener(this); 
        fontArial.setActionCommand("Arial");
        mFont.add(fontArial);

        fontcss = new JMenuItem("Comic Sans"); 
        fontcss.addActionListener(this); 
        fontcss.setActionCommand("Cosmic Sans");
        mFont.add(fontcss);

        fontTimes = new JMenuItem("New Times"); 
        fontTimes.addActionListener(this); 
        fontTimes.setActionCommand("New Times");
        mFont.add(fontTimes);

        //adding font sizes FS11, FS12, FS16, FS20, FS24
        FS8 = new JMenuItem("8"); 
        FS8.addActionListener(this); 
        FS8.setActionCommand("8"); 
        mFontSize.add(FS8); 

        FS11 = new JMenuItem("11"); 
        FS11.addActionListener(this); 
        FS11.setActionCommand("11"); 
        mFontSize.add(FS11); 

        FS12 = new JMenuItem("12"); 
        FS12.addActionListener(this); 
        FS12.setActionCommand("12"); 
        mFontSize.add(FS12); 

        FS16 = new JMenuItem("16"); 
        FS16.addActionListener(this); 
        FS16.setActionCommand("16"); 
        mFontSize.add(FS16); 

        FS20 = new JMenuItem("20"); 
        FS20.addActionListener(this); 
        FS20.setActionCommand("20"); 
        mFontSize.add(FS20); 

        FS24 = new JMenuItem("24"); 
        FS24.addActionListener(this); 
        FS24.setActionCommand("24"); 
        mFontSize.add(FS24);
    }//end of createFormatMenu method

    //subitem for edit menu
    public void createEditMenu(){
        //adding undo and redo feature
        undo = new JMenuItem("Undo"); 
        undo.addActionListener(this);
        undo.setActionCommand("Undo");
        mEdit.add(undo);

        redo = new JMenuItem("redo"); 
        redo.addActionListener(this);
        redo.setActionCommand("redo");
        mEdit.add(redo);
        
        //adding colors white, black and blue
        mChangeColor = new JMenu("Change color"); 
        mEdit.add(mChangeColor); 

        white = new JMenuItem("White"); 
        white.addActionListener(this);
        white.setActionCommand("WHITE");
        mChangeColor.add(white); 

        black = new JMenuItem("Black"); 
        black.addActionListener(this);
        black.setActionCommand("BLACK");
        mChangeColor.add(black); 

        blue = new JMenuItem("Blue"); 
        blue.addActionListener(this);
        blue.setActionCommand("BLUE");
        mChangeColor.add(blue); 

        
    }//end of createEditMenu method


    //actionListener nethod
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String command = e.getActionCommand(); 

        //switch statement to alternate between commands
        switch(command){
            case "New": file.newFile();
                break;
            case "Open": file.open();
                break;
            case "Save": file.save(); 
                break; 
            case "SaveAs": file.saveAs();
                break; 
            case "Exit": file.exit(); 
                break; 
        //cases for format menu wordwrap and font sizes 
            case "word wrap": format.wordWrap();
                break; 
            case "8": format.createFont(8);
                break;
            case "11": format.createFont(11);
                break;
            case "12": format.createFont(12);
                break;
            case "16": format.createFont(16);
                break;
            case "24": format.createFont(24);
                break;
            //cases for selected font 
            case "Arial": format.setFont("Arial"); 
                break; 
            case "Comic Sans": format.setFont("Comic Sans MS"); 
                break; 
            case "New Times": format.setFont("Times New Roman"); 
                break; 
            //cases for changing colors from the edit menu
            case "WHITE": edit.changeColor(command);
                break;
            case "BLACK": edit.changeColor(command);
                break;
            case "BLUE": edit.changeColor(command);
                break;
            //cases for undo and redo command
            case "Undo": edit.undo();
                break;
            case "Redo": edit.redo();
                break;

        }//end of switch statement 

    }//end of action performed class 

}//end of Notepad class 