import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class NhanVien{
    private String id, name;
    private int daySalary, workDay;
    private String position;

    public static int cnt = 0;
    public NhanVien(String name, int daySalary, int workDay, String position) {
        this.id = "NV"+ String.format("%02d", ++cnt);
        this.name = name;
        this.daySalary = daySalary;
        this.workDay = workDay;
        this.position = position;
    }

    public int salary(){
        return this.daySalary * this.workDay;
    }

    public int bonus(){
        if(this.workDay >= 25) return this.salary()/5;
        else if(this.workDay >= 22) return this.salary()/10;
        else return 0;
    }

    public int allowance(){
        String s = this.position;
        if(s.equals("GD")) return 250000;
        else if(s.equals("PGD")) return 200000;
        else if(s.equals("TP")) return 180000;
        else return 150000;
    }

    public int total(){
        return this.salary() + this.bonus() + this.allowance();
    }

    @Override
    public String toString(){
        return this.id + " "+ this.name + " " + this.salary() + " " + this.bonus() + " " + this.allowance() + " " + this.total();
    }
} 

public class sap_xep_bang_tinh_cong_J05041 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        scn.nextLine();
        ArrayList<NhanVien> arr = new ArrayList<>();
        while(t-- >0){
            NhanVien nv = new NhanVien(scn.nextLine(), Integer.parseInt(scn.nextLine()), Integer.parseInt(scn.nextLine()), scn.nextLine());
            arr.add(nv);
        }   
        Collections.sort(arr, new Comparator<NhanVien>(){
            @Override
            public int compare(NhanVien o1, NhanVien o2){
                return (int) o2.total() - o1.total();
            }
        });
        for(NhanVien x : arr){
            System.out.println(x);
        }
    }
}
