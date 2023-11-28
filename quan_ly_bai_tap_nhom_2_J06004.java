import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class SinhVien{
    private String id, name, phone;
    private int ordGr;
    public SinhVien(String id, String name, String phone, int ordGr) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.ordGr = ordGr;
    }

    public String getId(){
        return this.id;
    }

    public int getOrdGr(){
        return this.ordGr;
    }

    @Override
    public String toString(){
        return this.id + " " + this.name + " " + this.phone;
    }
}


public class quan_ly_bai_tap_nhom_2_J06004 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        int n = scn.nextInt();
        ArrayList<SinhVien> arr = new ArrayList<>();
        while(t-- >0){
            scn.nextLine();
            arr.add(new SinhVien(scn.nextLine(), scn.nextLine(), scn.nextLine(), scn.nextInt()));
        }   
        Collections.sort(arr, new Comparator<SinhVien>(){
            @Override
            public int compare(SinhVien o1, SinhVien o2){
                return o1.getId().compareTo(o2.getId());
            }
        });


        scn.nextLine();
        String[] a = new String[n + 1];
        for(int i = 1; i < n + 1; ++i){
            a[i] = scn.nextLine();
        }

        for(SinhVien x : arr){
            System.out.println(x + " " + x.getOrdGr() + " " + a[x.getOrdGr()]);
        }
    }   
}
