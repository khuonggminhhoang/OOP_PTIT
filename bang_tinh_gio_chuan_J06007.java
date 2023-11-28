import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class MonHoc{
    private String idMh, nameMh;

    public MonHoc(){}

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

public class bang_tinh_gio_chuan_J06007{
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
        for(LopHoc x : arr){
            System.out.println(x);
        }
    }   
}

