//Danny Hernandez
//Assignment 12
//CPSC 155
//Dec 1, 2023

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class TheFrame extends JFrame {


    private Container myPane; 
    private JLabel nm;
    private JLabel hometown;
    private JLabel numCones;
    private JTextField conesField;
    private JCheckBox waffleConesCheckBox;
    private JCheckBox doubleScoopsCheckBox;
    private JLabel lbsChoco;
    private JLabel chocoAmount;
    private JButton chocoButton;
    private JButton costButton;
    
    private waffleCheckHandler wHandler;
    private changeButtonHandler cHandler;
    private costButtonHandler mHandler; 
    private DoubleScoopCheckHandler dHandler;
    
public TheFrame(){
	
// Set up the title
    setTitle("Danny's Candy Company");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//FirstRow - Name & HomeTown  
    nm = new JLabel("Chocolates & Ice Cream");
    nm.setFont(new Font("Arial", Font.BOLD, 20));
    nm.setBackground(Color.GREEN);
    nm.setHorizontalAlignment(SwingConstants.CENTER);
    nm.setOpaque(true);
    
   
    hometown = new JLabel("Chicago, IL/Morelia, México");
    hometown.setFont(new Font("Arial", Font.BOLD, 20));
    hometown.setBackground(Color.GREEN);
    hometown.setOpaque(true);
    hometown.setHorizontalAlignment(SwingConstants.CENTER);
    
//SecondRow - Cones
    numCones = new JLabel("Number of Cones");
    numCones.setFont(new Font("Arial", Font.PLAIN, 16));
    numCones.setHorizontalAlignment(SwingConstants.RIGHT);
    numCones.setHorizontalAlignment(SwingConstants.CENTER);
    numCones.setBackground(Color.GREEN);
    numCones.setOpaque(true);
    

    conesField = new JTextField ("1");

    
//ThirdRow - WaffleCones & DoubleScoop
    waffleConesCheckBox = new JCheckBox("Waffle Cones");
    waffleConesCheckBox. setFont(new Font("Arial", Font.PLAIN, 16));
    waffleConesCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
    wHandler = new waffleCheckHandler();
    waffleConesCheckBox.addItemListener(wHandler);
    waffleConesCheckBox.setBackground(Color.GRAY);
    waffleConesCheckBox.setForeground(Color.WHITE);
    waffleConesCheckBox.setOpaque(true);
  
   
    
    doubleScoopsCheckBox = new JCheckBox("Double Scoops");
    doubleScoopsCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
    doubleScoopsCheckBox.setFont(new Font("Arial", Font.PLAIN, 16));
    dHandler = new DoubleScoopCheckHandler();
    doubleScoopsCheckBox.addItemListener(dHandler);
	 
//FourthRow - Pounds of Chocolate
    lbsChoco = new JLabel("Pounds of Chocolate: ");
    lbsChoco. setFont(new Font("Arial", Font.PLAIN, 16));
    lbsChoco.setBackground(Color.red);
    lbsChoco.setOpaque(true);
    lbsChoco.setHorizontalAlignment(SwingConstants.RIGHT);
    
    chocoAmount = new JLabel("1");
    lbsChoco.setHorizontalAlignment(SwingConstants.LEFT);
    chocoAmount.setOpaque(true);
    chocoAmount.setBackground(Color.RED);
    
//FifthRow - Change & Cost
    chocoButton = new JButton("Change Chocolate");
    chocoButton.setFont(new Font("Arial", Font.PLAIN, 16));
    cHandler = new changeButtonHandler();
    chocoButton.addActionListener(cHandler);
    chocoButton.setBackground(Color.red);
    
    costButton = new JButton("Calculate Cost");
    costButton.setFont(new Font("Arial", Font.PLAIN, 16));
    mHandler = new costButtonHandler();
    costButton.addActionListener(mHandler);
    costButton.setHorizontalAlignment(SwingConstants.RIGHT);
    
//My Pane
    this.setSize(550,300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    myPane = this.getContentPane();
    myPane.setLayout(new GridLayout(5, 2));
    myPane.add(nm);
    myPane.add(hometown);
    myPane.add(numCones);
    myPane.add(conesField);
    myPane.add(waffleConesCheckBox);
    myPane.add(doubleScoopsCheckBox);
    myPane.add(lbsChoco);
    myPane.add(chocoAmount);
    myPane.add(chocoButton);
    myPane.add(costButton);
    
    this.setVisible(true);
}
 //-----------------------------------------------------------------       
private class waffleCheckHandler implements ItemListener
  {
	 public void itemStateChanged(ItemEvent e)
	 {
		 if (waffleConesCheckBox.isSelected()) 
		 {
             waffleConesCheckBox.setForeground(Color.GREEN);
             waffleConesCheckBox.setFont(new Font("Arial",Font.ITALIC, 16));
         } 
		 else
		 {
			 waffleConesCheckBox.setForeground(Color.WHITE);
			 waffleConesCheckBox.setFont(new Font("Arial",Font.PLAIN, 16));
		 }
     }
               
 }
//----------------------------------------------------------------- 
private class DoubleScoopCheckHandler implements ItemListener
{
	public void itemStateChanged(ItemEvent e)
	{
		
	}
}
 //-----------------------------------------------------------------
private class changeButtonHandler implements ActionListener
{
	 public void actionPerformed(ActionEvent e)
	 {
		 String numChoco;
		 numChoco = JOptionPane.showInputDialog(null, "How much chocolate(lbs) do you want to buy? ");
		 chocoAmount.setText(numChoco);
     }
}
 
//----------------------------------------------------------------- 
private class costButtonHandler implements ActionListener
{
	final  float CHOCO = 8.95f;
	final float S_SCOOP = 2.25f;
	final float D_SCOOP = 3.25f;
	final float WAFFLE_CONE = 1.25f;
	
	 public void actionPerformed(ActionEvent e)
	 {
		 int numCones = Integer.parseInt(conesField.getText());
         double chocolatePounds = Double.parseDouble(chocoAmount.getText());

         double iceCreamCost = 0;
         if (doubleScoopsCheckBox.isSelected() && waffleConesCheckBox.isSelected()) 
         {
             iceCreamCost = (numCones * D_SCOOP) + (numCones * WAFFLE_CONE);
         } else 
         {
             iceCreamCost = numCones * S_SCOOP;
         }

         if (waffleConesCheckBox.isSelected() && !doubleScoopsCheckBox.isSelected())
         {
             iceCreamCost += numCones * WAFFLE_CONE;
         }
         else if (!waffleConesCheckBox.isSelected() && doubleScoopsCheckBox.isSelected() )
         {
        	 iceCreamCost += numCones * D_SCOOP;
         }

         double totalChocolateCost = chocolatePounds * CHOCO;
         double totalCost = iceCreamCost + totalChocolateCost;

         JOptionPane.showMessageDialog(null, String.format("Danny's Candy Company%n" + "Cost of Chocolates & Ice Cream%n%n"
        	        + "Chocolate Cost : $%.2f%n Ice Cream Cost : $%.2f%n Total Cost : $%.2f%n%n" + "Thank you for shopping with us! ", totalChocolateCost, iceCreamCost, totalCost));

 		
      
	 }
 }
//----------------------------------------------------------------- 

}



 