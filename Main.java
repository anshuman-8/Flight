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

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        byte ch=1;


        while(ch==1){
            System.out.println("\n\nFlight Ticket Management System\n");
            System.out.println("-----------Welcome-----------\n");
            System.out.println("Are you a Passenger or Airline admin?");
            System.out.println("[Passenger: p] ; [Airline Admin: a]");
            Byte pasWod=0;
            // paswod = 0 for invalid person for everything
            // paswod =1 for Airline Admin
            // paswod = 2 for Passenger
            sc.nextLine();
            String in=sc.toString();
            if(in=="A" || in=="a"){
                System.out.print("Enter Admin Password: ");
                String password=sc.toString();
                // if else for admin password check
                if(password=="meadmin"){
                    pasWod=1;
                    adminMethod();
                }
                else{
                    System.out.println("Incorrect password..Access denied");
                }
            }
            else if(in=="P" || in=="p"){
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
