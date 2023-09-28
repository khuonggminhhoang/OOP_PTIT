import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface IGiaoDich{
    public double getThanhTien();
}

interface ChucNang{
    public void nhapGDVang();
    public void nhapGDTT();
    public void out();
    public void xoa();
    // sua, xoa, sap xep, tim kiem
    public void sua();
    public void timTheoLoaiTien();
    public void timTheoGia();
    public void sapxeptheoGia();
    public void sapxepGDVangTheoGia();
    // cau thong ke
}

class GiaoDich implements IGiaoDich{
    private String ma, ngay;
    private double gia;
    private int soluong;
    public static int cnt = 0;
    
    public GiaoDich() {
    }

    public GiaoDich(String ma, String ngay, double gia, int soluong) {
        this.ma = ma;
        this.ngay = ngay;
        this.gia = gia;
        this.soluong = soluong;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    @Override
    public double getThanhTien() {
        return this.getSoluong() * this.getGia();
    }
}

class GiaoDichVang extends GiaoDich {
    private String loaivang;

    public GiaoDichVang() {}

    public GiaoDichVang(String ma,String loaivang, String ngay, double gia, int soluong) {
        super(ma, ngay, gia, soluong);
        this.loaivang = loaivang;
    }

    public String getMa(){
        return "v" + (super.cnt++);
    }

    public String getLoaivang() {
        return loaivang;
    }

    public void setLoaivang(String loaivang) {
        this.loaivang = loaivang;
    }

    public String toString()
    {
        return getMa()+"\t"+getNgay()+"\t"+
        getSoluong()+"\t"+getLoaivang()+"\t"+getThanhTien();
    }
}
 

class GiaoDichTienTe extends GiaoDich {
    private double tigia;
    private String loaitien;

    public GiaoDichTienTe() {
    }
    public GiaoDichTienTe(String ma, String ngay, double gia, int soluong, double tigia, String loaitien) {
        super(ma, ngay, gia, soluong);
        this.tigia = tigia;
        this.loaitien = loaitien;
    }
   
    public double getTigia() {
        return tigia;
    }
    public void setTigia(double tigia) {
        this.tigia = tigia;
    }
    public String getLoaitien() {
        return loaitien;
    }
    public void setLoaitien(String loaitien) {
        this.loaitien = loaitien;
    }

    @Override
    public double getThanhTien(){
        if(this.getLoaitien().equalsIgnoreCase("VN")){
            return super.getThanhTien();
        }
        else{
            return super.getThanhTien() * this.tigia;
        }
    }

    @Override
    public String toString()
    {
        return getMa()+"\t"+getNgay()+"\t"+
        getSoluong()+"\t"+getLoaitien()+"\t"+getTigia()+"\t"+String.format("%f",getThanhTien());
    }
}



class NganHang implements ChucNang{
    private List<GiaoDich> list;

    public NganHang() {
        list = new ArrayList<>();
        // list.add(new GiaoDichVang("V777","9999", "10/09/2023", 65000, 2));
        // list.add(new GiaoDichVang("V780", "24k", "20/09/2023", 10000, 3));
        // list.add(new GiaoDichTienTe("TT87", "1/5/2023",50000, 23, 0.5, "VN"));
    }
    
    

    @Override
    public void nhapGDVang() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'nhapGDVang'");
    }

    @Override
    public void nhapGDTT() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'nhapGDTT'");
    }

@Override
    public void out() {
        // TODO Auto-generated method stub
        for(GiaoDich i: list)
        {
            System.out.println(i);
        }
        System.out.printf("Tong: %d", list.size());
    }

    @Override
    public void xoa() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'xoa'");
    }



    @Override
    public void sua() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sua'");
    }



    @Override
    public void timTheoLoaiTien() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'timTheoLoaiTien'");
    }



    @Override
    public void timTheoGia() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'timTheoGia'");
    }



    @Override
    public void sapxeptheoGia() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sapxeptheoGia'");
    }



    @Override
    public void sapxepGDVangTheoGia() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sapxepGDVangTheoGia'");
    }

    
}

public class q6 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- >0){
            
        }   
        scn.close();
    }
}
