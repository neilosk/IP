import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class InputReader{
    private Scanner reader;


    public InputReader(){
    reader = new Scanner(System.in);
    }

 

    public HashSet<String> getInput(){
    String inputLine = reader.nextLine();

    String[] wordArray = inputLine.split(" ");
    int n = Integer.parseInt(wordArray[0]);
    System.out.println(n);
    String container = wordArray[1];
    System.out.println(container);
    String drink = wordArray[3];
    System.out.println(drink);

    HashSet<String> words = new HashSet<>();
    for(String word : wordArray){
        words.add(word);
    }
    return words;
    }
}