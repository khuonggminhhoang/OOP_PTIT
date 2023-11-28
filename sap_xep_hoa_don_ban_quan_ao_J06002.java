import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class SanPham{
    private String idSp, nameSp;
    private long cost1, cost2;

    public SanPham(String idSp, String nameSp, long cost1, long cost2) {
        this.idSp = idSp;
        this.nameSp = nameSp;
        this.cost1 = cost1;
        this.cost2 = cost2;
    }

    public String getIdSp() {
        return idSp;
    }

    public void setIdSp(String idSp) {
        this.idSp = idSp;
    }

    public String getNameSp() {
        return nameSp;
    }

    public void setNameSp(String nameSp) {
        this.nameSp = nameSp;
    }

    public long getCost1() {
        return cost1;
    }

    public void setCost1(long cost1) {
        this.cost1 = cost1;
    }

    public long getCost2() {
        return cost2;
    }

    public void setCost2(long cost2) {
        this.cost2 = cost2;
    }    
}

class HoaDon{
    private String idHd;
    private long amount;
    
    public static int cnt = 0;

    public HoaDon(String idHd, long amount) {
        this.idHd = idHd + "-" + String.format("%03d", ++cnt);
        this.amount = amount;
    }

    public String getIdHd() {
        return idHd;
    }

    public void setIdHd(String idHd) {
        this.idHd = idHd;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public static int getCnt() {
        return cnt;
    }

    public static void setCnt(int cnt) {
        HoaDon.cnt = cnt;
    }

    public double percent(){
        if(this.amount >= 150) return 0.5;
        else if(this.amount >= 100) return 0.3;
        else if(this.amount >= 50) return 0.15;
        else return 0;
    }
}

class Invoice{
    private SanPham sp;
    private HoaDon hd;

    public Invoice(SanPham sp, HoaDon hd) {
        this.sp = sp;
        this.hd = hd;
    }

    public long getCost(){
        if(hd.getIdHd().charAt(2) == '1'){
            return sp.getCost1();
        }
        else return sp.getCost2();
    }

    public long getDiscount(){
        return Math.round(getCost() * this.hd.getAmount() * this.hd.percent());
    }

    public long total(){
        return Math.round(getCost() * this.hd.getAmount() *(1 - this.hd.percent()));
    }

    @Override
    public String toString(){
        return this.hd.getIdHd() + " " + this.sp.getNameSp() + " " + getDiscount() + " " + total();
    }
}

public class sap_xep_hoa_don_ban_quan_ao_J06002 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        ArrayList<SanPham> arrSp = new ArrayList<>();
        while(t-- >0){
            scn.nextLine();
            arrSp.add(new SanPham(scn.nextLine(), scn.nextLine(), scn.nextLong(), scn.nextLong()));
        }   
        scn.nextLine();
        t = scn.nextInt();
        scn.nextLine();
        ArrayList<Invoice> arr = new ArrayList<>();
        while(t-- > 0){
            String[] s = scn.nextLine().trim().split("\\s+");
            HoaDon hoaDon = new HoaDon(s[0], Long.parseLong(s[1]));
            for(SanPham x : arrSp){
                if(x.getIdSp().equals(hoaDon.getIdHd().substring(0, 2))){
                    arr.add(new Invoice(x, hoaDon));
                    break;
                }
            }
        }
        Collections.sort(arr, new Comparator<Invoice>(){
            @Override
            public int compare(Invoice o1, Invoice o2){
                return Long.compare(o2.total(), o1.total());
            }
        });
        for(Invoice x : arr){
            System.out.println(x);
        }
    }
}
