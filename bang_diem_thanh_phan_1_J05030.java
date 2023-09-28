import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class SinhVien{
    private String id, name, classs;
    private double m1, m2, m3;
    public SinhVien(String id, String name, String classs, double m1, double m2, double m3) {
        this.id = id;
        this.name = name;
        this.classs = classs;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
    }

    public String getId(){
        return this.id;
    } 

    @Override
    public String toString(){
        return this.id + " " + this.name + " " + this.classs + " "+ String.format("%.1f %.1f %.1f", m1, m2, m3);
    }
}

public class bang_diem_thanh_phan_1_J05030 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        ArrayList<SinhVien> arr = new ArrayList<>();
        while(t-- >0){
            scn.nextLine();
            arr.add(new SinhVien(scn.nextLine(),scn.nextLine(), scn.nextLine(), scn.nextDouble(), scn.nextDouble(), scn.nextDouble()));
        }   
        Collections.sort(arr, new Comparator<SinhVien>(){
            @Override
            public int compare(SinhVien o1, SinhVien o2){
                return o1.getId().compareTo(o2.getId());
            }
        }); 
        for(int i=0; i< arr.size(); ++i){
            System.out.println((i + 1) + " " + arr.get(i));
        }
    }
}
