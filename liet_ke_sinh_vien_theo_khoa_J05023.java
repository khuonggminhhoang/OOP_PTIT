import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class SinhVien{
    private String id, name, classs, email;

    public SinhVien(String id, String name, String classs, String email) {
        this.id = id;
        this.name = name;
        this.classs = classs;
        this.email = email;
    }

    public String getClasss(){
        return this.classs;
    }

    public String getId(){
        return this.id;
    }

    @Override
    public String toString(){
        return this.id + " " + this.name + " " + this.classs + " " + this.email;
    }

}

public class liet_ke_sinh_vien_theo_khoa_J05023 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        scn.nextLine();
        ArrayList<SinhVien> arr = new ArrayList<>();
        while(t-- >0){
            arr.add(new SinhVien(scn.nextLine(), scn.nextLine(), scn.nextLine(), scn.nextLine()));
        }   

        int q = scn.nextInt();
        scn.nextLine();
        while(q-- > 0){
            String s = scn.nextLine();
            System.out.println("DANH SACH SINH VIEN KHOA " + s + ":");
            for(SinhVien x : arr){
                if(x.getClasss().substring(1,3).equals(s.substring(2))){
                    System.out.println(x);
                }
            }
        }
    }
}