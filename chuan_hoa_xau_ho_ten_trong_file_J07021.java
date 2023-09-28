import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class chuan_hoa_xau_ho_ten_trong_file_J07021 {
    public static String nameStd(String s){
        String ans = "";
        String[] arr = s.trim().split("\\s+");
        for(String x : arr){
            ans += Character.toUpperCase(x.charAt(0)) + x.substring(1).toLowerCase() + " ";
        }
        return ans;
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scn = new Scanner(new File("DATA.in"));
        while(scn.hasNext()){
            String tmp = scn.nextLine();
            if(!tmp.equals("END")) System.out.println(nameStd(tmp));
            else break;
            
        }
    }
}
