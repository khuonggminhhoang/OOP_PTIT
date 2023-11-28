import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class MatHang{
    private String name, id;
    private int cost, amount;

    public MatHang(String name, String id, int cost, int amount) {
        this.name = name;
        this.id = id;
        this.cost = cost;
        this.amount = amount;
    }
    
    public String getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String stt(){
        return this.id.substring(1, 4);
    }

    public int discount(){
        char c = this.id.charAt(4);
        if(c  == '1'){
            return this.cost * this.amount /2;
        }
        else {
            return this.cost * this.amount * 3 / 10;
        }
    }

    public int total(){
        return this.cost * this.amount - discount();
    }

    @Override
    public String toString(){
        return this.name + " " + this.id + " "+ this.stt() + " " + this.discount() + " " + this.total();
    }
}

public class sap_xep_don_hang_J05053 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        ArrayList<MatHang> arr = new ArrayList<>();
        while(t-- >0){  
            scn.nextLine();
            arr.add(new MatHang(scn.nextLine(), scn.nextLine(), scn.nextInt(), scn.nextInt()));
        }   
        Collections.sort(arr, new Comparator<MatHang>(){
            @Override
            public int compare(MatHang o1, MatHang o2){
                return o1.stt().compareTo(o2.stt());
            }
        });
        for(MatHang x : arr){
            System.out.println(x);
        }
    }
}
