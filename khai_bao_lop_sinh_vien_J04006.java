import java.util.Scanner;

class SinhVien{
    private String msv, fullname, classs, birthday;
    private double gpa; 

    SinhVien(){}
    SinhVien(String msv,String fullname, String classs, String birthday, double gpa){
        this.msv = msv;
        this.fullname = fullname;
        this.classs = classs;
        this.birthday = birthday;
        this.gpa = gpa;
    }

    public String dayStd(String s){
        StringBuilder sb = new StringBuilder(s);
        if(sb.charAt(1) == '/'){
            sb.insert(0,'0');
        }
        if(sb.charAt(4) == '/'){
            sb.insert(3, '0');
        }
        return sb.toString();
    }

    @Override
    public String toString(){
        return this.msv + " " + this.fullname + " " + this.classs + " " + this.dayStd(this.birthday) + " " + String.format("%.2f", this.gpa);
    }
}

public class khai_bao_lop_sinh_vien_J04006 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        SinhVien sv = new SinhVien("B20DCCN001", scn.nextLine(), scn.nextLine(), scn.nextLine(), scn.nextDouble());
        System.out.println(sv);
    }
}
