import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class LoaiPhong implements Comparable<LoaiPhong>{
    private String id, name;
    private int priceOfDay;
    private double bonus;

    public String getName(){
        return this.name;
    }

    public LoaiPhong(String s) {
        String[] arr = s.trim().split("\\s+");
        this.id = arr[0];
        this.name = arr[1];
        this.priceOfDay = Integer.parseInt(arr[2]);
        this.bonus = Double.parseDouble(arr[3]);
    }
    @Override
    public String toString(){
        return this.id + " "+ this.name + " "+ this.priceOfDay + " " + this.bonus;
    }

    @Override
    public int compareTo(LoaiPhong o){
        return this.name.compareTo(o.getName());
    }

}

public class loai_phong {
    public static void main(String[] args) throws IOException {
        ArrayList<LoaiPhong> ds = new ArrayList<>();
        Scanner in = new Scanner(new File("PHONG.in"));
        int n = Integer.parseInt(in.nextLine());
        while(n-->0){
            ds.add(new LoaiPhong(in.nextLine()));
        }
        Collections.sort(ds);
        for(LoaiPhong tmp : ds){
            System.out.println(tmp);
        }
    }
}
