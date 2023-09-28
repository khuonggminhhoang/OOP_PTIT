import java.util.Scanner;

public class ChuanHoaXauHoTen {
    public static String nameStd(String s){
        String[] arr = s.trim().split("\\s+");
        String ans = "";
        ans += Character.toUpperCase(arr[0].charAt(0)) +arr[0].substring(1).toLowerCase();
        for(int i=1; i<arr.length - 1;++i){
            ans += " " +arr[i].toLowerCase();
        }
        ans += " " + Character.toUpperCase(arr[arr.length - 1].charAt(0)) +arr[arr.length - 1].substring(1).toLowerCase();
        return ans;   
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        scn.nextLine();
        while(t-- > 0){
            String s = scn.nextLine();
            System.out.println(nameStd(s));
        }
    }
}

