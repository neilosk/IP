import java.util.ArrayList;
import java.util.List;

public class Pizza extends Food{                        //subclass of Food  

    protected List<String> toppings;                    //Defining toppings as a List of String
    
    public Pizza(){                                     
    super("Pizza", 45);                     //Initializing Pizza by superClass with name, price
    this.toppings = new ArrayList<>();                  //Initializing toppings Arraylist
    }

    public void addTopping(String topping){             //add topping method that adds each topping to the ArrayList
        toppings.add(topping);             
        price += 10;                                    //price increase by 10
    }

    public void setName(String name){                   //Change Pizza name
        this.name = name;
    }

    @Override                                            //Override diplay method from the SuperClass
    public void display() {         
        String displayToppings = " { }";                                                     //Defining the empty Pizza
        if(toppings.size()>0){                                                              //If there are toppings
        displayToppings = " { ";                                                            //Defining the start of the diplay of the toppings         
        for (String t : toppings) {                                                         //Loop over the toppings ArrayList
            displayToppings += t +", ";                                                     //Add each topping following ", "
        }
        int removal = displayToppings.length()-2;                                           //Defining the index of the displayTopping Strings minus the last ", "
        displayToppings =  displayToppings.substring(0, removal);               //using the substring method to remove the last ", "
        displayToppings += " }";                                                           //closing of displayToppings string 
        }
        System.out.print(price + " kr " + name + displayToppings);
    }
}
