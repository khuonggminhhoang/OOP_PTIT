import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class SinhVien{
    private String id, name, classs, email;

    private String nameStd(String s){
        String ans = "";
        String[] arr = s.trim().split("\\s+");
        for(String x : arr){
            ans += Character.toUpperCase(x.charAt(0)) + x.substring(1).toLowerCase() + " ";
        }
        return ans.substring(0,ans.length() - 1);
    }

    public SinhVien(String id, String name, String classs, String email) {
        this.id = id;
        this.name = name;
        this.classs = classs;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return this.id + " " + nameStd(this.name) + " " + this.classs + " " + this.email;
    }
}

public class danh_sach_sinh_vien_trong_file_1 {
    public static void main(String[] args){
        try {
            Scanner scn = new Scanner(new File("SINHVIEN.in"));
            int t = Integer.parseInt(scn.nextLine());
            ArrayList<SinhVien> arr = new ArrayList<>();
            while(t-- > 0){
                SinhVien sv = new SinhVien(scn.nextLine(), scn.nextLine(), scn.nextLine(), scn.nextLine());
                arr.add(sv);
            }
            Collections.sort(arr, new Comparator<SinhVien>(){

                @Override
                public int compare(SinhVien o1, SinhVien o2) {
                    return o1.getId().compareTo(o2.getId());
                }
                
            });
            for(SinhVien x : arr){
                System.out.println(x);
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
