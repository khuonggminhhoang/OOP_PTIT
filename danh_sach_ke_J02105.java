import java.util.Scanner;

public class danh_sach_ke_J02105 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        for(int i=1; i<=n; ++i){
            System.out.print("List(" + i + ") = ");
            for(int j=1; j<=n; ++j){
                int x = scn.nextInt();
                if(x == 1){
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }
}

