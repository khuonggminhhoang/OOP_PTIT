import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class SinhVien{
    private String idSv, nameSv, classSv, emailSv;

    public SinhVien(){}

    public SinhVien(String idSv, String nameSv, String classSv, String emailSv) {
        this.idSv = idSv;
        this.nameSv = nameStd(nameSv);
        this.classSv = classSv;
        this.emailSv = emailSv;
    }

    private String nameStd(String s){
        String[] arr = s.trim().split("\\s+");
        String ans = "";
        for(String x : arr){
            ans += Character.toUpperCase(x.charAt(0)) + x.substring(1).toLowerCase() + " ";  
        } 
        return ans.substring(0, ans.length() - 1);
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

    public String getClassSv() {
        return classSv;
    }

    public void setClassSv(String classSv) {
        this.classSv = classSv;
    }

    public String getEmailSv() {
        return emailSv;
    }

    public void setEmailSv(String emailSv) {
        this.emailSv = emailSv;
    }
}

class MonHoc{
    private String idMh, nameMh;
    private int amountMh;

    public MonHoc(){}

    public MonHoc(String idMh, String nameMh, int amountMh) {
        this.idMh = idMh;
        this.nameMh = nameMh;
        this.amountMh = amountMh;
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
    public int getAmountMh() {
        return amountMh;
    }
    public void setAmountMh(int amountMh) {
        this.amountMh = amountMh;
    }
}

class BangDiem{
    private MonHoc mh;
    private SinhVien sv;
    private String idSv, idMh;
    private double mark;

    public BangDiem(String idSv, String idMh, double mark) {
        this.idSv = idSv;
        this.idMh = idMh;
        this.mark = mark;
    }

    public MonHoc getMh() {
        return mh;
    }
    
    public void setMh(MonHoc mh) {
        this.mh = mh;
    }
    
    public SinhVien getSv() {
        return sv;
    }
    
    public void setSv(SinhVien sv) {
        this.sv = sv;
    }
    
    public String getIdSv() {
        return idSv;
    }
    
    public void setIdSv(String idSv) {
        this.idSv = idSv;
    }
    
    public String getIdMh() {
        return idMh;
    }
    
    public void setIdMh(String idMh) {
        this.idMh = idMh;
    }
    
    public double getMark() {
        return mark;
    }
    
    public void setMark(double mark) {
        this.mark = mark;
    }    

    @Override
    public String toString(){
        String tmp = (this.mark == (int)this.mark) ? (int) this.mark + "" : this.mark + "";  
        return this.idSv + " " + this.sv.getNameSv() + " " + this.sv.getClassSv() + " " + tmp;
    }
}

public class bang_diem_theo_mon_hoc_J07035 {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(new File("SINHVIEN.in"));
        int t = Integer.parseInt(scn.nextLine());
        ArrayList<SinhVien> arrSv = new ArrayList<>();
        while(t-- >0){
            arrSv.add(new SinhVien(scn.nextLine(), scn.nextLine(), scn.nextLine(), scn.nextLine()));
        }   

        scn = new Scanner(new File("MONHOC.in"));
        t = Integer.parseInt(scn.nextLine());
        ArrayList<MonHoc> arrMh = new ArrayList<>();
        while(t-- > 0){
            arrMh.add(new MonHoc(scn.nextLine(), scn.nextLine(), Integer.parseInt(scn.nextLine())));
        }

        scn = new Scanner(new File("BANGDIEM.in"));
        t = Integer.parseInt(scn.nextLine());
        ArrayList<BangDiem> arr = new ArrayList<>();
        while(t-- > 0){
            String[] a = scn.nextLine().split("\\s+");
            String idSv = a[0];
            String idMh = a[1];
            double mark = Double.parseDouble(a[2]);
            BangDiem bd = new BangDiem(idSv, idMh, mark);

            for(SinhVien x : arrSv){
                if(x.getIdSv().equals(idSv)){
                    bd.setSv(x);
                    break;
                }
            }

            for(MonHoc x : arrMh){
                if(x.getIdMh().equals(idMh)){
                    bd.setMh(x);
                    break;
                }
            }

            arr.add(bd);
        }

        Collections.sort(arr, new Comparator<BangDiem>(){
            @Override
            public int compare(BangDiem o1, BangDiem o2){
                if(o1.getMark() != o2.getMark()){
                    return Double.compare(o2.getMark(), o1.getMark());
                }
                else{
                    return o1.getSv().getIdSv().compareTo(o2.getSv().getIdSv());
                }
            }
        });

        t = Integer.parseInt(scn.nextLine());
        while(t-- > 0){
            System.out.print("BANG DIEM MON ");
            String idMh = scn.nextLine();
            for(MonHoc x : arrMh){
                if(x.getIdMh().equals(idMh)){
                    System.out.println(x.getNameMh() + ":");
                    break;
                }
            }
            for(BangDiem x : arr){
                if(x.getIdMh().equals(idMh)){
                    System.out.println(x);
                }
            }
        }
    }
}
