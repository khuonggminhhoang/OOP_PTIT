import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class NhanVien{
    private String id, name;
    private boolean gender;
    private double salary;

    
    public NhanVien(String id, String name, boolean gender, double salary) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.salary = salary;
    }

    public String getFirstName(){
        String[] arr = this.name.split("\\s+");
        return arr[arr.length - 1];
    }

    public String getLastName(){
        String[] arr = this.name.split("\\s+");
        return arr[0];
    }

    public String getMiddleName(){
        String[] arr = this.name.split("\\s+");
        String ans = "";
        for(int i = 1; i < arr.length - 1; ++i){
            ans += arr[i] + " ";
        }
        return ans.substring(0, ans.length() - 1);
    }

    // private String nameStd(String s){
    //     String[] arr = s.split("\\s+");
    //     String ans = ""; 
    //     for(String x : arr){
    //         ans += Character.toUpperCase(x.charAt(0)) + x.substring(1).toLowerCase() + " ";
    //     }
    //     return ans.substring(0, ans.length() - 1);
    // }

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

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString(){
        String sal = (this.salary == (long)this.salary)? ((long)this.salary + ""): (this.salary + "");
        return this.id + " " + this.name + " " + (this.gender?"nam":"nu") + " " + sal;
    }

}

public class nhanvien_test {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scn = new Scanner(new File("nhanvien.dat"));
        ArrayList<NhanVien> arr = new ArrayList<>();
        while(scn.hasNext()){
            String[] s = scn.nextLine().split("/");
            arr.add(new NhanVien(s[0], s[1], Boolean.parseBoolean(s[2]), Double.parseDouble(s[3])));
        }

        Collections.sort(arr, new Comparator<NhanVien>() {

            // @Override
            // public int compare(NhanVien o1, NhanVien o2) {

            //     if(!o1.getFirstName().equals(o2.getFirstName())){
            //         return o1.getFirstName().compareTo(o2.getFirstName());
            //     }
            //     else if(!o1.getLastName().equals(o2.getLastName())){
            //         return o1.getLastName().compareTo(o2.getLastName());
            //     }
            //     else{
            //         return o1.getMiddleName().compareTo(o2.getMiddleName());
            //     }
            // }

            @Override
            public int compare(NhanVien o1, NhanVien o2) {
                return o1.getName().compareTo(o2.getName());
            }
            
        });

        for(NhanVien x : arr){
            System.out.println(x);
        }
    }
}
