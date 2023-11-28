import java.util.Scanner;

public class day_du_cac_chu_so_J01020 {
    public static int[] used = new int[10];
    public static int cnt;

    public static void check(int n){
        while(n > 0){
            if(used[n % 10] == 0){
                used[n % 10] = 1;
                ++cnt;
            }
            n/=10;
        }
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- >0){
            int n = scn.nextInt();
            for(int i=0; i<10; ++i) used[i] = 0;
            cnt = 0;
            if(n == 0) System.out.println("Impossible");
            else{
                check(n);
                int tmp = 0;
                while(cnt < 10){
                    tmp++;
                    check(n * tmp);
                }
                System.out.println(n * tmp);
            }
        }
        scn.close();
    }
}
