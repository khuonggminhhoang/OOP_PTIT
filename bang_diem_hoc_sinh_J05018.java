import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class HocSinh{
    private String id, name;
    private double p1, p2, p3, p4, p5, p6, p7, p8, p9, p10;

    public static int cnt = 0;
    public HocSinh(String name, double p1, double p2, double p3, double p4, double p5, double p6, double p7, double p8,
            double p9, double p10) {
        this.id = "HS" + String.format("%02d", ++cnt);
        this.name = name;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.p5 = p5;
        this.p6 = p6;
        this.p7 = p7;
        this.p8 = p8;
        this.p9 = p9;
        this.p10 = p10;
    }

    public double avg(){
        return (p1 * 2 + p2 * 2 + p3 + p4 + p5 + p6 + p7 + p8 + p9 + p10)*1.0/12;
    }

    public String classity(){
        double tmp = avg();
        if(tmp >= 9) return "XUAT SAC";
        else if( 8 <= tmp && tmp <= 8.9) return "GIOI";
        else if( 7 <= tmp && tmp <= 7.9) return "KHA";
        else if( 5 <= tmp && tmp <= 6.9) return "TB";
        else return "YEU";
    }

    @Override
    public String toString(){
        return this.id + " " + this.name + " " + Math.round(avg() * 10)/10.0 + " " + this.classity();
    }
}

public class bang_diem_hoc_sinh_J05018 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        ArrayList<HocSinh> arr = new ArrayList<>();
        while(t-- >0){
            scn.nextLine();
            arr.add(new HocSinh(scn.nextLine(), scn.nextDouble(), scn.nextDouble(), scn.nextDouble(), scn.nextDouble()
            , scn.nextDouble(), scn.nextDouble(), scn.nextDouble(), scn.nextDouble()
            , scn.nextDouble(), scn.nextDouble()));
        }   

        Collections.sort(arr, new Comparator<HocSinh>(){
            @Override
            public int compare(HocSinh o1, HocSinh o2){
                if(o1.avg() > o2.avg()) return -1;
                else return 1;
            }
        });

        for(HocSinh x : arr){
            System.out.println(x);
        }
    }
}
