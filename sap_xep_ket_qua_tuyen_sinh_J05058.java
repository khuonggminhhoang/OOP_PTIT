import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        String total = ((int)(this.total()) == this.total() ? ((int)(this.total()) + "") : ((this.total()) + "")); 
        return this.id + " " + this.name + " " + this.getPriority() + " " + total + " " + this.classify();
    }
}

public class sap_xep_ket_qua_tuyen_sinh_J05058 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        ArrayList<ThiSinh> arr = new ArrayList<>();
        while(t-- >0){
            scn.nextLine();
            ThiSinh ts = new ThiSinh(scn.nextLine(), scn.nextLine(), scn.nextDouble(), scn.nextDouble(), scn.nextDouble());
            arr.add(ts);
        }   
        Collections.sort(arr, new Comparator<ThiSinh>() {
            @Override
            public int compare(ThiSinh o1, ThiSinh o2){
                if(o1.total() != o2.total()){
                    if(o1.total() > o2.total()){
                        return -1;
                    }
                    else{
                        return 1;
                    }
                }
                else{
                    return o1.getId().compareTo(o2.getId());
                }
            }
        });
        for(ThiSinh x : arr){
            System.out.println(x);
        }
    }
}
