import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class SinhVien{
    private int stt;
    private String id, name, classs, email, company;

    public static int cnt = 0;
    
    public SinhVien(String id, String name, String classs, String email, String company) {
        this.stt = ++cnt;
        this.id = id;
        this.name = name;
        this.classs = classs;
        this.email = email;
        this.company = company;
    }

    public String getName(){
        return this.name;
    }

    public String getCompany(){
        return this.company;
    }

    @Override
    public String toString() {
        return this.stt + " " + this.id + " " + this.name + " " + this.classs + " " + this.email + " " + this.company;
    }

}

public class danh_sach_thuc_tap_1_J05034 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        scn.nextLine();
        ArrayList<SinhVien> arr = new ArrayList<>();
        while(t-- >0){
            arr.add(new SinhVien(scn.nextLine(), scn.nextLine(), scn.nextLine(), scn.nextLine(), scn.nextLine()));
        }   
        Collections.sort(arr, new Comparator<SinhVien>(){
            @Override
            public int compare(SinhVien o1,SinhVien o2){
                return o1.getName().compareTo(o2.getName());
            }
        });
        
        int q = scn.nextInt();
        scn.nextLine();
        while(q-- > 0){
            String s = scn.nextLine();
            for(SinhVien x : arr){

                if(x.getCompany().equals(s)){
                    System.out.println(x);
                }
            }
        }

        ArrayList<Integer> a = new ArrayList<>();
        

    }
}
