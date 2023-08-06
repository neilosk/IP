import java.util.*;


public class Main {

    public static void main(String[] args){
    Scanner reader = new Scanner(System.in); 
  

    String inputLine = reader.nextLine();
    reader.close();
    String[] wordArray = inputLine.split(" ");
    int n = Integer.parseInt(wordArray[0]);
    String containers = wordArray[1];
    // String[] containerArray = containers.split("s", 0);
        
    //     StringBuffer sb = new StringBuffer();
    //         for(int i = 0; i < containerArray.length; i++) {
    //      sb.append(containerArray[i]);
    //         }
    //      String container = sb.toString();
    String container = containers.substring(0,containers.length()-1);

    String drink = wordArray[3];
    int loop = n+1;
    for (int i = 2; i < n; i++){
    System.out.println(loop-1 +" "+ containers + " of "+ drink + " on the wall");
    System.out.println(loop-1 +" "+ containers + " of "+ drink);
    System.out.println("Take one down, pass it around");
    System.out.println(loop-2 +" "+ containers + " of "+ drink + " on the wall");
    System.out.println(" ");
    loop--;
    };

        
        
    System.out.println(loop-1 +" "+ containers + " of "+ drink + " on the wall");
    System.out.println(loop-1 +" "+ containers + " of "+ drink);
    System.out.println("Take one down, pass it around");
    System.out.println("One" +" "+ container + " of "+ drink + " on the wall");
    System.out.println(" ");

    System.out.println("One" +" "+ container + " of "+ drink + " on the wall");
    System.out.println("One"+" "+ container + " of "+ drink);
    System.out.println("Take one down, pass it around");
    System.out.println("No more" +" "+ containers + " of "+ drink + " on the wall");
    System.out.println(" ");


    }
    
}




