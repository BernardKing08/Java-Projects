package testinglab;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyHandler implements KeyListener {
    //an object instance of the notepad class to be used
    Notepad gui;

    //constructor method
    public keyHandler(Notepad gui){
        this.gui = gui;
    }

    //not needed 
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    //method to control shortcut keys 
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_S){ //shortcut to save file
            gui.file.save();
        }
        if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_C){//shortcut to copy
            gui.textArea.copy();
        }
        if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_V){//shortcut to paste
            gui.textArea.paste();
        }
        if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_Z){//shortcut to undo
            gui.edit.undo();
        }
        if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_Y){//shortcut to redo 
            gui.edit.redo();
        }
    }

    //not released
    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
