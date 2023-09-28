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

public class sap_xep_sinh_vien_theo_lop_J05020 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        scn.nextLine();
        ArrayList<SinhVien> arr = new ArrayList<>();
        while(t-- >0){
            arr.add(new SinhVien(scn.nextLine(), scn.nextLine(), scn.nextLine(), scn.nextLine()));
        }   

        Collections.sort(arr, new Comparator<SinhVien>(){
            @Override
            public int compare(SinhVien o1, SinhVien o2){
                if(!o1.getClasss().equals(o2.getClasss())){
                    return o1.getClasss().compareTo(o2.getClasss());
                }
                else{
                    return o1.getId().compareTo(o2.getId());
                }
            }
        });
        for(SinhVien x : arr){
            System.out.println(x);
        }
    }
}