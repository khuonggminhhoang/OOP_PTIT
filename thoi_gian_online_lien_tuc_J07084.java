import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


class SinhVien{
    private String fullname;
    private String timeStart, timeEnd;
    public SinhVien(String fullname, String timeStart, String timeEnd) {
        this.fullname = fullname;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
    }

    public int amount(){
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime date1 = LocalDateTime.parse(this.timeStart, pattern);
        LocalDateTime date2 = LocalDateTime.parse(this.timeEnd, pattern);
        return (int) ChronoUnit.MINUTES.between(date1, date2);
    }

    public String getFullName(){
        return this.fullname;
    }

    @Override
    public String toString(){
        return this.fullname + " " + this.amount();
    }
}

public class thoi_gian_online_lien_tuc_J07084 {
    public static void main(String[] args) throws Exception{
        Scanner scn = new Scanner(new File("ONLINE.in"));
        int t = Integer.parseInt(scn.nextLine());
        ArrayList<SinhVien> arr = new ArrayList<>();
        while(t-- > 0){
            arr.add(new SinhVien(scn.nextLine(), scn.nextLine(), scn.nextLine()));
        }
        Collections.sort(arr, new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien o1, SinhVien o2){
                if(o1.amount() != o2.amount()){
                    return o2.amount() - o1.amount();
                }
                else return o1.getFullName().compareTo(o2.getFullName());
            }
        });

        for(SinhVien x : arr){
            System.out.println(x);
        }
    }
}
