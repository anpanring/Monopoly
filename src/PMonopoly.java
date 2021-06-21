import java.awt.Color;
import java.awt.Component;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;

/*
HIERARCHY OF PROPERTIES
Property
[Wes, Mr. Morris, Senior Parking, Lunch, Break, New School Day, Community Chest]
    Pay Property
    [Properties where the user has to pay a fee]
    Owned Property 
    [properties that you can own - true "properties"]
        Sports
        [Sports]
        Regular Property
        [Classrooms]
 */

public class PMonopoly implements ActionListener{
    //array list of the properties in order according to the board
    private Property[] propertyOrder;
    //array list of properties formatted for the GUI class to interpret
    //begin from the top left corner and tranverse the rows
    private Property[] propertiesForGUI; 
    //list of names only
    private ArrayList<String> propertyNames;
    private final int OUT_OF_JAIL = -50;
    private int potOfMoney;
    private Player player1;
    private Player player2;
    //if all the community chest cards are used, you need to save all the community chest cards in order to reintroduce them into the deck
    private final ArrayList<String> allCommunityChestCards;
    private ArrayList<String> communityChestDeck;
    private GUI gui;
    private Player currentPlayer;
    
    //Christina
    public PMonopoly() throws FontFormatException, IOException{
        potOfMoney = 0;
        player1 = new Player("", 1500, new ArrayList<OwnedProperty>(), Color.CYAN);
        player2 = new Player("", 1500, new ArrayList<OwnedProperty>(), new Color(255, 0, 239));
        
        //colors to use
        Color myRed = new Color(0xEB1A22);
        Color myYellow = new Color(0xFDF100);
        Color myOrange = new Color(0xF7941C);
        Color myGreen = new Color(0x20B259);
        Color myPink = new Color(0xD93A97);
        Color myBlue = new Color(0x0072BE);
        Color myLightBlue = new Color(0xAFE2FF);
        Color myBrown = new Color(0x955539);
        
        //creating all the properties according to the title deeds
        Property newSchoolDay = new Property("New School Day", Color.gray);  
        Property neale = new RegularProperty("Neale", null, 60, 2, 4, 10, 30, 90, 160, 250, 50, myBrown);
        Property communityChest1 = new Property("Community Chest 1", Color.gray);
        Property cohen = new RegularProperty("Cohen", null, 60, 4, 8, 20, 60, 180, 320, 450, 50, myBrown);
        Property pantherShack = new PayProperty("Panther Shack", 200, Color.gray);
        Property gym = new SportsProperty("Gym", null, 200, 25, 50, 100, 200, Color.gray);
        Property dubose = new RegularProperty("DuBose", null, 100, 6, 12, 30, 90, 270, 400, 550, 50, myLightBlue);
        Property communityChest2 = new Property("Community Chest 2", Color.gray);
        Property drO = new RegularProperty("Dr. O", null, 100, 6, 12, 30, 90, 270, 400, 550, 50, myLightBlue);
        Property carroll = new RegularProperty("Carroll", null, 120, 8, 16, 40, 100, 300, 450, 600, 50, myLightBlue);
        Property mrMorris = new Property("Mr. Morris", Color.gray);
        Property briggs = new RegularProperty("Briggs", null, 140, 12, 24, 60, 180, 500, 700, 900, 100, myPink);
        Property payTuition = new PayProperty("Pay Tuition", 150, Color.gray);
        Property payne = new RegularProperty("Payne", null, 140, 10, 20, 50, 150, 450, 625, 750, 100, myPink);
        Property hatzopoulos = new RegularProperty("Hatzopoulos", null, 160, 10, 20, 50, 150, 450, 625, 750, 100, myPink);
        Property field = new SportsProperty("Field", null, 200, 25, 50, 100, 200, Color.gray);
        Property paige = new RegularProperty("Paige", null, 180, 14, 28, 70, 200, 550, 750, 950, 100, myOrange);
        Property communityChest3 = new Property("Community Chest 3", Color.gray);
        Property robotics = new RegularProperty("Robotics", null, 180, 14, 28, 70, 200, 550, 750, 950, 100, myOrange);
        Property hemiup = new RegularProperty("Hemiup", null, 200, 16, 32, 80, 220, 600, 800, 1000, 100, myOrange);
        Property seniorParking = new Property("Senior Parking", Color.gray);
        Property mui = new RegularProperty("Miu", null, 220, 18, 36, 90, 250, 700, 875, 1050, 150, myRed);
        Property communityChest4 = new Property("Community Chest 4", Color.gray);
        Property faisal = new RegularProperty("Faisal", null, 220, 20, 40, 100, 300, 750, 225, 100, 150, myRed);
        Property lee = new RegularProperty("Lee", null, 240, 18, 36, 90, 250, 700, 875, 1050, 150, myRed);
        Property pool = new SportsProperty ("Pool", null, 200, 25, 50, 100, 200, Color.gray);
        Property bessin = new RegularProperty("Bessin", null, 260, 22, 44, 110, 330, 800, 975, 1150, 150, myYellow);
        Property trudelle = new RegularProperty("Trudelle", null, 260, 22, 44, 110, 330, 800, 975, 1150, 150, myYellow);
        Property payForDance = new PayProperty("Pay for Dance", 150, Color.gray);
        Property parker = new RegularProperty("Parker", null, 280, 24, 48, 120, 360, 850, 1025, 1200, 150, myYellow);
        Property wes = new Property("Wes", Color.gray);
        Property studentCenter = new RegularProperty("Student Center", null, 300, 28, 56, 150, 450, 1000, 1200, 1400, 200, myGreen);
        Property garden = new RegularProperty("Garden", null, 300, 26, 52, 130, 390, 900, 1100, 1275, 200, myGreen);
        Property communityChest5 = new Property("Community Chest 5", Color.gray);
        Property cafeteria = new RegularProperty("Cafeteria", null, 320, 26, 52, 130, 390, 900, 1100, 1275, 200, myGreen);
        Property tennisCourt = new SportsProperty("Tennis Court", null, 200, 25, 50, 100, 200, Color.gray);
        Property communityChest6 = new Property("Community Chest 6", Color.gray);
        Property foundersHall = new RegularProperty("Founders Hall", null, 350, 35, 70, 175, 500, 1100, 1300, 1500, 200, myBlue);
        Property payForPlayTickets = new PayProperty("Pay for Play Tickets", 100, Color.gray);
        Property monastery = new RegularProperty("Monastery", null, 400, 50, 100, 200, 600, 1400, 1700, 2000, 200, myBlue);
        //order in which the players are supposed to travel across the properties
        propertyOrder = new Property[]{newSchoolDay, communityChest1, neale, cohen, pantherShack, gym, dubose, communityChest2, 
            drO, carroll, mrMorris, briggs, payTuition, payne, hatzopoulos, field, paige, communityChest3, robotics, 
            hemiup, seniorParking, mui, communityChest4, faisal, lee, pool, bessin, trudelle, payForDance, parker,
            wes, studentCenter, garden, communityChest5, cafeteria, tennisCourt, communityChest6, foundersHall, 
            payForPlayTickets, monastery};
        //properties arranged in order from top -> bottom, left -> right for GUI
        propertiesForGUI = new Property[]{seniorParking, mui, communityChest4, faisal, lee, pool, bessin, trudelle, payForDance, parker,
            wes, hemiup, studentCenter, robotics, garden, communityChest3, communityChest5, paige, cafeteria, field, 
            tennisCourt, hatzopoulos, communityChest6, payne, foundersHall, payTuition, payForPlayTickets, briggs, monastery,
            mrMorris, carroll, drO, communityChest2, dubose, gym, pantherShack, cohen, communityChest1, neale, newSchoolDay};
        propertyNames = new ArrayList<String>();
        for (Property p:propertyOrder){
            if (PropertyType.isOwnedProperty(p)){
                propertyNames.add(p.getName().toUpperCase());
            }
        }
        System.out.println(propertyNames);
        gui = new GUI(propertiesForGUI);
        //action listener must be added to this class not GUI because when roll is pressed, PMonopoly must be notified
        gui.rollButton.addActionListener(this);
        for(Component c:gui.components){
            try{
                JButton button = (JButton)(c);
                button.addActionListener(this);
            }catch (Exception e){
                //do nothing
            }
        }
        //first player to start is player1
        currentPlayer = player1;
        //create the community chest card options
        allCommunityChestCards = new ArrayList<String>();
        allCommunityChestCards.add("You are assessed for street repairs: pay 40 per house and 115 per hotel you own");
        allCommunityChestCards.add("From sale of stock, you get 50");
        allCommunityChestCards.add("Advance to go. Collect 200");
        allCommunityChestCards.add("Doctor’s fees, pay 50");
        allCommunityChestCards.add("Holiday fund matures, receive 100");
        allCommunityChestCards.add("Life insurance matures, collect 100");
        allCommunityChestCards.add("Go on a field trip, pay 50");
        allCommunityChestCards.add("Income tax refund, collect 20");
        allCommunityChestCards.add("Go Directly to Jail. Do not pass GO. Do not collect 200");
        allCommunityChestCards.add("Hospital fees, pay 100");
        allCommunityChestCards.add("Traffic ticket, pay 100");
        //make deck filled with all the card options (full deck)
        communityChestDeck = allCommunityChestCards;
        for(Property p:propertyOrder){
            if(PropertyType.isRegularProperty(p)){
                RegularProperty r = (RegularProperty) p;
                System.out.println(r.getName() + " " + r.getHouseCost());
            }
        }
    }
    
