public class Main {
    
    public static void main(String[] args){
        //code runs from here 
        Notepad Gui = new Notepad();
        
        
        Gui.createMenuBar();
        Gui.createfileMenu();
        Gui.createEditMenu();
        Gui.createFormatMenu();
        Gui.createTextArea();
        Gui.go(); 
        
    }//end of main method

    
}//end of main class