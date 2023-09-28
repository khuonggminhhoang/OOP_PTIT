import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;


public class dia_chi_email {
    public static String emailStd(String s){
        String[] arr = s.trim().split("\\s+");
        String ans = "";
        ans += arr[arr.length-1].toLowerCase();
        for(int i=0; i<arr.length-1; ++i){
            ans += Character.toLowerCase(arr[i].charAt(0));
        }
        return ans;
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        scn.nextLine();
        ArrayList <String> arr = new ArrayList<>();
        LinkedHashMap <String, Integer> map = new LinkedHashMap<>(); 
        while(t-- > 0){
            String s = scn.nextLine();
            String str = emailStd(s);
            if(map.containsKey(str)) {
                int tmp = map.get(str);
                ++tmp;
                map.put(str, tmp);
                arr.add(str + tmp + "@ptit.edu.vn");
            }
            else{
                map.put(str, 1);
                arr.add(str + "@ptit.edu.vn");
            }
        }
        for(String x : arr){
            System.out.println(x);
        }
    }
}