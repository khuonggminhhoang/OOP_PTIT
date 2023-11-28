import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

class SinhVien implements Serializable{
    private String ma, ten, lop;
    private Date ngaysinh;
    private double gpa;

    public static int cnt = 0;

    public SinhVien(String ten, String lop, String ngaysinh, double gpa) throws ParseException {
        this.ma = "B20DCCN" + String.format("%03d", ++cnt);
        this.ten = ten;
        this.lop = lop;
        this.ngaysinh = new SimpleDateFormat("dd/MM/yyyy").parse(ngaysinh);
        this.gpa = gpa;
    }

    @Override
    public String toString(){
        DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        return this.ma + " " + this.ten + " " + this.lop + " " + date.format(this.ngaysinh) + " " + String.format("%.2f", this.gpa);
    }
}

public class danh_sach_sinh_vien_trong_file_nhi_phan_J07013 {
    public static void main(String[] args) throws Exception{
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("SV.in"));
        ArrayList<SinhVien> arr = (ArrayList<SinhVien>) input.readObject();
        for(SinhVien x : arr){
            System.out.println(x);
        }
        input.close();
    }
}
