import java.util.Scanner;

class Contestant{
    private String fullname, birthOfDate;
    private double mark1, mark2, mark3;

    Contestant(){}

    Contestant(String fullname, String birthOfDate, double mark1, double mark2, double mark3){
        this.fullname = fullname;
        this.birthOfDate = birthOfDate;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
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

    public double sum(){
        return this.mark1 + this.mark2 + this.mark3;
    }

    @Override
    public String toString(){
        return this.fullname + " " + this.dayStd(this.birthOfDate) + " " + String.format("%.1f",this.sum());
    }
}

public class khai_bao_lop_thi_sinh_J04005 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Contestant p = new Contestant(scn.nextLine(), scn.nextLine(), scn.nextDouble(), scn.nextDouble(), scn.nextDouble());
        System.out.println(p);
    }
}
