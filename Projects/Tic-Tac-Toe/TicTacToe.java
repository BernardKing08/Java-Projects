package TicTacToe; 

import java.util.*;
import javax.swing.*; 
import java.awt.*;
import java.awt.event.*; 

public class TicTacToe implements ActionListener{
    
    //instance feilds 
    JFrame frame; 
    JButton[] button; 
    JPanel panel; 
    JPanel panel2;
    JLabel label; 
    Random random = new Random(); 

    boolean playerTurn; 
    
    //constructor method
    TicTacToe(){

        //label component
        label = new JLabel("TicTacToe"); 
        label.setFont(new Font("Courier", Font.BOLD,20));
        label.setForeground(Color.darkGray);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setSize(200, 600);

        //first panel label
        panel = new JPanel();
        panel.setBackground(Color.cyan); 
        panel.setLayout(new BorderLayout());
        panel.add(label);
        
        //second panel component
        panel2 = new JPanel(); 
        panel2.setLayout(new GridLayout(3, 3));
        addButtons(); 

        //frame component
        frame = new JFrame("Simple TicTacToe game");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 350);
        frame.add(panel, BorderLayout.NORTH);
        frame.add(panel2); 
        frame.setResizable(false);
        frame.setVisible(true);
        
        //to get the user turn
        userTurn();

    }

    //adding buttons to the GridPanel
    public void addButtons(){
        //creating JButton array
        button = new JButton[9];
    
        //button component
        for(int i = 0; i < 9; i++){
            button[i] = new JButton();
            button[i].setFocusable(false);
            button[i].setForeground(Color.cyan);
            button[i].setBackground(Color.BLACK);
            button[i].setFont(new Font("Monospaced", Font.BOLD,70));
            button[i].addActionListener(this);
            panel2.add(button[i]); 
        }
    }

    //to shuffle between the players 
    private void userTurn(){
        //to delay the main thread
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*makes random number between 0 
          and 1 to determine who goes first  */
        if(random.nextInt(2) == 0){
            playerTurn = true; 
            label.setText("X turn");
        }
        else {
            playerTurn = false; 
            label.setText("O turn");
        }
    }

    //to control the button interface
    @Override
    public void actionPerformed(ActionEvent e) {
        
        for(int i = 0; i < 9; i++){
            if(e.getSource() == button[i]){
                //to check the player turn and if the button is empty
                if(button[i].getText() == ""){
                    if(playerTurn){
                        button[i].setForeground(Color.RED);
                        button[i].setText("X");
                        label.setText("O turn");
                        playerTurn = false;
                        check(); 
                    }
                    else{
                        button[i].setForeground(Color.cyan);
                        button[i].setText("O"); 
                        label.setText("X turn");
                        playerTurn = true;
                        check();
                    }
                }
            }
        }
    }//end of method

    //to check if the user, either X or O makes a winning move 
    public void check(){
        //checking if X wins
        if(     (button[0].getText() == "X") && 
                (button[1].getText() == "X") &&
                (button[2].getText() == "X")){
                    xWins(0,1,2); 
        }
        if(     (button[3].getText() == "X") &&
                (button[4].getText() == "X") &&
                (button[5].getText() == "X")){
                    xWins(3,4,5); 
        }
        if(     (button[6].getText() == "X") &&    
                (button[7].getText() == "X") && 
                (button[8].getText() == "X")){
                    xWins(6,7,8); 
        }
        if(     (button[1].getText() == "X") &&    
                (button[4].getText() == "X") && 
                (button[7].getText() == "X")){
                    xWins(1,4,7);
        } 
        if(     (button[2].getText() == "X") &&    
                (button[5].getText() == "X") && 
                (button[8].getText() == "X")){
                    xWins(2,5,8);
        } 
        if(     (button[0].getText() == "X") &&    
                (button[4].getText() == "X") && 
                (button[8].getText() == "X")){
                    xWins(0,4,8);
        } 
        if(     (button[2].getText() == "X") &&    
                (button[4].getText() == "X") && 
                (button[6].getText() == "X")){
                    xWins(2,4,6);
        } 

        //checking winning condition for 'O'
        if(     (button[0].getText() == "O") && 
                (button[1].getText() == "O") &&
                (button[2].getText() == "O")){
                    OWins(0,1,2); 
        }
        if(     (button[3].getText() == "O") &&
                (button[4].getText() == "O") &&
                (button[5].getText() == "O")){
                    OWins(3,4,5); 
        }
        if(     (button[6].getText() == "O") &&    
                (button[7].getText() == "O") && 
                (button[8].getText() == "O")){
                    OWins(6,7,8); 
        }
        if(     (button[1].getText() == "O") &&    
                (button[4].getText() == "O") && 
                (button[7].getText() == "O")){
                    OWins(1,4,7);
        } 
        if(     (button[2].getText() == "O") &&    
                (button[5].getText() == "O") && 
                (button[8].getText() == "O")){
                    OWins(2,5,8);
        } 
        if(     (button[0].getText() == "O") &&    
                (button[4].getText() == "O") && 
                (button[8].getText() == "O")){
                    OWins(0,4,8);
        } 
        if(     (button[2].getText() == "O") &&    
                (button[4].getText() == "O") && 
                (button[6].getText() == "O")){
                    OWins(2,4,6);
        } 

    }

    public void xWins(int num, int num2, int num3){
        button[num].setBackground(Color.green);
        button[num2].setBackground(Color.green);
        button[num3].setBackground(Color.green);

        //to disable the buttons 
        for(JButton butt : button){
            butt.setEnabled(false);
        }

        label.setText("X wins");
    }

    public void OWins(int num, int num2, int num3){
        button[num].setBackground(Color.green);
        button[num2].setBackground(Color.green);
        button[num3].setBackground(Color.green);

        for(JButton butt : button){
            butt.setEnabled(false);
        }

        label.setText("O wins");
    }


}//end of class