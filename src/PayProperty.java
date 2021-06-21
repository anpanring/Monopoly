
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
public class PayProperty extends Property{
    
    //private String name;
    private int priceToPay;
    
    public PayProperty(String name, int priceToPay, Color color){
        super(name, color);
        this.priceToPay = priceToPay;
    }
    
    public int getPriceToPay(){
        return priceToPay;
    }
    
    public void setPriceToPay(int priceToPay){
        this.priceToPay = priceToPay;
    }
    
}



