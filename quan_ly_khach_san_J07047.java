import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class KhachSan{
    private char loaiPhong;
    private String tenLoaiPhong;
    private double donGia, phiDichVu;

    public KhachSan(){}
    
    public KhachSan(char loaiPhong, String tenLoaiPhong, double donGia, double phiDichVu) {
        this.loaiPhong = loaiPhong;
        this.tenLoaiPhong = tenLoaiPhong;
        this.donGia = donGia;
        this.phiDichVu = phiDichVu;
    }

    public char getLoaiPhong() {
        return loaiPhong;
    }

    public void setLoaiPhong(char loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    public String getTenLoaiPhong() {
        return tenLoaiPhong;
    }

    public void setTenLoaiPhong(String tenLoaiPhong) {
        this.tenLoaiPhong = tenLoaiPhong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getPhiDichVu() {
        return phiDichVu;
    }

    public void setPhiDichVu(double phiDichVu) {
        this.phiDichVu = phiDichVu;
    }
}

class KhachHang{
    private String maKhachHang, tenKhachHang, maPhong, ngayDen, ngayDi;

    public static int cnt = 0;

    public KhachHang(String tenKhachHang, String maPhong, String ngayDen, String ngayDi) {
        this.maKhachHang = "KH" + String.format("%02d", ++cnt);
        this.tenKhachHang = tenKhachHang;
        this.maPhong = maPhong;
        this.ngayDen = ngayDen;
        this.ngayDi = ngayDi;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getNgayDen() {
        return ngayDen;
    }

    public void setNgayDen(String ngayDen) {
        this.ngayDen = ngayDen;
    }

    public String getNgayDi() {
        return ngayDi;
    }

    public void setNgayDi(String ngayDi) {
        this.ngayDi = ngayDi;
    }

    public int getDay(){
        String[] start = this.ngayDen.trim().split("/");
        LocalDate s = LocalDate.of(Integer.parseInt(start[2]), Integer.parseInt(start[1]), Integer.parseInt(start[0])); 
        String[] end = this.ngayDi.trim().split("/");
        LocalDate e = LocalDate.of(Integer.parseInt(end[2]), Integer.parseInt(end[1]), Integer.parseInt(end[0]));
        return (int) ChronoUnit.DAYS.between(s, e);
    }
}

class HoaDon{
    private KhachSan ks;
    private KhachHang kh;

    public HoaDon(KhachSan ks, KhachHang kh){
        this.ks = ks;
        this.kh = kh;
    }

    public KhachSan getKs() {
        return ks;
    }
    public void setKs(KhachSan ks) {
        this.ks = ks;
    }
    public KhachHang getKh() {
        return kh;
    }
    public void setKh(KhachHang kh) {
        this.kh = kh;
    }

    public double total(){
        int tmp = (this.kh.getDay() < 1 ) ? 1 : this.kh.getDay();
        double ans = tmp * this.ks.getDonGia() * (1 + this.ks.getPhiDichVu());
        if(this.kh.getDay() > 30) ans *= 0.94; 
        else if(this.kh.getDay() >= 20) ans *= 0.96;
        else if(this.kh.getDay() >= 10) ans *= 0.98;
        else ans *= 1;
        return ans;
    }

    @Override
    public String toString(){
        return this.kh.getMaKhachHang() + " " + this.kh.getTenKhachHang() + " " + this.kh.getMaPhong() + " " + this.kh.getDay() + " " + String.format("%.2f", this.total());
    }
}

public class quan_ly_khach_san_J07047 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scn = new Scanner(new File("DATA.in"));
        int t = Integer.parseInt(scn.nextLine());
        ArrayList<KhachSan> arrKs = new ArrayList<>();
        while(t-- >0){
            String[] tmp = scn.nextLine().split("\\s+");
            arrKs.add(new KhachSan(tmp[0].charAt(0), tmp[1], Double.parseDouble(tmp[2]),Double.parseDouble(tmp[3])));
        }   

        ArrayList<HoaDon> arr = new ArrayList<>();
        t = Integer.parseInt(scn.nextLine());
        while(t-- > 0){
            KhachHang kh = new KhachHang(scn.nextLine(), scn.nextLine(), scn.nextLine(), scn.nextLine());
            KhachSan ks = new KhachSan();
            for(KhachSan x : arrKs){
                if(kh.getMaPhong().charAt(2) == x.getLoaiPhong()){
                    ks = x;
                    break;
                }
            }
            arr.add(new HoaDon(ks, kh));
        }

        Collections.sort(arr, new Comparator<HoaDon>(){

            @Override
            public int compare(HoaDon o1, HoaDon o2) {
                return o2.getKh().getDay() - o1.getKh().getDay();
            }

        });

        for(HoaDon x : arr){
            System.out.println(x);
        }
    }
}
