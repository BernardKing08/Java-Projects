package testinglab;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*; 

public class Notepad implements ActionListener{
    
    JFrame frame = new JFrame("Notepad"); 

    //Textarea component 
    JTextArea textArea;
    JScrollPane scrollPane;

    //menu component
    JMenuBar mb = new JMenuBar(); 
    JMenu menu, menu2, menu3, menu4, menu5; 
    JMenuItem mNew, mOpen, mSave, mSaveAs, mExit; 

    //object controlling the file option 
    Function_File file = new Function_File(this); 

    public void go(){
        
        //frame settings
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setVisible(true);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String command = e.getActionCommand(); 

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
        }
    }

    
}//end of Notepad class 