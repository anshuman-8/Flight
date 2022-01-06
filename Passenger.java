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
                 System.out.print("Enter Number of passenger : ");
                 int yn = sc.nextInt();
                 sc.nextLine();
                 System.out.println("Final details : ");
                 System.out.println("  FLight "+index.get(j).getNum()+"  "+index.get(j).getFroDesti()+" -> "+index.get(j).getToDesti());
                 System.out.println("  On "+index.get(j).getFdate()+",  "+index.get(j).getFtime());
                 System.out.println(" Total Price "+index.get(j).getFprice()*yn+"  ("+yn+" passenger/s)\n");
                 int cost=index.get(j).getFprice()*yn;
                 System.out.println("Want to Enjoy on Flight unlimited meal? (Rs.450 per Passenger)");
                 System.out.println("[ Y :Yes]   [ N : NO]");
                 String meal=sc.nextLine();
                 if(meal.charAt(0)=='Y' || meal.charAt(0)=='y'){
                     System.out.println("\n Total cost : "+(cost+(450*yn))+"\n\n");
                     cost=cost+(450*yn);
                 }
                 Main.drama(" Opening Payment Portal ");


             }
         }
     }
}