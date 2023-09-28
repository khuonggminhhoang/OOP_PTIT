import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class MonHoc{
    private String id, name, exam;
    
    public MonHoc(String id, String name, String exam){
        this.id = id;
        this.name = name;
        this.exam = exam;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return this.id + " " + this.name + " " + this.exam;
    }
}

public class danh_sach_mon_thi_J07058 {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(new File("MONHOC.in"));
        int t = Integer.parseInt(scn.nextLine());
        ArrayList<MonHoc> arr = new ArrayList<>();
        while(t-- >0){
            arr.add(new MonHoc(scn.nextLine(), scn.nextLine(), scn.nextLine()));
        }
        Collections.sort(arr, new Comparator<MonHoc>(){

            @Override
            public int compare(MonHoc o1, MonHoc o2) {
                return o1.getId().compareTo(o2.getId());
            }

        });

        for(MonHoc x : arr){
            System.out.println(x);
        }
    }
}
