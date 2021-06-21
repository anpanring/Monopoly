/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author christinacheng
 */


import java.awt.Color;
import java.awt.FontFormatException;
import java.io.IOException;
import java.util.ArrayList;
public class Tester {
   public static void main(String[] args) throws FontFormatException, IOException {
       PMonopoly monopoly = new PMonopoly();
       monopoly.run();
   }
/*
//names of the properties
    String[] names = {"Senior Parking", "Miu", "Break", "Faisal", "Lee", "Pool", 
            "Bessin", "Trudelle", "Pay for Dance", "Parker", "Wes",
            "Hemiup", "Student Center", "Robotics", "Garden", "Lunch", "Lunch",
            "Paige", "Cafeteria", "Field", "Tennis Court", "Hatzopoulos", "Lunch",
            "Payne", "Founder's Hall", "Pay Tuition", "Pay for Play Tickets", 
            "Briggs", "Monastery", "Mr. Morris", "Carroll", "Dr. O", 
            "Break", "DuBose", "Gym", "Panther Shack", "Cohen",
            "Break", "Neale", "New School Day"};
//prices of the properties - corresponding to same index as name array
//if it is 0, it doesn't have a price (doesn't need one)
    int[] prices = {0, 220, 0, 220, 240, 200, 360, 360, 150, 280, 
        0, 200, 300, 180, 300, 0, 0, 180, 390, 200, 200, 160, 0, 140, 350, 150, 100, 140, 400, 0, 120, 100, 0, 100, 200, 
        200, 60, 0, 60, 0};

    //color tracker
        int ct = 0;
    //monopoly colors in hexadecimal
        Color myRed = new Color(0xEB1A22);
        Color myYellow = new Color(0xFDF100);
        Color myOrange = new Color(0xF7941C);
        Color myGreen = new Color(0x20B259);
        Color myPink = new Color(0xD93A97);
        Color myBlue = new Color(0x0072BE);
        Color myLightBlue = new Color(0xAFE2FF);
        Color myBrown = new Color(0x955539);
    
        //initializing all the properties with the correct name and price
        //listed from the top left corner across the rows (skipping the middle)
        //there is no pattern to which slots have which colors, so we have to use if statements
        // -> no switch statement because also ave to check for .contains()
        Property[] properties = new Property[names.length];
        for(int i = 0; i < names.length; i++){
            String currentName = names[i];
            int currentPrice = prices[i];
            properties[i] = new Property(currentName, currentPrice);
            if (ct == 0 || ct == 10 ||ct == 0 || ct == 39 || currentName.contains("Lunch") ||
                    currentName.contains("Break") || currentName.contains("Pay ")) properties[i].setColor(Color.white);
            else if (ct == 1 || ct == 3 || ct == 4) properties[i].setColor(myRed);
            else if (ct == 6 || ct == 7 || ct == 9) properties[i].setColor(myYellow);
            else if (ct == 11 || ct == 13 || ct == 17) properties[i].setColor(myOrange);
            else if (ct == 12 || ct == 14 || ct == 18) properties[i].setColor(myGreen);
            else if (ct == 21 || ct == 23 || ct == 27) properties[i].setColor(myPink);
            else if (ct == 24 || ct == 28) properties[i].setColor(myBlue);
            else if (ct == 30 || ct == 31 || ct == 33) properties[i].setColor(myLightBlue);
            else if (ct == 36 || ct == 38) properties[i].setColor(myBrown);
            else if (ct == 5 || ct == 19 || ct == 20 || ct == 34) properties[i].setColor(Color.gray);
            ct++;
        }
        //create GUI object and pass in the properties
        GUI test = new GUI(properties);

    }
*/
}






