import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class SinhVien{
    private String id, fullName, phoneNumber, email;
    private String lastName, middleName, firstName;

    public SinhVien(String id, String fullName, String phoneNumber, String email) {
        this.id = id;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        String[] arr = fullName.split("\\s+");
        this.lastName = arr[0];
        this.firstName = arr[arr.length - 1];
        this.middleName = this.fullName.substring(this.fullName.indexOf(' '), this.fullName.lastIndexOf(' '));
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
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

    @Override
    public String toString() {
        return this.id + " " + this.fullName + " " + this.phoneNumber + " " + this.email;
    }
}

public class sap_xep_danh_sach_sinh_vien_J07081 {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(new File("SINHVIEN.in"));
        int t = scn.nextInt();
        scn.nextLine();
        ArrayList<SinhVien> arr = new ArrayList<>();
        while(t-- >0){
            arr.add(new SinhVien(scn.nextLine(), scn.nextLine(), scn.nextLine(), scn.nextLine()));
        }
        Collections.sort(arr, new Comparator<SinhVien>(){
            @Override
            public int compare(SinhVien o1, SinhVien o2){
                if(!o1.getFirstName().equals(o2.getFirstName())){
                    return o1.getFirstName().compareTo(o2.getFirstName());
                }
                else if(!o1.getLastName().equals(o2.getLastName())){
                    return o1.getLastName().compareTo(o2.getLastName());
                }
                else if(!o1.getMiddleName().equals(o2.getMiddleName())){
                    return o1.getMiddleName().compareTo(o2.getMiddleName());
                }
                else return o1.getId().compareTo(o2.getId());
            }
        });

        for(SinhVien x : arr){
            System.out.println(x);
        }
    }
}
