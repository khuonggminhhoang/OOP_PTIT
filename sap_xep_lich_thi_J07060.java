import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class MonThi{
    private String maMt, tenMt, hinhThucThiMt;

    public MonThi(){}

    public MonThi(String maMt, String tenMt, String hinhThucThiMt) {
        this.maMt = maMt;
        this.tenMt = tenMt;
        this.hinhThucThiMt = hinhThucThiMt;
    }

    public String getMaMt() {
        return maMt;
    }

    public void setMaMt(String maMt) {
        this.maMt = maMt;
    }

    public String getTenMt() {
        return tenMt;
    }

    public void setTenMt(String tenMt) {
        this.tenMt = tenMt;
    }

    public String getHinhThucThiMt() {
        return hinhThucThiMt;
    }

    public void setHinhThucThiMt(String hinhThucThiMt) {
        this.hinhThucThiMt = hinhThucThiMt;
    }
}

class CaThi{
    private String maCt, ngayThi, gioThi, phongThi;

    public static int cnt = 0;

    public CaThi(){}

    public CaThi(String ngayThi, String gioThi, String phongThi) {
        this.maCt = "C" + String.format("%03d", ++cnt);
        this.ngayThi = ngayThi;
        this.gioThi = gioThi;
        this.phongThi = phongThi;
    }

    public String getMaCt() {
        return maCt;
    }

    public void setMaCt(String maCt) {
        this.maCt = maCt;
    }

    public String getNgayThi() {
        return ngayThi;
    }

    public void setNgayThi(String ngayThi) {
        this.ngayThi = ngayThi;
    }

    public String getGioThi() {
        return gioThi;
    }

    public void setGioThi(String gioThi) {
        this.gioThi = gioThi;
    }

    public String getPhongThi() {
        return phongThi;
    }

    public void setPhongThi(String phongThi) {
        this.phongThi = phongThi;
    }

    public static int getCnt() {
        return cnt;
    }

    public static void setCnt(int cnt) {
        CaThi.cnt = cnt;
    }
}

class LichThi{
    private CaThi cathi;
    private MonThi monthi;
    private String nhom, soSv;

    public LichThi(){}

    public LichThi(CaThi cathi, MonThi monthi, String nhom, String soSv) {
        this.cathi = cathi;
        this.monthi = monthi;
        this.nhom = nhom;
        this.soSv = soSv;
    }

    public CaThi getCathi() {
        return cathi;
    }

    public void setCathi(CaThi cathi) {
        this.cathi = cathi;
    }

    public MonThi getMonthi() {
        return monthi;
    }

    public void setMonthi(MonThi monthi) {
        this.monthi = monthi;
    }

    public String getNhom() {
        return nhom;
    }

    public void setNhom(String nhom) {
        this.nhom = nhom;
    }

    public String getSoSv() {
        return soSv;
    }

    public void setSoSv(String soSv) {
        this.soSv = soSv;
    }

    @Override
    public String toString(){
        return this.cathi.getNgayThi() + " " + this.cathi.getGioThi() + " " + this.cathi.getPhongThi() + " " + this.monthi.getTenMt() + " " + this.nhom + " " + this.soSv;
    }
}

public class sap_xep_lich_thi_J07060 {
    public static int convh(String time){
        return Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));
    }

    public static int conv(String date){
        String[] arr = date.split("/");
        return Integer.parseInt(arr[2] + arr[1] + arr[0]);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scn = new Scanner(new File("MONTHI.in"));
        int t = scn.nextInt();
        scn.nextLine();
        ArrayList<MonThi> arrMt = new ArrayList<>();
        while(t-- >0){
            arrMt.add(new MonThi(scn.nextLine(), scn.nextLine(), scn.nextLine()));
        }   

        scn = new Scanner(new File("CATHI.in"));
        t = Integer.parseInt(scn.nextLine());
        ArrayList<CaThi> arrCt = new ArrayList<>();
        while (t-- > 0) {
            arrCt.add(new CaThi(scn.nextLine(), scn.nextLine(), scn.nextLine()));
        }

        ArrayList<LichThi> arr = new ArrayList<>();
        scn = new Scanner(new File("LICHTHI.in"));
        t = Integer.parseInt(scn.nextLine());
        while(t-- > 0){
            String[] a = scn.nextLine().split("\\s+");
            CaThi ct = new CaThi();
            MonThi mt = new MonThi();
            for(CaThi x : arrCt){
                if(x.getMaCt().equals(a[0])){
                    ct = x;
                    break;
                }
            }

            for(MonThi x : arrMt){
                if(x.getMaMt().equals(a[1])){
                    mt = x;
                    break;
                }
            }

            arr.add(new LichThi(ct, mt, a[2], a[3]));
        }

        Collections.sort(arr, new java.util.Comparator<LichThi>(){

            @Override
            public int compare(LichThi o1, LichThi o2) {
                if(conv(o1.getCathi().getNgayThi()) != (conv(o2.getCathi().getNgayThi()))){
                    return conv(o1.getCathi().getNgayThi()) - (conv(o2.getCathi().getNgayThi()));
                }
                else if(convh(o1.getCathi().getGioThi()) != convh(o2.getCathi().getGioThi())){
                    return convh(o1.getCathi().getGioThi()) - convh(o2.getCathi().getGioThi());
                }
                else{
                    return o1.getCathi().getMaCt().compareTo(o2.getCathi().getMaCt());
                }
            }

        });

        for(LichThi x : arr){
            System.out.println(x);
        }
    }
}
