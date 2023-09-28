import java.util.Scanner;

class Student {
    public String id, fullname;
    public double markMath, markPhys, markChem;

    Student(String id, String fullname, double markMath, double markPhys, double markChem){
        this.id = id;
        this.fullname = fullname;
        this.markMath = markMath;
        this.markPhys = markPhys;
        this.markChem = markChem;
    }

    public int area(){
        return Integer.parseInt(id.substring(2, 3));
    }

    public double markArea(){
        int area = Integer.parseInt(id.substring(2, 3));
        if(area == 1) return 0.5;
        else if(area == 2) return 1;
        else return 2.5;
    }

    public double mark(){
        return this.markMath * 2 + this.markChem + this.markPhys;
    }

    public String check(){
        double mark = mark();
        if(area() == 1) mark += 0.5;
        else if(area() == 2) mark += 1;
        else mark += 2.5;
        return (mark >= 24) ? "TRUNG TUYEN" : "TRUOT"; 
    }

    @Override
    public String toString(){
        String mark = "";
        if((int) mark() == mark()) mark = String.format("%.0f", mark());
        else mark = String.format("%.1f",mark());
        String area = "";
        if(markArea() == (int) markArea()) area = String.format("%.0f", markArea());
        else area = String.format("%.1f", markArea());
        return this.id + " " + this.fullname + " " + area + " " + mark + " " + this.check();
    }
}

public class bai_toan_tuyen_sinh_J04013 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Student student = new Student(scn.nextLine(),scn.nextLine(),scn.nextDouble(),scn.nextDouble(),scn.nextDouble());
        System.out.println(student);
    }
}

