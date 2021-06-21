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
//basically identifies what kind of property the property passed in as a parameter is
public class PropertyType {
    public static boolean isRegularProperty(Property p){
        try{
            RegularProperty property = (RegularProperty)(p);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public static boolean isSportsProperty(Property p){
        try{
            SportsProperty property = (SportsProperty)(p);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public static boolean isOwnedProperty(Property p){
        try{
            OwnedProperty property = (OwnedProperty)(p);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public static boolean isPayProperty(Property p){
        try{
            PayProperty property = (PayProperty)(p);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}



