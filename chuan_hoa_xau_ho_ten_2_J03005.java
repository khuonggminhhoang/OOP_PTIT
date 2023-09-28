import java.util.Scanner;

public class chuan_hoa_xau_ho_ten_2_J03005 {
    public static String nameStd(String s){
        String[] arr = s.trim().split("\\s+");
        String ans = "";
        for(int i = 1; i < arr.length; ++i){
            String x = arr[i];
            ans += Character.toUpperCase(x.charAt(0)) + x.substring(1).toLowerCase() + " ";
        }
        ans = ans.substring(0, ans.length()-1);
        ans += ", ";
        ans += arr[0].toUpperCase();
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = Integer.parseInt(scn.nextLine());
        while(t-- > 0){
            String s = scn.nextLine();
            System.out.println(nameStd(s));
        }
    }    
}

