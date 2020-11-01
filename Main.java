import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  
  
  JLabel guessLabel; 

  JTextField userGuess;

  JButton submitButton;
  JButton newNumButton;

  JLabel resultGuess;
  
  JPanel mainPanel;



  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);

     // initialize the main panel 
     mainPanel = new JPanel();
     // turn on the manual layouts 
     mainPanel.setLayout(null);

    // initialize the first label 
    guessLabel = new JLabel("Guess the number between 0 and 100:");
    // set bounds for the first label 
    guessLabel.setBounds(200,200,300,30);
    
    // initialize the text field 
    userGuess = new JTextField();
    // set bounds for the text field 
    userGuess.setBounds(200,230,280,20);

    // initialize the submit button 
    submitButton = new JButton("Submit");
    // set bounds for the submit button 
    submitButton.setBounds(200,260,100,20);
   
    
    // initialize the new number button
    newNumButton = new JButton("New Number");
    //  set bounds for the new number button 
    newNumButton.setBounds(310,260,170,20);
    
    // initialize the label 
    resultGuess = new JLabel();
    // set bounds for the label
    resultGuess.setBounds(200,290,300,30);

    // set the action command so we know which button was pressed 
    submitButton.setActionCommand("Submit");
    newNumButton.setActionCommand("New Number");

   // add the action ActionListener
   submitButton.addActionListener(this);
   newNumButton.addActionListener(this);
   
   

    // add the label to the main panel
    mainPanel.add(guessLabel);
    
    // add the text field to the main panel 
    mainPanel.add(userGuess);

    // add the buttons to the main panel
    mainPanel.add(submitButton);
    mainPanel.add(newNumButton);

    // add the last label to the main panel 
    mainPanel.add(resultGuess);


    

    // add the main panel to the frame 
    frame.add(mainPanel);

 
    

  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

     // get the number that the user entered
     String guessNum = userGuess.getText();
     
     // convert the strings into integers
     int numberGuess = Integer.parseInt(guessNum);
     // genereate a random number between 1 to 100
      int randomNumber = (int)(Math.random()*(100 - 1 + 1 ) + 1);
      
      // if statement to see if submit button was pressed
       if(command.equals("Submit")){
        // submit button was pressed 
      // if and else if statements to see if the guessed number is bigger, smaller than the random number or if its the same
       if( numberGuess == randomNumber){
         // print it out in the label 
        resultGuess.setText("Your guess of " + numberGuess + " is correct!");

      }else if ( numberGuess < randomNumber && numberGuess != randomNumber ){
        // print it out in the label
        resultGuess.setText("Your guess of " + numberGuess + " is too low!");

      }else if ( numberGuess > randomNumber && numberGuess != randomNumber){
        // print it out in the label
        resultGuess.setText("Your guess of " + numberGuess + " is correct!");

      }
      }else if (command.equals("New Number")){
        // new number button was pressed
        // change the random number to a new number
         randomNumber = (int)(Math.random()*(100 - 1 + 1 ) + 1);
       }
      
      


      

     

  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
