import java.nio.channels.CancelledKeyException;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

public class RejseKort {

    private int balance;
    private int checkInTime;
    private ArrayList<Integer> xLocations;
    private ArrayList<Integer> yLocations;


    public RejseKort(){
        this.balance = 100;
        checkInTime = -1;
        xLocations = new ArrayList<>();
        yLocations = new ArrayList<>();
    }

    public void depositMoney(int dkk){
        if(dkk>=0){
            balance += dkk;
            System.out.println( dkk + " DKK deposited. New balance: " + balance + " DKK");
        }else if(dkk==0) System.out.println("0 DKK deposited. New balance: " + balance + " DKK");
        else System.out.println("Error: Cannot deposit negative amount");
    }

    public boolean isCheckedIn(int timeStamp){
        if ((timeStamp - checkInTime <= 120) && (checkInTime != -1)) return true;
        else return false;
    }
     
    public void checkIn(int x, int y, int timeStamp){
        if(balance >= 100){
            xLocations.add(x);
            yLocations.add(y);
            if(!isCheckedIn(timeStamp)){
                this.checkInTime = timeStamp;
                System.out.println("Checked in");
            } else {
                System.out.println("Continued journey (" + (timeStamp - checkInTime) + " minutes since last check in)");
                this.checkInTime = timeStamp;
            }
        } else System.out.println("Not enough money in account to check in. Please deposit at least " + (100 - balance) + " DKK");
    }

    public static int maxMinusMin(ArrayList<Integer> x) {
        int max = 0;
        int min = x.get(0);
        for (Integer i : x) {
            if(i>max) max = i;   
            if(i<min) min = i;
        }
        return max-min;
    }

    public int ticketPrice(){
        int price = (12 + (maxMinusMin(xLocations) + maxMinusMin(yLocations))*3);
        if(price < 12) return 12;
        if(price > 50) return 50;
        return price;
    }


    public void checkOut(int x, int y, int timeStamp){
        if(isCheckedIn(timeStamp)) {
                xLocations.add(x);
                yLocations.add(y);
                System.out.println("Checked out! " + (timeStamp - checkInTime) + " minutes since last check in. Price is " + ticketPrice() + " DKK, remaining balance is " + (balance - ticketPrice()) + " DKK") ;
                checkInTime = -1;
                balance -= ticketPrice();
        } else System.out.println("Error: Cannot check out; Not currently checked in");
    }


    public static void main(String[] args) {
       
    }
}