    public void run(){
        playerSetup(player1);
        playerSetup(player2);
    }
    
    //Jack
    public void playerSetup(Player p){
        //create a pop-up window and ask for the person's name, and update that name in the logistics info and player class
        JTextArea textArea = new JTextArea();
        textArea.setEditable(true);
       	JTextField textField1 = new JTextField();
        textField1.requestFocus();
        textArea.requestFocusInWindow();
        //ask for name
        JOptionPane.showMessageDialog(null, textField1, "What is your name?", JOptionPane.PLAIN_MESSAGE);
        String name = textField1.getText();
        //while the name is not entered, keep asking
        while(name == null || name.equals("")){
            JOptionPane.showMessageDialog(null, textField1, "What is your name?", JOptionPane.PLAIN_MESSAGE);
            name = textField1.getText();
        }
        //update classes and logistics accordingly
        if(p.equals(player1)){
            System.out.println("here");
            gui.player1Info.setText(name + ": $" + player1.getBalance());
            gui.player1Info.setForeground(player1.getColor());
            player1.setName(name);
            gui.currentPlayer.setText("Current Player: " + player1.getName());
        } else {
            gui.player2Info.setText(name + ": $" + player2.getBalance());
            gui.player2Info.setForeground(player2.getColor());
            player2.setName(name);
        }

    }
    //Ryan
    public int roll2Dice(){
        int die1 = (int) (Math.random()*6) + 1;
        int die2 = (int) (Math.random()*6) + 1;
        return die1 + die2;
    }
    
