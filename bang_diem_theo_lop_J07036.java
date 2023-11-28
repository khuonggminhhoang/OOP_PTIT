import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class SinhVien{
    private String idSv, nameSv, classs, emailSv;

    public SinhVien(){}

    public SinhVien(String idSv, String nameSv, String classs, String emailSv) {
        this.idSv = idSv;
        this.nameSv = nameStd(nameSv);
        this.classs = classs;
        this.emailSv = emailSv;
    }

    protected String nameStd(String s){
        String[] arr = s.trim().split("\\s+");
        String name = "";
        for(String x : arr){
            name += Character.toUpperCase(x.charAt(0)) + x.substring(1).toLowerCase() + " ";
        }
        return name.substring(0, name.length() - 1);
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

    public String getClasss() {
        return classs;
    }

    public void setClasss(String classs) {
        this.classs = classs;
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
    private int cre; // tín chỉ

    public MonHoc(){}

    public MonHoc(String idMh, String nameMh, int cre) {
        this.idMh = idMh;
        this.nameMh = nameMh;
        this.cre = cre;
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

    public int getCre() {
        return cre;
    }

    public void setCre(int cre) {
        this.cre = cre;
    } 
}

class BangDiem{
    private SinhVien sv;
    private MonHoc mh;
    private String mark;
    
    public BangDiem(SinhVien sv, MonHoc mh, String mark) {
        this.sv = sv;
        this.mh = mh;
        this.mark = mark;
    }

    public SinhVien getSv() {
        return sv;
    }

    public void setSv(SinhVien sv) {
        this.sv = sv;
    }

    public MonHoc getMh() {
        return mh;
    }

    public void setMh(MonHoc mh) {
        this.mh = mh;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    @Override
    public String toString(){
        return this.sv.getIdSv() + " " + this.sv.getNameSv() + " " + this.mh.getIdMh() + " " + this.mh.getNameMh() + " " + this.mark;
    }
}

public class bang_diem_theo_lop_J07036 {
    public static ArrayList<SinhVien> inpSv() throws FileNotFoundException{
        Scanner scn = new Scanner(new File("SINHVIEN.in"));
        ArrayList<SinhVien> arr = new ArrayList<>();
        int t = Integer.parseInt(scn.nextLine());
        while(t-- > 0){
            arr.add(new SinhVien(scn.nextLine(), scn.nextLine(), scn.nextLine(), scn.nextLine()));
        }
        scn.close();
        return arr;
    }

    public static ArrayList<MonHoc> inpMh() throws FileNotFoundException{
        Scanner scn = new Scanner(new File("MONHOC.in"));
        ArrayList<MonHoc> arr = new ArrayList<>();
        int t = Integer.parseInt(scn.nextLine());
        while (t-- > 0) {
            arr.add(new MonHoc(scn.nextLine(), scn.nextLine(), Integer.parseInt(scn.nextLine())));
        }
        scn.close();
        return arr;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scn = new Scanner(new File("BANGDIEM.in"));
        int t = Integer.parseInt(scn.nextLine());
        ArrayList<SinhVien> arrSv = inpSv();
        ArrayList<MonHoc> arrMh = inpMh();
        ArrayList<BangDiem> arrBd = new ArrayList<>();
        while(t-- >0){
            String line = scn.nextLine();
            String[] tmp = line.trim().split("\\s+");
            SinhVien sv = new SinhVien(); 
            MonHoc mh = new MonHoc();
            for(SinhVien x : arrSv){
                if(x.getIdSv().equals(tmp[0])){
                    sv = x;
                    break;
                }
            }
            for(MonHoc x : arrMh){
                if(x.getIdMh().equals(tmp[1])){
                    mh = x;
                    break;
                }
            }
            
            arrBd.add(new BangDiem(sv, mh, tmp[2]));
        }   
        Collections.sort(arrBd, new Comparator<BangDiem>() {

            @Override
            public int compare(BangDiem o1, BangDiem o2) {
                if(!o1.getMh().getIdMh().equals(o2.getMh().getIdMh())){
                    return o1.getMh().getIdMh().compareTo(o2.getMh().getIdMh());
                }
                else{
                    return o1.getSv().getIdSv().compareTo(o2.getSv().getIdSv());
                }
            }
            
        });

        t = Integer.parseInt(scn.nextLine());
        while(t-- > 0){
            String classs = scn.nextLine();
            System.out.println("BANG DIEM lop " + classs + ":" );
            for(BangDiem x : arrBd){
                if(x.getSv().getClasss().equals(classs)){
                    System.out.println(x);
                }
            }
        }
    }
}
