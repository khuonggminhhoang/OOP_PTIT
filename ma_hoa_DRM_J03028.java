import java.util.HashMap;
import java.util.Scanner;

public class ma_hoa_DRM_J03028 {
    public static HashMap<Character, Integer> mapci = new HashMap<>();
    public static HashMap<Integer, Character> mapic = new HashMap<>();

    public static int value(String s){
        int sum = 0;
        for(char x : s.toCharArray()){
            sum += mapci.get(x);
        }
        return sum;
    }

    public static String rotate(String s,int value){
        int mod = value % 26;
        String ans = "";
        for(char x : s.toCharArray()){
            int tmp = mapci.get(x) + mod;
            if(tmp > 25){
                tmp %= 26;
            }
            ans += mapic.get(tmp);
        }
        return ans;
    }

    public static String merge(String first, String second){
        String ans = "";
        for(int i=0; i < first.length(); ++i){
            ans += rotate(String.valueOf(first.charAt(i)), value(String.valueOf(second.charAt(i))));
        }      
        return ans;
    }

    public static void main(String[] args) {
        for(Character c = 'A'; c <='Z'; ++c){
            int tmp = c - 'A';
            mapci.put(c, tmp);
            mapic.put(tmp, c);
        }

        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        scn.nextLine();
        while(t-- > 0){
            String s = scn.nextLine();
            //devide
            String first = s.substring(0, s.length()/2);
            String second = s.substring(s.length()/2);
            //rotate
            first = rotate(first, value(first));
            second = rotate(second, value(second));
            //merge
            System.out.println(merge(first, second));
        }
        scn.close();
    }    
}
