public class Food {

    protected String name;                             //Defining name as name of the Food
    protected int price;                               //Defining price as price of the Food

    public Food(String name, int price){                //Initializing the fields as method input
        this.name = name;                               
        this.price = price;
    }

    public int getPrice(){                              // getPrice method returning price
        return price;
    }

    public void display(){                              //Food display method 
        System.out.print(price + " kr " + name);
    }

}