    //Jack and Christina
    public boolean isPassGO(int oldPos, int newPos){
        //if you are moving from Wes (GO TO JAIL) to Mr. Morris (JAIL), you don't receive the $200
        if(oldPos == 30 && newPos == 10){
            return false;
        //if the new position spot is less than the old position spot, then you have went past go
        } else if (oldPos > newPos){
            return true;
        } else {
            return false;
        }
    }
    
    //Jack and Christina
    public boolean isLandOnTax(Player a){
        //find player a's position
        int currentPos = a.getPosition();
        //check if the property in that position is a payproperty
        if(PropertyType.isPayProperty(propertyOrder[currentPos])){
            return true;
        }
        return false;
        //use PropertyType.isPayProperty() to determine if it is a property that needs to be paid
    }

    //Ryan and Christina
    public void payTax(Player a, PayProperty p){
        //get tax amount
        int tax = p.getPriceToPay(); 
        //deduct from player
        a.updateBalance(-tax);
        //add to potMoney
        potOfMoney =+ tax;
    }
    
    //Christina
    public int findPos(Property p){
        for (int i = 0; i < propertyOrder.length; i++){
            if (propertyOrder[i].equals(p)){
                return i;
            }
        }
        return -1;
         
    }
    
    //Ryan
    public void goToJail(Player a){ 
        //call makeMove() with the destination the jail property position
        a.setJailInfo(true);
        int jailPos = 10;
        makeMove(a, jailPos);
    }
    
    //Ryan
    public boolean isOnFreeParking(Player a){
        //check position of player
        int parkingPos = 20;
        if (a.getPosition() == parkingPos){
            return true;
        }
        return false;
    }
    
    //Jack and Christina
    public void makeMove(Player p, int destination){
        //the button that the player is currently on
        //property[p.getPosition] = current property
        //getComponentLocation -> returns that property's button representation in the component arr (different order)
        //gui.components[####] -> access that JButton that represents the property
        int oldPos = p.getPosition();
        JButton oldBtn = (JButton) gui.components[gui.getComponentLocation(propertyOrder[p.getPosition()])];
        //set the text color to black
        oldBtn.setForeground(Color.black);
        //find the property object at the desired destination
        Property nextDestination = propertyOrder[destination]; 
        //update player's position to destination
        p.setPosition(destination);
        //access the button representation
        JButton thisBtn = (JButton) gui.components[gui.getComponentLocation(nextDestination)];
        //set color to the player's identifying color
        thisBtn.setForeground(p.getColor());
        if(isPassGO(oldPos, p.getPosition())){
            System.out.println("recognized");
            p.updateBalance(200);
        }
    }
    
    //Christina
    public int findNewPosition(int currentPos, int moveAmt){
        //this method checks if currentPos + newPos exceeds 39, which means the new position is back at the beginning of the board/array
        if ((currentPos + moveAmt) > 39){
            return currentPos - 40 + moveAmt;
        }
        //if not, just add them together
        return currentPos + moveAmt;
    }
    
    //Jack and Christina
    //standard move = move player based on the dice roll
    public void makeStandardMove(Player p){
        //get position of player
        int pos = p.getPosition();
        //get dice result
        int diceResult = Integer.parseInt(gui.rollResult.getText());
        //find the new position based on the dice result
        int newPos = findNewPosition(pos, diceResult);
        // makeMove with correct destination 
        makeMove(p, newPos);
    }
    
