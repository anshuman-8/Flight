package Flight;
import java.util.*;

public class Main {
//--------------------------------------------------------------------------------------------------------------------------------admin
   protected static void adminMethod(){
        Flight[] index=new Flight[100];
        Scanner sc= new Scanner(System.in);
        System.out.println(" Welcome Admin, What do you want to do next: ");
        System.out.println("[1 : Add flight ]");
        System.out.println("[2 : Remove flight]");
        System.out.println("[3 : Display all flights]");
        byte mainChoice=sc.nextByte();
        //ArrayList flightRef=new ArrayList();
        //Byte mainComp=-1;
        if(mainChoice==1){
//            char a=(char) Flight.getNum();
            //ArrayList newFlight=new ArrayList();
            System.out.println("Scheduling a new flight\n ");
            System.out.print("Enter the flight number: ");
            int fli_num=sc.nextInt();
//            newFlight.add(fli_num);
            sc.nextLine();
            System.out.print("Enter flight from City: ");
            String fli_from=sc.nextLine();
//            newFlight.add(fli_from);
            System.out.print("Enter flight Destination City: ");
            String fli_to=sc.nextLine();
//            newFlight.add(fli_to);
            System.out.print("Enter cost per ticket: ");
            int price=sc.nextInt();
//            newFlight.add(price);
            sc.nextLine();
            System.out.print("Enter flight date (dd-mm-yyyy): ");
            String fli_date=sc.nextLine();
//            newFlight.add(fli_date);
            System.out.print("Enter flight time: ");
            //aasc.nextLine();
            String fli_tim=sc.nextLine();
            index[Flight.getCount()]=new Flight(fli_num,fli_from,fli_to,fli_tim,fli_date,price,Flight.count+1);
            System.out.println("\n"+index[Flight.getCount()-1].toString());
//            newFlight.add(fli_tim);
            //System.out.print("Enter Flight Code(Should be unique): ");
           // ArrayList flightRef[1]=new ArrayList();
            System.out.println("New flight added to Amrita Domestic\n");
//            System.out.println(newFlight);
//            flightMain.add(newFlight);
            //Flight refVar= new Flight(newFlight);

        }
        else if(mainChoice==2){

        }
        else if(mainChoice==3){
            int tot=0;
            for (int i=0;i<100;i++){
//              try {
//                  System.out.println("\n " + index[i].getNum() + "" + index[i].getFroDesti() + "" + index[i].getToDesti() + "" + index[i].getFprice() + "" + index[i].getFdate() + "" + index[i].getFtime() + "");
//                  tot++;
//              }
//              catch (Exception e){
//                  Exception vcxfg=e;
//              }
                System.out.println(index[i].toString());
                tot++;
            }
            System.out.println("\ntotal "+tot+" displayed");
        }
        else{
            System.out.println(" Invalid input ");
        }
    }
// -----------------------------------------------------------------------------------------------------------------------------------passenger
    protected static void passengerMethod(){
        System.out.println("\n--Hello!  Welcome to --***Amrita Airlines***--\n ");


    }

    //---------------------------------------------------------------------------------------------------------------------------------main
        // main method
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        byte ch=1;

        while(ch==1){
            System.out.println("\n\n---***Amrita Airlines***---");
            System.out.println("\nFlight Ticket Management System\n");
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
            System.out.println("Do you want to continue? ");
            System.out.print("[Y:yes]  [N: Exit] : ");
            String che=sc.nextLine();
            if (che.charAt(0)=='n'|| che.charAt(0)=='N'){
                System.out.println("\nThank you");
                ch=0;
            }
            //ch=0;   // to break the main while loop
        }
    }
}
