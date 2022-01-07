package Flight;


import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class Passenger {
    String name;
    int age;


}
class Booking extends Passenger {
        int pflightnum;
        int passengers;
        boolean snack;
        int pnr;
        static int n=1;

    public static ArrayList<Booking> khata=new ArrayList<Booking>();

        Booking(String name, int pflightnum, int passengers, boolean snack,int pnr){
            this.name=name;
            this.passengers=passengers;
            this.pflightnum=pflightnum;
            this.snack=snack;
            this.pnr=pnr;
            n+=1;

    }
     public static void book(int num,ArrayList<Flight> index,String name){
         Scanner sc=new Scanner(System.in);
         try{
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
                 boolean sna=false;
                 if(meal.charAt(0)=='Y' || meal.charAt(0)=='y'){
                     System.out.println("\n Total cost : "+(cost+(450*yn))+"\n\n");
                     cost=cost+(450*yn);
                     sna=true;
                 }
                 Main.drama(" Opening Payment Portal ");
                 boolean p=payment(cost,index);
                 if (p){
                     System.out.println("\n your booking is complete");
                     int pnr=n;
                     System.out.println("Your PNR is "+pnr);
                     Booking b= new Booking(name,num,yn,sna,pnr);
                     khata.add(b);
                     System.out.println("\nDo you want to download Ticket : ");
                     System.out.println("[Y : yes]  [N : No]");
                     String tic=sc.nextLine();
                     if (tic.charAt(0)=='Y' || tic.charAt(0)=='y'){
                         ticket(name,pnr,j,meal,yn,cost);
                         System.out.println("\nTicket has been downloaded ");
                     }
                 }

             }
         }}catch (Exception e){
             System.out.println("done payment");
         }
     }

     public static boolean payment(int cost,ArrayList<Flight> index) {
         Scanner sc = new Scanner(System.in);
         Main.drama("Connecting");
         System.out.println("\nEnter your Paymentmethod:");
         System.out.println("[C : Card]   [A : AmritaPay]");
         String pay = sc.nextLine();

         if (pay.charAt(0) == 'c' || pay.charAt(0) == 'C') {
             System.out.print("Enter Name on Card:");
             String nam = sc.nextLine();
             System.out.print("Enter Card Number: ");
             String cardn = sc.nextLine();
             System.out.print("Enter Expiry date: ");
             String cardd = sc.nextLine();
             System.out.print("Enter CVV: ");
             int cardps = sc.nextInt();
             System.out.println("Making paymaent for " + cost + "\n");
             Main.drama("Processing ");
             Main.drama("Making Payment ");
             System.out.println("\n Done");
             System.out.println("Thank you, Happy journey");
             return true;

         } else if (pay.charAt(0) == 'A' || pay.charAt(0) == 'a') {
             System.out.println("Glad to see you here");
             System.out.println("We offer 5% off for all our customers\n");
             System.out.println("Making payment for " + (cost * (0.95f)));
             System.out.print("Enter your AmritaPay User ID :");
             String id = sc.nextLine();
             Main.drama("Processing");
             System.out.println("\nPayment complete");
             System.out.println("Thank you for using AmritaPay ");
                return true;
         }
         else{
             System.out.println("Wrong input,,,closing payment gateway");
             return false;
         }

     }
     static void ticket(String name,int pnr,int j, String snack,int passengers, int cost ){
            try {
                File ticketfile = new File("/home/anshuman/Downloads/Ticket.txt");
                ticketfile.createNewFile();
                FileWriter writer=new FileWriter(ticketfile);
                writer.write("Ticket");
                writer.append("\n\n\n-----------***Amrita Airlines***--------------\n\n\n");
                writer.append(" Passengr name : "+name+"      Passenger(s): "+passengers+"\n");
                writer.append(" PNR :"+pnr+"\n");
                writer.append(" \nFlight Details: \n");
                writer.append(" Flight Number : "+Main.index.get(j).getNum()+"     From "+Main.index.get(j).getFroDesti()+"  to "+Main.index.get(j).getToDesti()+"\n");
                writer.append(" Date "+Main.index.get(j).getFdate()+"    Time : "+Main.index.get(j).getFtime()+"\n");
                writer.append(" \n On flight food: "+snack+"\n");
                writer.append("  Total cost : "+cost);
                writer.append("     \nHappy Journey !!!");
                Main.drama("Downloading ");
                writer.close();
            }catch (Exception e){
                System.out.println(" Sorry, some error occurred while Download");
            }
     }
}