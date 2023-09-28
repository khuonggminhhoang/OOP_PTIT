import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class GiangVien{
    private String id, name, major;

    public static int cnt = 0;

    public GiangVien(String name, String major) {
        this.id = "GV" + String.format("%02d",++cnt);
        this.name = name;
        this.major = major;
    }
    
    public String getFirstName(){
        return this.name.substring(this.name.lastIndexOf(' ') + 1);
    }

    public String getId(){
        return this.id;
    }

    public String compact(String s){
        String[] arr = s.trim().split("\\s+");
        String ans = "";
        for(String x : arr){
            ans += String.valueOf(x.charAt(0)).toUpperCase();
        }
        return ans;
    }

    @Override
    public String toString(){
        return this.id + " " + this.name + " " + this.compact(this.major);
    }
}

public class sap_xep_danh_sach_giang_vien_J05025 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        scn.nextLine();
        ArrayList<GiangVien> arr = new ArrayList<>();
        while(t-- >0){
            arr.add(new GiangVien(scn.nextLine(), scn.nextLine()));
        }   
        Collections.sort(arr, new Comparator<GiangVien>(){
            @Override
            public int compare(GiangVien o1, GiangVien o2){
                if(!o1.getFirstName().equals(o2.getFirstName())){
                    return o1.getFirstName().compareTo(o2.getFirstName());
                }
                else return o1.getId().compareTo(o2.getId());
            }
        });

        for(GiangVien x : arr){
            System.out.println(x);
        }
    }
}
