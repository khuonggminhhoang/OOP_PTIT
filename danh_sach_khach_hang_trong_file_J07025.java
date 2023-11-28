import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class KhachHang{
    private String id, name, gender, dob, address;

    public static int cnt = 0;

    public KhachHang(String name, String gender, String dob, String address) {
        this.id = "KH" + String.format("%03d", ++cnt);
        this.name = nameStd(name);
        this.gender = gender;
        this.dob = dayStd(dob);
        this.address = address;
    }

    private String dayStd(String s){
        StringBuilder sb = new StringBuilder(s);
        if(sb.charAt(1) == '/'){
            sb.insert(0, '0');
        }
        if(sb.charAt(4) == '/'){
            sb.insert(3, '0');
        }
        return sb.toString();
    }

    private String nameStd(String s){
        String ans = "";
        String[] arr = s.trim().split("\\s+");
        for(String x : arr){
            ans += Character.toUpperCase(x.charAt(0)) + x.substring(1).toLowerCase() + " ";
        }
        return ans.substring(0, ans.length() - 1);
    }

    public String getDOB(){
        String[] arr = this.dob.split("/");
        return arr[2] + arr[1] + arr[0];
    }

    @Override
    public String toString(){
        return this.id + " " + this.name + " "  + this.gender + " " + this.address + " " + this.dob;
    }
}

public class danh_sach_khach_hang_trong_file_J07025 {
    public static void main(String[] args) throws Exception{
        Scanner scn = new Scanner(new File("KHACHHANG.in"));
        int t = scn.nextInt();
        scn.nextLine();
        ArrayList<KhachHang> arr = new ArrayList<>();
        while(t-- >0){
            arr.add(new KhachHang(scn.nextLine(), scn.nextLine(), scn.nextLine(), scn.nextLine()));
        }   
        Collections.sort(arr, new Comparator<KhachHang>(){
            @Override
            public int compare(KhachHang o1, KhachHang o2){
                return o1.getDOB().compareTo(o2.getDOB());
            }
        });
        for(KhachHang x : arr){
            System.out.println(x);
        }
    }
}
