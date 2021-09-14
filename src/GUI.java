/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author christinacheng
 */

    
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GUI{
    
    public JTextField rollResult;
    public Component[] components;
    public JButton rollButton;
    public JLabel currentPlayer;
    public JLabel player1Info;
    public JLabel player2Info;
    
    public JLabel propertyTitle;
    public JLabel rentCost;
    public JLabel rentWithColorSetCost;
    public JLabel oneHouseLabel;
    public JLabel twoHouseLabel;
    public JLabel threeHouseLabel;
    public JLabel fourHouseLabel;
    public JLabel hotelCost;
    public JLabel housePurchaseCost1;
    public JLabel housePurchaseCost2;
    public JLabel resaleValueLabel;
    
    public GUI(Property[] properties) throws FontFormatException, IOException {
        
        //Monopoly font
        File informationFont = new File("resources/Kabel-Heavy.ttf");
        Font font = Font.createFont(Font.TRUETYPE_FONT, informationFont);
        //different font sizes
        Font regularFont = font.deriveFont(9f);
        Font smallFont = font.deriveFont(6f);
        Font infoFont = font.deriveFont(15f);
        Font propertyFont = font.deriveFont(20f);
        Font hugeFont = font.deriveFont(50f);
        
        //set frame information
        JFrame frame = new JFrame("Monopoly");
        frame.setSize(800, 850);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Ends the program when window closed
        Container content = frame.getContentPane();
        
        //layout of the entire page is BorderLayout
        content.setLayout(new BorderLayout());
        //top panel is set to GridBagLayout
        JPanel topPanel = new JPanel();
        GridBagLayout gbag = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        topPanel.setLayout(gbag);
        //200px in height, stretches across the whole screen
        Dimension topSize = new Dimension (frame.getWidth(), 200);
        topPanel.setSize(topSize);
        //bottom panel is set to GridLayout
        JPanel bottomPanel = new JPanel();
        Dimension bottomSize = new Dimension (frame.getWidth(), frame.getHeight()-topSize.height);
        bottomPanel.setSize(bottomSize);
        bottomPanel.setLayout(new GridLayout(11, 11, 0, 0));
        
        //an array of components for every single slot in the grid layout
        //JButtons and JLabels
        components = new Component[121]; 
        //tracks position in the name array
        int nameTracker = 0;
        //iterate through the slots in the entire board
        for(int i = 0; i < components.length; i++){
            //if it is a slot that needs a property
            if(i<= 10 || i%11 == 0 || (i+1)%11 == 0 || i >= 110){
                //variables with info for this button
                Property thisProperty = properties[nameTracker];
                String currentName = properties[nameTracker].getName().toUpperCase();
                String current = "resources/images/" + currentName + ".jpg";
                ImageIcon icon = new ImageIcon(current);
                Image image = icon.getImage();  
                Image resizedImage = image.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
                icon = new ImageIcon(resizedImage);
                String titleOfProperty;
                JButton button;
                if (PropertyType.isOwnedProperty(thisProperty)){
                    OwnedProperty property = (OwnedProperty) (thisProperty);
                    titleOfProperty = currentName + " – $" + property.getPrice();
                } else if (PropertyType.isPayProperty(thisProperty)){
                    PayProperty property = (PayProperty) (thisProperty);
                    titleOfProperty = currentName + " - $" + property.getPriceToPay();
                } else {
                    titleOfProperty = currentName;
                }
                button = new JButton(titleOfProperty, icon);
                button.setBorder(BorderFactory.createLineBorder(properties[nameTracker].getColor(), 6));
                //button.setBackground(properties[nameTracker].getColor());
                button.setOpaque(true);
                 //set font size based on length of the text 
                if(button.getText().length() >= 11){
                    button.setFont(smallFont);
                } else {
                    button.setFont(regularFont);
                }
                //make all buttons centered and at the bottom of the button
                button.setVerticalTextPosition(SwingConstants.BOTTOM);
                button.setHorizontalTextPosition(SwingConstants.CENTER);
                components[i] = button;
                nameTracker++;
                //at "Priory Monopoly" to center of the game board
            } else if ((i > 56 && i< 65) || (i > 46 && i < 53)) {
                if (i == 47) components[i] = new JLabel("P");
                if (i == 48) components[i] = new JLabel("R");
                if (i == 49) components[i] = new JLabel("I");
                if (i == 50) components[i] = new JLabel("O");
                if (i == 51) components[i] = new JLabel("R");
                if (i == 52) components[i] = new JLabel("Y");
                
                if (i == 57) components[i] = new JLabel("M");
                if (i == 58) components[i] = new JLabel("O");
                if (i == 59) components[i] = new JLabel("N");
                if (i == 60) components[i] = new JLabel("O");
                if (i == 61) components[i] = new JLabel("P");
                if (i == 62) components[i] = new JLabel("O");
                if (i == 63) components[i] = new JLabel("L");
                if (i == 64) components[i] = new JLabel("Y");
                components[i].setFont(hugeFont);
            } else {
                components[i] = new JLabel("");
            }
            
        }
        
        //center the words within each slot 
        for (int i = 0; i<components.length; i++){
            if ((i > 56 && i< 65) || (i > 46 && i < 53)){
                bottomPanel.add(components[i], BorderLayout.CENTER);
            }
            bottomPanel.add(components[i]);
        }
        
         //make the information labels for the top panel
        ArrayList<Component> information = new ArrayList<Component>();
         
        //row 1 labels
        //SAMPLE CARD - no functionality yet
        JLabel propertyCardLabel = new JLabel ("PROPERTY CARD INFORMATION");
        propertyTitle = new JLabel ("SAMPLE CARD");
        rentCost = new JLabel ("RENT $14.");
        rentWithColorSetCost = new JLabel("RENT WITH COLOR SET $28.");
        oneHouseLabel = new JLabel ("With 1 House  $70.");
        twoHouseLabel = new JLabel ("With 2 Houses  $200.");
        threeHouseLabel = new JLabel ("With 3 Houses  $550.");
        fourHouseLabel = new JLabel ("With 4 Houses  $750.");
        hotelCost = new JLabel ("With HOTEL $950.");
        housePurchaseCost1 = new JLabel ("Houses cost $100. each");
        housePurchaseCost2 = new JLabel ("Hotels, $100. plus 4 houses ");
        resaleValueLabel = new JLabel("Resale value  $50.");
        
        /*
        //row 2
        JLabel upgradeError = new JLabel ("POTENTIAL ERROR MESSAGE");
        JButton upgrade = new JButton ("UPGRADE THIS PROPERTY");
        JLabel sellError = new JLabel ("POTENTIAL ERROR MESSAGE");
        JButton sell = new JButton ("SELL");
        */
        
        //row 3
        currentPlayer = new JLabel ("Current Player: Player 1");
        player1Info = new JLabel ("Player 1: $0");
        player1Info.setForeground(Color.CYAN);
        player2Info = new JLabel ("Player 2: $0");
        player2Info.setForeground(Color.PINK);
        rollButton = new JButton ("ROLL");
        JLabel rollLabel = new JLabel("Result:");
        
        //set button dimensions
        Dimension shortDim = new Dimension (100, 25);
        Dimension longDim = new Dimension (200, 25);
        //upgrade.setPreferredSize(longDim);
        rollButton.setPreferredSize(shortDim);
        //sell.setPreferredSize(shortDim);
        
        rollResult = new JTextField(5);
        rollResult.setEditable(false);
        
        /*
        By using a weightx of 1.0, the components divide the horizontal space.
        However, because weighty uses its default value of 0.0, 
        the components remain centered from top to bottom
        */
        gbc.weightx = 1.0;
        
        //set x and y positions constraints and add to ArrayList of JComponents
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipady = 5;
        gbag.setConstraints(propertyCardLabel, gbc);
        information.add(propertyCardLabel);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbag.setConstraints(propertyTitle, gbc);
        information.add(propertyTitle);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbag.setConstraints(rentCost, gbc);
        information.add(rentCost);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbag.setConstraints(rentWithColorSetCost, gbc);
        information.add(rentWithColorSetCost);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbag.setConstraints(oneHouseLabel, gbc);
        information.add(oneHouseLabel);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbag.setConstraints(twoHouseLabel, gbc);
        information.add(twoHouseLabel);
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbag.setConstraints(threeHouseLabel, gbc);
        information.add(threeHouseLabel);
        
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbag.setConstraints(fourHouseLabel, gbc);
        information.add(fourHouseLabel);
        
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbag.setConstraints(hotelCost, gbc);
        information.add(hotelCost);
        
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbag.setConstraints(housePurchaseCost1, gbc);
        information.add(housePurchaseCost1);
        
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbag.setConstraints(housePurchaseCost2, gbc);
        information.add(housePurchaseCost2);
        
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbag.setConstraints(resaleValueLabel, gbc);
        information.add(resaleValueLabel);
        
        /*
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbag.setConstraints(upgrade, gbc);
        information.add(upgrade);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbag.setConstraints(upgradeError, gbc);
        information.add(upgradeError);
        
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbag.setConstraints(sell, gbc);
        information.add(sell);
        
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbag.setConstraints(sellError, gbc);
        information.add(sellError);
        */
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbag.setConstraints(currentPlayer, gbc);
        information.add(currentPlayer);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbag.setConstraints(player1Info, gbc);
        information.add(player1Info);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbag.setConstraints(player2Info, gbc);
        information.add(player2Info);
        
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbag.setConstraints(rollButton, gbc);
        information.add(rollButton);
        
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbag.setConstraints(rollLabel, gbc);
        information.add(rollLabel);
        
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbag.setConstraints(rollResult, gbc);
        information.add(rollResult);
        
        
        /*the last lavel and the two check boxes use the remaining space.
        this allows the components to occupy all the remaining room in the row
        */
        gbc.gridwidth = GridBagConstraints.REMAINDER;
       
        
        //add everything to the content pane
        
        //set alignment of labels correct according to the Monopoly board layout
        propertyCardLabel.setHorizontalAlignment(SwingConstants.CENTER);
        propertyTitle.setHorizontalAlignment(SwingConstants.CENTER);
        rentCost.setHorizontalAlignment(SwingConstants.CENTER);
        rentWithColorSetCost.setHorizontalAlignment(SwingConstants.CENTER);
        oneHouseLabel.setHorizontalAlignment(SwingConstants.LEFT);
        twoHouseLabel.setHorizontalAlignment(SwingConstants.LEFT); 
        threeHouseLabel.setHorizontalAlignment(SwingConstants.LEFT);
        fourHouseLabel.setHorizontalAlignment(SwingConstants.LEFT);
        hotelCost.setHorizontalAlignment(SwingConstants.CENTER);
        housePurchaseCost1.setHorizontalAlignment(SwingConstants.CENTER);
        housePurchaseCost2.setHorizontalAlignment(SwingConstants.CENTER);
        
        //set font size
        for (Component item: information){
            if (item == propertyTitle){
                item.setFont(propertyFont);
            } else {
                item.setFont(infoFont);
            }
            //add label/button to the topPanel
            topPanel.add(item);
        }
        
        //add the top and bottom panels to the underlying window
        content.add(topPanel, BorderLayout.NORTH);
        content.add(bottomPanel, BorderLayout.CENTER);
        //make visible
        frame.setVisible(true);
    }
    
    //Christina
    //finds the location of the button of this property in the component arr, so text can be edited
    //order is not the same so the buttons could be arranged correctly and easily
    public int getComponentLocation(Property p){
        String name = p.getName();
        for (int i = 0; i<components.length; i++){
            try {
                //some objects in the array are buttons, some are labels, etc.
                //try and cast this object in the array to a JButton
                JButton thisBtn = (JButton) components[i];
                //if it works, check if its text contains the name of the property we are searching for
                //contains not equals because some of the text labels in the JButtons are formatted NAME – $PRICE
                if (thisBtn.getText().contains(name.toUpperCase())){
                    return i;
                }
            } catch (Exception e){
                //do nothing
            }
        }
        return -1;
    }
    
}

