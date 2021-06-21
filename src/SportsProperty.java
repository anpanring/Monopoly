
import java.awt.Color;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author christinacheng
 */
public class SportsProperty extends OwnedProperty{
    
    //private String name;
    //private Player owner;
    //private int price;
    //private int rent;
    private int twoOwned;
    private int threeOwned;
    private int fourOwned;
    
    public SportsProperty(String name, Player owner, int price, int rent, int twoOwned, int threeOwned, int fourOwned, Color color){
        super(name, price, owner, rent, color);
        this.twoOwned = twoOwned;
        this.threeOwned  = threeOwned;
        this.fourOwned = fourOwned;
    }
    
    public void setTwoOwned(int twoOwned){
        this.twoOwned = twoOwned;
    }
    
    public void setThreeOwned(int threeOwned){
        this.threeOwned = threeOwned;
    }
    
    public void setFourOwned(int fourOwned){
        this.fourOwned = fourOwned;
    }
    
    public int getTwoOwned(){
        return twoOwned;
    }
    
    
    public int getThreeOwned(){
        return threeOwned;
    }
    
    public int getFourOwned(){
        return fourOwned;
    }
}



