package WhichIsGreater;

import java.util.Scanner;

public class Main {
    public static void main(String[]args){
    Scanner greater = new Scanner(System.in);

    int a = greater.nextInt();
    int b = greater.nextInt();

    if(a>0 && b>0){
    if (a>b){
    System.out.println("1");
    }     else {
        System.out.println("0");
        }
        }
    }
}
