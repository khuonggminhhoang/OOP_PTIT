import java.util.Scanner;

class NhanVien{
    private String id , fullname, gender, birtOfDate, address, taxCode, dayContract;

    public NhanVien(String id, String fullname, String gender, String birtOfDate, String address, String taxCode, String dayContract) {
        this.id = id;
        this.fullname = fullname;
        this.gender = gender;
        this.birtOfDate = birtOfDate;
        this.address = address;
        this.taxCode = taxCode;
        this.dayContract = dayContract;
    }

    public String dayStd(String s){
        StringBuilder sb = new StringBuilder(s);
        if(sb.charAt(1) == '/'){
            sb.insert(0,'0');
        }
        if(sb.charAt(4) == '/'){
            sb.insert(3, '0');
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return this.id + " " + this.fullname + " " + this.gender + " " + this.dayStd(this.birtOfDate) + " " + this.address + " " + this.taxCode + " " + this.dayStd(this.dayContract);
    }
}

public class khai_bao_lop_nhan_vien_J04007 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        NhanVien nv = new NhanVien("00001", scn.nextLine(), scn.nextLine(), scn.nextLine(), scn.nextLine(), scn.nextLine(), scn.nextLine());
        System.out.println(nv);
    }
}
