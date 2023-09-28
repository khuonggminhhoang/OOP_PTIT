import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class DoanhNghiep{
    private String id, name;
    private int quantity;
    public DoanhNghiep(String id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }
    public String getId() {
        return id;
    }
    @Override
    public String toString() {
        return this.id + " " + this.name + " " + this.quantity;
    }
}

public class danh_sach_doanh_nghiep_J07037 {
    public static void main(String[] args) throws Exception{
        Scanner scn = new Scanner(new File("DN.in"));
        int t = Integer.parseInt(scn.nextLine());
        ArrayList<DoanhNghiep> arr = new ArrayList<>();
        while(t-- > 0){
            arr.add(new  DoanhNghiep(scn.nextLine(), scn.nextLine(), Integer.parseInt(scn.nextLine())));
        }
        Collections.sort(arr, new Comparator<DoanhNghiep>(){
            public int compare(DoanhNghiep o1, DoanhNghiep o2){
                return o1.getId().compareTo(o2.getId());
            }
        });
        for(DoanhNghiep x : arr){
            System.out.println(x);
        }
    }
}
