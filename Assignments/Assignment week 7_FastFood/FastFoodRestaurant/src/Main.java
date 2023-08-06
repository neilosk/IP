public class Main {
    public static void main(String[] args) {
        Pizza p1 = new Pizza();
        Food b1 = new Food("Burger", 65);
        Food s1 = new Food("Salad", 30);
        // p1.addTopping("Pepperoni");
        // p1.addTopping("Onions");
        Order order1 = new Order();
        order1.addFood(p1);
        order1.addFood(b1);
        order1.addFood(s1);

        // p1.display();
        order1.display();
    }
}
// public class Main {
//     public static void main(String[] args) {
//         Pizza p1 = new Pizza();
//         Food b1 = new Food("Burger", 65);
//         Food s1 = new Food("Salad", 30);
//         // p1.addTopping("Pepperoni");
//         // p1.addTopping("Onions");
//         Order order1 = new Order();
//         order1.addFood(p1);
//         order1.addFood(b1);
//         order1.addFood(s1);

//         // p1.display();
//         order1.display();
//     }
// }
