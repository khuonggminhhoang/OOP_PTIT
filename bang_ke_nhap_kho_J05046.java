import java.util.HashMap;
import java.util.Scanner;

class SanPham{
    private String id ,name;
    private int amount, cost;
    private static HashMap<String, Integer> map = new HashMap<>();

    public SanPham(String name, int amount, int cost) {
        this.name = name;
        this.amount = amount;
        this.cost = cost;
        this.id = getId();
    }

    private String getId(){
        String[] arr = this.name.trim().split("\\s+");
        String ans = "";
        for(int i=0; i<arr.length - 1; ++i){
            ans += Character.toUpperCase(arr[i].charAt(0));
        }
        if(!map.containsKey(ans)){
            map.put(ans,1);
        }
        else{
            map.put(ans, map.get(ans) + 1);
        }
        return ans + String.format("%02d", map.get(ans));
    }

    public long discountMoney(){
        double dis;
        if(this.amount > 10) dis = 0.05;
        else if(this.amount >=8) dis = 0.02;
        else if(this.amount >= 5) dis = 0.01;
        else dis = 0;
        return Math.round(1l * this.cost * this.amount * dis);
    }

    public long total(){
        return 1l * this.cost * this.amount - this.discountMoney();
    }

    @Override
    public String toString(){
        return this.id + " " + this.name + " " + this.discountMoney() + " " + this.total();
    }
}

public class bang_ke_nhap_kho_J05046 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- >0){
            scn.nextLine();
            SanPham sp = new SanPham(scn.nextLine(), scn.nextInt(), scn.nextInt());
            System.out.println(sp);
        }   
    }
}
