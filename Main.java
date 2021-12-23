package Flight;
import java.util.*;

public class Main {

   protected static void adminMethod(){
        Scanner sc= new Scanner(System.in);
        System.out.println(" Welcome Admin, What do you want to do next: ");
        System.out.println("[1 : Add flight ]");
        System.out.println("[2 : Remove flight]");
        System.out.println("[3 : Display all flights]");
        byte mainChoice=sc.nextByte();
        //Byte mainComp=-1;
        if(mainChoice==1){
            System.out.println("Scheduling a new flight\n ");
            System.out.print("Enter the flight number: ");
            int fli_num=sc.nextInt();
            sc.nextLine();
            System.out.print("Enter flight from City: ");
            String fli_from=sc.nextLine();
            //sc.nextLine();
            System.out.print("Enter flight Destination City: ");
            String fli_to=sc.nextLine();
            //sc.nextLine();
            System.out.print("Enter cost per ticket: ");
            int price=sc.nextInt();
            System.out.print("Enter flight date (dd-mm-yyyy): ");
            String fli_date=sc.nextLine();
            sc.nextLine();
            System.out.print("Enter flight time: ");
            //aasc.nextLine();
            String fli_tim=sc.nextLine();

        }
        else if(mainChoice==2){

        }
        else if(mainChoice==3){

        }
        else{
            System.out.println(" Invalid input ");
        }
    }

    static void passengerMethod(){
       

    }
        // main method
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        byte ch=1;


        while(ch==1){
            System.out.println("\n\nFlight Ticket Management System\n");
            System.out.println("-----------Welcome-----------\n");
            System.out.println("Are you a Passenger or Airline admin?");
            System.out.print("[Passenger: p] ; [Airline Admin: a], input: ");
            String inp=sc.nextLine();
            Byte pasWod=0;
            // paswod = 0 for invalid person for everything
            // paswod =1 for Airline Admin
            // paswod = 2 for Passenger
            if(inp.charAt(0) == 'A' || inp.charAt(0)=='a'){
                System.out.print("Enter Admin Password: ");
                String password=sc.nextLine();
                // if else for admin password check
                if(password.equals("meadmin")){
                    pasWod=1;
                    adminMethod();
                }
                else{
                    System.out.println("Incorrect password..Access denied");
                }
            }
            else if(inp=="P" || inp=="p"){
                pasWod=2;
                passengerMethod();
            }
            else{
                System.out.println(" Invalid input ");
            }

            ch=0;   // to break the main while loop
        }
    }
}
