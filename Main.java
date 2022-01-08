package Flight;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {

    public static ArrayList<Flight> index=new ArrayList<Flight>();

    protected static void drama(String text){ // just to waste 3 seconds
        System.out.print(text);
        try{
            TimeUnit.SECONDS.sleep(1);
            System.out.print(".");
            TimeUnit.SECONDS.sleep(1);
            System.out.print(".");
            TimeUnit.SECONDS.sleep(1);
            System.out.println(".\n");}
        catch(Exception e){
            System.out.println();
        }
    }

//--------------------------------------------------------------------------------------------------------------------------------admin

   protected static void adminMethod(){
        byte ach=1;
        while (ach==1) {
            Scanner sc = new Scanner(System.in);
            System.out.println(" Welcome Admin, What do you want to do next: ");
            System.out.println("[1 : Add flight ]");
            System.out.println("[2 : Remove flight]");
            System.out.println("[3 : Display all flights]");
            System.out.println("[4 : Exit(logout of admin)]");
            byte mainChoice = sc.nextByte();
            if (mainChoice == 1) {
                System.out.println("Scheduling a new flight\n ");
                System.out.print("Enter the flight number: ");
                int fli_num = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter flight from City: ");
                String fli_from = sc.nextLine().toLowerCase();

                System.out.print("Enter flight Destination City: ");
                String fli_to = sc.nextLine().toLowerCase();

                System.out.print("Enter cost per ticket: ");
                int price = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter flight date (dd-mm-yyyy): ");
                String fli_date = sc.nextLine();

                System.out.print("Enter flight time: ");

                String fli_tim = sc.nextLine();
                Flight fli = new Flight(fli_num, fli_from, fli_to, fli_tim, fli_date, price);
                index.add(fli);
                System.out.println("\n" + fli.toString() + "\n");
                drama(" Adding");
                System.out.println("New flight added to Amrita Domestic\n");

            }
            else if(mainChoice==4){
                    ach=0;
                    drama("Logging out Admin ");
            }
            else if (mainChoice == 2) {
                System.out.print("\nEnter The Flight number to be remove: ");
                int n = sc.nextInt();
                sc.nextLine();
                for (int j = 0; j < 200; j++) {
                    if (index.get(j).getNum() == n) {
                        String fli = index.get(j).toPrint();
                        System.out.println(fli);
                        System.out.println("Do you really want to Delete this Flight ? ");
                        System.out.print("[yes: Y]  [No: N]  :");
                        String yn = sc.nextLine();
                        if (yn.charAt(0) == 'Y' || yn.charAt(0) == 'y') {
                            index.remove(j);
                            drama("Deleting ");
                            System.out.println("\n" + fli + " Has been Deleted\n ");
                            break;
                        } else if (yn.charAt(0) == 'N' || yn.charAt(0) == 'n') {
                            break;
                        }
                    }
                }


            } else if (mainChoice == 3) {
                int tot = 0;
                try {
                    for (int i = 0; i < 100; i++) {
                        System.out.println("\n" + index.get(i).toString());
                        tot++;
                    }
                } catch (Exception e) {
                    System.out.println("total " + tot + " displayed\n");
//                    System.out.println("Do Want to Continue as ADMIN or exit(logout) ");
                }


            } else {
                System.out.println(" Invalid input ");
            }

        }
    }
// -----------------------------------------------------------------------------------------------------------------------------------passenger
    protected static void passengerMethod() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n  Welcome to --***Amrita Airlines***--\n ");
        System.out.print("Enter your name : ");
        String name = sc.nextLine();
        byte pch=1;
        while (pch==1) {
            System.out.println(" Hello " + name + " what would you like to do next: ");
            System.out.println("[1 : Search & Book flight ]");
            System.out.println("[2 : Check PNR status]");
            System.out.println("[3 : Cancel ticket ]");
            System.out.println("[4 : LogOut of " + name + " ]");
            byte mainChoice = sc.nextByte();
            sc.nextLine();

            if (mainChoice == 1) {
                boolean ch = true;
                while (ch == true) {
                    System.out.print("Enter From City : ");
                    String from = sc.nextLine().toLowerCase();
                    System.out.print("Enter the Destination City : ");
                    String to = sc.nextLine().toLowerCase();
                    System.out.print("Enter The Date of Travel(DD-MM-YYYY) : ");
                    String date = sc.nextLine();
                    int f = 0;
                    try {
                        System.out.println("Searching for flight from " + from + " to " + to + " on " + date);
                        drama("Searching");
                        for (int j = 0; j < 200; j++) {
                            String q = index.get(j).getFroDesti();
                            String w = index.get(j).getToDesti();
                            String dae = index.get(j).getFdate();
                            if ((q.equals(from)) && (w.equals(to)) && (dae.equals(date))) {
                                System.out.println("All the Flights : ");
                                String fli = index.get(j).toString();
                                System.out.println(fli);
                                f++;
                            }
                        }
                    } catch (Exception n) {
                        if (f == 0) {
                            System.out.println(" No result found,  Try searching for other dates ");
                            System.out.print("[Y : Search other flights]    [N : Exit]");
                            String c = sc.nextLine();
                            if (c.charAt(0) == 'Y' || c.charAt(0) == 'y') {
                                System.out.println();
                            } else if (c.charAt(0) == 'N' || c.charAt(0) == 'n') {
                                ch = false;
                            } else {
                                System.out.println("invalid response");
                            }

                        } else {
                            System.out.println(f + " Flights available \n");
                            System.out.print("Enter the flight Number to choose: ");
                            int choseNum = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Do you want to continue booking ?");
                            System.out.println("[Y : Booking]  [A : Search for another flight]  [N : Exit]");
                            String c = sc.nextLine();
                            if (c.charAt(0) == 'Y' || c.charAt(0) == 'y') {
                                Booking.book(choseNum, index, name);
                                break;
                            } else if (c.charAt(0) == 'N' || c.charAt(0) == 'n') {
                                ch = false;
                            } else if (c.charAt(0) == 'A' || c.charAt(0) == 'a') {
                                System.out.println();
                            } else {
                                System.out.println("invalid response");
                            }

                        }
                    }
                }
            } else if (mainChoice == 2) {
                System.out.println("Searching pnr");
                drama("Searching ");
                try {
                    for (int i = 0; i < 200; i++) {
                        if (Booking.khata.get(i).getName() == name) {
                            Booking.displayTic(i);
                        }
                    }
                } catch (Exception e) {
                }
            } else if (mainChoice == 3) {
                System.out.println("Deleting ticket");
                System.out.println("Do you want to delete your ticket?");
                System.out.println("[Yes : Y]   [No : N]");
                String delch = sc.nextLine();
                if (delch.charAt(0) == 'y' || delch.charAt(0) == 'Y') {
                    drama(" Deleting ");
                    Booking.delTicket(name);
                    System.out.println("Your Ticket has been deleted \n");
                }
            }else if(mainChoice==4){
                pch=0;
                System.out.println("Logging out ");
            }
            else {
                System.out.println("Invalid input ");
            }
        }
    }

    //---------------------------------------------------------------------------------------------------------------------------------main
        // main method
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        byte ch=1;

        //healper
        Flight fli=new Flight(233,"kochi","delhi","0800hrs","21-01-2022",7599);
        index.add(fli);
        fli=new Flight(256,"delhi","kolkata","1300hrs","21-01-2022",6999);
        index.add(fli);
        fli=new Flight(345,"chennai","mumbai","0700hrs","21-01-2022",5999);
        index.add(fli);
        fli=new Flight(513,"pune","srinagar","1630hrs","21-01-2022",7599);
        index.add(fli);

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
                System.out.print("Enter Admin Password: ");  // Password is meadmin
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
            else if(inp.charAt(0) == 'P' || inp.charAt(0)=='p'){
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
