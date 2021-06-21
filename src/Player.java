/*
Christina, Jack and Ryan
Priory Monopoly
Checkpoint 2
 */

import java.awt.Color;
import java.util.ArrayList;
public class Player {
    private String name;
    private double balance;
    private ArrayList<OwnedProperty> properties;
    private int position;
    private Color color;
    private Color propertyColor;
    private boolean needsToPayJailFee;
    
    public Player(String name, double balance, 
    ArrayList<OwnedProperty> properties, Color color){
        this.name = name;
        this.balance = balance;
        this.properties = properties;
        position = 0;
        this.color = color;
        this.propertyColor = new Color(color.getRed(), color.getGreen(), color.getBlue(), 50);
        needsToPayJailFee = false;
    }

    public String getName(){
        return name;
    }
    
    public int getPosition(){
        return position;
    }
    
    public Color getColor(){
        return color;
    }
    
    public double getBalance(){
        return balance;
    }
    
    public ArrayList<OwnedProperty> getProperties(){
        return properties;
    }
    
    public Color getPropertyColor(){
        return propertyColor;
    }
    
    public boolean getJailInfo(){
        return needsToPayJailFee;
    }
    
    public void setColor(Color color){
        this.color = color;
    }
    
    public void setPosition(int newPos){
        position = newPos;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setJailInfo(boolean bool){
        needsToPayJailFee = bool;
    }

    //for buying properties
    public void buyProperty(OwnedProperty p){
        int price = p.getPrice();
	updateBalance(-price);
        properties.add(p);
        p.setOwner(this);
    }
    
    //for selling properties
    public void sellProperty(OwnedProperty p, int amt){
        updateBalance(amt);
        properties.remove(p);
	p.setOwner(null);
    }
    
    //for adding and subtracting from player’s balance
    public void updateBalance(double add){ //not really sure if this is what we are supposed to do??
        balance += add; 
    }
    
    public String toString(){
	String props = "";
        for (int i = 0; i < properties.size() - 1; i++) {
            props = props + properties.get(i).getName() + ", ";
        }
        props = props + "and ";
        properties.get(properties.size() - 1).getName();
        return "Player: " + name + "\nBalance: $" + balance + 
        "\nProperties: " + props;
    }
}







