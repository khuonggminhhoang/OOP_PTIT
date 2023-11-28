import java.util.Scanner;

class Person{
    private String id, name, dateOfBirth;
    private double theory, practice;

    public static int cnt = 0;

    public Person(String name, String dateOfBirth, double theory, double practice) {
        this.id = "PH" + String.format("%02d", ++cnt);
        this.name = name;
        this.dateOfBirth = dayStd(dateOfBirth);
        this.theory = theory;
        this.practice = practice;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getTheory() {
        return theory;
    }

    public void setTheory(double theory) {
        this.theory = theory;
    }

    public double getPractice() {
        return practice;
    }

    public void setPractice(double practice) {
        this.practice = practice;
    }

    public static int getCnt() {
        return cnt;
    }

    public static void setCnt(int cnt) {
        Person.cnt = cnt;
    }

    public double bonus(){
        if(this.theory >= 8 && this.practice >= 8) return 1.0;
        else if(this.theory >= 7.5 && this.practice >= 7.5) return 0.5;
        else return 0;
    }

    public long total(){
        double ans = (this.theory*1.0 + this.practice)/2 + bonus();
        long res = Math.round(ans);
        return (res > 10 ? 10 : res);
    }

    public String classify(){
        if(total() < 5) return "Truot";
        else if(total() <= 6) return "Trung binh";
        else if(total() <= 7) return "Kha";
        else if(total() <= 8) return "Gioi";
        else return "Xuat sac";
    }

    private String dayStd(String s){
        StringBuilder sb = new StringBuilder(s);
        if(sb.charAt(1) == '/'){
            sb.insert(0, '0');
        }
        if(sb.charAt(4) == '/'){
            sb.insert(3,'0');
        }
        return sb.toString();
    }

    public int Old(){
        int year = Integer.parseInt(this.dateOfBirth.substring(6));
        return 2021 - year;
    }

    @Override
    public String toString(){
        return this.id + " " + this.name + " " + this.Old() + " " + this.total() + " " + this.classify();
    }

}

public class ket_qua_xet_tuyen_J05060 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- >0){
            scn.nextLine();
            Person x = new Person(scn.nextLine(), scn.nextLine(), scn.nextDouble(), scn.nextDouble());
            System.out.println(x);
        }   
    }
}
