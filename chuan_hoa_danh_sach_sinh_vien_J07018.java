import java.io.File;
import java.util.Scanner;

class SinhVien{
    private String id, name, classs, dob;
    private double gpa;

    public static int cnt = 0;

    public SinhVien(String name, String classs, String dob, double gpa) {
        this.id = "B20DCCN" + String.format("%03d", ++cnt);
        this.name = nameStd(name);
        this.classs = classs;
        this.dob = dayStd(dob);
        this.gpa = gpa;
    }

    private String dayStd(String s){
        StringBuilder sb = new StringBuilder(s);
        if(sb.charAt(1) == '/'){
            sb.insert(0, '0');
        }
        if(sb.charAt(4) == '/'){
            sb.insert(3, '0');
        }
        return sb.toString();
    }

    private String nameStd(String s){
        String ans = "";
        String[] arr = s.trim().split("\\s+");
        for(String x : arr){
            ans += Character.toUpperCase(x.charAt(0)) + x.substring(1).toLowerCase() + " ";
        }
        return ans.substring(0, ans.length() - 1);
    }

    @Override
    public String toString(){
        return this.id + " " + this.name + " " + this.classs + " " + this.dob + " " + String.format("%.2f", this.gpa);
    }
}

public class chuan_hoa_danh_sach_sinh_vien_J07018 {
    public static void main(String[] args) throws Exception{
        Scanner scn = new Scanner(new File("SINHVIEN.in"));
        int t = scn.nextInt();
        while(t-- > 0){
            scn.nextLine();
            SinhVien x = new SinhVien(scn.nextLine(), scn.nextLine(), scn.nextLine(), scn.nextDouble());
            System.out.println(x);
        }
    }
}
