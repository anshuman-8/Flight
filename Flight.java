package Flight;

import java.sql.Time;
import java.util.ArrayList;
import java.util.*;


public class Flight {

    private String froDesti;
    private int num;
    private String toDesti;
    private String ftime;
    private String fdate;
    private int fprice;
    static int count;

    public Flight(int num,String froDesti, String toDesti, String ftime, String fdate, int price){
        if (toDesti.equals(froDesti)) {
            throw new IllegalArgumentException("destination and origin are the same");
        }
        this.num=num;
        this.froDesti=froDesti;
        this.toDesti=toDesti;
        this.ftime=ftime;
        this.fdate=fdate;
        this.fprice=price;
    }


    public String getFroDesti() {
        return froDesti;
    }

    public void setFroDesti(String froDesti) {
        this.froDesti = froDesti;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getToDesti() {
        return toDesti;
    }

    public void setToDesti(String toDesti) {
        this.toDesti = toDesti;
    }

    public String getFtime() {
        return ftime;
    }

    public void setFtime(String ftime) {
        this.ftime = ftime;
    }

    public String getFdate() {
        return fdate;
    }

    public void setFdate(String fdate) {
        this.fdate = fdate;
    }

    public int getFprice() {
        return fprice;
    }

    public void setFprice(int fprice) {
        this.fprice = fprice;
    }
    public static int getCount(){
        return count;
    }

    @Override
    public String toString() {
        String one = "Flight " + num;
        String two = "  From " + froDesti + " -> to " + toDesti;
        String mid= "  On " +fdate;
        String three = "  At " + ftime;
        String four = "  Original price: " + fprice + " Rs.";
        return one + two +mid+ three + four;
    }
    public String toPrint(){
        String one = "Flight " + num;
        String two = "  From " + froDesti + " -> to " + toDesti;
        String three = "  At " + ftime;
        return one + two + three ;
    }

}
