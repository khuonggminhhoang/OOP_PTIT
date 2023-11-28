import java.util.ArrayList;
import java.util.Scanner;

class CLB{
    private String idClb, nameClb;
    private long ticketPrice, amount;

    public CLB(String idClb, String nameClb, long ticketPrice) {
        this.idClb = idClb;
        this.nameClb = nameClb;
        this.ticketPrice = ticketPrice;
        this.amount = 0;
    }

    public String getIdClb(){
        return this.idClb;
    }
    
    public void setAmount(long amount){
        this.amount = amount;
    }

    public long total(){
        return this.ticketPrice * this.amount;
    }

    @Override
    public String toString(){
        return this.nameClb + " " + this.total();
    }
}

public class cau_lac_bo_bong_da_J05069 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        ArrayList<CLB> arr = new ArrayList<>();
        while(t-- >0){
            scn.nextLine();
            arr.add(new CLB(scn.nextLine(), scn.nextLine(), scn.nextLong()));
        }   
        scn.nextLine();
        int q = Integer.parseInt(scn.nextLine());
        while(q-- >0){
            String code = scn.next();
            long amount = Long.parseLong(scn.next());
            String idClb = code.substring(1, 3);
            for(CLB x : arr){
                if(idClb.equals(x.getIdClb())){
                    x.setAmount(amount);
                    System.out.println(code + " " + x);
                    break;
                }
            }
        }
    }
}
