import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class MaHang{
    private String id;
    private long amountIn;

    public MaHang(String id, long amountIn) {
        this.id = id;
        this.amountIn = amountIn;
    }

    public String getId(){
        return this.id;
    }

    public long amountOut(){
        if(this.id.charAt(0) == 'A') return Math.round(0.6 * this.amountIn);
        else return Math.round(0.7 * this.amountIn);
    }
    
    public long unitPrice(){
        char c = this.id.charAt(this.id.length() - 1);
        if(c == 'Y') return 110000;
        else return 135000; 
    }

    public long money(){
        return this.amountOut() * this.unitPrice();
    }

    public long tax(){
        char first = this.id.charAt(0);
        char last = this.id.charAt(this.id.length() - 1);
        if(first == 'A' && last == 'Y') return money()*8/100;
        else if(first == 'A' && last == 'N') return money()*11/100;
        else if(first == 'B' && last == 'Y') return money()*17/100;
        else return money()*22/100;
    }

    @Override
    public String toString(){
        return this.id + " " + this.amountIn + " " + this.amountOut() + " " + this.unitPrice() + " " + this.money() + " " + this.tax();
    }
}

public class liet_ke_nhap_xuat_hang_theo_nhom_J05049 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        ArrayList<MaHang> arr = new ArrayList<>();
        while(t-- >0){
            scn.nextLine();
            MaHang x = new MaHang(scn.nextLine(), scn.nextLong());
            arr.add(x);
        }   
        Collections.sort(arr, new Comparator<MaHang>(){
            @Override
            public int compare(MaHang o1, MaHang o2){
                return (int) (o2.tax() - o1.tax());
            }
        });
        scn.nextLine();
        char c = scn.nextLine().charAt(0);
        for(MaHang x : arr){
            if(x.getId().charAt(0) == c){
                System.out.println(x);
            }
        }
    }
}
