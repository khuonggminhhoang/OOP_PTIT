import java.util.Scanner;

class MaHang{
    private String id;
    private long amountIn;

    public MaHang(String id, long amountIn) {
        this.id = id;
        this.amountIn = amountIn;
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


public class bang_theo_doi_nhap_xuat_hang_J05048 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- >0){
            scn.nextLine();
            MaHang x = new MaHang(scn.nextLine(), scn.nextLong());
            System.out.println(x);
        }   
    }
}
