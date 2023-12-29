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

    //to check if the user makes a winning move 
    public void check(){
        //work in progress
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
                    }
                }
            }
        }
    }//end of method

}//end of class