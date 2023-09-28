import java.util.Scanner;

class SinhVien{
    private String id, name;
    private String gender;
    private double mark;
    public SinhVien(String id, String name, String gender, double mark) {
        this.id = id.toUpperCase();
        this.name = name;
        this.gender = (gender.toLowerCase().equals("true")) ? "nam" : "nu";
        this.mark = mark;
    }
    @Override
    public String toString() {
        String st = (mark <5) ? "hoc lai" :"dat";
        return this.id + " " + this.name + " " + this.gender + " "+ st;
    }
}

public class tao_lop_sinh_vien {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        SinhVien sv = new SinhVien(scn.nextLine(), scn.nextLine(), scn.nextLine(), scn.nextDouble());
        System.out.println(sv);
        scn.close();
    }
}
