import java.util.Scanner;

class GiaoVien{
    private String id, fullname;
    private long salary;
    public GiaoVien(String id, String fullname, long salary) {
        this.id = id;
        this.fullname = fullname;
        this.salary = salary;
    }

    public int allowance(){
        String tmp = this.id.substring(0,2);
        if(tmp.equals("HT")) return 2000000;
        else if(tmp.equals("HP")) return 900000;
        else return 500000;
    }

    public String level(){
        return this.id.substring(2,4);
    }

    public long income(){
        return this.salary * Integer.parseInt(this.level()) + this.allowance();
    }

    @Override
    public String toString(){
        return this.id + " " + this.fullname + " " + Integer.parseInt(this.level()) + " " + this.allowance() + " " + this.income();
    }
}

public class tinh_thu_nhap_giao_vien_J04015 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        GiaoVien gv = new GiaoVien(scn.nextLine(), scn.nextLine(), scn.nextLong());
        System.out.println(gv);
    }
}
