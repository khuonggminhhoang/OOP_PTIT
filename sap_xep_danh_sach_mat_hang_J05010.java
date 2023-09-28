import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class MatHang{
    private int id;
    private String name, field;
    private double impPrice, expPrice;

    public static int cnt = 0;
    public MatHang(String name, String field, double impPrice, double expPrice) {
        this.id = ++cnt;
        this.name = name;
        this.field = field;
        this.impPrice = impPrice;
        this.expPrice = expPrice;
    }

    public double profit(){
        return this.expPrice - this.impPrice;
    }

    @Override 
    public String toString(){
        return this.id + " " + this.name + " " + this.field + " " + String.format("%.2f", this.profit());
    }
}

public class sap_xep_danh_sach_mat_hang_J05010 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        ArrayList<MatHang> arr = new ArrayList<>();
        while(t-- >0){
            scn.nextLine();
            arr.add(new MatHang(scn.nextLine(), scn.nextLine(), scn.nextDouble(), scn.nextDouble()));
        }   
        Collections.sort(arr, new Comparator<MatHang>(){
            @Override
            public int compare(MatHang o1, MatHang  o2){
                if(o1.profit() > o2.profit()){
                    return -1;
                }
                else return 1;
            }
        });
        for(MatHang x : arr){
            System.out.println(x);
        }
    }
}
