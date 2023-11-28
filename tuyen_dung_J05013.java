import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class NhanVien{
    private String id, name;
    private double theory, practice;

    public static int cnt = 0;

    public NhanVien(String name, double theory, double practice) {
        this.id = "TS" + String.format("%02d", ++cnt);
        this.name = name;
        this.theory = (theory > 10 ? theory/10 : theory);
        this.practice = (practice > 10 ? practice/10 : practice);
    }

    public double avg(){
        return (this.theory + this.practice)/2; 
    }

    public String classify(){
        if(avg() < 5) return "TRUOT";
        else if(avg() < 8) return "CAN NHAC";
        else if(avg() <= 9.5) return "DAT";
        else return "XUAT SAC";
    }

    @Override
    public String toString(){
        return this.id + " " + this.name + " " + String.format("%.2f", avg()) + " " + this.classify();
    }
}

public class tuyen_dung_J05013 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        ArrayList<NhanVien> arr = new ArrayList<>();
        while(t-- >0){
            scn.nextLine();
            NhanVien x = new NhanVien(scn.nextLine(), scn.nextDouble(), scn.nextDouble());
            arr.add(x);
        }   
        Collections.sort(arr, new Comparator<NhanVien>(){
            @Override
            public int compare(NhanVien o1, NhanVien o2){
                return Double.compare(o2.avg(), o1.avg());
            }
        });

        for(NhanVien x : arr){
            System.out.println(x);
        }
    }
}
