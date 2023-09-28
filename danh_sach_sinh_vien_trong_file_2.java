import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class SinhVien{
    private String id, fullname, birthday, classs;
    private double gpa;
    public static int cnt = 0;

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

    public SinhVien(){}
    public SinhVien(String fullname, String classs, String birthday, double gpa){
        this.id = "B20DCCN" + String.format("%03d", ++cnt);
        this.fullname = fullname;
        this.classs = classs;
        this.birthday = birthday;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return this.id + " " + this.fullname + " " + this.classs + " " + this.dayStd(this.birthday) + " " + String.format("%.2f", this.gpa);
    }
    
}

public class danh_sach_sinh_vien_trong_file_2 {
    public static void main(String[] args) {
        try {
            Scanner scn = new Scanner(new File("SV.in"));
            int t = Integer.parseInt(scn.nextLine());
            while(t-- > 0){
                String fullname = scn.nextLine();
                String classs = scn.nextLine();
                String birthday = scn.nextLine();
                double gpa = Double.parseDouble(scn.nextLine());
                SinhVien sv = new SinhVien(fullname, classs, birthday, gpa);
                System.out.println(sv);
            }



        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
