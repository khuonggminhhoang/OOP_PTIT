import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Item{
    private String id, name; 
    private int cost, guarantee;
    
    public Item(String id, String name, int cost, int guarantee) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.guarantee = guarantee;
    }

    public String getId() {
        return id;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return this.id + " " + this.name + " "+ this.cost + " "+ this.guarantee;
    }
}

public class danh_sach_san_pham_2_J07048 {
    public static void main(String[] args) throws Exception{
        Scanner scn = new Scanner(new File("SANPHAM.in"));
        int t = Integer.parseInt(scn.nextLine());
        ArrayList<Item> arr = new ArrayList<>();
        while(t-- > 0){
            arr.add(new Item(scn.nextLine(), scn.nextLine(), Integer.parseInt(scn.nextLine()), Integer.parseInt(scn.nextLine())));
        }
        Collections.sort(arr, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2){
                if(o1.getCost() != o2.getCost()){
                    return o2.getCost() - o1.getCost();
                }
                else{
                    return o1.getId().compareTo(o2.getId());
                }
            }
        });

        for(Item x : arr){
            System.out.println(x);
        }
    }
}
