import java.util.Scanner;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map;



public class StackingCups {


    public static boolean isNumeric(String value){
        return Character.isDigit(value.charAt(0));
    }

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);

        int nCups = Integer.parseInt(scanner.nextLine());

        Map<Integer, String> cups = new TreeMap<Integer, String>();



        for (int i = 0; i < nCups; i++) {
            String cupInfo = scanner.nextLine();
            String[] tokens = cupInfo.split(" ");

            String color = "";
            int radius = 0;
            if(isNumeric(tokens[0])){
                color = tokens[1];
                radius = Integer.parseInt(tokens[0]) / 2;
            } else{
                    color = tokens[0];
                    radius = Integer.parseInt(tokens[1]);
                }
            cups.put(radius,color);
        }
        for(String color : cups.values()){
            System.out.println(color);
        }
        scanner.close();
    }
}
