import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class tre_nhat_gia_nhat_J05032 {
    public static String conv(String s){
        String ans = "";
        String[] arr = s.trim().split("/");
        for(int i = arr.length - 1; i >=0; --i){
            ans += arr[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.nextLine();
        String[][] arr = new String[n][2];
        for(int i=0; i<n; ++i){
            String name = scn.next();
            String birthday = conv(scn.next());
            arr[i][0] = name;
            arr[i][1] = birthday;
        }  
        Arrays.sort(arr, new Comparator<String[]>(){
            @Override 
            public int compare(String[] o1, String[] o2){
                return o2[1].compareTo(o1[1]);
            }
        });
        System.out.println(arr[0][0]);
        System.out.println(arr[arr.length -1][0]);
    }
}
