import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Customer{
    private String id, name, roomCode, dayStart, dayEnd;

    public static int cnt = 0;

    public Customer(String name, String roomCode, String dayStart, String dayEnd) {
        this.id = "KH" + String.format("%02d",++cnt);
        this.name = name;
        this.roomCode = roomCode;
        this.dayStart = dayStart;
        this.dayEnd = dayEnd;
    }

    public int getDistanceDay(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date1 = LocalDate.parse(this.dayStart, formatter);
        LocalDate date2 = LocalDate.parse(this.dayEnd, formatter);
        return (int) ChronoUnit.DAYS.between(date1, date2);
    }

    @Override
    public String toString() {
        return this.id + " " + this.name + " " + this.roomCode + " " + this.getDistanceDay();
    }
}

public class danh_sach_luu_tru_J07046 {
    public static void main(String[] args) throws Exception{
        Scanner scn = new Scanner(new File("KHACH.in"));
        int t = scn.nextInt();
        scn.nextLine();
        ArrayList <Customer> arr = new ArrayList<>();
        while(t-- > 0){
            arr.add(new Customer(scn.nextLine(),scn.nextLine(),scn.nextLine(),scn.nextLine()));
        }
        Collections.sort(arr, new Comparator<Customer>() {
            public int compare(Customer o1, Customer o2){
                return o2.getDistanceDay() - o1.getDistanceDay();
            }
        });
        for(Customer x : arr){
            System.out.println(x);
        }
    }
}
