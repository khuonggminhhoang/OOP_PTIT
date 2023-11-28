import java.util.ArrayList;
import java.util.Scanner;

class DonHang{
    private String id, name, classify;
    private int inAmount, outAmount, cost;

    public DonHang(String id, String name, String classify) {
        this.id = id;
        this.name = name;
        this.classify = classify;
        this.inAmount = 0;
        this.outAmount = 0;
        this.cost = 0;
    }

    public void setInAmount(int inAmount){
        this.inAmount = inAmount;
    }

    public void setOutAmount(int outAmount){
        this.outAmount = outAmount;
    }

    public void setCost(int cost){
        this.cost = cost;
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

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public int inTotal(){
        return this.inAmount * this.cost;
    }

    public int outTotal(){
        if(this.classify.equals("A")) return this.cost * this.outAmount * 108/100;
        else if(this.classify.equals("B")) return this.cost * this.outAmount * 105/100;
        else if(this.classify.equals("C")) return this.cost * this.outAmount * 102/100;
        else return 0;
    }   

    @Override 
    public String toString(){
        return this.id + " " + this.name + " " + this.inTotal() + " " + this.outTotal();
    }
}

public class nhap_xuat_hang_J05076 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        scn.nextLine();
        ArrayList<DonHang> arr = new ArrayList<>();
        while(t-- >0){
            arr.add(new DonHang(scn.nextLine(), scn.nextLine(), scn.nextLine()));
        }   
        int q = scn.nextInt();
        scn.nextLine();
        while(q-- > 0){
            String id = scn.next();
            int inAmount = scn.nextInt();
            int cost = scn.nextInt();
            int outAmount = scn.nextInt();
    
            for(DonHang x : arr){
                if(id.equals(x.getId())){
                    x.setInAmount(inAmount);
                    x.setOutAmount(outAmount);
                    x.setCost(cost);
                    System.out.println(x);
                    break;
                }
            }
        }
    }
}