import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class HoaDon{
    private String id, name;
    private long amount, bill, discount;
    
    public HoaDon(String id, String name, long amount, long bill, long discount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.bill = bill;
        this.discount = discount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getBill() {
        return bill;
    }

    public void setBill(long bill) {
        this.bill = bill;
    }

    public long getDiscount() {
        return discount;
    }

    public void setDiscount(long discount) {
        this.discount = discount;
    }

    public long total(){
        return this.bill * this.amount - this.discount;
    }

    @Override
    public String toString(){
        return this.id + " " + this.name + " " + this.amount + " " + this.bill + " " + this.discount + " " + this.total();
    }
}

public class tinh_tien_J05012 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        ArrayList<HoaDon> arr = new ArrayList<>();
        while(t-- >0){
            scn.nextLine();
            arr.add(new HoaDon(scn.nextLine(), scn.nextLine(), scn.nextLong(), scn.nextLong(), scn.nextLong()));
        }   
        scn.nextLine();
        Collections.sort(arr, new Comparator<HoaDon>(){

            @Override
            public int compare(HoaDon o1, HoaDon o2) {
                return Long.compare(o2.total(), o1.total());
            }
            
        });

        for(HoaDon x : arr){
            System.out.println(x);
        }
        scn.close();
    }
}
