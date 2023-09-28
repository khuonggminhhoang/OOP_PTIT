import java.util.Scanner;

class Employee {
    private String id, fullname, position; 
    private long  salaryPerDay, workday;

    public static int cnt = 0;

    Employee(String fullname, long salaryPerDay, long workday, String position){
        cnt++;
        this.id = "NV" + String.format("%02d",cnt);
        this.fullname = fullname;
        this.salaryPerDay = salaryPerDay;
        this.workday = workday;
        this.position = position;
    }

    public long salary(){
        return salaryPerDay * workday;
    }

    public long bonus(){
        if(workday >= 25){
            return salary() * 20/100; 
        }
        else if(22 <= workday && workday <25){
            return salary() * 10/100;
        }
        else{
            return 0;
        }
    }
    // phụ cấp
    public long allowance(){
        if(position.equals("GD")) return 250000;
        else if(position.equals("PGD")) return 200000;
        else if(position.equals("TP")) return 180000;
        else return 150000;
    }

    public long totalSalary(){
        return this.salary() + this.allowance() + this.bonus();
    }

    @Override
    public String toString() {
        return this.id + " " + this.fullname + " " + this.salary() + " " + this.bonus() + " " + this.allowance() + " " + this.totalSalary();
    }
}

public class bai_toan_tinh_cong_J04012 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String fullname = scn.nextLine();
        long salaryPerDay = scn.nextLong();
        long workday = scn.nextLong();
        scn.nextLine();
        String position = scn.nextLine();
        Employee employee = new Employee(fullname, salaryPerDay, workday, position);
        System.out.println(employee);
    }
}
