import java.util.Scanner;

public class chuan_hoa_xau_ho_ten_1_J03004 {
    public static String nameStd(String s){
        String[] arr = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder("");
        for(String x : arr){
            if(!x.equals(" ")){
                sb.append(Character.toUpperCase(x.charAt(0)));
                for(int i = 1; i < x.length(); ++i){
                    sb.append(Character.toLowerCase(x.charAt(i)));
                }
                sb.append(" ");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        scn.nextLine();
        while( t-- > 0){
            String s = scn.nextLine();
            System.out.println(nameStd(s));
        }
    }
}





