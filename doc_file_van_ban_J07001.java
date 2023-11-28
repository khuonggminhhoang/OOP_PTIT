import java.io.File;
import java.util.Scanner;

public class doc_file_van_ban_J07001 {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(new File("C:\\Users\\HP\\OneDrive - ptit.edu.vn\\Documents\\OOP\\OOP PTIT\\DATA.in"));
        while(scn.hasNext()){
            String line = scn.nextLine();
            System.out.println(line);
        }
    }
}
