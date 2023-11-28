import java.util.HashMap;
import java.util.Scanner;

class Invoice{
    private String id;
    private int amount;
    private HashMap<String, String> mapName;
    private HashMap<String, Long> mapCost;
    private HashMap<String, Double> mapTax;

    public Invoice(String id, int amount) {
        mapName = new HashMap<>();
        mapName.put("BP", "British Petro");
        mapName.put("ES", "Esso");
        mapName.put("SH", "Shell");
        mapName.put("CA", "Castrol");
        mapName.put("MO", "Mobil");
        mapName.put("TN", "Trong Nuoc");

        mapCost = new HashMap<>();
        mapCost.put("X", 1l * 128000);
        mapCost.put("D", 1l * 11200);
        mapCost.put("N", 1l * 9700);

        mapTax = new HashMap<>();
        mapTax.put("X", 0.03);
        mapTax.put("D", 0.035);
        mapTax.put("N", 0.02);

        this.id = id;
        this.amount = amount;
    }

    public String name(){
        String shortenBrandName = this.id.substring(3);
        return this.mapName.get(shortenBrandName);
    }

    public long cost(){
        String shortenProductName = this.id.substring(0, 1);
        return this.mapCost.get(shortenProductName);
    }

    public double taxPercent(){
        String shortenProductName = this.id.substring(0, 1);
        return this.mapTax.get(shortenProductName);
    }

    public long tax(){
        double taxPercent = (this.id.substring(3).equals("TN") ? 0 : taxPercent());
        return (long) (1l * this.amount * this.cost()*(taxPercent));
    }

    public long total(){
        double taxPercent = (this.id.substring(3).equals("TN") ? 0 : taxPercent());
        return (long) (1l * this.amount * this.cost()*(1 + taxPercent));
    }

    @Override
    public String toString(){
        return this.id + " " + this.name() + " " + this.cost() + " " + this.tax() + " " + this.total();
    }
}

public class quan_ly_kho_xang_dau_J05067 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        scn.nextLine();
        while(t-- >0){
            Invoice invoice = new Invoice(scn.next(), Integer.parseInt(scn.next()));
            System.out.println(invoice);
        }   
    }
}
