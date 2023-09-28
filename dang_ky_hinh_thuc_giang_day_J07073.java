import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class MonHoc{
    private String id, name;
    private int amount;
    private String theory, practice;
    
    public MonHoc(String id, String name, int amount, String theory, String practice) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.theory = theory;
        this.practice = practice;
    }

    public String getId() {
        return id;
    }

    public String getPractice() {
        return practice;
    }

    @Override
    public String toString() {
        return this.id + " " + this.name + " " + this.amount + " " + this.theory + " " + this.practice;
    }
}

public class dang_ky_hinh_thuc_giang_day_J07073 {   
    public static void main(String[] args) throws Exception{
        Scanner scn = new Scanner(new File("MONHOC.in"));
        int t = Integer.parseInt(scn.nextLine());
        ArrayList<MonHoc> arr = new ArrayList<>();
        while(t-- > 0){
            MonHoc x = new MonHoc(scn.nextLine(),scn.nextLine(), Integer.parseInt(scn.nextLine()),scn.nextLine(), scn.nextLine());
            if(!x.getPractice().equals("Truc tiep")){
                arr.add(x);
            }
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
