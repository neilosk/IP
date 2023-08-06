import java.util.TreeSet;
import java.util.Iterator;
import java.util.Set;

public class TreeSetDemo {
    public static void main(String[] args) throws Exception {
       
        Set<String> fruitSet = new TreeSet<String>();
        fruitSet.add("banana");
        fruitSet.add("apple");
        fruitSet.add("strawberry");
        fruitSet.add("pear");

        System.out.println("Elements of the set: ");
        for(String fruit : fruitSet){
        System.out.println("\t" +  fruit); // "\t" allows to print as tab the next argument
        }

        System.out.println("\nTry to add a duplicate item:"); // \n add a new line
        if (fruitSet.add("apple") == false){
            System.out.println("apple is already in the set");
        }

        if(!fruitSet.contains("pear")){
            fruitSet.add("apple");
        }

        Iterator<String> it = fruitSet.iterator();
        System.out.println("Elements of the set: (again) ");
            while(it.hasNext()){
                System.out.println("\t" + it.next());    
            }

        Iterator<String> it2 = fruitSet.iterator();
        System.out.println("Elements of the set: (again) ");
            while(it2.hasNext()){
                String element = it2.next();
                if(element.equals("strawberry")){
                    it2.remove();
                    } else{
                            System.out.println("\t" +  element);
                            }
             }
       }
    }

