import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class MonHoc{
    private String id, name;
    private int quantity;
    
    public MonHoc(String id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.id + " " + this.name + " " + this.quantity;
    }
}

public class danh_sach_mon_hoc_J07034 {
    public static void main(String[] args) throws Exception{
        Scanner scn = new Scanner(new File("MONHOC.in"));
        int t = scn.nextInt();
        scn.nextLine();
        ArrayList<MonHoc> arr = new ArrayList<>();
        while(t-- > 0){
            String id = scn.nextLine();
            String name = scn.nextLine();
            int quantity = Integer.parseInt(scn.nextLine());
            arr.add(new MonHoc(id, name, quantity));
        }
        Collections.sort(arr, new Comparator<MonHoc>(){

            @Override
            public int compare(MonHoc o1, MonHoc o2) {
                return o1.getName().compareTo(o2.getName());
            }
            
        });
        for(MonHoc x : arr){
            System.out.println(x);
        }
    }
}
