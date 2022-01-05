package Flight;


import java.util.*;

public class Passenger {
    String name;
    int age;
    String pnr;


}
class Booking extends Passenger {

     public static void book(int num,ArrayList<Flight> index){
         Scanner sc=new Scanner(System.in);
         for(int j=0;j<200;j++){
             if(index.get(j).getNum()==num) {
                 String fli = index.get(j).toPrint();
                 System.out.println(fli);
                 System.out.println("Enter Number of passenger : ");
                 int yn = sc.nextInt();
                 sc.nextLine();
             }
         }
     }
}