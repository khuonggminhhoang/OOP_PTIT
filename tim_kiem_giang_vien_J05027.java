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

    public String getName(){
        return this.name;
    }
    
    public String compact(){
        String s = this.major;
        String[] arr = s.trim().split("\\s+");
        String ans = "";
        for(String x : arr){
            ans += String.valueOf(x.charAt(0)).toUpperCase();
        }
        return ans;
    }

    @Override
    public String toString(){
        return this.id + " " + this.name + " " + this.compact();
    }
}

public class tim_kiem_giang_vien_J05027 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        scn.nextLine();
        ArrayList<GiangVien> arr = new ArrayList<>();
        while(t-- >0){
            arr.add(new GiangVien(scn.nextLine(), scn.nextLine()));
        }   
        int q = scn.nextInt();
        scn.nextLine();
        while(q-- > 0){
            String tmp = scn.nextLine();
            System.out.println("DANH SACH GIANG VIEN THEO TU KHOA " + tmp + ":");
            String s = tmp.toLowerCase();
            for(GiangVien x : arr){
                if(x.getName().toLowerCase().contains(s)){
                    System.out.println(x);
                }
            }
        }
    }
}
