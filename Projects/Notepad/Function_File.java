package testinglab;

import java.awt.FileDialog;
import java.io.*; 

//a class containing methods to be executed
//depending on the option selected by the user 
//from the notepad class 

public class Function_File implements Serializable{
    //an guiect instance of the notepad class to be used 
    Notepad gui;

    //variables for dealing with files 
    private String fileName; 
    private String fileAddress;

    //creates an instance of the notepad class inorder to access its properties 
    public Function_File(Notepad gui){

        this.gui = gui; 
    }

    //this clears the notepad, and sets the title to 'New'
    public void newFile(){

        gui.textArea.setText("");
        gui.frame.setTitle("New");

        fileName = null; 
        fileAddress = null; 
    }

    //this opens the fileDialog box to access file to open 
    public void open(){

        //to file dialog to the screen 
        FileDialog fd = new FileDialog(gui.frame, "Open", FileDialog.LOAD); 
        fd.setVisible(true);


        if(fd.getFile() != null){
            fileName = fd.getFile(); 
            fileAddress = fd.getDirectory();
            gui.frame.setTitle(fileName); 
        }

        //inoder to get the text from file selected from filedialog
        try{
            BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName));
            gui.textArea.setText("");

            String line = null; 

            //readline() reads a text line by line 
            while((line = br.readLine()) != null){

                gui.textArea.append(line + " \n");
            }

            br.close(); //closes bufferReader 
        }
        catch(Exception e){
            System.out.println("File not found"); //prints it to the console
        }
    }

    public void saveAs(){
        FileDialog fd = new FileDialog(gui.frame, "Save", FileDialog.SAVE);
        fd.setVisible(true);

        if(fd.getFile() != null){
            fileName = fd.getFile(); 
            fileAddress = fd.getDirectory(); 
            gui.frame.setTitle(fileName);
        }


        try{
            FileWriter fw = new FileWriter(fileAddress + fileName); 
            fw.write(gui.textArea.getText());
            fw.close();
        }
        catch(Exception e){
            System.out.println("File not saved"); //prints it to the console
        }
    }

    public void save(){
        
        if(fileName == null){
            saveAs();
        }
        else{
            try{
                FileWriter fw = new FileWriter(fileAddress + fileName); 
                fw.write(gui.textArea.getText());
                fw.close();
            }
            catch(Exception e){
                System.out.println("File not saved"); //prints it to the console
            }
        }
    }

    public void exit(){
        System.exit(0);
    }
   
}//end of function_file class 
