
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*; 

public class Notepad implements ActionListener{
    
    JFrame frame = new JFrame("Notepad"); 

    //Textarea component 
    JTextArea textArea;
    JScrollPane scrollPane;
    boolean wordWrapOn = false; 

    //menu component
    JMenuBar mb = new JMenuBar(); 
    JMenu menu, menu2, menu3, menu4, menu5; 
    JMenuItem mNew, mOpen, mSave, mSaveAs, mExit; //file menu subn items
    JMenuItem mCopy, mCut, mPaste; //edit menu sub items 
    JMenuItem mWordWrap, fontArial, fontTimes, fontcss, FS8, FS11, FS12, FS16, FS20, FS24; //Format menu sub items 
    JMenu mFont, mFontSize; 

    //objects for other classes
    Function_File file = new Function_File(this); 
    Function_Edit edit = new Function_Edit(this); 
    Function_Format format = new Function_Format(this); 

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
        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        frame.add(scrollPane);
    }

    //settings for the menubar
    public void createMenuBar(){
        menu = new JMenu("File");
        mb.add(menu);

        menu2 = new JMenu("Edit");
        mb.add(menu2);

        menu3 = new JMenu("Format");
        mb.add(menu3);

        menu4 = new JMenu("View");
        mb.add(menu4);

        menu5 = new JMenu("Help");
        mb.add(menu5);

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

    public void createFormatMenu(){
        mWordWrap = new JMenuItem("Word Wrap: off"); 
        mWordWrap.addActionListener(this);
        mWordWrap.setActionCommand("word wrap");
        menu3.add(mWordWrap);

        mFont = new JMenu("Font");
        menu3.add(mFont); 

        mFontSize = new JMenu("Font Size");
        menu3.add(mFontSize); 

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
    }


    
    /*Next: creating the edit menu */



    @Override
    public void actionPerformed(ActionEvent e) {
        
        String command = e.getActionCommand(); 

        //switch statement to alternate between action commands from the file menu
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

        }//end of switch statement 

    }//end of action performed class 

}//end of Notepad class 