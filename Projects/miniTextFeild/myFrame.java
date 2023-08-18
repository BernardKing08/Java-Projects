package Future_Githubb.miniTextFeild;

import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*; 

public class myFrame extends JFrame implements ActionListener{
    
    JButton button; 
    JTextArea textArea = new JTextArea(20, 25);
    JTextField textField = new JTextField(40); 
    
    myFrame(){
        //button component 
        button = new JButton("Submit"); 
        button.setSize(50,25);
        button.setFocusable(false);
        button.addActionListener(this);
        
        //JTextArea and JTextFeild 
        textArea.setEnabled(false);
        
        //Scroller component 
        JScrollPane scrollPane = new JScrollPane(textArea); 
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); 
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        //Panel component
        JPanel panel = new JPanel(); 
        panel.setSize(50, 75); 
        panel.add(button); 
        panel.add(textField); 
        JPanel panel2 = new JPanel(); 
        panel2.setSize(100, 200); 
        panel2.add(scrollPane);         

        //frame component 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(300, 300);
        this.getContentPane().add(panel, BorderLayout.NORTH);
        this.getContentPane().add(panel2, BorderLayout.CENTER);
        this.pack();
         
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        textArea.append(textField.getText() + "\n");
        textField.setText("");
    }

}


