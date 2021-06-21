
import java.awt.Color;

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
public class OwnedProperty extends Property {
    
    //private String name;
    private Player owner;
    private int price;
    private int rent;
    private double resaleValue;
    
    
    public OwnedProperty(String name, int price, Player owner, int rent, Color color){
        super(name, color);
        this.owner = owner;
        this.price = price;
        this.rent = rent;
        resaleValue = price*.5;
    }
    
    public void setOwner(Player owner){
        this.owner = owner;
    }
    
    public void setPrice(int price){
        this.price = price;
    }
    
    public void setRent(int rent){
        this.rent = rent;
    }
    
    public void setResaleValue(int value){
        this.resaleValue = value;
    }
    
    public Player getOwner(){
        return owner;
    }
    
    public double getResaleValue(){
        return resaleValue;
    }
    
    public int getPrice(){
        return price;
    }
    
    public int getRent(){
        return rent;
    }
}



