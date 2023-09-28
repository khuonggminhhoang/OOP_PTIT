import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class SinhVien{
    private String id, name, dateOfBirth, classs;
    private double gpa;

    public static int cnt = 0;

    public SinhVien(String name, String classs, String dateOfBirth,  double gpa) {
        this.id = "B20DCCN" + String.format("%03d", ++cnt);
        this.name = nameStd(name);
        this.dateOfBirth = dayStd(dateOfBirth);
        this.classs = classs;
        this.gpa = gpa;
    }

    private String dayStd(String s){
        StringBuilder sb = new StringBuilder(s);
        if(sb.charAt(1) == '/'){
            sb.insert(0,'0');
        }
        if(sb.charAt(4) == '/'){
            sb.insert(3,'0');
        }
        return sb.toString();
    }

    private String nameStd(String s){
        String[] arr = s.trim().split("\\s+");
        String ans = "";
        for(String x : arr){
            ans += Character.toUpperCase(x.charAt(0)) + x.substring(1).toLowerCase() + " ";
        }
        return ans.substring(0, ans.length() - 1);
    }

    public double getGpa(){
        return this.gpa;
    }

    @Override
    public String toString() {
        return this.id + " " + this.name + " " + this.classs + " " + this.dateOfBirth + " " + String.format("%.2f", this.gpa);
    }
    
}

public class danh_sach_doi_tuong_sinh_vien_3_J05005 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        ArrayList<SinhVien> arr = new ArrayList<>();
        while(t-- >0){
            scn.nextLine();
            SinhVien sv = new SinhVien(scn.nextLine(),scn.nextLine(), scn.nextLine(), scn.nextDouble());
            arr.add(sv);
        }
        Collections.sort(arr, new Comparator<SinhVien>(){
            public int compare(SinhVien o1, SinhVien o2){
                if(o1.getGpa() > o2.getGpa()){
                    return -1;
                }
                else return 1;
            }
        });
        for(SinhVien x : arr){
            System.out.println(x);
        }
    }
}
