
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class MonHoc{
    private String idMh, nameMh;

    public MonHoc(){}

    public MonHoc(MonHoc o){
        this.idMh = o.idMh;
        this.nameMh = o.nameMh;
    }

    public MonHoc(String idMh, String nameMh) {
        this.idMh = idMh;
        this.nameMh = nameMh;
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
}

class GiangVien{
    private String idGv, nameGv;

    public GiangVien(){}

    public GiangVien(GiangVien o){
        this.idGv = o.idGv;
        this.nameGv = o.nameGv;
    }

    public GiangVien(String idGv, String nameGv) {
        this.idGv = idGv;
        this.nameGv = nameGv;
    }

    public String getIdGv() {
        return idGv;
    }

    public void setIdGv(String idGv) {
        this.idGv = idGv;
    }

    public String getNameGv() {
        return nameGv;
    }

    public void setNameGv(String nameGv) {
        this.nameGv = nameGv;
    }
}

class HocPhan{
    private String idGv, idMh;
    private double hour;

    public HocPhan(){}

    public HocPhan(HocPhan o){
        this.idGv = o.idGv;
        this.idMh = o.idMh;
        this.hour = o.hour;
    }

    public HocPhan(String idGv, String idMh, double hour) {
        this.idGv = idGv;
        this.idMh = idMh;
        this.hour = hour;
    }
    public String getIdGv() {
        return idGv;
    }
    public void setIdGv(String idGv) {
        this.idGv = idGv;
    }
    public String getIdMh() {
        return idMh;
    }
    public void setIdMh(String idMh) {
        this.idMh = idMh;
    }
    public double getHour() {
        return hour;
    }
    public void setHour(double hour) {
        this.hour += hour;
    }
}

class LopHoc{
    private GiangVien gv;
    private MonHoc mh;
    private HocPhan hp;

    public LopHoc(GiangVien gv, MonHoc mh, HocPhan hp) {
        this.gv = gv;
        this.mh = mh;
        this.hp = hp;
    }

    public GiangVien getGv() {
        return gv;
    }

    public void setGv(GiangVien gv) {
        this.gv = gv;
    }

    public MonHoc getMh() {
        return mh;
    }

    public void setMh(MonHoc mh) {
        this.mh = mh;
    }

    public HocPhan getHp() {
        return hp;
    }

    public void setHp(HocPhan hp) {
        this.hp = hp;
    }

    @Override
    public String toString(){
        String ans = String.format("%.2f",this.hp.getHour());
        String tmp = ans.replace(',', '.');
        return this.gv.getNameGv() + " " +  tmp;
    }
}

public class tinh_gio_chuan_cho_tung_giang_vien_J06008{
    public static void main(String[] args) {
        Scanner scn =  new Scanner(System.in);
        int t = Integer.parseInt(scn.nextLine());
        ArrayList<MonHoc> arrMh = new ArrayList<>();
        while(t-- > 0){
            arrMh.add(new MonHoc(scn.next(), scn.nextLine().trim()));
        }

        t = Integer.parseInt(scn.nextLine());
        ArrayList<GiangVien> arrGv = new ArrayList<>();
        while(t-- > 0){
            arrGv.add(new GiangVien(scn.next(), scn.nextLine().trim()));
        }
        
        t = Integer.parseInt(scn.nextLine());
        ArrayList<LopHoc> arr = new ArrayList<>();
        ArrayList<LopHoc> arrSimp = new ArrayList<>();
        while(t-- > 0){
            String[] a = scn.nextLine().split("\\s+");
            HocPhan hp = new HocPhan(a[0], a[1], Double.parseDouble(a[2]));
            GiangVien gv = new GiangVien();
            for(GiangVien x : arrGv){
                if(hp.getIdGv().equals(x.getIdGv())){
                    gv = x;
                    break;
                }
            }

            MonHoc mh = new MonHoc();
            for(MonHoc x : arrMh){
                if(hp.getIdMh().equals(x.getIdMh())){
                    mh = x;
                    break;
                }
            }

            arrSimp.add(new LopHoc(new GiangVien(gv), new MonHoc(mh), new HocPhan(hp)));

            boolean flag = false;
            for(LopHoc x : arr){
                if(x.getGv().getIdGv().equals(hp.getIdGv())){
                    flag = true;
                    x.getHp().setHour(Double.parseDouble(a[2]));
                    break;
                }
            }
            if(!flag){
                LopHoc lopHoc = new LopHoc(gv, mh, hp);
                arr.add(lopHoc);
            }
        }
        String idGv = scn.nextLine();
        for(LopHoc x : arr){
            if(x.getGv().getIdGv().equals(idGv)){
                System.out.println("Giang vien: " + x.getGv().getNameGv());   
                for(LopHoc y : arrSimp){
                    if(y.getGv().getIdGv().equals(idGv))
                        System.out.println(y.getMh().getNameMh() + " " + y.getHp().getHour());
                }
                String tmp = String.format("%.2f", x.getHp().getHour()).replace(',','.');
                System.out.println("Tong: " + tmp);
            }
        }
        scn.close();
    }   
}

