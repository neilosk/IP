// import java.util.Scanner;
// import java.util.ArrayList;

// public class BookaRoom {
//     public static void main(String[] args){

//     java.util.Scanner scanner = new Scanner(System.in);
//     int r = scanner.nextInt();
//     int n = scanner.nextInt();

//     if(n>=r){
//         System.out.println("too late");
//         scanner.close();
//         return;
//         }

//     ArrayList<Integer> bookedRooms = new ArrayList<>();
//     for (int i = 0;  i<n;  i++) {
//         int roomNumber = scanner.nextInt();
//         bookedRooms.add(roomNumber);
//     }

//     int guess = 1;
//     while(true){
//         if(!bookedRooms.contains(guess)){
//         System.out.println(guess);
//         break;
//         }
//         guess++;
//     }
//     scanner.close();

//     }
// }
