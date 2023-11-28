import java.util.ArrayList;
import java.util.Scanner;

class GiangVien{
    private String id, name;
    private double heso;
    private String kk;
    private int gionc;

    public static int cnt = 0;

    public GiangVien(String name, double heso, String kk, int gionc) {
        this.id = "PM" + String.format("%03d", ++cnt);
        this.name = name;
        this.heso = heso;
        this.kk = kk;
        this.gionc = gionc;
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

    public String getTen(){
        String[] a = this.name.trim().split("\\s+");
        return a[a.length - 1];
    }

    public String getHo(){
        String[] a = this.name.trim().split("\\s+");
        return a[0];
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeso(double heso) {
        this.heso = heso;
    }

    public int getGionc() {
        return gionc;
    }

    public void setGionc(int gionc) {
        this.gionc = gionc;
    }

    public static int getCnt() {
        return cnt;
    }

    public static void setCnt(int cnt) {
        GiangVien.cnt = cnt;
    }

    public double getHesokk(){
        if(this.kk.equals("A")) return 1.5;
        else if(this.kk.equals("B")) return 1.2;
        else return 1;
    }

    public double luongLinh(){
        double tmp = 1;
        if(this.gionc >= 500) tmp = 1;
        else if(this.gionc >= 351) tmp = 1 - 0.05;
        else if(this.gionc >= 101) tmp = 1 - 0.1;
        else tmp = 1 - 0.15;
        return this.heso * this.getHesokk() * 3000 * tmp;
    }

    @Override
    public String toString(){
        return this.id + " " + this.name + " " + this.heso + " " + this.kk + " " + this.gionc + " " + Math.round(luongLinh());
    }
}

public class tinh_luong_giang_vien {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        ArrayList<GiangVien> arr = new ArrayList<>();

        while(t-- >0){
            scn.nextLine();
            GiangVien x = new GiangVien(scn.nextLine(), Double.parseDouble(scn.nextLine()), scn.nextLine(), scn.nextInt());
            arr.add(x);
        }   
        
        // Collections.sort(arr, new Comparator<GiangVien>() {
        //     @Override
        //     public int compare(GiangVien o1, GiangVien o2){
        //         if(!o1.getTen().equals(o2.getTen())){
        //             return o1.getTen().compareTo(o2.getTen());
        //         }
        //         else if(!o1.getHo().equals(o2.getHo())){
        //             return o1.getHo().compareTo(o2.getHo());
        //         }
        //         else return o1.getName().compareTo(o2.getName());

        //     }
        // });
        scn.nextLine();
        String id = scn.nextLine();
        boolean flag = false;   

        for(GiangVien x : arr){
            if(x.getId().equals(id)){
                flag = true;
                break;
            }
        }
        System.out.println(flag ? "xoa thanh cong!" : "khong tim thay");
    }
}
