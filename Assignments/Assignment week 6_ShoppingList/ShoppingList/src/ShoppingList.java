import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ShoppingList {

      public static void main(String[] args) {
        ShoppingList list = new ShoppingList();
        list.printShoppingList();
    }

    private String availableCom;                                                //String var for the first "AVAILABE" user input
    private String[] inputWords;                                                //String Array to assign the words of each input Line
    private Map<String, Integer> amap;                                          //Hashmap for Available items (K,V) = (Name,Quantity)
    private Map<String, Integer> rmap;                                          //Hashmap for Recipe items (K,V) = (Name,Quantity)
    private Map<String, Integer> shoppingMap;                                   //Treemap for Shopping Items (final) - so items will be stored in Key natural(alphabetical) order
    private boolean isRecipe;                                                   //boolean var to check if the input is recipe or available items

    public ShoppingList(){
    Scanner sc = new Scanner(System.in);

    amap = new HashMap<>();
    rmap = new HashMap<>();
    shoppingMap = new TreeMap<>();

    availableCom = sc.nextLine();
   

        while(sc.hasNextLine()){                                                
            String input = sc.nextLine();                                           //Assign input (after "AVAILABLE" first line) to a String
            inputWords = input.split(" ");                                   //Split above input to words
            String qtyText = inputWords[0];                                         //Assign first word the the Word Array to check if it is a recipe
        
            if (!qtyText.equals("RECIPE")){                               //if the first word input is NOT "RECIPE"
                String weight = inputWords[1];                                      //Assign second word as the weight measure system
                String name = inputWords[2];                                        //Assign third word to word Array as the name of the item
                    if (isRecipe == true){                                          //Logical test if the item is under a "RECIPE"
                        if (rmap.get(name) != null){                                //Logical test if the item already exits (In case of multiple "RECIPES")
                            int qty = Integer.parseInt(qtyText) ;               //Convert Quantity as text to Integer
                                if(weight.equals("kg")){              //Logical Test if the quanity is in "g" or "kg" and convert to "g"
                                     qty = qty * 1000;
                                }
                            qty += rmap.get(name);                              //Add the new qty to the old one
                            rmap.put(name, qty);                                //Assign Name and Quantity to RecipeMap
                    } else {                                                    //if the item does not exist in current RecipeMap
                            int qty = Integer.parseInt(qtyText) ;               //Convert Quantity as text to Integer
                                if(weight.equals("kg")){               //Logical Test if the quanity is in "g" or "kg" and convert to "g"
                                     qty = qty * 1000;
                                }
                            rmap.put(name, qty);                                //Assign item to RecipeMap (for the first time) (K,V) = (Name,Quantity)
                        }
                } else{                                                         //If isRecipe is false, meaning that the item should be assigned to AvailableMap
                     int qty = Integer.parseInt(qtyText);                       //Convert Quantity as text to Integer
                            if(weight.equals("kg")){                   //Logical Test if the quanity is in "g" or "kg" and convert to "g"
                                qty = qty * 1000;
                            }
                    amap.put(name, qty);                                        //Assign item to AvailableMap (K,V) = (Name,Quantity)
                    }
            }else {
                isRecipe = true;                                                //If first word is "RECIPE", change the value of the boolean and move to the nextLine
                } 
        }
        sc.close();                                                             //Scanner close


        for( String key : rmap.keySet()){                                            //KeySet returns a set and looping through keys of the RecipeMap
            if (amap.containsKey(key)){                                              //Logical test if Available Map contains items from the RecipeMap (by checking their keys-names)
                if(amap.get(key) < rmap.get(key)){                                  //Logical Test if Quantity in the RecipeMap for the same Item is bigger
                    int newQty = rmap.get(key) - amap.get(key);                     //THe newQuantity should be the difference    
                    shoppingMap.put(key, newQty);                                   //Assign the new Quantity to the ShoppingMap
                } 
            }else{                                                                  //In case AvailableMap does not contain the item of the RecipeMap
                shoppingMap.put(key, rmap.get(key));                                //Assign the name and the quantity to ShoppingMap (from the RecipeMap)
            }
        }
    }

      public void printShoppingList(){                                               //pintShoppingList method
            System.out.println("Shopping List:");                                  //print first line
            if (shoppingMap.size() > 0){                                               //Logical test if ShoppingMap is NOT empty
                for (String key : shoppingMap.keySet()) {                              //Loop for every key of the ShoppingMap
                    System.out.println(shoppingMap.get(key) + " g " + key );           //Print Quanity and Name of the ShoppingMap
                }
            }
    }
}
