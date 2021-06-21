
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
public class Property {
    
    private Color color;
    private String name;   
    
    public Property(String name, Color color){
        this.name = name;
        this.color = color;
    }
    
    public String getName(){
        return name;
    }
    
    public Color getColor(){
        return color;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setColor(Color color){
        this.color = color;
    }

    public String toString(){
        return "Name: " + name + "\nColor: " + color;
    }
    
}



