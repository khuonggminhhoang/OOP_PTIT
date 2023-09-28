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

public class tra_cuu_don_hang_J05052 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- >0){
            scn.nextLine();
            MatHang x = new MatHang(scn.nextLine(), scn.nextLine(), scn.nextInt(), scn.nextInt());
            System.out.println(x);
        }   
    }
}
