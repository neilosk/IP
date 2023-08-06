import java.util.ArrayList;
import java.util.List;

public class Order{
    protected List<Food> ordered;                                   //Defining a list of Food

    public Order(){
        ordered = new ArrayList<>();                                //Initializing the ordered ArrayList
    }

    public void addFood(Food food){
        ordered.add(food);                                          //Adding Food to the ArrayList
    }

    public int total(){                                             
    int totalAmmount = 0;                                           //Defiing the total ammount
    for (Food food : ordered) {                                      //Loop over ordered Arraylist
        totalAmmount += food.getPrice();                            //increase total ammount by the price of the food
    }
    return totalAmmount;                                            //returning the total ammount
    }

    public void display(){                                          //display method for the total order
        for (Food food : ordered) {                                 //Loop over ordered ArrayList
            food.display();                                         //use Food display method
            System.out.println();
        }
        System.out.println(total() + " kr TOTAL");
    }

    public boolean payWith(CreditCard card){                        //Creating payWith method using CreditCard Interface as parameter
        if(card.withdraw(total()) == false){                        //Logical test if card witrdraw method from CreditCard Interface returns false for the total ammount
            System.out.println("ERROR: Payment failed");         //If false print
            return false;
        }
        return true;
    }
}
