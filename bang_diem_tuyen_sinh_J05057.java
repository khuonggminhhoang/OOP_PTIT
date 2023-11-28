import java.util.Scanner;

class ThiSinh{
    private String id, name;
    private double math, phys, chem;
    public ThiSinh(String id, String name, double math, double phys, double chem) {
        this.id = id;
        this.name = name;
        this.math = math;
        this.phys = phys;
        this.chem = chem;
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
    public void setName(String name) {
        this.name = name;
    }
    public double getMath() {
        return math;
    }
    public void setMath(double math) {
        this.math = math;
    }
    public double getPhys() {
        return phys;
    }
    public void setPhys(double phys) {
        this.phys = phys;
    }
    public double getChem() {
        return chem;
    }
    public void setChem(double chem) {
        this.chem = chem;
    }

    public String getPriority(){
        String s = this.id.substring(0, 3);
        if(s.equals("KV1")) return "0.5";
        else if(s.equals("KV2")) return "1";
        else return "2.5";
    }

    public double total(){
        return this.math*2 + this.phys + this.chem + Double.parseDouble(this.getPriority());
    }

    public String classify(){
        if(total() < 24){
            return "TRUOT";
        }
        else{
            return "TRUNG TUYEN";
        }
    }

    @Override
    public String toString() {
        String total = ((int)(this.total() - Double.parseDouble(getPriority())) == this.total() - Double.parseDouble(getPriority()) ? ((int)(this.total() - Double.parseDouble(getPriority())) + "") : ((this.total() - Double.parseDouble(getPriority())) + "")); 
        return this.id + " " + this.name + " " + this.getPriority() + " " + total + " " + this.classify();
    }
}

public class bang_diem_tuyen_sinh_J05057 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- >0){
            scn.nextLine();
            ThiSinh ts = new ThiSinh(scn.nextLine(), scn.nextLine(), scn.nextDouble(), scn.nextDouble(), scn.nextDouble());
            System.out.println(ts);
        }   
    }
}
