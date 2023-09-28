import java.io.File;
import java.util.Scanner;

public class tinh_tong {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(new File("C:\\Users\\HP\\OneDrive - ptit.edu.vn\\Documents\\OOP\\OOP PTIT\\src file\\DATA.in"));
        long sum = 0;
        while(scn.hasNext()){
            String s = scn.next();
            try {
                sum += Integer.parseInt(s);
            } 
            catch (Exception e) {
            }
        }
        System.out.println(sum);
    }
}