    //Christina
    public void switchPlayers(){
        //switch
        if(currentPlayer.equals(player1)){
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
        gui.currentPlayer.setText("Current Player: " + currentPlayer.getName());
        //if they have to pay to get out of jail, they cannot roll the dice and must pay a $50 fee
        if(currentPlayer.getJailInfo() == true){
            String[] opts = new String[]{"PAY"};
            int clicked = JOptionPane.showOptionDialog(null, "You are in jail and must pay a $50 fee.", "NOTIFICATION", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opts, opts[0]);
            currentPlayer.updateBalance(OUT_OF_JAIL);
            updatePlayerInfo();
            //marks that they paid jail fee
            currentPlayer.setJailInfo(false);
            switchPlayers();
        }
    }
    
    //Christina
    //called when actionPerformed is called and decides which functions to call afterwards
    public void buttonClicked(String actionCommand){
        System.out.println("actionCommand" + actionCommand);
        //actionCommand is often the title of the button, which includes the price of the property
        //need to get the name only -> trim and remove the price info
        String nameOnly = Helper.trimToName(actionCommand);
        System.out.println("nameOnly" + nameOnly);
        //if the roll button was clicked, the player landed on a property, and has to present options for the player to decide on
        if(actionCommand.equals("ROLL")){
            diceWasRolled();
            //CHECK IF PRICE == 0
        //propertyNames only contains the names of OwnedProperty objects
        //if this property clicked is an OwnedProperty, we can display the title deed in the logistics bar
        } else if(propertyNames.contains(nameOnly)){
            System.out.println("entered");
            validPropertyWasClicked(nameOnly);
        }
    }
    
    //Everyone
    public void diceWasRolled(){
        //show result of 2 dices rolling
        gui.rollResult.setText("" + roll2Dice());
        //show to move on the GUI/board
        makeStandardMove(currentPlayer);
        //get the property the player has landed on
        Property thisProperty = propertyOrder[currentPlayer.getPosition()];
        //if this property is an OwnedProperty, display title deed in logistics
        if(PropertyType.isOwnedProperty(thisProperty)){
            validPropertyWasClicked(thisProperty.getName().toUpperCase());
        }
        JTextArea textArea = new JTextArea();
        textArea.setEditable(true);
        textArea.requestFocusInWindow();
        //PROMPT is the message to display in the pop-up window
        //notifies the player on the property they landed
        String prompt = "You have landed on the " + Helper.trimToName(thisProperty.getName()).toUpperCase() + " property\n";
        ArrayList<String> options = new ArrayList<String>();
        
        //IF THE PROPERTY THAT WAS LANDED ON WAS A REGULAR PROPERTY
        if(PropertyType.isRegularProperty(thisProperty)){
            //cast to a RegularProperty so it can be used as such
            RegularProperty rP = (RegularProperty) thisProperty;
            //IF NO ONE OWNS THE PROPERTY
            if(rP.getOwner() == null){
                //if they can afford to purchase the property
                if(currentPlayer.getBalance() >= rP.getPrice()){
                    //they can buy the property
                    options.add("BUY");
                    //or decline to buy the property
                    options.add("EXIT");
                //if they can't afford to purchase the property
                } else {
                    //notify them
                    prompt += "This property is available for sale, but you don't have enough money to buy it.";
                    //they cannot do anything, must click exit
                    options.add("EXIT");
                }
            //IF THE PLAYER OWNS THE PROPERTY
            } else if (rP.getOwner() == currentPlayer){
                System.out.println("AT THE UPGRADE JUNCTION");
                System.out.println("state " + rP.getState());
                System.out.println("balance of current " + currentPlayer.getBalance());
                System.out.println("house cost " + rP.getHouseCost());
                //they can do nothing, sell the property, or upgrade
                options.add("EXIT");
                options.add("SELL TO BANK");
                //they can only upgrade if they have a monopoly on the color set
                if(Helper.hasMonopoly(currentPlayer, propertyOrder)){
                    //they almost must have enough money to upgrade (house cost) and not be on the final stage of upgrading (hotel)
                    //if so, notify through the prompt
                    if(rP.getState() == 6){
                        prompt += "You cannot upgrade this property because you have upgraded it as much as possible.";
                    } else if (currentPlayer.getBalance() < rP.getHouseCost()){
                        prompt += "This property is available for upgrade, but you don't have enough money to purchase an upgrade.";
                    //if conditions are met, they can upgrade the property
                    } else {
                        options.add("UPGRADE");
                    }
                }
            //IF THE OTHER PLAYER OWNS THE PROPERTY
            } else {
                //if they can afford to pay for rent
                //dependent on if the player has a Monopoly bc then they have to pay color set rent
                //if not, find the appropriate rent cost based on the upgrade status
                if(currentPlayer.getBalance() >= rP.getCurrentRentCost(Helper.hasMonopoly(getOtherPlayer(), propertyOrder))){
                    options.add("PAY RENT"); 
                //can't pay rent = game over
                } else {
                    prompt += "You don't have enough money to pay for rent.";
                    options.add("LEAVE");
                }
            }
        
        //IF THE PROPERTY THAT WAS LANDED ON WAS A SPORTS PROPERTY
        } else if (PropertyType.isSportsProperty(thisProperty)){
            //cast to SportsProperty
            SportsProperty sP = (SportsProperty) thisProperty;
            //if no one owns the property
            if (sP.getOwner() == null){
                //if they can afford to purchase
                if(currentPlayer.getBalance() >= sP.getPrice()){
                    //options are to buy the property or decline
                    options.add("BUY");
                    options.add("EXIT");
                //if they can't afford it
                } else {
                    //notify
                    prompt += "This property is available for sale, but you don't have enough money to buy it.";
                    //only option is to exit the pop up window
                    options.add("EXIT");
                }
            //if they own the property
            } else if (sP.getOwner() == currentPlayer){
                    //sell, do nothing
                    options.add("EXIT");
                    options.add("SELL TO BANK");
            //if the other player owns the property
            //sP.getOwner() != currentPlayer
            } else {
                //if they can afford rent, they must pay rent
                if(currentPlayer.getBalance() >= Helper.numSportsPropertiesOwned(getOtherPlayer(), propertyOrder)*25){
                    options.add("PAY RENT");
                //if not = game over
                } else {
                    //notify
                    prompt += "You don't have enough money to pay for rent.";
                    //JOptionPane.showMessageDialog(null, secondTF, "You don't have enough money to pay for rent.", JOptionPane.PLAIN_MESSAGE);
                    options.add("LEAVE");
                }
            } 
            
        //IF THE PROPERTY IS A TAX/PAYPROPERTY
        } else if (isLandOnTax(currentPlayer)){
            //cast to a PayProperty
            PayProperty pP = (PayProperty) thisProperty;
            //if they can afford to pay the tax
            if(currentPlayer.getBalance() >= pP.getPriceToPay()){
                //must pay fee
                options.add("PAY FEE");
            //can't afford to pay:
            //currentPlayer.getBalance() < pP.getPriceToPay()
            } else {
                //notify + game over
                prompt += "You don't have enough money to pay this fee.";
                options.add("LEAVE");
            }
            
        //AT THIS POINT, MUST BE A "PROPERTY" 
        } else {
            //get name
            String pName = thisProperty.getName().toUpperCase();
            if(pName.equals("New School Day".toUpperCase())){
                options.add("OK");
            } else if(pName.equals("Mr. Morris".toUpperCase())){
                prompt += "Don't worry, you are just visiting!";
                options.add("OK");
            //pName.equals("Senior Parking".toUpperCase())
            } else if (isOnFreeParking(currentPlayer)){
                //if there is money in the pot, they can receive it
                if(potOfMoney > 0){
                    prompt += "Congratulations, you will receive the money from fees - $" + potOfMoney + ".";
                    //JOptionPane.showMessageDialog(null, secondTF, "Congratulations, you will receive the money from fees - $" + potOfMoney + ".", JOptionPane.PLAIN_MESSAGE);
                    options.add("ACCEPT MONEY");
                //if there is money in the pot, tell them the situation
                } else {
                    prompt += "You are eligible to receive money from fees, but there currently is none. ";
                    //JOptionPane.showMessageDialog(null, secondTF, "You are eligible to receive money from fees, but there currently is none. ", JOptionPane.PLAIN_MESSAGE);
                    options.add("OK");
                }
            //wes = go to jail
            } else if (pName.equals("Wes".toUpperCase())){
                prompt += "Wes has sent you to Mr. Morris (jail)";
                //JOptionPane.showMessageDialog(null, secondTF, "Wes has sent you to Mr. Morris (jail)", JOptionPane.PLAIN_MESSAGE);
                options.add("GO TO JAIL");
            } else if (pName.contains("Community Chest".toUpperCase())){
                prompt += "You landed on community chest!";
                options.add("SEE CARD");
            }
        }
        //copy ArrayList of options into an array, which is needed for the correct formatting of the pop up window
        String[] optionList = new String[options.size()];
        for(int i = 0; i<options.size(); i++){
            optionList[i] = options.get(i);
        }
        
        //SCENARIO HAS BEEN INTERPRETED, PROMPT AND BUTTONS MUST BE PRESENTED ACCORDINGLY
        //show the popup window, with the prompt message and option buttons that were formatted based on the scenario above
        int choice = JOptionPane.showOptionDialog(null, prompt, "You landed a property!", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, optionList, optionList[0]);
        //choice == -1 means they didn't select a button, they clicked the X button, so continue to ask
        while(choice == -1){
            choice = JOptionPane.showOptionDialog(null, prompt, "You landed a property!", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, optionList, optionList[0]);
        }
        //selection = the button they chose
        String selection = optionList[choice];
        System.out.println("selection is " + selection);
        /*
        Each of these buttons represent something
        BUY - option to buy property
        EXIT - decline to do anything
        LEAVE - cannot do anything because they went bankrupt
        SELL TO BANK - sell property that player owns to the bank
        UPGRADE - upgrade
        PAY RENT - pay rent
        PAY FEE - pay PayProperty fee
        OK - do nothing, just accept the prompt
        ACCEPT MONEY - take money from the pop (senior parking only)
        GO TO JAIL - go to jail
        SEE CARD - see the community chest card
        */
        if(selection.equals("BUY")){
            //if you can buy it, it must be owned -> cast to OwnedProperty
            OwnedProperty oP = (OwnedProperty) thisProperty;
            //if its a REGULARPROPERTY, set its state to 1 = rent
            if(PropertyType.isRegularProperty(oP)){
                ((RegularProperty) (oP)).setState(1);
            }
            currentPlayer.buyProperty(oP);
            //create a border for this purchased property that has the color of the property and color representing the player, to show that they own it (Compoundborder)
            int loc = gui.getComponentLocation(oP);
            JButton b = (JButton) gui.components[loc];
            b.setBorder(new CompoundBorder(BorderFactory.createLineBorder(oP.getColor(), 2), BorderFactory.createLineBorder(currentPlayer.getColor(), 4)));
            gui.components[loc].setBackground(currentPlayer.getPropertyColor());
            b.setContentAreaFilled(false);
            b.setOpaque(false);
        } else if (selection.equals("LEAVE")){
            //display another pop up window that shows game is over, and display the results of the game
            JTextArea textArea2 = new JTextArea();
            textArea2.setEditable(true);
            textArea2.requestFocusInWindow();
            String[] opts = new String[]{"END GAME"};
            Player winner = getOtherPlayer();
            String message = winner.getName() + " has won the game with $" + winner.getBalance() + " remaining\n" + currentPlayer.getName() + " has lost the game and gone bankrupt.";
            int clicked = JOptionPane.showOptionDialog(null, message, "GAME OVER", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opts, opts[0]);
            while(choice == -1){
                clicked = JOptionPane.showOptionDialog(null, message, "GAME OVER", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opts, opts[0]);
            }
            System.exit(0);
        } else if (selection.equals("SELL TO BANK")){
            //if the property can be sold, it must be owned -> cast to OwnedProperty
            OwnedProperty oP = (OwnedProperty) thisProperty;
            //show resale value
            String message = "The resale value of this property is $" + oP.getResaleValue();
            int houseCost = 0;
            //compile the properties within this colorset
            ArrayList<RegularProperty> colorSet = new ArrayList<RegularProperty>();
            if(PropertyType.isRegularProperty(oP)){
                RegularProperty rP = (RegularProperty)  oP;
                for(Property p:propertyOrder){
                    if(p.getColor().equals(rP.getColor())){
                        colorSet.add((RegularProperty)p);
                    }
                }
                //needed to determine the building payback cost, since if you see one property from a monopoly, you must sell all upgrades (houses/hotels) from all properties in that monopoly
                houseCost = Helper.getBuildingPaybackCost(colorSet);
                message += "\nYou also need to sell all the houses and hotels from all properties within the color set. The cost for selling back buildings is $" + houseCost + ".";
            }
            message += "\nThe total value you will sell is $" + (oP.getResaleValue()+houseCost);
            String[] opts = new String[]{"SELL"};
            int clicked = JOptionPane.showOptionDialog(null, message, "SELL PROPERTY TO BANK", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opts, opts[0]);
            if(PropertyType.isRegularProperty(oP)){
                for(RegularProperty rP:colorSet){
                    rP.setState(1);
                }
                RegularProperty thisOne = (RegularProperty) oP;
                thisOne.setState(0);
            }
            //complete purchase
            currentPlayer.sellProperty(oP, (int)oP.getResaleValue()+houseCost);
            JButton propertyButton = (JButton) (gui.components[gui.getComponentLocation(oP)]);
            //remove border that indicates ownership, since the bank owns the property now
            propertyButton.setBorder(BorderFactory.createLineBorder(oP.getColor(), 6));
        } else if (selection.equals("UPGRADE")){
            //you can only upgrade RegularProperty
            RegularProperty rP = (RegularProperty) thisProperty;
            //show calculations and result of upgrade
            String message = "You will be upgrading this property from " + Helper.getStateAsString(rP.getState()) + " to " + Helper.getStateAsString(rP.getState() + 1) + ". This will cost $" + rP.getHouseCost() + ".";
            String[] opts = new String[]{"PAY"};
            int clicked = JOptionPane.showOptionDialog(null, message, "UPGRADE PROPERTY", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opts, opts[0]);
            //update the state of the property by incrementing it
            rP.setState(rP.getState() + 1);
            //deduct cost
            currentPlayer.updateBalance(-rP.getHouseCost());
        } else if (selection.equals("PAY RENT")){
            //must be an OwnedProperty
            OwnedProperty oP = (OwnedProperty) thisProperty;
            String message = "";
            int rent = 0;
            //PROPERTY IS A REGULARPROPERTY
            if(PropertyType.isRegularProperty(oP)){
                RegularProperty rP = (RegularProperty) oP;
                rent = rP.getCurrentRentCost(Helper.hasMonopoly(getOtherPlayer(), propertyOrder));
                //if they have a monopoly, they must pay colorset rent
                message += "The rent, based on their upgrade status, will be $" + rent + " (see title deed for more info).";
            //PROPERTY IS A SPORTSPROPERTY
            } else {
                SportsProperty sP = (SportsProperty) oP;
                //pay rent based on the number of sportsproperties owned
                //find that #
                int numOwned = Helper.numSportsPropertiesOwned(getOtherPlayer(), propertyOrder);
                rent = numOwned*25;
                //show calculations
                message += "The owner of this property owns " + numOwned + " sports facility properties. The rent will be $" + rent + ".";
            }
            //another pop up window to officially pay
            String[] opts = new String[]{"PAY"};
            int clicked = JOptionPane.showOptionDialog(null, message, "PAY RENT", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opts, opts[0]);
            while(clicked == -1){
                clicked = JOptionPane.showOptionDialog(null, message, "PAY RENT", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opts, opts[0]);
            }
            //deduct rent and give money to owner (other player)
            currentPlayer.updateBalance(-rent);
            getOtherPlayer().updateBalance(rent);
        } else if (selection.equals("PAY FEE")){
            PayProperty pP = (PayProperty) thisProperty;
            //show amt and display pop up window
            String message = "You must pay $" + pP.getPriceToPay() + ".";
            String[] opts = new String[]{"PAY"};
            int clicked = JOptionPane.showOptionDialog(null, message, "PAY FEE", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opts, opts[0]);
            while(clicked == -1){
                clicked = JOptionPane.showOptionDialog(null, message, "PAY FEE", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opts, opts[0]);
            }
            //pay the amt
            payTax(currentPlayer, pP);
        } else if (selection.equals("ACCEPT MONEY")){
            //give potmoney to current player
            currentPlayer.updateBalance(potOfMoney);
            //reset potmoney to 0
            potOfMoney = 0;
        } else if (selection.equals("GO TO JAIL")){
            //self explanatory
            goToJail(currentPlayer);
        //(community chest)
        } else if (selection.equals("SEE CARD")){
            //randomly select a card from the deck
            int cardIndex = (int) (Math.random()*communityChestDeck.size());
            //get the card message
            String cardMessage = communityChestDeck.get(cardIndex);
            //remove from the deck
            communityChestDeck.remove(cardIndex);
            System.out.println("cardMessage " + cardMessage);
            //ONLY CARD THAT DOESN'T INVOLVE JUST PAYING OR RECEIVING MONEY
            if(cardMessage.equals("You are assessed for street repairs: pay 40 per house and 115 per hotel you own")){
                String message = "";
                //calculate the number of houses and hotels owned by the player
                int numHouses = 0;
                int numHotels = 0;
                int cost = 0;
                for(OwnedProperty p:currentPlayer.getProperties()){
                    if(PropertyType.isRegularProperty(p)){
                        RegularProperty r = (RegularProperty) p;
                        int state = r.getState();
                        if(state == 6){
                            numHotels++;
                        } else if (state > 1){
                            numHouses += state-1;
                        }
                    }
                }
                //determine amt to pay
                cost = numHouses*40 + numHotels*115;
                //if there are no houses or hotels, notify
                if (cost == 0){
                    message += "\nYou don't have any houses or hotels so this won't cost any money.";
                //if not, show calculations and cost
                } else {
                    message += "\nSince you have " + numHouses + " houses and " + numHotels + " hotels, you have to pay $" + cost + ".";
                }
                //display pop up window outlining payments and result of the card selection
                String[] opts = new String[]{"OK"};
                int clicked = JOptionPane.showOptionDialog(null, cardMessage + message, "COMMUNITY CHEST CARD", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opts, opts[0]);
                while(clicked == -1){
                    clicked = JOptionPane.showOptionDialog(null, cardMessage + message, "COMMUNITY CHEST CARD", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opts, opts[0]);
                }
                //pay the fee
                currentPlayer.updateBalance(-cost);
            //COMMUNITY CHEST CARD ONLY INVOLVES PAYING OR RECEIVING MONEY
            } else {
                //show result of the card
                String[] opts = new String[]{"OK"};
                int clicked = JOptionPane.showOptionDialog(null, cardMessage, "COMMUNITY CHEST CARD", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opts, opts[0]);
                while(clicked == -1){
                    clicked = JOptionPane.showOptionDialog(null, cardMessage, "COMMUNITY CHEST CARD", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opts, opts[0]);
                }
                
                //based on the card selected, carry out the necessary functions
                if (cardMessage.equals("Advance to go. Collect 200")){
                    makeMove(currentPlayer, 0);
                } else if (cardMessage.equals("Doctor’s fees, pay 50")){
                    currentPlayer.updateBalance(-50);
                } else if (cardMessage.equals("Holiday fund matures, receive 100")){
                    currentPlayer.updateBalance(100);
                } else if (cardMessage.equals("Life insurance matures, collect 100")){
                    currentPlayer.updateBalance(100);
                } else if (cardMessage.equals("Go on a field trip, pay 50")){
                    currentPlayer.updateBalance(-50);
                } else if (cardMessage.equals("Income tax refund, collect 20")){
                    currentPlayer.updateBalance(20);
                } else if (cardMessage.equals("Go Directly to Jail. Do not pass GO. Do not collect 200")){
                    goToJail(currentPlayer);
                } else if (cardMessage.equals("Hospital fees, pay 100")){
                    currentPlayer.updateBalance(-100);
                } else if (cardMessage.equals("Traffic ticket, pay 100")){
                    currentPlayer.updateBalance(-100);
                } else if (cardMessage.equals("From sale of stock, you get 50")){
                    currentPlayer.updateBalance(50);
                }
            }
            //if there are no cards remaining in the deck, replenish the deck from the list of options (allCommunityChestcards)
            if(communityChestDeck.size() == 0){
                communityChestDeck = allCommunityChestCards;
            }
        }  
        //update logistics for each player
        updatePlayerInfo();
        //switch to other player (for currentPlayer)
        switchPlayers();
    }
    
    //Christina
    //update logistics for each player
    public void updatePlayerInfo(){
        gui.player1Info.setText(player1.getName() + ": $" + player1.getBalance());
        gui.player2Info.setText(player2.getName() + ": $" + player2.getBalance());
    }
    
    //Christina
    //when a property (that is an OwnedProperty) was clicked, the logistics must be shown
    public void validPropertyWasClicked(String actionCommandNameOnly){
        System.out.println("validPropertyWasClicked " + actionCommandNameOnly);
        OwnedProperty thisProperty;
        //if the button clicked 
        //find the corresponding property for the actionCommand (which holds the property name) - has been already trimmed + removed the property price
        for(Property p:propertyOrder){
            if(actionCommandNameOnly.equals(p.getName().toUpperCase())){
                thisProperty = (OwnedProperty) p;
                //property has been found
                //if its a SPORTSPROPERTY, call the function for displaying sports property title deed info
                if(PropertyType.isSportsProperty(thisProperty)){
                    validPropertyWasSports(thisProperty);
                //PropertyType.isRegularProperty(thisProperty) == true
                //if its a REGULARPROPERTY, call the function for displaying regular property title deed info
                } else {
                    validPropertyWasRegular(thisProperty);
                }
            }
        }
    }
    
    //Christina
    //property where logistic info must be shown was REGULARPROPERTY
    public void validPropertyWasRegular(OwnedProperty thisProperty){
        //cast
        RegularProperty regularProperty = (RegularProperty) thisProperty;
        //show information on the appropriate lines and set text color to black
        gui.propertyTitle.setText(regularProperty.getName().toUpperCase());
        gui.rentCost.setText("RENT $" + regularProperty.getRent() + ".");
        gui.rentCost.setForeground(Color.BLACK);
        gui.rentWithColorSetCost.setText("RENT WITH COLOR SET $" + regularProperty.getColorSetRent() + ".");
        gui.rentWithColorSetCost.setForeground(Color.BLACK);
        gui.oneHouseLabel.setText("With 1 House $" + regularProperty.getOneHouseRent() + ".");
        gui.oneHouseLabel.setForeground(Color.BLACK);
        gui.twoHouseLabel.setText("With 2 Houses $" + regularProperty.getTwoHouseRent() + ".");
        gui.twoHouseLabel.setForeground(Color.BLACK);
        gui.threeHouseLabel.setText("With 3 Houses $" + regularProperty.getThreeHouseRent() + ".");
        gui.threeHouseLabel.setForeground(Color.BLACK);
        gui.fourHouseLabel.setText("With 4 Houses $" + regularProperty.getFourHouseRent() + ".");
        gui.fourHouseLabel.setForeground(Color.BLACK);
        gui.hotelCost.setText("With HOTEL " + regularProperty.getHotelRent() + ".");
        gui.hotelCost.setForeground(Color.BLACK);
        gui.housePurchaseCost1.setText("Houses cost $" + regularProperty.getHouseCost() + ". each");
        gui.housePurchaseCost2.setText("Hotels, $" + regularProperty.getHotelRent() + ". plus 4 houses ");
        gui.resaleValueLabel.setText("Resale value $" + regularProperty.getResaleValue() + ".");
        //if the property is owned, change the color of the line of the status of the upgrade
        //eg. if the player who owns the property has one house, the one house line text will be the player's representative color (NOT BLACK)
        if(regularProperty.getOwner() != null){
            int state;
            //get the state
            state = regularProperty.getState();
            //if its at the rent state and has a monopoly = color set rent, set it to 7 (new value)
            if(state == 1 && Helper.hasMonopoly(regularProperty.getOwner(), propertyOrder)){
                state = 7;
            }
            //change color to appropriate line
            if(state == 1){
                gui.rentCost.setForeground(regularProperty.getOwner().getColor());
            } else if (state == 2){
                gui.oneHouseLabel.setForeground(regularProperty.getOwner().getColor());
            } else if (state == 3){
                gui.twoHouseLabel.setForeground(regularProperty.getOwner().getColor());
            } else if (state == 4){
                gui.threeHouseLabel.setForeground(regularProperty.getOwner().getColor());
            } else if (state == 5){
                gui.fourHouseLabel.setForeground(regularProperty.getOwner().getColor());
            } else if (state == 6){
                gui.hotelCost.setForeground(regularProperty.getOwner().getColor());
            } else if (state == 7){
                gui.rentWithColorSetCost.setForeground(regularProperty.getOwner().getColor());
            }
            System.out.println("state " + state);
        }
    }
    
    //Christina
    //property where logistic info must be shown was SPORTSPROPERTY
    public void validPropertyWasSports(OwnedProperty thisProperty){
        //cast
        SportsProperty sportsProperty = (SportsProperty) thisProperty;
        //show information on the appropriate lines and set text color to black
        gui.propertyTitle.setText(sportsProperty.getName().toUpperCase());
        gui.rentCost.setText("RENT $" + sportsProperty.getRent() + ".");
        gui.rentCost.setForeground(Color.BLACK);
        gui.rentWithColorSetCost.setText("");
        gui.oneHouseLabel.setText("If 2 Sports Facilities are owned $" + sportsProperty.getTwoOwned());
        gui.oneHouseLabel.setForeground(Color.BLACK);
        gui.twoHouseLabel.setText("If 3 Sports Facilities are owned $" + sportsProperty.getThreeOwned());
        gui.twoHouseLabel.setForeground(Color.BLACK);
        gui.threeHouseLabel.setText("If 4 Sports Facilities are owned $" + sportsProperty.getFourOwned());
        gui.threeHouseLabel.setForeground(Color.BLACK);
        gui.fourHouseLabel.setText("");
        gui.hotelCost.setText("");
        gui.housePurchaseCost1.setText("");
        gui.housePurchaseCost2.setText("");
        gui.resaleValueLabel.setText("");
        //if the property is owned, change the color of the line of the status of the rent payment
        //eg. if the player who owns the property owns three sports facilities properties, the rent if three facilities are owned text will be the player's representative color (NOT BLACK)
        if(sportsProperty.getOwner() != null){
            //get the num owned
            int state = Helper.numSportsPropertiesOwned(sportsProperty.getOwner(), propertyOrder);
            //change text of appropriate line
            if (state == 1){
                gui.rentCost.setForeground(sportsProperty.getOwner().getColor());
            } else if (state == 2){
                gui.oneHouseLabel.setForeground(sportsProperty.getOwner().getColor());
            } else if (state == 3){
                gui.twoHouseLabel.setForeground(sportsProperty.getOwner().getColor());
            } else if (state == 4){
                gui.threeHouseLabel.setForeground(sportsProperty.getOwner().getColor());
            }
            System.out.println("state " + state);
        }
        
    }

    //Christina
    //if a button is clicked with an action listener, give the actionCommand to buttonClicked method, which will determine the next steps
    public void actionPerformed(ActionEvent ae){
        System.out.println("actionPerformed " + ae.getActionCommand());
        buttonClicked(ae.getActionCommand());
    }
    
    //Christina
    public Player getOtherPlayer(){
        if(currentPlayer == player1){
            return player2;
        } else {
            return player1;
        }
    }
}

