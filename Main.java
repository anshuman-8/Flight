package Flight;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        byte ch=1;
        while(ch==1){
            System.out.println("\n\nFlight Ticket Management System\n");
            System.out.println("-----------Welcome-----------\n");
            System.out.println("Are you a Passenger or Airline admin?");
            System.out.println("[Passenger: p] ; [Airline Admin: a]");
            sc.nextLine();
            String in=sc.toString();

            ch=0;
        }
    }
}
