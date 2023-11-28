import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class KhachHang{
    private String idCus, nameCus, genderCus, dobCus, addressCus;

    public static int cnt = 0;

    public KhachHang(){}

    public KhachHang(String nameCus, String genderCus, String dobCus, String addressCus) {
        this.idCus = "KH" + String.format("%03d", ++cnt);
        this.nameCus = nameCus;
        this.genderCus = genderCus;
        this.dobCus = dayStd(dobCus);
        this.addressCus = addressCus;
    }

    private String dayStd(String s){
        StringBuilder sb = new StringBuilder(s);
        if(sb.charAt(1) == '/'){
            sb.insert(0, '0');
        }
        if(sb.charAt(4) == '/'){
            sb.insert(3, '0');
        }
        return sb.toString();
    }

    public String getIdCus() {
        return idCus;
    }

    public void setIdCus(String idCus) {
        this.idCus = idCus;
    }

    public String getNameCus() {
        return nameCus;
    }

    public void setNameCus(String nameCus) {
        this.nameCus = nameCus;
    }

    public String getGenderCus() {
        return genderCus;
    }

    public void setGenderCus(String genderCus) {
        this.genderCus = genderCus;
    }

    public String getDobCus() {
        return dobCus;
    }

    public void setDobCus(String dobCus) {
        this.dobCus = dobCus;
    }

    public String getAddressCus() {
        return addressCus;
    }

    public void setAddressCus(String addressCus) {
        this.addressCus = addressCus;
    }

    public static int getCnt() {
        return cnt;
    }

    public static void setCnt(int cnt) {
        KhachHang.cnt = cnt;
    }
}   

class MatHang{
    private String idMh, nameMh, unitMh;
    private int  purcharse, price;

    public static int cnt = 0;

    public MatHang(){}

    public MatHang(String nameMh, String unitMh, int purcharse, int price) {
        this.idMh = "MH" + String.format("%03d", ++cnt);
        this.nameMh = nameMh;
        this.unitMh = unitMh;
        this.purcharse = purcharse;
        this.price = price;
    }

    public String getIdMh() {
        return idMh;
    }

    public void setIdMh(String idMh) {
        this.idMh = idMh;
    }

    public String getNameMh() {
        return nameMh;
    }

    public void setNameMh(String nameMh) {
        this.nameMh = nameMh;
    }

    public String getUnitMh() {
        return unitMh;
    }

    public void setUnitMh(String unitMh) {
        this.unitMh = unitMh;
    }

    public int getPurcharse() {
        return purcharse;
    }

    public void setPurcharse(int purcharse) {
        this.purcharse = purcharse;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

class HoaDon{
    private String idHd, idCus, idMh;
    private int amount;

    public static int cnt = 0;

    public HoaDon(String idCus, String idMh, int amount) {
        this.idHd = "HD" + String.format("%03d", ++cnt);
        this.idCus = idCus;
        this.idMh = idMh;
        this.amount = amount;
    }

    public String getIdHd() {
        return idHd;
    }

    public void setIdHd(String idHd) {
        this.idHd = idHd;
    }

    public String getIdCus() {
        return idCus;
    }

    public void setIdCus(String idCus) {
        this.idCus = idCus;
    }

    public String getIdMh() {
        return idMh;
    }

    public void setIdMh(String idMh) {
        this.idMh = idMh;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}

class Invoice{
    private KhachHang kh;
    private MatHang mh;
    private HoaDon hd;

    public Invoice(KhachHang kh, MatHang mh, HoaDon hd) {
        this.kh = kh;
        this.mh = mh;
        this.hd = hd;
    }

    public int total(){
        return this.hd.getAmount() * this.mh.getPrice();
    }

    public int benifit(){
        return this.hd.getAmount() * (this.mh.getPrice() - this.mh.getPurcharse());
    }

    @Override
    public String toString(){
        return this.hd.getIdHd() + " " + this.kh.getNameCus() + " " + this.kh.getAddressCus() + " " 
        + this.mh.getNameMh() + " " + this.hd.getAmount() + " " + total() + " " + benifit();
    }
}

public class quan_ly_ban_hang_2_J06006 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = Integer.parseInt(scn.nextLine());
        
        ArrayList<KhachHang> arrKh = new ArrayList<>();
        while(t-- > 0){
            arrKh.add(new KhachHang(scn.nextLine(), scn.nextLine(), scn.nextLine(), scn.nextLine()));
        }
        
        t = Integer.parseInt(scn.nextLine());
        ArrayList<MatHang> arrMh = new ArrayList<>();
        while(t-- > 0){
            arrMh.add(new MatHang(scn.nextLine(), scn.nextLine(), Integer.parseInt(scn.nextLine()), Integer.parseInt(scn.nextLine())));
        }

        t = Integer.parseInt(scn.nextLine());

        ArrayList<Invoice> arr = new ArrayList<>();
        while(t-- > 0){
            String[] a = scn.nextLine().trim().split("\\s+");
            HoaDon bill = new HoaDon(a[0], a[1], Integer.parseInt(a[2]));
            
            KhachHang customer = new KhachHang();
            for(KhachHang x : arrKh){
                if(x.getIdCus().equals(bill.getIdCus())){
                    customer = x;
                    break;
                }
            }

            MatHang product = new MatHang();
            for(MatHang x : arrMh){
                if(bill.getIdMh().equals(x.getIdMh())){
                    product = x;
                    break;
                }
            }

            Invoice inv = new Invoice(customer, product,bill);
            arr.add(inv);
        }

        Collections.sort(arr, (o1, o2) -> (o2.benifit() - o1.benifit()));
        for(Invoice x : arr){
            System.out.println(x);
        }
        scn.close();
    }
}
