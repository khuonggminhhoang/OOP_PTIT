import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Person{
    private String lastName, middleName, firstName, fullName;

    public Person(String fullName) {
        this.fullName = nameStd(fullName);
        String[] arr = this.fullName.split("\\s+");
        this.lastName = arr[0];
        this.firstName = arr[arr.length - 1];
        this.middleName = this.fullName.substring(this.fullName.indexOf(' ') + 1, this.fullName.lastIndexOf(' '));
    }

    private String nameStd(String s){
        String ans = "";
        String[] arr = s.trim().split("\\s+");
        for(String x : arr){
            ans += Character.toUpperCase(x.charAt(0)) + x.substring(1).toLowerCase() + " ";
        }
        return ans.substring(0, ans.length() - 1);
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return this.fullName;
    }
}

public class chuan_hoa_va_sap_xep_J07072 {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(new File("DANHSACH.in"));
        ArrayList<Person> arr = new ArrayList<>();
        while(scn.hasNext()){
            Person x = new Person(scn.nextLine());
            arr.add(x);
        }

        Collections.sort(arr, new Comparator<Person>(){

            @Override
            public int compare(Person o1, Person o2) {
                if(!o1.getFirstName().equals(o2.getFirstName())){
                    return o1.getFirstName().compareTo(o2.getFirstName());
                }
                else if(!o1.getLastName().equals(o2.getLastName())){
                    return o1.getLastName().compareTo(o2.getLastName());
                }
                else return o1.getMiddleName().compareTo(o2.getMiddleName());
            }
            
        });

        for(Person x : arr){
            System.out.println(x);
        }
    }
}
