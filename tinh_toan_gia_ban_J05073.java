import java.util.Scanner;

class DonHang{
    private String id;
    private long bill, amount;
    private double tax, transFee;

    public DonHang(String id, long bill, long amount) {
        this.id = id;
        this.bill = bill;
        this.amount = amount;
    }

    public void setData(){
        char c = this.id.charAt(0);
        if(c == 'T'){
            this.tax = 29;
            this.transFee = 4;
        }
        else if(c == 'C'){
            this.tax = 10;
            this.transFee = 3;
        }
        else if(c == 'D'){
            this.tax = 8;
            this.transFee = 2.5;
        }
        else if(c == 'M'){
            this.tax = 2;
            this.transFee = 0.5;
        }
    }

    public double total(){
        if(!this.id.endsWith("C")){
            return (this.bill * this.amount * (1 + this.tax/100 + this.transFee/100)) * 1.2/this.amount;
        }
        else{
            return (this.bill * this.amount * (1 + this.tax/100 * 0.95 + this.transFee/100))*1.2/this.amount;
        }
    }

    @Override
    public String toString(){
        return this.id + " " + String.format("%.2f", this.total());
    }
}

public class tinh_toan_gia_ban_J05073 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        scn.nextLine();
        while(t-- >0){
            String[] a = scn.nextLine().trim().split("\\s+");
            DonHang x = new DonHang(a[0], Long.parseLong(a[1]), Long.parseLong(a[2]));
            x.setData();
            System.out.println(x);
        }   
    }
}