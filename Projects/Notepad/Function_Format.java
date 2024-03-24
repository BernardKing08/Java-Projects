package testinglab;

import java.awt.Font;

public class Function_Format {
    //an object instance of the notepad class to be used
    Notepad gui; 

    //varirables for format class
    Font arial, tms, cms; 
    String selectedFont; 
    

    Function_Format(Notepad gui){
        this.gui = gui; 
    }

    public void wordWrap(){
        
        //condition to turn wordwrap on or off
        if(gui.wordWrapOn == false){
            gui.wordWrapOn = true; 
            gui.textArea.setLineWrap(true);
            gui.textArea.setWrapStyleWord(true);
            gui.mWordWrap.setText("Word Wrap: on");
        }
        else if(gui.wordWrapOn == true){
            gui.wordWrapOn = false; 
            gui.textArea.setLineWrap(false);
            gui.textArea.setWrapStyleWord(false);
            gui.mWordWrap.setText("Word Wrap: off");
        }
    }//end of wordwrap method

    //font 
    public void createFont(int FontSize){
        
        arial = new Font("Arial", 0, FontSize);
        cms = new Font("Comic Sans MS", 0, FontSize);
        tms = new Font("Times New Roman", 0, FontSize);

        setFont(selectedFont);
    }

    /*to get the font the user slected
      when the font is selected the method is called and an argument(the selected font)
      is passed to the method and the font is changed using the JTextArea.setFont() method
    */
    public void setFont(String font){
        
        selectedFont = font; 

        switch(selectedFont){
            case "Arial" : gui.textArea.setFont(arial);
                break; 
            case "Cosmic Sans MS" : gui.textArea.setFont(cms);
                break; 
            case "Times New Roman" : gui.textArea.setFont(tms);
                break; 
        }
    } 

}//end of format class 
