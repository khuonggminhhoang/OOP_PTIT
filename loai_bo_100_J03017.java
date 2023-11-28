import java.util.Scanner;

public class loai_bo_100_J03017 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = Integer.parseInt(scn.nextLine());
        while(t-- > 0) {
            int res = 0;
            String s = scn.nextLine();
            while (s.contains("100")) {
                int c = 0;
                int i = s.indexOf("100");
                while ((0 <= i && i < s.length() && s.indexOf("100") == i) || (i - 1 >= 0 && i - 1 < s.length()
                        && s.indexOf("100") == i - 1) || (i - 2 >= 0 && i - 2 < s.length() && s.indexOf("100") == i - 2)) {
                    c += 3;
                    i = s.indexOf("100");
                    s = s.substring(0, i) + s.substring(i + 3);
                }
                if (c > res) {
                   res = c;
                }
            }
            System.out.println(res);
        }
    }
}