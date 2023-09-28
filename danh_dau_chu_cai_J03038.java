import java.util.HashSet;
import java.util.Scanner;

public class danh_dau_chu_cai_J03038 {
    public static void main(String[] args) {
        Scanner scn= new Scanner(System.in);
        String s = scn.nextLine();
        HashSet <Character> set = new HashSet<>();
        for(char x : s.toCharArray()){
            set.add(x);
        }
        System.out.println(set.size());
    }
}
