import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class SinhVien{
    private String idSv, nameSv, phoneSv;

    public SinhVien(){}

    public SinhVien(String idSv, String nameSv, String phoneSv) {
        this.idSv = idSv;
        this.nameSv = nameSv;
        this.phoneSv = phoneSv;
    }

    public String getIdSv() {
        return idSv;
    }

    public void setIdSv(String idSv) {
        this.idSv = idSv;
    }

    public String getNameSv() {
        return nameSv;
    }

    public void setNameSv(String nameSv) {
        this.nameSv = nameSv;
    }

    public String getPhoneSv() {
        return phoneSv;
    }

    public void setPhoneSv(String phoneSv) {
        this.phoneSv = phoneSv;
    }
}

class BaiTap{
    private int sttBt;
    private String nameBt;
    public static int cnt = 0;

    public BaiTap(){}
    
    public BaiTap(String nameBt) {
        this.sttBt = ++cnt;
        this.nameBt = nameBt;
    }

    public int getSttBt() {
        return sttBt;
    }

    public void setSttBt(int sttBt) {
        this.sttBt = sttBt;
    }

    public String getNameBt() {
        return nameBt;
    }

    public void setNameBt(String nameBt) {
        this.nameBt = nameBt;
    }
}

public class quan_ly_bai_tap_nhom_J07027 {
    public static void main(String[] args) throws Exception{
        Scanner scn = new Scanner(new File("SINHVIEN.in"));
        int t = Integer.parseInt(scn.nextLine());
        ArrayList<SinhVien> arrSv = new ArrayList<>();
        while(t-- >0){
            arrSv.add(new SinhVien(scn.nextLine(), scn.nextLine(), scn.nextLine()));
        }     

        scn = new Scanner(new File("BAITAP.in"));
        t = Integer.parseInt(scn.nextLine());
        ArrayList<BaiTap> arrBt = new ArrayList<>();
        while(t-- > 0){
            arrBt.add(new BaiTap(scn.nextLine()));
        }

        scn = new Scanner(new File("NHOM.in"));
        HashMap<String, String> map = new HashMap<>();
        while(scn.hasNext()){
            String ans = "";
            String[] a = scn.nextLine().trim().split("\\s+");
            for(SinhVien x : arrSv){
                if(x.getIdSv().equals(a[0])){
                    ans += a[0] + " " + x.getNameSv() + " " + x.getPhoneSv() + " ";
                    break;
                }
            }
            for(BaiTap x : arrBt){
                if(x.getSttBt() == Integer.parseInt(a[1])){
                    ans += a[1] + " " + x.getNameBt();
                    break;
                }
            }
            if(!ans.equals(""))
                map.put(a[0], ans);
        }
        ArrayList<Map.Entry<String, String>> arr = new ArrayList<>(map.entrySet());
        Collections.sort(arr, (a, b) -> a.getKey().compareTo(b.getKey()));
        for(Map.Entry<String, String> x : arr){
            System.out.println(x.getValue());
        }
    }
}
