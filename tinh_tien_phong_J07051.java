import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Customer{
    private String id, name, room, dateStart, dateEnd;
    private int serviceCost;

    public static int cnt = 0;

    public Customer(String name, String room, String dateStart, String dateEnd, int serviceCost) {
        this.id = "KH" + String.format("%02d", ++cnt);
        this.name = nameStd(name);
        this.room = room;
        this.dateStart = dayStd(dateStart);
        this.dateEnd = dayStd(dateEnd);
        this.serviceCost = serviceCost;
    }

    private String dayStd(String s){
        StringBuilder sb = new StringBuilder(s);
        if(sb.charAt(1) == '/'){
            sb.insert(0,'0');
        }
        if(sb.charAt(4) == '/'){
            sb.insert(3,'0');
        }
        return sb.toString();
    }

    public int dayDistance(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date1 = LocalDate.parse(this.dateStart, formatter);
        LocalDate date2 = LocalDate.parse(this.dateEnd, formatter);
        return (int) ChronoUnit.DAYS.between(date1, date2) + 1;
    }

    public int fee(){
        char c = this.room.charAt(0);
        int price = 0;
        if(c == '1') price = 25;
        else if(c == '2') price = 34;
        else if(c == '3') price = 50;
        else price = 80;
        return price * this.dayDistance() + this.serviceCost;
    }

    private String nameStd(String s){
        String ans  = "";
        String[] arr = s.trim().split("\\s+");
        for(String x : arr){
            ans += Character.toUpperCase(x.charAt(0)) + x.substring(1).toLowerCase() + " ";
        }
        return ans.substring(0, ans.length() - 1);
    }

    @Override
    public String toString() {
        return this.id + " " + this.name + " " + this.room + " " + this.dayDistance() + " " + this.fee();
    }    
}

public class tinh_tien_phong_J07051 {
    public static void main(String[] args) throws Exception{
        Scanner scn = new Scanner(new File("KHACHHANG.in"));
        int t = Integer.parseInt(scn.nextLine());
        ArrayList<Customer> arr = new ArrayList<>();
        while(t-- > 0){
            Customer a = new Customer(scn.nextLine(), scn.nextLine(), scn.nextLine(),scn.nextLine(), Integer.parseInt(scn.nextLine()));
            arr.add(a);
        }   
        Collections.sort(arr, new Comparator<Customer>() {

            @Override
            public int compare(Customer o1, Customer o2) {
                return o2.fee() - o1.fee();
            }
            
        });
        for(Customer x : arr){
            System.out.println(x);
        }
    }
}
