import java.util.Scanner;

class MatHang{
    private String id, name, init;
    private long inCost, amount;

    public static int cnt = 0;
    public MatHang(String name, String init, long inCost, long amount) {
        this.id = "MH" + String.format("%02d",++cnt);
        this.name = name;
        this.init = init;
        this.inCost = inCost;
        this.amount = amount;
    }

    public long feeDelivery(){
        return Math.round(this.inCost * this.amount * 0.05);
    }

    public long inMoney(){
        return Math.round(this.inCost * this.amount + feeDelivery());
    }

    public long cost(){
        return Math.round(inMoney() * 1.02);
    }

    @Override
    public String toString(){
        return this.id + " " + this.name + " " + this.init + " " + this.feeDelivery() + " " + this.inMoney() + " " + this.cost();
    }
}

public class tinh_gia_ban_1_J05036 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- >0){
            scn.nextLine();
            MatHang mh = new MatHang(scn.nextLine(), scn.nextLine(), scn.nextLong(), scn.nextLong());
            System.out.println(mh);
        }   
    }
}
