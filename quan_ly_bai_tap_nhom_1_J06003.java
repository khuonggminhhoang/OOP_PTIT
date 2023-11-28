import java.util.ArrayList;
import java.util.Scanner;

class SinhVien{
    private String id, name, phone;
    private int ordGr;
    public SinhVien(String id, String name, String phone, int ordGr) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.ordGr = ordGr;
    }

    public int getOrdGr(){
        return this.ordGr;
    }

    @Override
    public String toString(){
        return this.id + " " + this.name + " " + this.phone;
    }
}

public class quan_ly_bai_tap_nhom_1_J06003 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        int n = scn.nextInt();
        ArrayList<SinhVien> arr = new ArrayList<>();
        while(t-- >0){
            scn.nextLine();
            arr.add(new SinhVien(scn.nextLine(), scn.nextLine(), scn.nextLine(), scn.nextInt()));
        }   
        scn.nextLine();
        String[] a = new String[n + 1];
        for(int i=1; i<n + 1; ++i){
            a[i] = scn.nextLine();
        }

        int q = Integer.parseInt(scn.nextLine());
        while(q-- > 0){
            int select = scn.nextInt();
            System.out.println("DANH SACH NHOM " + select + ":");
            for(SinhVien x : arr){
                if(x.getOrdGr() == select){
                    System.out.println(x);
                }
            }
            System.out.println("Bai tap dang ky: " + a[select]);
        }
    }
}
