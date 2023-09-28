import java.util.Scanner;

public class xu_ly_van_ban_J03022 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String stream = "";
        while(scn.hasNext()){
            stream += scn.next() + " ";
        }
        String[] arr = stream.trim().split("[.?!]");
        for(String x : arr){
            String tmp = x.trim();
            System.out.println(Character.toUpperCase(tmp.charAt(0)) + tmp.substring(1).toLowerCase());
        }
    }
}
