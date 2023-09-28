import java.util.Scanner;

class NhanVien{
    private String id, name, gender, dateOfBirth, address, taxCode, dayContract;

    public static int cnt = 0;

    public NhanVien(String name, String gender, String dateOfBirth, String address, String taxCode,
            String dayContract) {
        this.id = String.format("%05d", ++cnt);
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dayStd(dateOfBirth);
        this.address = address;
        this.taxCode = taxCode;
        this.dayContract = dayStd(dayContract);
    }

    private String dayStd(String s){
        StringBuilder sb = new StringBuilder(s);
        if(sb.charAt(1) == '/'){
            sb.insert(0,'0');
        }
        if(sb.charAt(4) == '/'){
            sb.insert(3,'0');
        }
        return sb.toString();
    }

    @Override
    public String toString(){
        return this.id + " " + this.name + " " + this.gender + " " + this.dateOfBirth
        + " " + this.address + " " + this.taxCode + " " + this.dayContract;
    }

}

public class danh_sach_doi_tuong_nhan_vien_J05006 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int t = Integer.parseInt(scn.nextLine());
        while(t-- > 0){
            NhanVien nv = new NhanVien(scn.nextLine(), scn.nextLine(), scn.nextLine(), scn.nextLine(), scn.nextLine(), scn.nextLine());
            System.out.println(nv);
        }
    }
}
