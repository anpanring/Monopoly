import java.util.ArrayList;

public class Helper {
    
    //CHRISTINA
    //this is used for the actionCommand (when a button is clicked), which is formatted as PROPERTYNAME - $RENT
    //we need to use name only, so trim off the rent and return
    public static String trimToName(String untrimmed){
        if(untrimmed.contains("–")){
            int index = untrimmed.indexOf("–");
            return untrimmed.substring(0, index-1);
        }
        return untrimmed;
    }
    
    //CHRISTINA
    //when you sell a property and have a monopoly on the color set, 
    //you must sell all upgrades (houses/hotels) from all properties in the color set
    //this is calculated as the houses/2
    public static int getBuildingPaybackCost(ArrayList<RegularProperty> colorSet){
        int cost = 0;
        for(RegularProperty p:colorSet){
            //if has upgrades (since state of 2 = one house)
            if(p.getState() > 1){
                //calculate total cost
                cost += (p.getState()-1)*(int) (p.getHouseCost()/2);
            }
        }
        return cost;
    }
    
    //CHRISTINA
    //interpret the state digit as a String
    public static String getStateAsString(int n){
        switch(n){
            case 0:
                return "for sale";
            case 1:
                return "rent";
            case 2:
                return "one house";
            case 3:
                return "two houses";
            case 4:
                return "three houses";
            case 5:
                return "four houses";
            case 6:
                return "hotel";
        }
        return "";
    }
    
    //JACK
    //find if the player has a monopoly on the color set from this property
    public static boolean hasMonopoly(Player p, Property[] propertyOrder){
        ArrayList<Property> ownedPropertiesOfThisColor = new ArrayList<Property>();
            for(Property pl : propertyOrder){
                if(pl.getColor().equals(propertyOrder[p.getPosition()].getColor())){
                    System.out.println("if statement is true (hasMonopoly)");
                    ownedPropertiesOfThisColor.add(pl);
                }
            }
            int colorProps = 0;
            for(Property prop : ownedPropertiesOfThisColor){
                if(p.getProperties().contains(prop)){
                    colorProps++;
                }
            }  
            System.out.println("colorProps " + colorProps);
            System.out.println(colorProps == ownedPropertiesOfThisColor.size());
            return colorProps == ownedPropertiesOfThisColor.size();
    }
    
    //CHRISTINA
    //find the number of sports facilities the player owns
    public static int numSportsPropertiesOwned(Player p, Property[] propertyOrder){
        int num = 0;
        int[] locsOfSPs = {5, 15, 25, 35};
        for(int i = 0; i < locsOfSPs.length; i++){
            SportsProperty thisSP = (SportsProperty) propertyOrder[locsOfSPs[i]];
            if(thisSP.getOwner() == p){
                num++;
            }
        }
        return num;
    }
}


