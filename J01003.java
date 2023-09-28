import java.util.Scanner;

public class J01003 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int b = scn.nextInt();
        if(a == 0){
            if(b== 0){
                System.out.println("VSN");
            }
            else
                System.out.println("VN");
        }
        else{
            System.out.printf( "%.2f",(double) -b/a );
        }
    }
}
