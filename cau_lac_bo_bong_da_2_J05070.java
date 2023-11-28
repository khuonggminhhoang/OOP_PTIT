import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class CLB{
    private String idClb, nameClb, id;
    private long ticketPrice, amount;

    public CLB(String idClb, String nameClb, long ticketPrice) {
        this.idClb = idClb;
        this.nameClb = nameClb;
        this.ticketPrice = ticketPrice;
        this.amount = 0;
        this.id = "";
    }

    public String getNameClb(){
        return this.nameClb;
    }

    public String getIdClb(){
        return this.idClb;
    }
    
    public void setAmount(long amount){
        this.amount = amount;
    }

    public void setId(String id){
        this.id = id;
    }

    public long total(){
        return this.ticketPrice * this.amount;
    }

    @Override
    public String toString(){
        return this.id + " " + this.nameClb + " " + this.total();
    }
}

public class cau_lac_bo_bong_da_2_J05070 {
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
        ArrayList<CLB> list = new ArrayList<>();
        while(q-- >0){
            String code = scn.next();
            long amount = Long.parseLong(scn.next());
            String idClb = code.substring(1, 3);
            for(CLB x : arr){
                if(idClb.equals(x.getIdClb())){
                    x.setAmount(amount);
                    x.setId(code);
                    list.add(x);
                    break;
                }
            }
        }
        Collections.sort(list, new Comparator<CLB>(){
            @Override
            public int compare(CLB o1, CLB o2){
                if(o1.total() != o2.total()){
                    return Long.compare(o2.total(), o1.total());
                }
                else{
                    return o1.getNameClb().compareTo(o2.getNameClb());
                }
            }
        });

        for(CLB x : list){
            System.out.println(x);
        }
    }
}
