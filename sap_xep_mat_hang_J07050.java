import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class MatHang{
    private String id, name, field;
    private double purchasePrice, saleCost;

    public static int cnt = 0;
    public MatHang(String name, String field, double purchasePrice, double saleCost) {
        this.id = "MH" + String.format("%02d", ++cnt);
        this.name = name;
        this.field = field;
        this.purchasePrice = purchasePrice;
        this.saleCost = saleCost;
    }

    public double getProfit(){
        return this.saleCost - this.purchasePrice ;
    }

    @Override
    public String toString() {
        return this.id + " " + this.name +" " + this.field + " " + String.format("%.2f", this.getProfit());
    }
}

public class sap_xep_mat_hang_J07050 {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(new File("MATHANG.in"));
        int t = Integer.parseInt(scn.nextLine());
        ArrayList<MatHang> arr = new ArrayList<>();
        while(t-- > 0){
            arr.add(new MatHang(scn.nextLine(), scn.nextLine(), Double.parseDouble(scn.nextLine()), Double.parseDouble(scn.nextLine())));
        }
        Collections.sort(arr, new Comparator<MatHang>(){
            @Override
            public int compare(MatHang o1, MatHang o2){
                if(o1.getProfit() > o2.getProfit())
                    return -1;
                else return 1;
            }
        });
        for(MatHang x : arr){
            System.out.println(x);
        }
    }
}
