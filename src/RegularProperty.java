
import java.awt.Color;
import java.util.ArrayList;

/*
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

public class RegularProperty extends OwnedProperty{
    
    //private String name;
    //private Player owner;
    //private int price;
    //private int rent;
    private int state;
    /*
    0 = for sale
    1 = rent
    2 = one house
    3 = two houses
    4 = three houses
    5 = four houses
    6 = hotel
    */
    private int colorSetRent;
    private int oneHouseRent;
    private int twoHouseRent;
    private int threeHouseRent;
    private int fourHouseRent;
    private int hotelRent;
    private int houseCost;
    
    public RegularProperty(String name, Player owner, int price, int rent, int colorSetRent, 
            int oneHouseRent, int twoHouseRent, int threeHouseRent, int fourHouseRent, int hotelRent, int houseCost, Color color){
        super(name, price, owner, rent, color);
        this.state = 0;
        this.colorSetRent = colorSetRent;
        this.oneHouseRent = oneHouseRent;
        this.twoHouseRent = twoHouseRent;
        this.threeHouseRent = threeHouseRent;
        this.fourHouseRent = fourHouseRent;
        this.hotelRent = hotelRent;
        this.houseCost = houseCost;
    }
    
    public void setColorSetRent(int colorSetRent){
        this.colorSetRent = colorSetRent;
    }
    
    public void setOneHouseRent(int oneHouseRent){
        this.oneHouseRent = oneHouseRent;
    }
    
    public void setTwoHouseRent(int twoHouseRent){
        this.twoHouseRent = twoHouseRent;
    }
    
    public void setThreeHouseRent(int threeHouseRent){
        this.threeHouseRent = threeHouseRent;
    }
    
    public void setFourHouseRent(int fourHouseRent){
        this.fourHouseRent = fourHouseRent;
    }
    
    public void setHotelRent(int hotelRent){
        this.hotelRent = hotelRent;
    }
    
    public void setHouseCost(int houseCost){
        this.houseCost = houseCost;
    }
    
    public void setState(int state){
        this.state = state;
    }
    
    public int getColorSetRent(){
        return colorSetRent;
    }
    
    public int getOneHouseRent(){
        return oneHouseRent;
    }
    
    public int getTwoHouseRent(){
        return twoHouseRent;
    }
    
    public int getThreeHouseRent(){
        return threeHouseRent;
    }
    
    public int getFourHouseRent(){
        return fourHouseRent;
    }
    
    public int getHotelRent(){
        return hotelRent;
    }
    
    public int getHouseCost(){
        return houseCost;
    }
    
    public int getState(){
        return state;
    }
    
    public int getCurrentRentCost(boolean hasMonopoly){
        if(state == 1 && !hasMonopoly){
            return getRent();
        } else if (state == 1 && hasMonopoly){
            return colorSetRent;
        } else if (state == 2){
            return oneHouseRent;
        } else if (state == 3){
            return twoHouseRent;
        } else if (state == 4){
            return threeHouseRent;
        } else if (state == 5){
            return fourHouseRent;
        } else if (state == 6){
            return hotelRent;
        }
        // state == 0
        return -1;
    }
    
    /*
    int numInColor = 0;
        Color thisColor = getColor();
        Color myRed = new Color(0xEB1A22);
        Color myYellow = new Color(0xFDF100);
        Color myOrange = new Color(0xF7941C);
        Color myGreen = new Color(0x20B259);
        Color myPink = new Color(0xD93A97);
        Color myBlue = new Color(0x0072BE);
        Color myLightBlue = new Color(0xAFE2FF);
        Color myBrown = new Color(0x955539);
        
        if(thisColor.equals(myBrown) || thisColor.equals(myBlue)){
            numInColor = 2;
        } else {
            numInColor = 3;
        }
    1 = rent
    2 = one house
    3 = two houses
    4 = three houses
    5 = four houses
    6 = hotel
    */
    
    
}



