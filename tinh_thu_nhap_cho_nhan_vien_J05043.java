import java.util.Scanner;

class NhanVien{
    private String id, name, position;
    private int simpSalary, workDay;

    public static int cnt = 0;
    public NhanVien(String name, String position, int simpSalary, int workDay) {
        this.id = "NV" + String.format("%02d", ++cnt);
        this.name = name;
        this.position = position;
        this.simpSalary = simpSalary;
        this.workDay = workDay;
    }

    public long salary(){
        return 1l *this.simpSalary * this.workDay;
    }

    public long allowance(){
        String s = this.position;
        if(s.equals("GD")) return 500;
        else if(s.equals("PGD")) return 400;
        else if(s.equals("TP")) return 300;
        else if(s.equals("KT")) return 250;
        else return 100;
    }

    public long tmpMoney(){
        double x = this.allowance() + this.salary() * 2/3.0;
        if( x< 25000) return Math.round(x/1000)*1000;
        else return 25000;
    }

    public long remain(){
        return this.salary() - this.tmpMoney() + this.allowance();
    }

    @Override
    public String toString(){
        return this.id + " " + this.name + " " + this.allowance() + " " + this.salary() + " " + this.tmpMoney() + " " + this.remain(); 
    }
}

public class tinh_thu_nhap_cho_nhan_vien_J05043 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- >0){
            scn.nextLine();
            NhanVien nv = new NhanVien(scn.nextLine(), scn.nextLine(), scn.nextInt(), scn.nextInt());
            System.out.println(nv);
        }   
        scn.close();
    }
}
