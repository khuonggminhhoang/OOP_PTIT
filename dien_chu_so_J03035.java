import java.util.Scanner;

public class dien_chu_so_J03035 {
    public static int calc(String s1, String s2) {
        int count = 0;          // đếm số dấu ?
        for (char x : s1.toCharArray()) 
            count = (x == '?' ? ++count : count); 

        for (int i = 0; i < s1.length(); ++i) {
            if(s1.charAt(i) != '?'){
                int n1 = s1.charAt(i) - '0';
                int n2 = s2.charAt(i) - '0';
                if(n1 < n2) return 0;
                else if(n1 > n2){
                    return (int) Math.pow(10, count);
                }
            }
            else{
                return (int) ((int) ('9' - s2.charAt(i)) * Math.pow(10, count - 1)) 
                + calc(s1.substring(0, i) + s2.charAt(i) + s1.substring(i + 1), s2); // đệ quy để xử lý trường hợp 2 số gần giống nhau
            }
            
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = Integer.parseInt(scn.nextLine());
        while (t-- > 0) {
            String s1 = scn.nextLine();
            String s2 = scn.nextLine();
            System.out.println(calc(s1, s2));
        }
        scn.close();
    }
}
