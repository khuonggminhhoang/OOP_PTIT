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


public class liet_ke_sinh_vien_theo_nganh_J05024 {
    public static String conv(String s){
        if(s.equals("Ke toan")) return "DCKT";
        else if(s.equals("Cong nghe thong tin")) return "DCCN";
        else if(s.equals("An toan thong tin")) return "DCAT";
        else if(s.equals("Vien thong")) return "DCVT";
        else return "DCDT";
    }
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
            String tmp = conv(s);
            System.out.println("DANH SACH SINH VIEN NGANH " + s.toUpperCase() + ":");
            for(SinhVien x : arr){
                if(x.getId().substring(3,7).equals(tmp)){
                    if(tmp.equals("DCCN") || tmp.equals("DCAT")){
                        if(x.getClasss().charAt(0) != 'E') System.out.println(x);       
                    }
                    else{
                        System.out.println(x);
                    }
                }
            }
        }
    }
}
