import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class chuan_hoa_cau_J03029 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        ArrayList<String> arr = new ArrayList<>();
        while(scn.hasNext()){
            Queue<Character> q = new LinkedList<>();
            String line = scn.nextLine();
            for(char x : line.toCharArray()){
                if(x == '.' || x == '!' || x == '?'){
                    q.add(x);
                }
            }
            String[] arrTmp = line.split("[.!?]");
            for(String sentence : arrTmp){
                String[] a = sentence.trim().toLowerCase().split("\\s+");
                String ans = "";
                for(String x : a){
                    ans += x + " ";
                }
                ans = ans.trim();
                ans = Character.toUpperCase(ans.charAt(0)) + ans.substring(1).toLowerCase();
                if(!q.isEmpty()){
                    ans += q.poll();
                }
                else ans += ".";
                arr.add(ans);
            }
        }
        for(String x : arr){
            System.out.println(x);
        }
    }
}
