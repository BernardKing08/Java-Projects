
import java.awt.Color;

//work im progress

public class Function_Edit {
    //an object instance of the notepad class to be used
    Notepad gui;

    
    Function_Edit(Notepad gui){
        this.gui = gui;
    }

    //method to change the color of the text inn textArea
    public void changeColor(String str){

        //switch statement to alternate between colors
        switch(str){
            case "WHITE": gui.textArea.setForeground(Color.WHITE);
                break; 
            case "BLUE": gui.textArea.setForeground(Color.BLUE);
                break; 
            case "BLACK": gui.textArea.setForeground(Color.BLACK);
                break; 
        }
    }//end of changeColor method

    //undo command 
    public void undo(){
        gui.um.undo();
    }

    //redo comand 
    public void redo(){
        gui.um.redo();
    }
    

}