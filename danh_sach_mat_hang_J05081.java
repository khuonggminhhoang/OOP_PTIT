import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Item{
    private String itemCode, name, unit;
    private int purchase, price;

    public static int cnt = 0;

    Item(){}
    Item(String name, String unit, int purchase, int price){
        cnt++;
        this.itemCode = "MH" + String.format("%03d", cnt);
        this.name = name;
        this.unit = unit;
        this.purchase = purchase;
        this.price = price;
    }

    public String getItemCode(){
        return this.itemCode;
    }

    public int getProfit(){
        return this.price - this.purchase;
    }

    @Override
    public String toString(){
        return this.itemCode + " " + this.name + " " + this.unit + " " + this.purchase + " " + this.price + " " + this.getProfit();
    }
}

public class danh_sach_mat_hang_J05081 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        scn.nextLine();
        ArrayList <Item>  arr = new ArrayList<>();
        while(t-- > 0){
            String name = scn.nextLine();
            String unit = scn.nextLine();
            int purchase = scn.nextInt();
            int price = scn.nextInt();
            scn.nextLine();
            Item item = new Item(name, unit, purchase, price);
            arr.add(item);
        }
        Collections.sort(arr, new Comparator<Item>(){

            @Override
            public int compare(Item o1, Item o2) {
                if(o2.getProfit() != o1.getProfit()) return o2.getProfit() - o1.getProfit();
                else{
                    return o1.getItemCode().compareTo(o2.getItemCode());
                }
            }
            
        });
        for(Item x : arr){
            System.out.println(x);
        }
    }
}

