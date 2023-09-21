package testinglab;

public class Main {
    public static void main(String[] args){
        Notepad Gui = new Notepad();
        
        Gui.createMenuBar();
        Gui.createfileMenu();
        Gui.createTextArea();
        Gui.go(); 
        
    }
}
