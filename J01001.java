import java.util.Scanner;

public class J01001 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int b = scn.nextInt(); 
        if(a <= 0 || b <= 0){
            System.out.println(0);
            return;
        }
        System.out.print((a+b)*2 + " ");
        System.out.print(a*b);
        scn.close();
    }
}
