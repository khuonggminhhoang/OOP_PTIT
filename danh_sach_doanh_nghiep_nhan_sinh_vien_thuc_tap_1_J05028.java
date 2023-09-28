import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class DoanhNghiep{
    private String id, name;
    private int amount;
    public DoanhNghiep(String id, String name, int amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }

    public String getId(){
        return this.id;
    }

    public int getAmount(){
        return this.amount;
    }

    @Override
    public String toString() {
        return this.id + " "+ this.name + " " + this.amount;
    }
}

public class danh_sach_doanh_nghiep_nhan_sinh_vien_thuc_tap_1_J05028 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        ArrayList<DoanhNghiep> arr = new ArrayList<>();
        while(t-- >0){
            scn.nextLine();
            arr.add(new DoanhNghiep(scn.nextLine(), scn.nextLine(),scn.nextInt()));
        }   
        Collections.sort(arr, new Comparator<DoanhNghiep>(){
            @Override
            public int compare(DoanhNghiep o1, DoanhNghiep o2){
                if(o2.getAmount() != o1.getAmount()){
                    return o2.getAmount() - o1.getAmount();
                }
                else return o1.getId().compareTo(o2.getId());
            }
        });
        for(DoanhNghiep x : arr){
            System.out.println(x);
        }
    }
}
