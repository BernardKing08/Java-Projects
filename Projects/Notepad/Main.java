public class Main {
    //code runs from here
    public static void main(String[] args){
         
        Notepad Gui = new Notepad();
        
        Gui.createMenuBar();
        Gui.createfileMenu();
        Gui.createFormatMenu();
        Gui.createTextArea();
        Gui.go(); 
        
    }//end of main method 

    
}//end of main class
