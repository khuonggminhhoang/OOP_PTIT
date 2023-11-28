import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Comparator;

class SanPham{
    private String maSp, tenSp;
    private int giaSp, baoHanh;

    public SanPham(){}

    public SanPham(String maSp, String tenSp, int giaSp, int baoHanh) {
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.giaSp = giaSp;
        this.baoHanh = baoHanh;
    }

    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public int getGiaSp() {
        return giaSp;
    }

    public void setGiaSp(int giaSp) {
        this.giaSp = giaSp;
    }

    public int getBaoHanh() {
        return baoHanh;
    }

    public void setBaoHanh(int baoHanh) {
        this.baoHanh = baoHanh;
    }
}

class KhachHang{
    private String maKh, tenKh, diaChiKh, maSp;
    private int soLuong;
    private String ngayMua;

    public static int cnt = 0;

    public KhachHang(){}

    public KhachHang(String tenKh, String diaChiKh, String maSp, int soLuong, String ngayMua) {
        this.maKh = "KH" + String.format("%02d", ++cnt);
        this.tenKh = tenKh;
        this.diaChiKh = diaChiKh;
        this.maSp = maSp;
        this.soLuong = soLuong;
        this.ngayMua = ngayMua;
    }

    public String getMaKh() {
        return maKh;
    }

    public void setMaKh(String maKh) {
        this.maKh = maKh;
    }

    public String getTenKh() {
        return tenKh;
    }

    public void setTenKh(String tenKh) {
        this.tenKh = tenKh;
    }

    public String getDiaChiKh() {
        return diaChiKh;
    }

    public void setDiaChiKh(String diaChiKh) {
        this.diaChiKh = diaChiKh;
    }

    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(String ngayMua) {
        this.ngayMua = ngayMua;
    }
}

class HoaDon{
    private SanPham sp;
    private KhachHang kh;

    public HoaDon(){}

    public HoaDon(SanPham sp, KhachHang kh) {
        this.sp = sp;
        this.kh = kh;
    }

    public int total(){
        return this.kh.getSoLuong() * this.sp.getGiaSp();
    }

    public String ngayHetHanBaoHanh(){
        String[] arr = this.kh.getNgayMua().split("/");
        LocalDate lcd = LocalDate.of(Integer.parseInt(arr[2]), Integer.parseInt(arr[1]), Integer.parseInt(arr[0]));
        LocalDate date = lcd.plusMonths(1l * this.sp.getBaoHanh());
        String[] tmp = date.toString().split("-");
        String ans = "";
        for(int i=2; i>=0; --i){
            ans += tmp[i] + "/";
        }
        return ans.substring(0, ans.length() - 1);
    }

    @Override
    public String toString(){
        return this.kh.getMaKh() + " " + this.kh.getTenKh() + " " + this.kh.getDiaChiKh() + " " + this.sp.getMaSp() + " " + this.total() + " " + this.ngayHetHanBaoHanh();
    }

    public SanPham getSp() {
        return sp;
    }

    public void setSp(SanPham sp) {
        this.sp = sp;
    }

    public KhachHang getKh() {
        return kh;
    }

    public void setKh(KhachHang kh) {
        this.kh = kh;
    }
}

public class tinh_ngay_het_han_bao_hanh_J07049 {
    public static int conv(String date){
        String[] arr = date.split("/");
        return Integer.parseInt(arr[2] + arr[1] + arr[0]);
    }

    public static void main(String[] args) throws Exception{
        Scanner scn = new Scanner(new File("MUAHANG.in"));
        int t = Integer.parseInt(scn.nextLine());
        ArrayList<SanPham> arrSp = new ArrayList<>();
        while(t-- > 0){
            arrSp.add(new SanPham(scn.nextLine(), scn.nextLine(), Integer.parseInt(scn.nextLine()),Integer.parseInt(scn.nextLine())));
        }

        t = Integer.parseInt(scn.nextLine());
        ArrayList<HoaDon> arr = new ArrayList<>();
        while(t-- > 0){
            KhachHang kh = new KhachHang(scn.nextLine(), scn.nextLine(), scn.nextLine(), Integer.parseInt(scn.nextLine()), scn.nextLine());
            SanPham sp = new SanPham();
            for(SanPham x : arrSp){
                if(kh.getMaSp().equals(x.getMaSp())){
                    sp = x;
                    break;
                }
            }
            arr.add(new HoaDon(sp, kh));
        }

        Collections.sort(arr, new Comparator<HoaDon>(){
            @Override
            public int compare(HoaDon o1, HoaDon o2){
                if(conv(o1.ngayHetHanBaoHanh()) != conv(o2.ngayHetHanBaoHanh())){
                    return conv(o1.ngayHetHanBaoHanh()) - conv(o2.ngayHetHanBaoHanh());
                }
                else return o1.getKh().getMaKh().compareTo(o2.getKh().getMaKh());
            }
        });

        for(HoaDon x : arr){
            System.out.println(x);
        }
    }
}
